package App;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMiniMusicApp
{
	public static void main(String[] args)
	{
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}// close main

	public void play()
	{
		try
		{
			Sequencer player = MidiSystem.getSequencer();
			// get a sequencer and open it
			player.open();
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			// ask the sequencer for a Track- the track lives
			// in the sequence and the midi data lives in the track
			// put some midi events into the track
			// make a message
			ShortMessage a = new ShortMessage();
			// put the instruction in the message
			// this message says "start playing note 44"
			a.setMessage(144, 1, 44, 100);
			// make a new midi event using the message
			// the instructions are in the message,but the midi event
			// adds the moment in time when the instruction should be
			// triggered. this midievent says to trigger
			// messag "a" at the first beat
			MidiEvent noteOn = new MidiEvent(a, 1);
			// add the midievent to the track, a track holds all the midievent
			// objects. the sequence organizes them according to when each event
			// is
			// supposed to happen, and then the sequencer plays them back in
			// that order.
			// you can have multiple events happen at the same time
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			// setMessage(int command(message type), int channel, int data1(note
			// to play),int data2(velocity))
			b.setMessage(128, 1, 44, 100);
			// MidiEvent (message, long tick)
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);
			// give the sequence to the sequencer
			player.setSequence(seq);
			player.start();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
