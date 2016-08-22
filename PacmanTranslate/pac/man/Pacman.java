package man;

import java.awt.Image;
import java.util.Timer;
public class Pacman
{
	// Attributes to describe pacman
		Image[] pacman = new Image[5];

		String pacDirection = "Stop";

		String nextPacDirection = "";

		Short pacSpeed = 10;
		int counter = 0;
		int score = 0;
		short mazeCompletion;
		Timer pacMoveClock = new Timer();
GameRun game = new GameRun();
	public void assignKeys()
	{
		//
		// ' keyvalues to set nextpacdirection
		//
		// ' when it is set then we use it to see if the move is valid

		if (e.KeyValue = Keys.Up)
		{
			nextPacDirection = "Up";
		}
		else if (e.KeyValue = Keys.Down)
		{
			nextPacDirection = "Down";
		}
		else if (e.KeyValue = Keys.Right)
		{
			nextPacDirection = "Right";
		}
		else if (e.KeyValue = Keys.Left)
		{
			nextPacDirection = "Left";
		}
		else
		{
			nextPacDirection = "Stop";
		}

	}

	void PacMoveClock_Tick()
	{

//	'This function deals with all the Pacman move stuff.
//
//	' It does all of the following...
//
//	'1) Updates Counter so we can animate our Pacman from open mouth to close mouth to make him "Munch". Odd is open and even is odd
//
//	'2) Use HitWalls to see if next move will be a collision. If it is set PacDirection to Stop. If it isn't make NextPacDirection and PacDirection the same.
//
//	'3) Check to see what edibles Pacman has collided with and update score and play sound files accordingly
//
//	'4) Check to see if Pacman has moved through the secret passage and move him to the other side of the maze.
//
//	'Check for collision with walls then move or stop pacman accordingly

	counter += 1;

	if (game.hitWalls(myPac, nextPacDirection, pacSpeed) == true)
	{
	if (nextPacDirection == pacDirection)
		{
	pacDirection = "Stop";

		}
	movePac();

//	' 'Check to see if pacman is going through the tunnels and teleport him to
//
//	' ' other side of map if so

	if (myPac.Left > 450)
		{

	myPac.Left = -50;
	myPac.Top = 50;
		}
	else if (myPac.Left < -50)
		{
	myPac.Left = 450;
	myPac.Top = 50;
		}

	if (myPac.Top > 450)
	{
	myPac.Top = -50;
	myPac.Left = 50;
	}
	else if (myPac.Top < -50)
	{
	myPac.Top = 450;
	myPac.Left = 50;
	}

//	' ' CHANGE NUMBERS ^^
//
//	' ' Have portals move

	if (hitGhost(myPac, myGhost1) == "Dead")
	{
//	'<- MyPac and MyGhost location
	Computer.Audio.Play(Resources.pacman_death, AudioPlayMode.Background);
	pacMoveClock.Enabled = false;
	}
	else if (hitGhost(myPac, myGhost1) == "Ghost Score") 
	{
	score += 200;
	Computer.Audio.Play(Resources.pacman_eatghost, AudioPlayMode.Background);
	ghostMoveClock1.Enabled = false;

//	'Change name: "InkyClock.Enabled"

//	'Different timer for each ghost because once it's eaten, it will stop moving

//	MyGhost1.Left = -100 'Move it off screen instead of making visibily false because it might still kill you

	myGhost1.Top = -100;
	}

//	' 'See what edibles Pacman has collided with and play correct sounds and update score

	String eatable = eats(myPac);

	if (eatable == "Dot") 
	{
	score += 10;

	Computer.Audio.Play(Resources.pacman_chomp, AudioPlayMode.Background);
	}
	else if( eatable == "PowerPellet")
		{

	powerPelletClock.Enabled = true;

	score += 100;

	Computer.Audio.Play(Resources.pacman_chomp, AudioPlayMode.Background);
		}
	else if( eatable == "Fruit") 
	{
	score = score + 1000;
	Computer.Audio.Play(Resources.pacman_chomp, AudioPlayMode.Background)
	}
	else if (eatable == "Complete") 
	{
	pacMoveClock.Enabled = false;
	ghostMoveClock1.Enabled = false;
	messageBox.Show("Level Complete");
	}
	System.out.println("Score " + score);
	}
	}

	private void movePac()
	{
//	'This simply moves our pacman in the direction stored in
//
//	' PacPacDirection and animates the chomping motion based
//
//	' on the # stored in Counter
//
//	' if Counter is an even # it will load the open mouth
//
//	' image for the correct direction.
//
//	' if counter is odd it will load the closed mouth pacman

	if (pacDirection == "Right")
	{
	myPac.Left += pacSpeed;
	if (counter % 2 == 0)
		{
	myPac.Image = pacman[4];
	}
	else
	{
	myPac.Image = pacman[0];
	}
	}
	else if (pacDirection == "Left")
		{
	myPac.Left -= pacSpeed;
	if (counter % 2 == 0) 
	{
	myPac.Image = pacman[3];
	}
	else
	{
	myPac.Image = pacman[0];
	}
		}
	else if( pacDirection == "Up") 
	{
	myPac.Top -= pacSpeed;
	if (counter % 2 == 0) 
	{
	myPac.Image = pacman[1];
	}
	else
	{
	myPac.Image = pacman[0];
	}
	}
	else if (pacDirection == "Down")
		{
	myPac.Top += pacSpeed;
	if(counter % 2 == 0) 
	{
	myPac.Image = pacman[2];
	}
	else
	{
	myPac.Image = pacman[0];
	}
	}
}

	// 'loop through all the dots to see if pacman has hit it. If the bounds of
	// the Pacman picturebox
	//
	// 'touches the bounds of the dot or other object return its name.
	//
	// 'so if this function returns a "Dot" pac has his a dot. If it returns a
	// "Pellet" pacman has hit a pellet
	//
	// 'and if ut returns "Fruit" pacman has eaten a special. If it returns
	// nothing then no collision has occured
	//
	// 'We also move the dots off screen to make it look like they disappeared
	

	private String hitGhost()
	{
		Short distanceApart = Math.Sqrt((myPac.Left - myGhost1.Left) ^ 2 + (myPac.Top - myGhost1.Top) ^ 2);
	if(distanceApart <= 45 && powerPelletClock.Enabled == false)
	{
	return "Dead";
	}
	else if (distanceApart <= 45 && Me.PowerPelletClock.Enabled = true)
	{
	return "Ghost Score";
	}
	else
	{
	return "";
	}
	}
}
