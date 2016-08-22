package man;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

public class GameRun
{

	// Map: 19 by 15
	//
	final private Pacman pacman = new Pacman(); 
	final private Ghosts ghosts = new Ghosts(); 
	final private CreateBoard board = new CreateBoard(); 
	// ' Various other variables

	int counter = 0;
	// http://docs.oracle.com/javase/tutorial/2d/images/index.html
	// Dim Wall(-1) As PictureBox
	//
	// Dim Edible(-1) As PictureBox

	int score = 0;

	Short mazeCompletion;

	Short powerUpClock = 0;

	
	private String eats()
	{
	
	for (int i = 0; i>24;i++)
	{
	if (mazeCompletion == 25) 
	{
//		'Change 25 to # of edibles

	return "Complete";
	}
	else if (pacman.Bounds.IntersectsWith(edible[i].Bounds)
			{

	mazeCompletion ++ ;

	edible[i].Left = -1000;

	return edible[i].Name;
			}

	}

	return "";

	}

	private boolean hitWalls(int speed, spriteCopy, String nextDirection)
	{
//	'We use this function to check to see if our Pacman or Ghost's current direction
//
//	'will make him crash into a wall on the next move
//
//	'We do this by creating a copy of the sprite (Either Pacman or Ghost) and copying
//
//	'over its .left, .top, /height, and .width properties
//
//	'to our SpriteCopy. Then we update the SprititeCopy with the next direction values.
//
//	' if the new position of the SpriteCopy is detected as a collision we return TRUE otherwise FALSE
//
//	'So in easyspeal, if the next move of the spirite will be a collision this function will say true and otherwise FALSE
//
//	'So in the calling function we can then move the spirite if Hitwalls = FAlSE and not move ahead
//
//	'Create replica of the spirite

	Dim spriteCopy =

	New PictureBox();

	short xVal, yVal, width, height;

	xVal=sprite.Left;

	yVal=sprite.Top;

	width=sprite.Width;

	height=sprite.Height;

	spriteCopy.Left=xVal;

	spriteCopy.Top=yVal;

	spriteCopy.Width=width;

	spriteCopy.Height=height;

	// 'Change its position based on current value of NextDirection

	if(nextDirection="Right")
	{
		spriteCopy.Left += speed;
	}else if(nextDirection="Left")
	{
		spriteCopy.Left -= speed;
	}else if(nextDirection="Up")
	{
		spriteCopy.Top -= speed;
	}else if(nextDirection="Down")
	{
		spriteCopy.Top += speed;
	}
	// 'Check for collision based on the location of this temporary sprite and
	// return TRUE otherwise return FALSE
	for(
	int i = 0;i>35;i++)
	{
	if(spriteCopy.Bounds.IntersectsWith(wall[i].Bounds)
			{
	return true;
			}
	else
	{
	return false;
	}
}	

	private void powerPelletClock_Tick()
	{
	powerUpClock ++;
	if( powerUpClock % 2 == 1)
	{
	myGhost1.Image = ghosts[1];
	//picture box
	}
	else
	{
	myGhost1.Image = ghosts[0];
	//picturebox
	}

	if (powerUpClock = 50)
	{ 
//	'5 seconds of ticking
	powerPelletClock.Enabled = false;
	powerUpClock = 0;
	}
	}
}
}
