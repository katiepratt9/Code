package man;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public class Ghosts
{
	// ' Attributes to describe Ghosts
		Image[] ghosts = new Image[4];
		// <<-- Need more images for more ghosts

		String ghostDirection = "Left";

		String nextGhostDirection = "";

		Short ghostSpeed = 5;

	private void GhostMoveClock_Tick()
	{
	ghostChooseDirection();

	if (ghostDirection == "Left")
		{
	myGhost1.Left -= ghostSpeed;
		}
	else if( ghostDirection == "Right") 
	{
	myGhost1.Left += ghostSpeed;
	}
	else if (ghostDirection == "Up")
	{
	myGhost1.Top -= ghostSpeed;
	}
	else if( ghostDirection == "Down")
	{
	myGhost1.Top += ghostSpeed;
	}
	if( myGhost1.Left >= 450) 
		{ 
//	'Change number because size is different
	myGhost1.Left = -40; 
//	'Change depending on location of passages
		}
	else if (myGhost1.Left < -40)
	{
	myGhost1.Left = 440;
	}
	}

	private void ghostChooseDirection()
	{
		// 'create an array of available directions then randomly choose 1
		//
		// 'Example
		//
		// ' if the spaces below and left of pac are open but above the right
		// are not
		//
		// 'the array DirectionsAvailable() will have 2 values {"Left, "Up"}
		//
		// 'the ghost will randomly select from one of those available spaces
		//
		// 'we can apply some rudimentary AI behaviours to this by checking to
		// see where
		//
		// 'Pac is relative to the ghost and have it choose it's direction
		// strategically
		//
		// 'When you get to the point of adding more ghosts to your game be sure
		// to google
		//
		// 'pacman ghost behaviour" to get a run down on how the ghosts move.

		ArrayList<String> directionsAvailable = new ArrayList<>();
		// 'Assign array value -1 to start with nothing (indicates value will be
		// changed later)

		if (hitWalls(myGhost1, "Up", ghostSpeed) == false && ghostDirection != "Down")
		{
			directionsAvailable.add("Up");

			// 'if going "UP" and current direction is not "DOWN" then add "UP"
			// to list of available directions
		}
		if (hitWalls(myGhost1, "Down", ghostSpeed) == false && ghostDirection != "Up")
		{
			directionsAvailable.add("Down");

		}

		if (hitWalls(myGhost1, "Left", ghostSpeed) == false && ghostDirection != "Right")
		{
			directionsAvailable.add("Left");
		}
		if (hitWalls(myGhost1, "Right", ghostSpeed) == false && ghostDirection != "Left")
		{
			directionsAvailable.add("Right");
		}

		// 'You can comment out the randomize() below to give pacman a more
		// predictable
		//
		// 'during testing

		Random random = new Random();

		ghostDirection = directionsAvailable(Int(Rnd() * directionsAvailable.size()));

		// 'ghost randomize, ghost move strategically, find other two ways for
		// other two ghosts (more AI)

	}
}
