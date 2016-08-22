package Man;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics2D;

public class GameRun JPanel implements ActionListener
{

boolean dying = false;

	  private void playGame(Graphics2D g2d) {
		//if pacman runs into ghost-dies
			        if (dying) {

			            death();

			        } else {
		//movepacman, animate pacman?, move ghost, check if maze is complete
			            pac.movePacman();
			            pac.drawPacman(g2d);
			            pac.moveGhosts(g2d);
			            if (checkMaze())
			            {
			            	winGame();
			            }
			        }
			    }
private void death()
{
	// TODO Auto-generated method stub
	
}
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import Man.CreateBoard;

public class CreateBoard
{
    public void Board() {

    	//loads in images
        loadImages();
        //initilize varibles
        initVariables();
        
        //?
        addKeyListener(new TAdapter());

        //?
        setFocusable(true);

        //set the background color
        setBackground(Color.black);
        //?
        setDoubleBuffered(true);
    }
    private void loadImages() {

        ghost = new ImageIcon("images/ghost.png").getImage();
        pacman1 = new ImageIcon("images/pacman.png").getImage();
        pacman2up = new ImageIcon("images/up1.png").getImage();
        pacman3up = new ImageIcon("images/up2.png").getImage();
        pacman4up = new ImageIcon("images/up3.png").getImage();
        pacman2down = new ImageIcon("images/down1.png").getImage();
        pacman3down = new ImageIcon("images/down2.png").getImage();
        pacman4down = new ImageIcon("images/down3.png").getImage();
        pacman2left = new ImageIcon("images/left1.png").getImage();
        pacman3left = new ImageIcon("images/left2.png").getImage();
        pacman4left = new ImageIcon("images/left3.png").getImage();
        pacman2right = new ImageIcon("images/right1.png").getImage();
        pacman3right = new ImageIcon("images/right2.png").getImage();
        pacman4right = new ImageIcon("images/right3.png").getImage();

    }
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
//		ArrayList<BufferedImage> pacman = new ArrayList<>(5); 
//		ArrayList<BufferedImage> pinky = new ArrayList<>(4);
//		// ' Pre Load the ghost image
//		
//				for (int i = 1; i < pinky.size(); i++)
//				{
//					try
//				    {
//				      // the line that reads the image file
//						
//				      BufferedImage image = ImageIO.read(new File("/KatiePrattDocuments/Workspace/PacmanPicturesAll/" + "p" + i + ".png"));
//				      pinky.set(i, image);
//				    } 
//				    catch (IOException e)
//				    {
//				      // log the exception
//				      // re-throw if desired
//				    }
//				}
//				// ' Pre Load all of our pac images
//				for (int i = 0; i < pacman.size(); i++)
//				{
//
//					try
//				    {
//				      // the line that reads the image file
//						
//				      BufferedImage image = ImageIO.read(new File("/KatiePrattDocuments/Workspace/PacmanPicturesAll/" + "p" + i + ".png"));
//				      pacman.set(i, image);
//				    } 
//				    catch (IOException e)
//				    {
//				      // log the exception
//				      // re-throw if desired
//				    }
//				}
				final short dotX[] =
					{72,122,172,222,272,322,372,422,472,522,622,672,722,772,822,872,922,972,1022,
							72,422,522,622,872,1022,
							572,122,172,222,272,322,422,522,622,722,772,822,872,1022,
							72,172,322,422,522,622,722,872,1022,
							72,172,322,422,522,622,672,722,772,822,872,1022,
							72,172,222,272,322,422,522,622,822,1022,
							72,172,322,422,522,622,672,722,822,922,972,1022,
							72,172,222,272,322,422,522,622,722,822,922,1022,
							72,172,222,422,522,622,722,822,922,972,
							72,122,172,222,272,322,422,522,622,722,822,922,1022,
							72,422,522,622,722,822,922,1022,
							72,122,172,222,272,322,372,422,472,522,622,672,722,772,822,872,922,1022,
							72,172,272,372,472,622,1022,
							72,172,272,372,472,522,572,622,672,722,772,1022,
							72,172,272,372,772,1022,
							72,172,272,372,822,1022,
							72,122,172,222,272,322,372,422,472,522,572,622,672,722,772,822,872,922,972,1022};

					final short dotY[] =
					{72,72,72,72,72,50,72,72,72,72,72,72,72,72,72,72,72,72,72,
						122,122,122,122,122,122,
						172,172,172,172,172,172,172,172,172,172,172,172,172,172,
						222,222,222,222,222,222,222,222,222,
						272,272,272,272,272,272,272,272,272,272,272,272,
						322,322,322,322,322,322,322,322,322,322,
						372,372,372,372,372,372,372,372,372,372,372,372,
						422,422,422,422,422,422,422,422,422,422,422,422,
						472,472,472,472,472,472,472,472,472,472,
						522,522,522,522,522,522,522,522,522,522,522,522,522,
						572,572,572,572,572,572,572,572,
						622,622,622,622,622,622,622,622,622,622,622,622,622,622,622,622,622,622,
						672,672,672,672,672,672,672,
						722,722,722,722,722,722,722,722,722,722,722,722,
						772,772,772,772,772,772,
						822,822,822,822,822,822,
						872,872,872,872,872,872,872,872,872,872,872,872,872,872,872,872,872,872,872,872};

					final short wallX[] =
					{0,50,100,150,250,300,350,400,450,500,550,600,650,700,750,800,850,900,950,1000,1050,
							0,550,1050,
							0,100,150,200,250,300,350,450,550,650,700,750,800,900,950,1050,
							0,350,450,550,650,900,950,1050,
							0,100,200,250,350,450,550,650,750,800,900,950,1050,
							0,100,200,250,350,450,550,900,950,1050,
							0,100,350,450,550,650,700,750,850,900,950,1050,
							0,100,200,250,350,450,550,750,850,1050,
							0,100,350,450,550,650,750,850,950,
							0,100,200,250,350,450,550,650,750,850,950,1050,
							0,350,450,5050,650,750,850,950,1050,
							0,100,150,200,250,300,350,450,550,650,750,850,950,1050,
							0,550,650,1050,
							100,200,300,400,500,550,650,700,750,800,850,900,950,1050,
							0,100,200,300,400,800,850,900,950,1050,
							0,100,200,300,400,450,500,550,600,650,700,800,850,900,950,1050,
							0,100,200,300,400,450,500,550,600,650,700,800,850,900,950,1050,
							0,1050,
							0,50,100,150,200,250,300,350,400,450,500,600,650,700,750,800,850,900,950,1000,1050};

					final short wallY[] =
					{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
							50,50,50,
							100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
							150,150,150,150,150,150,150,150,
							200,200,200,200,200,200,200,200,200,200,200,200,200,
							250,250,250,250,250,250,250,250,250,250,
							300,300,300,300,300,300,300,300,300,300,300,300,
							350,350,350,350,350,350,350,350,350,350,
							400,400,400,400,400,400,400,400,400,
							450,450,450,450,450,450,450,450,450,450,450,450,
							500,500,500,500,500,500,500,500,500,
							550,550,550,550,550,550,550,550,550,550,550,500,550,550,
							600,600,600,600,
							650,650,650,650,650,650,650,650,650,650,650,650,650,650,
							700,700,700,700,700,700,700,700,700,700,
							750,750,750,750,750,750,750,750,750,750,750,750,750,750,750,750,
							800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,800,
							850,850,
							900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900,900
};
				
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

						Image newDot;

						if (i == 12)
						{

							// ' Fruit Special

							newDot.Color.RED;

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
    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (ingame) {
                if (key == KeyEvent.VK_LEFT) {
                    reqdx = -1;
                    reqdy = 0;
                } else if (key == KeyEvent.VK_RIGHT) {
                    reqdx = 1;
                    reqdy = 0;
                } else if (key == KeyEvent.VK_UP) {
                    reqdx = 0;
                    reqdy = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    reqdx = 0;
                    reqdy = 1;
                } else if (key == KeyEvent.VK_ESCAPE && timer.isRunning()) {
                    ingame = false;
                } else if (key == KeyEvent.VK_PAUSE) {
                    if (timer.isRunning()) {
                        timer.stop();
                    } else {
                        timer.start();
                    }
                }
            } else {
                if (key == 's' || key == 'S') {
                    ingame = true;
                    initGame();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == Event.LEFT || key == Event.RIGHT
                    || key == Event.UP || key == Event.DOWN) {
                reqdx = 0;
                reqdy = 0;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }
    private void repaint()
	{
		// TODO Auto-generated method stub
		
	}
	private void initVariables() {

        screendata = new short[nrofblocks * nrofblocks];
        //numbers find color?
        mazecolor = new Color(5, 100, 5);
        //dimensions of maze are 400 by 400?
        d = new Dimension(400, 400);
        //ghost speed left
        ghostx = new int[maxghosts];
        //ghost direction left
        ghostdx = new int[maxghosts];
        //ghost speed up
        ghosty = new int[maxghosts];
        //ghost direction up
        ghostdy = new int[maxghosts];
        //ghost speed
        ghostspeed = new int[maxghosts];
        //4 directions?
        dx = new int[4];
        //4 directions
        dy = new int[4];
        
        //create new timer, set it on time 40?
        timer = new Timer(40, this);
        //start timer
        timer.start();
}
}
