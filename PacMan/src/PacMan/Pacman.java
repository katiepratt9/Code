package PacMan;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pacman
// ArrayList<PictureBox> edible = new ArrayList<PictureBox>(-1);
//
// ArrayList<PictureBox> wall = new ArrayList<PictureBox>(-1);
//
// ArrayList<Image> ghosts = new ArrayList<Image>(4);
//
// ArrayList<Image> pacman = new ArrayList<Image>(5);

{
	String pacDirection = new String();
	{
		pacDirection = "Stop";

		String nextPacDirection;
		nextPacDirection = "";

		short PacSpeed = 10;

		String ghostDirection1;
		ghostDirection1 = "Left";

		String nextGhostDirection1;
		nextGhostDirection1 = "";

		short ghostSpeed1 = -5;

		String ghostDirection2;
		ghostDirection2 = "Left";

		String nextGhostDirection2;
		nextGhostDirection2 = "";

		short ghostSpeed2 = -5;

		String ghostDirection3;
		ghostDirection3 = "Left";

		String nextGhostDirection3;
		nextGhostDirection3 = "";

		short GhostSpeed3 = -5;

		String ghostDirection4;
		ghostDirection4 = "Left";

		String nextGhostDirection4;
		nextGhostDirection4 = "";

		short ghostSpeed4 = 0;

		int counter = 0;

		short score = 0;

		short mazeCompletion;

		short powerUpClock = 0;
	}

	private  Form1_Load()
	{
	ArrayList<Integer> dotX = new ArrayList<Integer>(72, 122, 172, 222, 272, 322, 372, 422, 472, 522, 572, 622, 672, 722, 772, 822, 872, 922, 922, 772, 472, 272, 172, 72, 922, 772, 672, 622, 572, 472, 372, 322, 272, 172, 72, 922, 872, 822, 772, 672, 572, 522, 472, 422, 372, 272, 172, 72, 922, 772, 672, 622, 572, 472, 372, 272, 222, 172, 122, 72, 922, 872, 822, 772, 722, 672, 572, 472, 372, 272, 172, 72, 922, 822, 672, 672, 572, 472, 422, 372, 272, 172, 72, 922, 822, 772, 722, 672, 572, 472, 372, 322, 272, 172, 72, 922, 772, 572, 472, 372, 172, 72, 72, 122, 172, 222, 272, 322, 372, 472, 522, 572, 622, 672, 722, 772, 822, 872, 922);

	ArrayList<Integer> doty = new ArrayList<Integer>(72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 122, 122, 122, 122, 122, 122, 172, 172, 172, 172, 172, 172, 172, 172, 172, 172, 172, 222, 222, 222, 222, 222, 222, 222, 222, 222, 222, 222, 222, 222, 272, 272, 272, 272, 272, 272, 272, 272, 272, 272, 272, 272, 322, 322, 322, 322, 322, 322, 322, 322, 322, 322, 322, 322, 372, 372, 372, 372, 372, 372, 372, 372, 372, 372, 372, 422, 422, 422, 422, 422, 422, 422, 422, 422, 422, 422, 422, 472, 472, 472, 472, 472, 472, 472, 522, 522, 522, 522, 522, 522, 522, 522, 522, 522, 522, 522, 522, 522, 522, 522, 522);

	ghosts[0] = Image.FromFile("Inky.png");

	ghosts[1] = Image.FromFile("InkyVulnerable.png");

	myGhost1.Image = Ghosts[0];

	pacman[0] = Image.FromFile("B.png");//basic

	pacman[1] = Image.FromFile("U.png"); //up

	pacman[2] = Image.FromFile("D.png"); //down

	pacman[3] = Image.FromFile("L.png"); //left

	pacman[4] = Image.FromFile("R.png"); //right

	myPac.Image = pacman[4];

	For (int i = 0;i< dotX.Length(); i++)
	{
		ArrayList<PictureBox> newDot = new ArrayList<PictureBox>;

		if (i == 12)
		{
		newDot.BackColor = Color.Red;

		newDot.Name = "Fruit";

		newDot.Width = 20;

		newDot.Height = 20;

		newDot.Left = dotX(index) - 10;

		newDot.Top = dotY(index) - 10;
		}
		else if (i == 24)
		{
		newDot.BackColor = Color.AliceBlue;

		NewDot.Name = "PowerPellet";

		newDot.Width = 20;

		newDot.Height = 20;

		newDot.Left = dotX[i] - 10;

		newDot.Top = dotY[i] - 10;
		}
		else{
		newDot.BackColor = Color.White;

		newDot.Name = "Dot";

		newDot.Width = 5;

		newDot.Height = 5;

		newDot.Left = dotX(index) - 10;

		newDot.Top = dotY(index) - 10;
		}
	}

//		ReDim Preserve Edible(Edible.Length())
//
//		Edible(index) = NewDot
//
//		Me.Controls.Add(Edible(index))
	}

	ArrayList<Integer> wallX = new ArrayList<Integer>(0, 50, 100, 150, 200, 250, 300, 400, 450, 500, 550, 600, 650, 700,_
			750, 800, 850, 900, 950, 950, 950, 950, 950, 950, 950, 950, 950, 950, 950, 900, 850, 800, 750, 700, 650,
			600, 550, 500, 450, 400, 350, 300, 250, 200, 150, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 100, 100, 100, 100,
			100, 100, 200, 200, 200, 200, 200, 200, 200, 250, 300, 300, 300, 300, 300, 300, 350, 400, 400, 400, 400,
			400, 400, 400, 500, 500, 500, 500, 500, 500, 500, 550, 600, 650, 700, 700, 700, 700, 700, 750, 700, 650,
			600, 600, 600, 600, 800, 850, 850, 850, 850, 800, 850, 800, 800, 850, 800, 850, 850, 800, 800, 850, 850,
			850, 850, 800, 700, 750, 650, 700, 950, 950, 950, 950, 950, 950, 950, 950, 950, 950, 950, 900, 850, 800,
			750, 750, 800, 850, 900, 950, 700, 700);

	ArrayList<Integer> wallY = new ArrayList<Integer>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 100, 150, 200, 250, 300, 400, 450, 500, 550, 550, 550, 550, 550, 550, 550, 550, 550, 550, 550, 550, 550, 550, 550, 550, 550, 550, 550, 500, 400, 350, 300, 250, 200, 150, 100, 50, 450, 400, 300, 350, 200, 150, 100, 100, 150, 200, 300, 350, 400, 450, 450, 450, 350, 300, 250, 200, 100, 100, 100, 150, 250, 300, 400, 450, 500, 450, 400, 350, 300, 250, 150, 100, 100, 100, 100, 100, 150, 200, 250, 350, 350, 450, 450, 450, 400, 300, 200, 450, 450, 400, 350, 250, 250, 150, 150, 100, 100);

	for(
	int i = 0;i<wallX.Length();i++)
	{

		ArrayList<PictureBox> newWallPeice = new ArrayList<PictureBox>();

		newWallPeice.Width = 50;

		newWallPeice.Height = 50;

		newWallPeice.Left = wallX(i);

		newWallPeice.Top = wallY(i);

		newWallPeice.BackColor = Color.BLUE;

		// ReDim Preserve Wall(Wall.Length());
		//
		// wall(i) = NewWallPeice;
		//
		// Me.Controls.Add(Wall(index));

	}
	}

	Private nextPacDirection()
	{
		if(e.KeyValue=Keys.Up){nextPacDirection="Up";}else if(e.KeyValue=Keys.Down){nextPacDirection="Down";}else if(e.KeyValue=Keys.Right){nextPacDirection="Right";}else if(e.KeyValue=Keys.Left){nextPacDirection="Left"}else{nextPacDirection="Stop";}
	}

	Private pacMoveClock()
	{
		counter+=1;if(hitWalls(MyPac,NextPacDirection,PacSpeed)=true){pacDirection="Stop";}else{pacDirection=nextPacDirection;}movePac(pacDirection,counter);if(myPac.Left>1000){myPac.Left=0;myPac.Top=450;else if(myPac.Left<0){myPac.Left=1000;myPac.Top=350;}else if(myPac.Top>500){myPac.Left=350;myPac.Top=0;}else if(myPac.Top<0){myPac.Left=100;myPac.Top=500;}if(hitGhost(myPac,myGhost1)="Dead"){my.Computer.Audio.Play(My.Resources.pacman_death,AudioPlayMode.Background);pacMoveClock.Enabled=false;ghostMoveClock1.Enabled=false;MessageBox.Show("You Died");Close()else if(hitGhost(myPac,myGhost1)="Ghost Score"){score+=200;My.Computer.Audio.Play(My.Resources.pacman_eatghost,AudioPlayMode.Background);ghostMoveClock1.Enabled=false;myGhost1.Left=-1000;}String eatable;eatable=Eats(myPac);if(eatable="Dot"){score+=10;My.Computer.Audio.Play(My.Resources.pacman_chomp,AudioPlayMode.Background);else if(eatable="PowerPellet"){powerPelletClock.Enabled=true;score+=100;My.Computer.Audio.Play(My.Resources.pacman_chomp,AudioPlayMode.Background);else if(eatable="Fruit"){score+=1000;My.Computer.Audio.Play(My.Resources.pacman_chomp,AudioPlayMode.Background);}else if(eatable="Complete"){pacMoveClock.Enabled=false;ghostMoveClock1.Enabled=false;MessageBox.Show("Level Complete");Close();}
		// lblScore.Text = "Score " + Score.ToString;
	}

	private void movePac()
	{
	if (pacDirection = "Right") 
	{
	myPac.Left += PacSpeed;
	if (counter % 2 == 0)
	{
	myPac.Image = pacman(4);
	}
	else
	{
	MyPac.Image = pacman(0);
	}
	}
	else if( PacDirection = "Left")
	{
	myPac.Left -= pacSpeed;
	if(counter % 2 == 0)
	{
	myPac.Image = pacman(3);
	}
	else
	{
	myPac.Image = pacman(0);
	}
	}
	else if (pacDirection = "Up")
	{
	myPac.Top -= pacSpeed;
	if (counter % 2 = 0)
	{
	myPac.Image = pacman(1)
	}
	else
	{
	myPac.Image = pacman(0);
	}
	else if (pacDirection = "Down")
	{
	myPac.Top += pacSpeed;
	}
	}
	if (counter % 2 = 0) 
			{
	myPac.Image = pacman(2);
			}
	else
	{
	myPac.Image = pacman(0);
	}
	}
	private String Eats()
	{
	for(int i = 0;i<118;i++)
	{

	if( mazeCompletion == 119)
	{
	return "Complete";
	}
	else if(pacMan.Bounds.IntersectsWith(Edible(index).Bounds))
	{
	mazeCompletion ++;
	edible(index).Left = -1050;
	return Edible(index).Name;
	}
	}
	return "";
	}
	private 

	HitGhost(ByVal Pacman As PictureBox, ByVal Ghost As PictureBox)

	Dim DistanceApart As Short = Math.Sqrt((MyPac.Left - MyGhost1.Left) ^ 2 + (MyPac.Top - MyGhost1.Top) ^ 2)

	If DistanceApart <= 45 And Me.PowerPelletClock.Enabled = False Then

	Return "Dead"

	ElseIf DistanceApart <= 45 And Me.PowerPelletClock.Enabled = True Then

	Return "Ghost Score"

	Else

	Return ""

	End If

	End Function

	Private Function

	HitWalls(ByVal Sprite As PictureBox, ByVal NextDirection As String, ByVal Speed As Short)

	Dim SpriteCopy =

	New PictureBox()

	Dim XVal, YVal, Width, Height As Short

	XVal = Sprite.Left

	YVal = Sprite.Top

	Width = Sprite.Width

	Height = Sprite.Height

	SpriteCopy.Left = XVal

	SpriteCopy.Top = YVal

	SpriteCopy.Width = Width

	SpriteCopy.Height = Height

	'Change its position based on current value of NextDirection

	If NextDirection = "Right" Then

	SpriteCopy.Left += Speed

	ElseIf NextDirection = "Left" Then

	SpriteCopy.Left -= Speed

	ElseIf NextDirection = "Up" Then

	SpriteCopy.Top -= Speed

	ElseIf NextDirection = "Down" Then

	SpriteCopy.Top += Speed

	End If

	'Check for collision based on the location of this temporary sprite and return TRUE otherwise return FALSE

	For index = 0 To 116

	If SpriteCopy.Bounds.IntersectsWith(Wall(index).Bounds) Then

	Return True

	End If

	Next

	Return False

	End Function

	Private Sub GhostMoveClock1_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles GhostMoveClock1.Tick

	GhostChooseDirection()

	If GhostDirection1 = "Left" Then

	MyGhost1.Left -= GhostSpeed1

	ElseIf GhostDirection1 = "Right" Then

	MyGhost1.Left += GhostSpeed1

	ElseIf GhostDirection1 = "Up" Then

	MyGhost1.Top -= GhostSpeed1

	ElseIf GhostDirection1 = "Down" Then

	MyGhost1.Top += GhostSpeed1

	End If

	If MyGhost1.Left > 1000 Then

	MyGhost1.Left = 0

	MyGhost1.Top = 450

	ElseIf MyGhost1.Left < 0 Then

	MyGhost1.Left = 1000

	MyGhost1.Top = 350

	ElseIf MyGhost1.Top > 500 Then

	MyGhost1.Left = 350

	MyGhost1.Top = 0

	ElseIf MyGhost1.Top < 0 Then

	MyGhost1.Left = 100

	MyGhost1.Top = 500

	End If

	End Sub

	Private ghostChooseDirection()
	{

	Dim DirectionsAvailable(-1) As String 'Assign array value -1 to start

	with nothing (indicates value will be changed later)

	if (hitWalls(MyGhost1, "Up", GhostSpeed1) = False && GhostDirection1 <> "Down")
	{
	ReDim Preserve DirectionsAvailable(DirectionsAvailable.Length())
	DirectionsAvailable(DirectionsAvailable.Length() - 1) = "Up"
	}

	if (hitWalls(MyGhost1, "Down", GhostSpeed1) = False && GhostDirection1 <> "Up" Then

	ReDim Preserve DirectionsAvailable(DirectionsAvailable.Length())

	DirectionsAvailable(DirectionsAvailable.Length() - 1) = "Down"

	End If

	If HitWalls(MyGhost1, "Left", GhostSpeed1) = False And GhostDirection1 <> "Right" Then

	ReDim Preserve DirectionsAvailable(DirectionsAvailable.Length())

	DirectionsAvailable(DirectionsAvailable.Length() - 1) = "Left"

	End If

	If HitWalls(MyGhost1, "Right", GhostSpeed1) = False And GhostDirection1 <> "Left" Then

	ReDim Preserve DirectionsAvailable(DirectionsAvailable.Length())

	DirectionsAvailable(DirectionsAvailable.Length() - 1) = "Right"

	End If

	'Randomize()

	'GhostDirection1 = DirectionsAvailable(Int(Rnd() * DirectionsAvailable.Length))

	'ghost randomize, ghost move strategically, find other two ways for other two

	ghosts (more AI)

}

	Private Sub

	PowerPelletClock_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles PowerPelletClock.Tick
	{
	PowerUpClock += 1

	If (PowerUpClock % 2 = 1)
	{
	Me.MyGhost1.Image = Ghosts(1)
	}
	Else
	{
	Me.MyGhost1.Image = Ghosts(0)
}

	If (PowerUpClock == 70)
	{

	Me.PowerPelletClock.Enabled = False

	PowerUpClock = 0
	}

}
}
