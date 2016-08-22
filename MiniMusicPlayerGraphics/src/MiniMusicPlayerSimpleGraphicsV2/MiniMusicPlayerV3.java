package MiniMusicPlayerSimpleGraphicsV2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiniMusicPlayerV3
{
	static JFrame f = new JFrame("My first music video");
	static MyDrawPanel ml;

	public static void main(String[] args)
	{
		MiniMusicPlayerV3 mini = new MiniMusicPlayerV3();
		mini.go();
	}

	private void go()
	{
		setUpGui();
		try
		{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addControllerEventListener(ml, new int[]
			{ 127 });
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			int r = 0;
			for (int i = 0; i < 60; i += 4)
			{
				r = (int) ((Math.random() * 50) + 1);
				track.add(makeEvent(144, 1, r, 100, i));
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, r, 100, i + 2));
			}
			sequencer.setSequence(seq);
			sequencer.start();
		} catch (Exception ex)
		{
			ex.printStackTrace();
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

	private void setUpGui()
	{
		ml = new MyDrawPanel();
		f.setContentPane(ml);
		f.setBounds(30, 30, 300, 300);
		f.setVisible(true);
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
