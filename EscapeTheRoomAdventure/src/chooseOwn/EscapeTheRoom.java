package chooseOwn;

public class EscapeTheRoom
{
	private boolean bedPickedUp = false;
	private boolean bedMoved = false;
	private boolean crowbarPickedUp = false;
	private boolean dresserOpened = false;
	private boolean keyContainerPickedUp = false;
	private boolean keyContainerPlaced = false;
	private boolean hammerPickedUp = false;
	private boolean keyOpened = false;
	private boolean keyPickedUp = false;
	private boolean doorUnlocked = false;
	boolean positionFront = false;// 1
	boolean positionBack = false;// 2
	boolean positionLeftSide = false;// 3
	boolean positionRightSide = false;// 4
	boolean positionMiddle = true;// 5
	boolean inventory = false;

	public void updatePosition(int value)
	{
		if (value == 1)
		{
			positionFront = true;
			positionBack = false;
			positionLeftSide = false;
			positionRightSide = false;
			positionMiddle = false;
		}
		else if (value == 2)
		{
			positionFront = false;
			positionBack = true;
			positionLeftSide = false;
			positionRightSide = false;
			positionMiddle = false;
		}
		else if (value == 3)
		{
			positionFront = false;
			positionBack = false;
			positionLeftSide = true;
			positionRightSide = false;
			positionMiddle = false;
		}
		else if (value == 4)
		{
			positionFront = false;
			positionBack = false;
			positionLeftSide = false;
			positionRightSide = true;
			positionMiddle = false;
		}
		else if (value == 5)
		{
			positionFront = false;
			positionBack = false;
			positionLeftSide = false;
			positionRightSide = false;
			positionMiddle = true;
		}
	}

	private boolean taskComplete(boolean task)
	{
		if (task == false)
		{
			return false;
		}
		return true;
	}

	public boolean currentStateOfBed()
	{
		if (taskComplete(bedMoved))
		{
			return true;
		}
		return false;
	}

	public boolean currentStateOfCrowBar()
	{
		if (taskComplete(crowbarPickedUp))
		{
			return true;
		}
		return false;
	}

	public boolean currentStateOfKeyContainerPickedUp()
	{
		if (taskComplete(keyContainerPickedUp))
		{
			return true;
		}
		return false;
	}

	public boolean currentStateOfKeyContainerPlaced()
	{
		if (taskComplete(keyContainerPlaced))
		{
			return true;
		}
		return false;
	}

	public boolean currentStateOfHammer()
	{
		if (taskComplete(hammerPickedUp))
		{
			return true;
		}
		return false;
	}

	public boolean currentStateOfKey()
	{
		if (taskComplete(keyPickedUp))
		{
			return true;
		}
		return false;
	}

	public boolean currentStateOfDoor()
	{
		if (taskComplete(doorUnlocked))
		{
			return true;
		}
		return false;
	}

	public ChooseAction chooseBegining(ChooseAction action)
	{

		switch (action)
		{
		case LOOK:
			lookInBegining();
			break;
		case OPEN:
			openInBeggining();
			break;
		case EXAMINE:
			examineInBegining();
			break;
		case MOVETOFRONT:
			moveToFrontInBegining();
			break;
		case MOVETOBACK:
			moveToBackInBegining();
			break;
		case MOVETOLEFTSIDE:
			moveToLeftInBegining();
			break;
		case MOVETORIGHTSIDE:
			moveToRightInBegining();
			break;
		case MOVETOMIDDLE:
			moveToMiddleInBegining();
			break;
		case PLACE:
			PlaceInBegining();
			break;
		case ACTIONDESTROY:
			actionDestroyInBegining();
			break;
		case PICKUP:
			actionPickUpInBegining();
			break;
		default:
			System.out.println("That is not an action you can do, try again.");
			chooseBegining(action);
			break;
		}

		return action;
	}

	private void PlaceInBegining()
	{
		if (inventory = true && positionMiddle == true)
		{
			System.out.println("You Place the bed in the middle of the room.");
			System.out.println("You remember how much you hate tight places");
			inventory = false;
			bedMoved = true;
		}
		else if (inventory = true)
		{
			System.out.println("Cannot place here.");
		}
		else
		{
			System.out.println("You don't have anything to place.");
		}

	}

	private void actionPickUpInBegining()
	{
		if (positionLeftSide == true && bedPickedUp == false)
		{
			System.out.println("You Pick up the bed it is heavier than suspected, you need to put it down somewhere.");
			inventory = true;
			bedPickedUp =true;
		}
		else if (inventory = true && bedPickedUp == true)
		{
			System.out.println("I have to put this down first.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("Even if you picked up the hammer, you can't break the lock with it");
		}
		else
		{
			System.out.print("Nothing to pick up");
		}

	}

	private void actionDestroyInBegining()
	{
		System.out.println("There's nothing to destroy, and nothing to destroy that nothing with.");

	}

	private void moveToRightInBegining()
	{
		System.out.println("You move to the right so that you are standing in front of the dresser.");
		updatePosition(4);
	}

	private void moveToLeftInBegining()
	{
		if (bedPickedUp == true)
		{
			System.out.print("Nothing here.");
		}
		else
		{
			System.out.println("You move to the left so that you are standing in front of the bed.");
			updatePosition(3);
		}
	}

	private void moveToBackInBegining()
	{
		System.out.println("You move to the back so that you are standing in front of the table.");
		updatePosition(2);
	}

	private void moveToFrontInBegining()
	{
		System.out.println("You move to the front so that you are standing in front of the metal door");
		updatePosition(1);

	}

	private void moveToMiddleInBegining()
	{
		System.out.println("You move to the middle.");
		updatePosition(5);
	}

	private void examineInBegining()
	{
		if (positionMiddle == true)
		{
			System.out.println("your in the middle of the room there's nothing to examine");
		}
		else if (positionLeftSide == true)
		{
			System.out.println(
					"The bed looks uncomfortable to sleep on, it also looks light, mabye even light enough to carry...");
		}
		else if (positionRightSide == true)
		{
			System.out.println("The dresser is a faded brown, it looks sturdy and would be immposible to move");
		}
		else if (positionFront == true)
		{
			System.out.println(
					"The metal door is locked, and strong enough that you wouldn't be able to break it down, you have to find a key to open it");
		}
		else if (positionBack == true)
		{
			System.out.println("the table has a hammer sitting on it, the hammer looks weak from overuse.");
		}
	}

	private void lookInBegining()
	{
		if (positionMiddle == true)
		{
			System.out.println(
					"The room is a sqaure shape, the walls are made of concrete, in front of you is a metal door, to Your left you see a ratty bed, to your right you see a dresser, behind you is a table.");
		}
		else if (positionLeftSide == true)
		{
			if (bedPickedUp == true)
			{
				System.out.println("Nothing Here.");
			}
			else
			{
				System.out.println(
						"In front of you is a knee high dirty bed, it has dusty, pale white sheets and a thin pillow at the head.");
			}
		}
		else if (positionRightSide == true)
		{
			System.out.println("in front of you is a heavy, old dresser, it is currently closed.");
		}
		else if (positionBack == true)
		{
			System.out.println("In front of you is a shaky wooden table.");
		}
		else if (positionFront == true)
		{
			System.out.println("In front of you is a rusty metal door.");
		}
	}

	private void openInBeggining()
	{
		if (positionMiddle == true)
		{
			System.out.println("your in the middle of the room there's nothing to open.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("you can't open a bed.");
		}
		else if (positionRightSide == true)
		{
			System.out.println(
					"The dresser isn't locked, but doors are stuck and wont budge open, you need something to get some leverage.");
		}
		else if (positionFront == true)
		{
			System.out.println("worth a shot, but the metal door remains locked, closed and daunting.");
		}
		else if (positionBack == true)
		{
			System.out.println("you can't open a table.");
		}
	}

	public ChooseAction chooseBeginingTwo(ChooseAction action)
	{

		switch (action)
		{
		case LOOK:
			lookInBeginingTwo();
			break;
		case OPEN:
			openInBegginingTwo();
			break;
		case EXAMINE:
			examineInBeginingTwo();
			break;
		case MOVETOFRONT:
			moveToFrontInBeginingTwo();
			break;
		case MOVETOMIDDLE:
			moveToMiddleInBeginingTwo();
			break;
		case MOVETOBACK:
			moveToBackInBeginingTwo();
			break;
		case MOVETOLEFTSIDE:
			moveToLeftInBeginingTwo();
			break;
		case MOVETORIGHTSIDE:
			moveToRightInBeginingTwo();
			break;
		case PLACE:
			PlaceInBeginingTwo();
			break;
		case ACTIONDESTROY:
			actionDestroyInBeginingTwo();
			break;
		case PICKUP:
			actionPickUpInBeginingTwo();
			break;
		default:
			throw new RuntimeException("That is not an action you can do, try again.");
			// chooseBeginingTwo(action);
			// break;
		}

		return action;

	}

	private void actionPickUpInBeginingTwo()
	{
		if (positionLeftSide == true)
		{
			System.out.print("You bend down and pick up the crowbar, it looks like its been sitting there for years.");
			inventory = true;
			crowbarPickedUp = true;
			System.out.println("The room seems smaller than it was a second ago");
		}
		else if (positionBack == true)
			System.out.print("Even if you picked up the hammer, theres nothing to use it on.");
		else
		{
			System.out.print("Nothing to pick up.");
		}
	}

	private void actionDestroyInBeginingTwo()
	{
		System.out.println("There's nothing to destroy, and nothing to destroy that nothing with.");
	}

	private void PlaceInBeginingTwo()
	{
		System.out.println("You don't have anything to place.");
	}

	private void moveToRightInBeginingTwo()
	{
		System.out.println("You move to the right so that you are standing in front of the dresser.");
		updatePosition(4);
	}

	private void moveToLeftInBeginingTwo()
	{
		System.out.println("You move to the left so that you are standing in front of where the bed used to be.");
		updatePosition(3);

	}

	private void moveToBackInBeginingTwo()
	{
		System.out.println("You move to the back so that you are standing in front of the table.");
		updatePosition(2);
	}

	private void moveToFrontInBeginingTwo()
	{
		System.out.println("You move to the front so that you are standing in front of the metal door");
		updatePosition(1);

	}

	private void moveToMiddleInBeginingTwo()
	{
		System.out.println("You move to the middle so that you are standing on the bed");
		updatePosition(5);
	}

	private void examineInBeginingTwo()
	{
		if (positionMiddle == true)
		{
			System.out.println(
					"your in the middle of the room standing on the bed, you can feel it creaking under your weight, theres nothing new about the bed, and there's no give in the ceiling when you push against it.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println(
					"You look at the empty space where the bed used to be and see a crowbar lying on the floor, it looks like it's been there for years.");
		}
		else if (positionRightSide == true )
		{
			System.out.println("The dresser is a faded brown, it looks sturdy and would be immposible to move");
		}
		else if (positionFront == true)
		{
			System.out.println(
					"The metal door is locked, and strong enough that you wouldn't be able to break it down, you have to find a key to open it");
		}
		else if (positionBack == true)
		{
			System.out.println("the table has a hammer sitting on it, the hammer looks weak from overuse.");
		}

	}

	private void openInBegginingTwo()
	{
		if (positionMiddle == true)
		{
			System.out.println("you can't open a bed.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("There's nothing to open.");
		}
		else if (positionRightSide == true)
		{
			System.out.println(
					"The dresser isn't locked, but doors are stuck and wont budge open, you need something to get some leverage.");
		}
		else if (positionFront == true)
		{
			System.out.println("still locked.");
		}
		else if (positionBack == true)
		{
			System.out.println("you can't open a table.");
		}

	}

	private void lookInBeginingTwo()
	{
		if (positionMiddle == true)
		{
			System.out.println(
					"In front of you is a knee high dirty bed, it has dusty, pale white sheets and a thin pillow at the head.");
			System.out.println(
					"The room is a sqaure shape, the walls are made of concrete, in front of you is a metal door, to Your left you see a ratty bed, to your right you see a dresser, behind you is a table.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("Just an empty space.");

		}
		else if (positionRightSide == true)
		{
			System.out.println("in front of you is a heavy, old dresser, it is currently closed.");
		}
		else if (positionBack == true)
		{
			System.out.println("In front of you is a shaky wooden table.");
		}
		else if (positionFront == true)
		{
			System.out.println("In front of you is a rusty metal door.");
		}
	}

	public ChooseAction chooseMiddle(ChooseAction action)
	{

		switch (action)
		{
		case LOOK:
			lookInMiddle();
			break;
		case OPEN:
			openInMiddle();
			break;
		case EXAMINE:
			examineInMiddle();
			break;
		case MOVETOFRONT:
			moveToFrontInMiddle();
			break;
		case MOVETOBACK:
			moveToBackInMiddle();
			break;
		case MOVETOLEFTSIDE:
			moveToLeftInMiddle();
			break;
		case MOVETORIGHTSIDE:
			moveToRightInMiddle();
			break;
		case MOVETOMIDDLE:
			moveToMiddleInMiddle();
			break;
		case PLACE:
			PlaceInMiddle();
			break;
		case ACTIONDESTROY:
			actionDestroyInMiddle();
			break;
		case PICKUP:
			actionPickUpInMiddle();
			break;
		default:
			System.out.println("That is not an action you can do, try again.");
			chooseMiddle(action);
			break;
		}
		{
		}
		return action;

	}

	private void actionPickUpInMiddle()
	{
		if (positionRightSide == true && dresserOpened == true)
		{
			System.out.print("You pick up a glass container with a key in it, you can't open it.");
			System.out.println("you feel like the room is shrinking");
			inventory = true;
			keyContainerPickedUp = true;
		}
		else if (positionBack == true)
		{
			System.out.print("even if you picked up the hammer you have nothing to use it on.");
		}
		else
		{
			System.out.print("Nothing to pick up.");
		}

	}

	private void actionDestroyInMiddle()
	{
		System.out.println("There's nothing to destroy, and nothing to destroy that nothing with.");

	}

	private void PlaceInMiddle()
	{if(inventory = false)
	{
		System.out.println("You don't have anything to place.");
	}
	else
	{
	System.out.println("why would you place the crowbar?");	
	}
	}
	private void moveToRightInMiddle()
	{
		System.out.println("You move to the right so that you are standing in front of the dresser.");
		updatePosition(4);
	}

	private void moveToLeftInMiddle()
	{
		System.out.println("You move to the left so that you are standing in front of where the bed used to be.");
		updatePosition(3);
	}

	private void moveToBackInMiddle()
	{
		System.out.println("You move to the back so that you are standing in front of the table.");
		updatePosition(2);
	}

	private void moveToFrontInMiddle()
	{
		System.out.println("You move to the front so that you are standing in front of the metal door");
		updatePosition(1);
	}

	private void moveToMiddleInMiddle()
	{
		System.out.println("You move to the middle so that you are standing on the bed");
		updatePosition(5);
	}

	private void examineInMiddle()
	{
		if (positionMiddle == true)
		{
			System.out.println(
					"your in the middle of the room standing on the bed, you can feel it creaking under your weight, theres nothing new about the bed, and there's no give in the ceiling when you push against it.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("You look at the empty space where the bed used to be and see a whole lot'a nothing.");
		}
		else if (positionRightSide == true && dresserOpened == false)
		{
			System.out.println(
					"The dresser is a faded brown, it looks sturdy and would be immposible to move, but you can probably use the crowbar to open it.");
		}
		else if (dresserOpened == true)
		{
		System.out.println("You see a glass container with something encased in it on one of the shelves.");
		}
		else if (positionFront == true)
		{
			System.out.println(
					"The metal door is locked, and strong enough that you wouldn't be able to break it down, you have to find a key to open it");
		}
		else if (positionBack == true)
		{
			System.out.println("the table has a hammer sitting on it, the hammer looks weak from overuse.");
		}

	}

	private void openInMiddle()
	{
		if (positionMiddle == true)
		{
			System.out.println("you can't open a bed.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("There's nothing to open.");
		}
		else if (positionRightSide == true && dresserOpened == false)
		{
			System.out.println("You use the crowbar to open the dresser, dust fly's everywhere.");
			dresserOpened = true;
		}
		else if(dresserOpened == true)
		{
			System.out.println("already opened.");
		}
		else if (positionFront == true)
		{
			System.out.println("still locked.");
		}
		else if (positionBack == true)
		{
			System.out.println("you can't open a table.");
		}
	}

	private void lookInMiddle()
	{
		if (positionMiddle == true)
		{
			System.out.println(
					"In front of you is a knee high dirty bed, it has dusty, pale white sheets and a thin pillow at the head.");
			System.out.println(
					"The room is a sqaure shape, the walls are made of concrete, in front of you is a metal door, to Your left you see a ratty bed, to your right you see a dresser, behind you is a table.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("Just an empty space.");
		}
		else if (positionRightSide == true && dresserOpened == false)
		{
			System.out.println("in front of you is a heavy, old dresser, it is currently closed.");
		}
		else if(dresserOpened == true)
		{
			System.out.println("The dresser is opened, you see something inside.");
		}
		else if (positionBack == true)
		{
			System.out.println("In front of you is a shaky wooden table.");
		}
		else if (positionFront == true)
		{
			System.out.println("In front of you is a rusty metal door.");
		}
	}

	public ChooseAction chooseMiddleTwo(ChooseAction action)
	{
		switch (action)
		{
		case LOOK:
			lookInMiddleTwo();
			break;
		case OPEN:
			openInMiddleTwo();
			break;
		case EXAMINE:
			examineInMiddleTwo();
			break;
		case MOVETOFRONT:
			moveToFrontInMiddleTwo();
			break;
		case MOVETOBACK:
			moveToBackInMiddleTwo();
			break;
		case MOVETOLEFTSIDE:
			moveToLeftInMiddleTwo();
			break;
		case MOVETORIGHTSIDE:
			moveToRightInMiddleTwo();
			break;
		case MOVETOMIDDLE:
			moveToMiddleInMiddleTwo();
			break;
		case PLACE:
			PlaceInMiddleTwo();
			break;
		case ACTIONDESTROY:
			actionDestroyInMiddleTwo();
			break;
		case PICKUP:
			actionPickUpInMiddleTwo();
			break;
		default:
			System.out.println("That is not an action you can do, try again.");
			chooseMiddleTwo(action);
			break;
		}
		{
		}
		return action;

	}

	private void actionPickUpInMiddleTwo()
	{
		if (positionBack == true)
		{
			System.out.print("Your already holding the key, you have to put it down first.");
		}
		else
		{
			System.out.print("Nothing to pick up.");
		}

	}

	private void actionDestroyInMiddleTwo()
	{
		System.out.println("There's nothing to destroy, and nothing to destroy that nothing with.");
	}

	private void PlaceInMiddleTwo()
	{
		if (positionBack == true)
		{
			System.out.println("You place the glass container on the table.");
			System.out.println("You think you see a the walls move out of the corner of your eye");
			inventory = false;
			keyContainerPlaced = true;
		}
		else
		{
			System.out.println("why would you place the key here?");
		}
	}

	private void moveToRightInMiddleTwo()
	{
		System.out.println("You move to the right so that you are standing in front of the dresser.");
		updatePosition(4);
	}

	private void moveToLeftInMiddleTwo()
	{
		System.out.println("You move to the left so that you are standing in front of where the bed used to be.");
		updatePosition(3);
	}

	private void moveToBackInMiddleTwo()
	{
		System.out.println("You move to the back so that you are standing in front of the table.");
		updatePosition(2);

	}

	private void moveToFrontInMiddleTwo()
	{
		System.out.println("You move to the front so that you are standing in front of the metal door");
		updatePosition(1);
	}

	private void moveToMiddleInMiddleTwo()
	{
		System.out.println("You move to the middle so that you are standing on the bed");
		updatePosition(5);
	}

	private void examineInMiddleTwo()
	{
		if (positionMiddle == true)
		{
			System.out.println(
					"your in the middle of the room standing on the bed, you can feel it creaking under your weight, theres nothing new about the bed, and there's no give in the ceiling when you push against it.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("You look at the empty space where the bed used to be and see a whole lot'a nothing.");
		}
		else if (positionRightSide == true)
		{
			System.out.println(
					"The dresser is a faded brown, it looks sturdy and would be immposible to move, it's currently empty.");
		}
		else if (positionFront == true)
		{
			System.out.println(
					"The metal door is locked, and strong enough that you wouldn't be able to break it down, you have to find a key to open it");
		}
		else if (positionBack == true)
		{
			System.out.println("the table has a hammer sitting on it, the hammer looks weak from overuse.");
		}

	}

	private void openInMiddleTwo()
	{
		if (positionMiddle == true)
		{
			System.out.println("you can't open a bed.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("There's nothing to open.");
		}
		else if (positionRightSide == true)
		{
			System.out.println("The dresser is already opened.");
			dresserOpened = true;
		}
		else if (positionFront == true)
		{
			System.out.println("still locked.");
		}
		else if (positionBack == true)
		{
			System.out.println("you can't open a table.");
		}

	}

	private void lookInMiddleTwo()
	{
		if (positionMiddle == true)
		{
			System.out.println(
					"In front of you is a knee high dirty bed, it has dusty, pale white sheets and a thin pillow at the head.");
			System.out.println(
					"The room is a sqaure shape, the walls are made of concrete, in front of you is a metal door, to Your left you see a ratty bed, to your right you see a dresser, behind you is a table.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("Just an empty space.");
		}
		else if (positionRightSide == true)
		{
			System.out
					.println("in front of you is a heavy, old dresser, it is currently opened but has nothing inside.");
		}
		else if (positionBack == true)
		{
			System.out.println("In front of you is a shaky wooden table.");
		}
		else if (positionFront == true)
		{
			System.out.println("In front of you is a rusty metal door.");
		}

	}

	public ChooseAction chooseMiddleThree(ChooseAction action)
	{

		switch (action)
		{
		case LOOK:
			lookInMiddleThree();
			break;
		case OPEN:
			openInMiddleThree();
			break;
		case EXAMINE:
			examineInMiddleThree();
			break;
		case MOVETOFRONT:
			moveToFrontInMiddleThree();
			break;
		case MOVETOBACK:
			moveToBackInMiddleThree();
			break;
		case MOVETOLEFTSIDE:
			moveToLeftInMiddleThree();
			break;
		case MOVETORIGHTSIDE:
			moveToRightInMiddleThree();
			break;
		case MOVETOMIDDLE:
			moveToMiddleInMiddleThree();
			break;
		case PLACE:
			PlaceInMiddleThree();
			break;
		case ACTIONDESTROY:
			actionDestroyInMiddleThree();
			break;
		case PICKUP:
			actionPickUpInMiddleThree();
			break;
		default:
			System.out.println("That is not an action you can do, try again.");
			chooseMiddleThree(action);
			break;
		}
		{
		}
		return action;

	}

	private void moveToMiddleInMiddleThree()
	{
		System.out.println("You move to the middle so that you are standing on the bed");
		updatePosition(5);
	}

	private void lookInMiddleThree()
	{
		if (positionMiddle == true)
		{
			System.out.println(
					"In front of you is a knee high dirty bed, it has dusty, pale white sheets and a thin pillow at the head.");
			System.out.println(
					"The room is a sqaure shape, the walls are made of concrete, in front of you is a metal door, to Your left you see a ratty bed, to your right you see a dresser, behind you is a table.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("Just an empty space.");
		}
		else if (positionRightSide == true)
		{
			System.out
					.println("in front of you is a heavy, old dresser, it is currently opened but has nothing inside.");
		}
		else if (positionBack == true)
		{
			System.out.println("In front of you is a shaky wooden table.");
		}
		else if (positionFront == true)
		{
			System.out.println("In front of you is a rusty metal door.");
		}

	}

	private void openInMiddleThree()
	{
		if (positionMiddle == true)
		{
			System.out.println("you can't open a bed.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("There's nothing to open.");
		}
		else if (positionRightSide == true)
		{
			System.out.println("The dresser is already opened.");
		}
		else if (positionFront == true)
		{
			System.out.println("still locked.");
		}
		else if (positionBack == true)
		{
			System.out.println(
					"you can't open a table, and you can't open the key container, but mabye you could smash it open.");
		}
	}

	private void examineInMiddleThree()
	{
		if (positionMiddle == true)
		{
			System.out.println(
					"your in the middle of the room standing on the bed, you can feel it creaking under your weight, theres nothing new about the bed, and there's no give in the ceiling when you push against it.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("You look at the empty space where the bed used to be and see a whole lot'a nothing.");
		}
		else if (positionRightSide == true)
		{
			System.out.println(
					"The dresser is a faded brown, it looks sturdy and would be immposible to move, it's currently empty.");
		}
		else if (positionFront == true)
		{
			System.out.println(
					"The metal door is locked, and strong enough that you wouldn't be able to break it down, you have to find a key to open it");
		}
		else if (positionBack == true)
		{
			System.out.println(
					"the table has a hammer sitting on it, the hammer looks weak from overuse, mabye you can use it to open the container.");
		}
	}

	private void moveToFrontInMiddleThree()
	{
		System.out.println("You move to the front so that you are standing in front of the metal door");
		updatePosition(1);
	}

	private void moveToBackInMiddleThree()
	{
		System.out.println("You move to the back so that you are standing in front of the table.");
		updatePosition(2);
	}

	private void moveToLeftInMiddleThree()
	{
		System.out.println("You move to the left so that you are standing in front of where the bed used to be.");
		updatePosition(3);
	}

	private void moveToRightInMiddleThree()
	{
		System.out.println("You move to the right so that you are standing in front of the dresser.");
		updatePosition(4);
	}

	private void PlaceInMiddleThree()
	{
		System.out.println("You have nothing to place.");
	}

	private void actionDestroyInMiddleThree()
	{
		System.out.println("You can't smash the container with your fist's, you need to pick up the hammer.");
	}

	private void actionPickUpInMiddleThree()
	{
		if (positionBack == true && inventory == false)
		{
			System.out.print("You pick up the hammer, it's heavier than you expected.");
			System.out.println("You look up and the ceiling looks closer");
			hammerPickedUp = true;
			inventory = true;
		}
		else
		{
			System.out.print("Nothing to pick up.");
		}
	}

	public ChooseAction chooseEnd(ChooseAction action)
	{

		switch (action)
		{
		case LOOK:
			lookInEnd();
			break;
		case OPEN:
			openInEnd();
			break;
		case EXAMINE:
			examineInEnd();
			break;
		case MOVETOFRONT:
			moveToFrontInEnd();
			break;
		case MOVETOBACK:
			moveToBackInEnd();
			break;
		case MOVETOLEFTSIDE:
			moveToLeftInEnd();
			break;
		case MOVETORIGHTSIDE:
			moveToRightInEnd();
		case MOVETOMIDDLE:
			moveToMiddleInEnd();
			break;
		case PLACE:
			PlaceInEnd();
			break;
		case ACTIONDESTROY:
			actionDestroyInEnd();
			break;
		case PICKUP:
			actionPickUpInEnd();
			break;
		default:
			System.out.println("That is not an action you can do, try again.");
			chooseEnd(action);
			break;
		}
		{
		}
		return action;

	}

	private void moveToMiddleInEnd()
	{
		System.out.println("You move to the middle so that you are standing on the bed");
		updatePosition(5);
	}

	private void PlaceInEnd()
	{
		if (keyOpened == true && positionBack == true)
			System.out.println("you put down the hammer.");
		else
		{
			System.out.println("why would you put the hammer down?");
		}
	}

	private void lookInEnd()
	{
		if (positionMiddle == true)
		{
			System.out.println(
					"In front of you is a knee high dirty bed, it has dusty, pale white sheets and a thin pillow at the head.");
			System.out.println(
					"The room is a sqaure shape, the walls are made of concrete, in front of you is a metal door, to Your left you see a ratty bed, to your right you see a dresser, behind you is a table.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("Just an empty space.");
		}
		else if (positionRightSide == true)
		{
			System.out
					.println("in front of you is a heavy, old dresser, it is currently opened but has nothing inside.");
		}
		else if (positionBack == true)
		{
			System.out.println("In front of you is a shaky wooden table.");
		}
		else if (positionFront == true)
		{
			System.out.println("In front of you is a rusty metal door.");
		}
	}

	private void openInEnd()
	{
		if (positionMiddle == true)
		{
			System.out.println("you can't open a bed.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("There's nothing to open.");
		}
		else if (positionRightSide == true)
		{
			System.out.println("The dresser is already opened.");
		}
		else if (positionFront == true)
		{
			System.out.println("still locked.");
		}
		else if (positionBack == true)
		{
			System.out.println(
					"you can't open a table, and you can't open the key container, but mabye you could smash it open.");
		}
	}

	private void examineInEnd()
	{
		if (positionMiddle == true)
		{
			System.out.println(
					"your in the middle of the room standing on the bed, you can feel it creaking under your weight, theres nothing new about the bed, and there's no give in the ceiling when you push against it.");
		}
		else if (positionLeftSide == true)
		{
			System.out.println("You look at the empty space where the bed used to be and see a whole lot'a nothing.");
		}
		else if (positionRightSide == true)
		{
			System.out.println(
					"The dresser is a faded brown, it looks sturdy and would be immposible to move, it's currently empty.");
		}
		else if (positionFront == true)
		{
			System.out.println(
					"The metal door is locked, and strong enough that you wouldn't be able to break it down, you have to find a key to open it");
		}
		else if (positionBack == true && keyOpened == false)
		{
			System.out.println(
					"the table has a hammer sitting on it, the hammer looks weak from overuse, mabye you can use it to open the container.");
		}
		else if (positionBack == true && keyOpened == true)
		{
			System.out.println("the table has the smashed container on it, and the rusty key is acessable.");
		}

	}

	private void moveToFrontInEnd()
	{
		System.out.println("You move to the front so that you are standing in front of the metal door");
		updatePosition(1);
	}

	private void moveToBackInEnd()
	{
		System.out.println("You move to the back so that you are standing in front of the table.");
		updatePosition(2);
	}

	private void moveToLeftInEnd()
	{
		System.out.println("You move to the left so that you are standing in front of where the bed used to be.");
		updatePosition(3);

	}

	private void moveToRightInEnd()
	{
		System.out.println("You move to the right so that you are standing in front of the dresser.");
		updatePosition(4);

	}

	private void actionDestroyInEnd()
	{
		if (positionBack == true)
			System.out.println("You smash the glass contiainer apart so the key is free.");
		keyOpened = true;
	}

	private void actionPickUpInEnd()
	{
		if (positionBack == true && keyOpened == true)
		{
			System.out.print("You pick up the small rust key, it's cold against your fingers.");
			System.out.println("The walls are so close, You feel like you're suffocating");
			keyPickedUp = true;
			inventory = true;
		}
		else
		{
			System.out.print("Nothing to pick up.");
		}
	}

	public ChooseAction chooseEndTwo(ChooseAction action)
	{

		switch (action)
		{
		case LOOK:
			lookInEndTwo();
			break;
		case OPEN:
			openInEndTwo();
			break;
		case EXAMINE:
			examineInEndTwo();
			break;
		case MOVETOFRONT:
			moveToFrontInEndTwo();
			break;
		case MOVETOBACK:
			moveToBackInEndTwo();
			break;
		case MOVETOLEFTSIDE:
			moveToLeftInEndTwo();
			break;
		case MOVETORIGHTSIDE:
			moveToRightInEndTwo();
			break;
		case MOVETOMIDDLE:
			moveToMiddleInEndTwo();
			break;
		case PLACE:
			PlaceInEndTwo();
			break;
		case ACTIONDESTROY:
			actionDestroyInEndTwo();
			break;
		case PICKUP:
			actionPickUpInEndTwo();
			break;
		default:
			System.out.println("That is not an action you can do, try again.");
			chooseEndTwo(action);
			break;
		}
		{
		}
		return action;

	}

	private void moveToMiddleInEndTwo()
	{
		System.out.println("You move to the middle so that you are standing on the bed");
		updatePosition(5);
	}

	private void lookInEndTwo()
	{
		System.out.println("what are you looking around, hurry and leave.");
	}

	private void openInEndTwo()
	{
		if (positionFront == true)
		{
			System.out.println("You use the key to unlock the door.");
			System.out.println("You swing the door open, as the walls move to crush you.");
			doorUnlocked = true;
			System.out.println("You wake up in a small square room.");
		}
		else
		{
			System.out.println("There's only one thing you need to open right now, and that's the door.");
		}
	}

	private void examineInEndTwo()
	{
		System.out.println("You know what needs a good examining? the door.");
	}

	private void moveToFrontInEndTwo()
	{
		System.out.println("You move to the front so that you are standing in front of the metal door");
		updatePosition(1);
	}

	private void moveToBackInEndTwo()
	{
		System.out.println("You move to the back so that you are standing in front of the table.");
		updatePosition(2);
	}

	private void moveToLeftInEndTwo()
	{
		System.out.println("You move to the left so that you are standing in front of where the bed used to be.");
		updatePosition(3);

	}

	private void moveToRightInEndTwo()
	{
		System.out.println("You move to the right so that you are standing in front of the dresser.");
		updatePosition(4);
	}

	private void PlaceInEndTwo()
	{
		System.out.println("why would you place the key?");
	}

	private void actionDestroyInEndTwo()
	{
		System.out.println("There's nothing to destroy, and nothing to destroy that nothing with.");
	}

	private void actionPickUpInEndTwo()
	{
		System.out.print("Nothing to pick up.");
	}

}
