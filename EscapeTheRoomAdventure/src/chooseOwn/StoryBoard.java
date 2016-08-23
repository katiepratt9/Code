package chooseOwn;

//import  sun.audio.*;    //import the sun.audio package
//import  java.io.*;
//acts as game to keep the story moving
public class StoryBoard
{
	private final EscapeTheRoom adventure;
	private final EscapeTheRoomPlayer player;

	//// AudioStream as = new AudioStream (url.openStream());
	//
	// AudioPlayer.player.start(as);
	//
	// AudioPlayer.player.stop(as);
	public StoryBoard(EscapeTheRoom adventure, EscapeTheRoomPlayer player)
	{
		this.adventure = adventure;
		this.player = player;
	}

	public ChooseAction chooseWhatToDo(EscapeTheRoomPlayer player)
	{
		return player.chooseWhatToDo();
	}

	public void playOneAction()
	{
		ChooseAction action = chooseWhatToDo(player);
		checkAction(action);
	}

	public void checkAction(ChooseAction action)
	{
		if (!adventure.currentStateOfBed())
		{
			adventure.chooseBegining(action);
		}
		else if (!adventure.currentStateOfCrowBar())
		{
			adventure.chooseBeginingTwo(action);
		}
		else if (!adventure.currentStateOfKeyContainerPickedUp())
		{
			adventure.chooseMiddle(action);
		}
		else if (!adventure.currentStateOfKeyContainerPlaced())
		{
			adventure.chooseMiddleTwo(action);
		}
		else if (!adventure.currentStateOfHammer())
		{
			adventure.chooseMiddleThree(action);
		}
		else if (!adventure.currentStateOfKey())
		{
			adventure.chooseEnd(action);
		}
		else if (!adventure.currentStateOfDoor())
		{
			adventure.chooseEndTwo(action);
		}
	}

	public boolean storyContinue()
	{
		while (!isStoryDone())
		{
			playOneAction();
		}
		return true;
	}

	public boolean isStoryDone()
	{
		if (!adventure.currentStateOfDoor())
		{
			return false;
		}
		return true;
	}

}
