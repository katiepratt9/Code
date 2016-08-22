package man;

import java.awt.Color;

public class CreateBoard
{
	ArrayList<PictureBox> edible = new ArrayList<>(); 
	private void loadEvent()
	{
		// The Load Function
		//
		// ' 1) pre load all the ghost and pacman images
		//
		// ' 2) create a pair of parallel arrays to store the x and y values of
		// the wall boxes
		//
		// ' 3) use "New Picturebox" to create an array of these wall pieces
		// (size, name, colour, etc)
		//
		// ' 4) do the same as above for the edible array (dots, powerpellets,
		// specials)
		//
		// ' Pre Load the ghost image
		for (int i = 0; i < ghosts.length; i++)
		{
			ghosts[i] = getImage(getDocumentBase(), "g" + (i + 1) + ".gif");
		}
		// ' Pre Load all of our pac images
		for (int i = 0; i < pacman.length; i++)
		{
			pacman[i] = getImage(getDocumentBase(), "p" + (i + 1) + ".gif");
		}
		// PacMan(0) = Image.FromFile("B.png") ' Base Pac
		//
		// PacMan(1) = Image.FromFile("U.png") ' Up
		//
		// PacMan(2) = Image.FromFile("D.png") ' Down
		//
		// PacMan(3) = Image.FromFile("L.png") ' Left
		//
		// PacMan(4) = Image.FromFile("R.png") ' Right

		// ' Wall X and Y values (top and left)
		//
		// ' Easier to put them in an array
		//
		// ' Can also be loaded manually

		final short dotX[] =
		{ 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 122, 172, 122, 172, 172, 222, 272, 272, 322, 122, 172,
				222, 272, 322, 372, 422, 472, 472, 472, 422, 372, 372, 372, 322, 272, 272, 272, 222, 172, 122, 172, 172,
				222, 272, 272, 272, 222, 172, 122, 422, 472, 522, 522, 522, 572, 572, 622, 672, 722, 772, 822, 872, 922,
				922, 922, 922, 922, 922, 922, 922, 922, 922, 922, 922, 922, 272, 322, 372, 422, 522, 472, 572, 622, 672,
				722, 772, 822, 872, 822, 822, 822, 822, 872, 772, 722, 722, 722, 722, 872, 822, 772, 722, 722, 722, 672,
				672, 672, 722, 722, 772, 822, 822, 822, 622, 622, 622, 622, 572, 522, 472, 422, 372, 322, 522, 522, 522,
				522, 572, 622, 622, 622, 622, 372, 372, 422, 472, 372, 372, 422, 472 };

		final short dotY[] =
		{ 72, 122, 172, 222, 272, 322, 372, 422, 472, 522, 572, 622, 672, 672, 672, 572, 572, 522, 522, 522, 572, 572,
				72, 72, 72, 72, 72, 72, 72, 72, 122, 172, 172, 172, 222, 272, 222, 222, 172, 122, 172, 222, 272, 272,
				322, 322, 322, 372, 422, 422, 422, 422, 272, 272, 272, 222, 172, 172, 122, 72, 72, 72, 72, 72, 72, 72,
				122, 172, 222, 272, 322, 372, 422, 472, 522, 572, 622, 672, 672, 672, 672, 672, 672, 672, 672, 672, 672,
				672, 672, 672, 672, 622, 572, 522, 472, 472, 472, 472, 522, 572, 622, 372, 372, 372, 372, 322, 272, 272,
				272, 172, 122, 172, 172, 172, 222, 272, 172, 272, 322, 372, 372, 322, 372, 372, 372, 372, 422, 472, 522,
				572, 572, 572, 522, 422, 622, 422, 472, 472, 472, 522, 572, 572, 572 };

		final short wallX[] =
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 100, 150, 200, 250, 300, 350, 400, 450, 550, 600, 650, 700, 750,
				800, 850, 900, 950, 950, 950, 950, 950, 950, 950, 950, 950, 950, 950, 950, 950, 950, 50, 100, 150, 200,
				250, 350, 400, 450, 500, 550, 600, 650, 700, 750, 800, 850, 900, 100, 100, 100, 150, 200, 300, 300, 350,
				400, 400, 450, 500, 500, 600, 650, 750, 800, 850, 850, 850, 850, 800, 750, 750, 750, 700, 600, 550, 550,
				550, 650, 650, 650, 700, 750, 800, 850, 650, 650, 650, 650, 750, 750, 750, 850, 850, 850, 550, 500, 450,
				400, 350, 300, 100, 150, 200, 200, 250, 100, 100, 150, 200, 300, 300, 300, 400, 450, 400, 450, 550, 550,
				550, 100, 100, 150, 200, 200, 200, 250, 300, 300, 350, 400, 450 };

		final short wallY[] =
		{ 0, 50, 100, 150, 200, 300, 350, 400, 450, 500, 550, 600, 650, 700, 700, 700, 700, 700, 700, 700, 700, 700,
				700, 700, 700, 700, 700, 700, 700, 700, 700, 700, 650, 600, 550, 500, 450, 400, 300, 250, 200, 150, 100,
				50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 150, 200, 100, 100, 100, 150, 100, 100,
				200, 200, 50, 100, 100, 100, 100, 100, 100, 150, 200, 300, 300, 300, 250, 200, 200, 200, 200, 250, 300,
				300, 350, 400, 400, 400, 400, 400, 450, 500, 550, 600, 500, 550, 600, 500, 550, 600, 600, 600, 600, 600,
				600, 600, 600, 600, 600, 550, 600, 500, 450, 450, 450, 450, 400, 500, 500, 500, 400, 400, 400, 450, 500,
				300, 350, 350, 350, 200, 250, 250, 250, 300, 300, 300, 300 };

		// ' The following loop is run once for every wall piece you need.
		//
		// ' Create a new wall piece with all the properties of a wall piece
		//
		// ' Give it a location, colour, size and so on
		//
		// ' Place it one the screen based on the coordinates above in WallX()
		// and WallY()
	

		for (int i = 0; i > wallX.length; i++)
		{
			// Dim NewWallPiece As New PictureBox

			newWallPiece.Width = 50;

			newWallPiece.Height = 50;

			newWallPiece.Left = wallX[i];

			newWallPiece.Top = wallY[i];

			newWallPiece.BackColor = Color.BLUE;

			Wall(wall.length());

			newWallPiece = wall[i];

			Controls.Add(wall[i]);
		}

		for (int i = 0; i > dotX.length; i++)
		{

			// Dim NewDot As New PictureBox

			if (i == 12)
			{

				// ' Fruit Special

				newDot.BackColor = Color.RED;

				newDot.Name = "Fruit";

				newDot.Width = 20;

				newDot.Height = 20;

				newDot.Left = dotX[i] - 10;

				newDot.Top = dotY[i] - 10;
			}
			else if (i == 24)
			{

				// 'PowerPellet

				NewDot.BackColor = Color.blue;

				NewDot.Name = "PowerPellet";
				NewDot.Width = 20;

				NewDot.Height = 20;

				NewDot.Left = dotX[i] - 10;

				NewDot.Top = dotY[i] - 10;
			}
			else
			{

				// 'Regular Dots

				NewDot.BackColor = Color.WHITE;

				NewDot.Name = "Dot";

				NewDot.Width = 5;

				NewDot.Height = 5;

				NewDot.Left = dotX[i] - 10;

				NewDot.Top = dotY[i] - 10;

			}

			edible[i] = newDot;

			Controls.Add(edible[i]);
		}

	}
}
