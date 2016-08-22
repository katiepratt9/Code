package MiniMusicPlayerSimpleV1;
import javax.sound.midi.*;
public class MiniMusicPlayer1
{
	
public static void main(String[] args)
{
	try{
		Sequencer sequencer = MidiSystem.getSequencer();
		sequencer.open();
		//make and open a sequencer
		
		Sequence seq = new Sequence(Sequence.PPQ,4);
		Track track = seq.createTrack();
		//make a sequence and a track 
		
		for(int i =5;i<61;i+=4)
			//make events to make the notes keep going up(from piano note 5 to 61)
		{
			track.add(makeEvent(144,2,i,100,i));
			track.add(makeEvent(128,1,i,100,i+2));
			//call makeEvent() method to make a message and an event, then add the result
			//(the midiEvent returned from makeEvent()) to the track. these are noteOn(144) and noteOff(128)
		}
		
		sequencer.setSequence(seq);
		sequencer.setTempoInBPM(220);
		sequencer.start();
		//start it running
	}
	catch(Exception e){e.printStackTrace();}
}
public static MidiEvent makeEvent(int comd,int chan, int one, int two, int tick)
{
	//the four arguments for the message and the event tick for when this message should happen
	MidiEvent event = null;
	try{
		//make the message and the event using the method parameters 
		ShortMessage a = new ShortMessage();
		a.setMessage(comd,chan,one,two);
		event = new MidiEvent(a,tick);
	}
	catch(Exception e){}
	//return the event you just made
	return event;
}
}
