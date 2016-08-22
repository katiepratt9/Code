package MiniMusicPlayerSimpleGraphicsV2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.sound.midi.*;
import javax.swing.JPanel;

public class MiniMusicPlayer2 implements ControllerEventListener
{// we need to listen for controller events, so we implement the listener
	// interface
	public static void main(String[] args)
	{
		MiniMusicPlayer2 mini = new MiniMusicPlayer2();
		mini.go();
	}

	private void go()
	{
		try
		{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();

			int[] eventsIWant =
			{ 127 };
			sequencer.addControllerEventListener(this, eventsIWant);
			// register for events with the sequencer. the event registration
			// method takes the listener and
			// an int[] representing the list of Controller events you want we
			// want only one event '127'

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			for (int i = 5; i < 60; i += 4)
			{
				track.add(makeEvent(144, 1, i, 100, i));

				track.add(makeEvent(176, 1, 127, 0, i));
				// heres how we pick the beat. we insert our own controller
				// event(176 says the event type
				// is Controller event) with an argument for event #127. This
				// event will do nothing. we put it in just so that
				// we can get an event each time a note is played. In other
				// words, it sole purpose is so that something
				// will fire that we can listen for(we can't listen for
				// NoteOn/Off events) note that were making this event happen
				// at the same tick as the NoteON so when the NoteOn event
				// happens, we'll know about it because our event will fire at
				// the same time.

				track.add(makeEvent(128, 1, i, 100, i + 2));
			}

			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick)
	{
		// the four arguments for the message and the event tick for when this
		// message should happen
		MidiEvent event = null;
		try
		{
			// make the message and the event using the method parameters
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e)
		{
		}
		// return the event you just made
		return event;
	}

	@Override
	public void controlChange(ShortMessage event)
	// the event handler method(from the controllerEvent listener interface).
	// eachtime we get the event, we'll print "la" to the command-line
	{
		System.out.println("la");
	}
class MyDrawPanel extends JPanel implements ControllerEventListener
{
	boolean msg = false;

	@Override
	public void controlChange(ShortMessage event)
	{
		msg = true;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		if (msg)
		{
			Graphics2D g2 = (Graphics2D) g;

			int r = (int) (Math.random() * 250);
			int b = (int) (Math.random() * 250);
			int gr = (int) (Math.random() * 250);

			g.setColor(new Color(r, gr, b));

			int ht = (int) ((Math.random() * 120) + 10);
			int wdth = (int) ((Math.random() * 120) + 10);
			int x = (int) ((Math.random() * 40) + 10);
			int y = (int) ((Math.random() * 40) + 10);
			g.fillRect(x, y, wdth, ht);
			msg = false;
		}
	}
}
}
