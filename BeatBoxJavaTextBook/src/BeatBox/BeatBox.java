package BeatBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.sound.midi.*;
import javax.swing.*;

public class BeatBox
{
	JPanel mainPanel;
	ArrayList<JCheckBox> checkBoxList;
	// we store the checkboxes in an arrayList
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame theFrame;
	String[] instrumentNames =
	{ "Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymball", "Hand Clap", "High Tom",
			"High Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
			"Open Hi Conga" };
	// these are the names of the instruments, as a string array, for building
	// the gui lables on each row
	int[] instruments =
	{ 35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63 };

	// these represent the actual drum 'keys' the drum channel is like a piano,
	// except each key is a different drum.
	public static void main(String[] args)
	{
		new BeatBox().buildGUI();
	}

	private void buildGUI()
	{
		theFrame = new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//an 'empty border' gives a margin between the edges of a panel and where the components are placed.
		checkBoxList = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);

		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);

		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);

		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyTempoUpListener());
		buttonBox.add(upTempo);

		JButton downTempo = new JButton("Tempo Down");
		downTempo.addActionListener(new MyTempoDownListener());
		buttonBox.add(downTempo);

		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < 12; i++)
		{
			nameBox.add(new Label(instrumentNames[i]));
		}

		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);

		theFrame.getContentPane().add(background);

		GridLayout grid = new GridLayout(16, 16);
		grid.setVgap(1);
		grid.setVgap(2);
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER, mainPanel);
//make the checkboxes, set them to 'unchecked' and add them to an arraylist and to the gui panel.
		for (int i = 0; i < 256; i++)
		{
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkBoxList.add(c);
			mainPanel.add(c);
		}

		setUpMidi();

		theFrame.setBounds(50, 50, 300, 300);
		theFrame.pack();
		theFrame.setVisible(true);
	}

	public void setUpMidi()
	{
		try
		{
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void buildTrackAndStart()
	{
		int[] trackList = null;
//make a 1b array to hold the values for one instrument, across all 16 beats. 
		//if the instrument is supposed to play on that beat, the value at that element will be the key.
		//if that instrument is not supposed to play on that beat, put in a zero.
		sequence.deleteTrack(track);
		//get rid of the old track and make a fresh one
		track = sequence.createTrack();

		for (int i = 0; i < 16; i++)
		{//do this for each of the 16 rows
			trackList = new int[16];

			int key = instruments[i];
//set the 'key' that represents which instrument this is, 
			//the instrument holds the actual midi numbers for each instrument.
			for (int j = 0; j < 16; j++)
			{//do this for each of the beats for this row
			//if the checkbox at this beat is selected [ut the key value in this slot in the array(the slot that represents this beat)
			//else the instrument is not supposed to play at this beat, set to zero.
				JCheckBox jc = checkBoxList.get(j + 16 * i);
				if (jc.isSelected())
				{
					trackList[j] = key;
				}
				else
				{
					trackList[j] = 0;
				}
			}
//for this instrument and for all 16 beats, makeEvents and add them to the track
			makeTrack(trackList);
			track.add(makeEvent(176, 1, 127, 0, 16));
		}
		track.add(makeEvent(192, 9, 1, 0, 15));
		//make sure that there us an event at beat 16(it goes 0-15)
		//else the beatbox might not go to the full 16 beats, before starting over.
		try
		{
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			//specifu the number of loop iterations,in this case continous looping
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public class MyStartListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent a)
		{
			buildTrackAndStart();

		}

	}

	public class MyStopListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent a)
		{
			sequencer.stop();
		}
	}

	public class MyTempoUpListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent a)
		{
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * 1.03));
			//the tempo factor scales the sequence tempo by the factor provided.
			//the default is 1.0, so we're adjusting +/-3% per click
		}
	}

	public class MyTempoDownListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent a)
		{
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * tempoFactor * .97));
		}
	}

	public void makeTrack(int[] list)
	{
		for (int i = 0; i < 16; i++)
		{
			int key = list[i];

			if (key != 0)
			{
				//make note on and note off events and add them to the track
				track.add(makeEvent(144, 9, key, 100, i + 1));
				track.add(makeEvent(128, 9, key, 100, i + 1));
			}
		}
	}

	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick)
	{
		MidiEvent event = null;
		try
		{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return event;
	}
}