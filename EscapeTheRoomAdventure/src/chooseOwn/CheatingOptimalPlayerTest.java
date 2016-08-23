package chooseOwn;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheatingOptimalPlayerTest
{

	@Test
	public void testCheatingOptimalPlayer()
	{
		CheatingOptimalPlayer optimalPlayer = new CheatingOptimalPlayer();
		
		EscapeTheRoom adventure = new EscapeTheRoom();
		StoryBoard story = new StoryBoard(adventure, optimalPlayer);
		
		story.playOneAction();
		assertFalse(adventure.currentStateOfBed());
		assertFalse(adventure.hasInventory());

		story.playOneAction();
		assertFalse(adventure.currentStateOfBed());
		assertTrue(adventure.hasInventory());

		story.playOneAction();
		assertFalse(adventure.currentStateOfBed());
		assertTrue(adventure.hasInventory());

		story.playOneAction();
		assertTrue(adventure.currentStateOfBed());
		assertFalse(adventure.hasInventory());

		//
		story.playOneAction();
		assertFalse(adventure.currentStateOfCrowBar());

		story.playOneAction();
		assertFalse(adventure.currentStateOfCrowBar());

		story.playOneAction();
		assertTrue(adventure.currentStateOfCrowBar());
//
		story.playOneAction();
		assertFalse(adventure.currentStateOfKeyContainerPickedUp());
		
		story.playOneAction();
		assertFalse(adventure.currentStateOfKeyContainerPickedUp());

		story.playOneAction();
		assertTrue(adventure.currentStateOfKeyContainerPickedUp());
//
		story.playOneAction();
		assertFalse(adventure.currentStateOfKeyContainerPlaced());

		story.playOneAction();
		assertTrue(adventure.currentStateOfKeyContainerPlaced());
//
		story.playOneAction();
		assertTrue(adventure.currentStateOfHammer());
//
		story.playOneAction();
		assertFalse(adventure.currentStateOfKey());

		story.playOneAction();
		assertFalse(adventure.currentStateOfKey());

		story.playOneAction();
		assertTrue(adventure.currentStateOfKey());
		//
		story.playOneAction();
		assertFalse(adventure.currentStateOfDoor());

		story.playOneAction();
		assertTrue(adventure.currentStateOfDoor());

	}

}
