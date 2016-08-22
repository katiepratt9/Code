package Man;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameAndBoard extends JPanel implements ActionListener {
	
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private Dimension dimension;
			//set font to large, "kind of font", bolded font, size 
		    private final Font largefont = new Font("Helvetica", Font.BOLD, 18);
	//image of pacman
		    private Image ii;
		    //create dot, set dotcolor?size?
		private final Color dotColor = new Color(255,255,0);
		    private Color mazecolor;

		    private boolean duringGame = false;
		    private boolean dead = false;

		    //set block size 
		    private final int blockSize = 20;
		    //set number of blocks
		    private final int nrofblocks = 15;
		   //screen size = # of blocks * the blocksize
		    private final int scrsize = nrofblocks * blockSize;
		    //pacSpeed
		    private final int pacspeed = 5;
		    private int pacsleft, score;
		    //dimensions x axsis,dimensions y axsis
		    private int[] dimensionX, dimensionY;

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
		    private short[] screendata;
		    private Timer timer;
		  //makes board
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
		  //initilizes varible
		    private void initVariables() {
		        mazecolor = new Color(0,0,255);
		        //dimensions of maze are 400 by 400?
		        dimension = new Dimension(900, 1000);
		        //ghost speed left
		        dimensionX = new int[4];
		        //4 directions
		        dimensionY = new int[4];
		        
		        //create new timer, set it on time 40?
		        Timer pacMoveClock= new Timer(40, this);
		        Timer ghostMoveClock= new Timer(40, this);
		        Timer powerPelletClock= new Timer(40, this);
		        //start timer
		        timer.start();
		    }

		    @Override
		    public void addNotify() {
		        super.addNotify();
	//initialize game?
		        initGame();
		    }
	//does animation
		    private void doAnim() {
	
		            }
		        }
		    }
	//plays game
		    private void playGame(Graphics2D g2d) {
	//if pacman runs into ghost-dies
		        if (dead) {

		            death();

		        } else {
	//movepacman, animate pacman?, move ghost, check if maze is complete
		            movePacman();
		            drawPacman(g2d);
		            moveGhosts(g2d);
		            checkMaze();
		        }
		    }
	//shows intro screen
		    private void showIntroScreen(Graphics2D g2d) {

		    	//set color to numbers?
		        g2d.setColor(new Color(0, 32, 48));
		        //fill the form with color?
		        g2d.fillRect(50, scrsize / 2 - 30, scrsize - 100, 50);
		        //set color to white
		        g2d.setColor(Color.white);
		        //create form?
		        g2d.drawRect(50, scrsize / 2 - 30, scrsize - 100, 50);

		        //tells player to "press s to start"
		        String s = "Press s to start.";
		        //sets font to large,"font type",bolded,size
		        Font large = new Font("Helvetica", Font.BOLD, 14);
		        //gets font?
		        FontMetrics metr = this.getFontMetrics(large);

		        //sets font color to white?
		        g2d.setColor(Color.white);
		        //set font to white
		        g2d.setFont(large);
		        //create string on screen?
		        g2d.drawString(s, (scrsize - metr.stringWidth(s)) / 2, scrsize / 2);
		    }
	//makes score counter
		    private void drawScore(Graphics2D g) {

		        int i;
		        String s;

		        //set font to large
		        g.setFont(largefont);
		        //set color to numbers?
		        g.setColor(new Color(96, 128, 255));
		        //set string
		        s = "Score: " + score;
		        //creates string?
		        g.drawString(s, scrsize / 2 + 96, scrsize + 16);

		        //?
		        for (i = 0; i < pacsleft; i++) {
		            g.drawImage(pacman3left, i * 28 + 8, scrsize + 1, this);
		        }
		    }
	
		    private void drawGhost(Graphics2D g2d, int x, int y) {

		        g2d.drawImage(ghost, x, y, this);
		    }

		    private void movePacman() {

		        int pos;
		        short ch;

		        if (reqdx == -pacmandx && reqdy == -pacmandy) {
		            pacmandx = reqdx;
		            pacmandy = reqdy;
		            viewdx = pacmandx;
		            viewdy = pacmandy;
		        }

		        if (pacmanx % blockSize == 0 && pacmany % blockSize == 0) {
		            pos = pacmanx / blockSize + nrofblocks * (int) (pacmany / blockSize);
		            ch = screendata[pos];

		            if ((ch & 16) != 0) {
		                screendata[pos] = (short) (ch & 15);
		                score++;
		            }

		            if (reqdx != 0 || reqdy != 0) {
		                if (!((reqdx == -1 && reqdy == 0 && (ch & 1) != 0)
		                        || (reqdx == 1 && reqdy == 0 && (ch & 4) != 0)
		                        || (reqdx == 0 && reqdy == -1 && (ch & 2) != 0)
		                        || (reqdx == 0 && reqdy == 1 && (ch & 8) != 0))) {
		                    pacmandx = reqdx;
		                    pacmandy = reqdy;
		                    viewdx = pacmandx;
		                    viewdy = pacmandy;
		                }
		            }

		            // Check for standstill
		            if ((pacmandx == -1 && pacmandy == 0 && (ch & 1) != 0)
		                    || (pacmandx == 1 && pacmandy == 0 && (ch & 4) != 0)
		                    || (pacmandx == 0 && pacmandy == -1 && (ch & 2) != 0)
		                    || (pacmandx == 0 && pacmandy == 1 && (ch & 8) != 0)) {
		                pacmandx = 0;
		                pacmandy = 0;
		            }
		        }
		        pacmanx = pacmanx + pacmanspeed * pacmandx;
		        pacmany = pacmany + pacmanspeed * pacmandy;
		    }

		    private void drawPacman(Graphics2D g2d) {

		        if (viewdx == -1) {
		            drawPacnanLeft(g2d);
		        } else if (viewdx == 1) {
		            drawPacmanRight(g2d);
		        } else if (viewdy == -1) {
		            drawPacmanUp(g2d);
		        } else {
		            drawPacmanDown(g2d);
		        }
		    }

		    private void drawPacmanUp(Graphics2D g2d) {

		        switch (pacmananimpos) {
		            case 1:
		                g2d.drawImage(pacman2up, pacmanx + 1, pacmany + 1, this);
		                break;
		            case 2:
		                g2d.drawImage(pacman3up, pacmanx + 1, pacmany + 1, this);
		                break;
		            case 3:
		                g2d.drawImage(pacman4up, pacmanx + 1, pacmany + 1, this);
		                break;
		            default:
		                g2d.drawImage(pacman1, pacmanx + 1, pacmany + 1, this);
		                break;
		        }
		    }

		    private void drawPacmanDown(Graphics2D g2d) {

		        switch (pacmananimpos) {
		            case 1:
		                g2d.drawImage(pacman2down, pacmanx + 1, pacmany + 1, this);
		                break;
		            case 2:
		                g2d.drawImage(pacman3down, pacmanx + 1, pacmany + 1, this);
		                break;
		            case 3:
		                g2d.drawImage(pacman4down, pacmanx + 1, pacmany + 1, this);
		                break;
		            default:
		                g2d.drawImage(pacman1, pacmanx + 1, pacmany + 1, this);
		                break;
		        }
		    }

		    private void drawPacnanLeft(Graphics2D g2d) {

		        switch (pacmananimpos) {
		            case 1:
		                g2d.drawImage(pacman2left, pacmanx + 1, pacmany + 1, this);
		                break;
		            case 2:
		                g2d.drawImage(pacman3left, pacmanx + 1, pacmany + 1, this);
		                break;
		            case 3:
		                g2d.drawImage(pacman4left, pacmanx + 1, pacmany + 1, this);
		                break;
		            default:
		                g2d.drawImage(pacman1, pacmanx + 1, pacmany + 1, this);
		                break;
		        }
		    }

		    private void drawPacmanRight(Graphics2D g2d) {

		        switch (pacmananimpos) {
		            case 1:
		                g2d.drawImage(pacman2right, pacmanx + 1, pacmany + 1, this);
		                break;
		            case 2:
		                g2d.drawImage(pacman3right, pacmanx + 1, pacmany + 1, this);
		                break;
		            case 3:
		                g2d.drawImage(pacman4right, pacmanx + 1, pacmany + 1, this);
		                break;
		            default:
		                g2d.drawImage(pacman1, pacmanx + 1, pacmany + 1, this);
		                break;
		        }
		    }

		    private void drawMaze(Graphics2D g2d) {

		        short i = 0;
		        int x, y;

		        for (y = 0; y < scrsize; y += blockSize) {
		            for (x = 0; x < scrsize; x += blockSize) {

		                g2d.setColor(mazecolor);
		                g2d.setStroke(new BasicStroke(2));

		                if ((screendata[i] & 1) != 0) { 
		                    g2d.drawLine(x, y, x, y + blockSize - 1);
		                }

		                if ((screendata[i] & 2) != 0) { 
		                    g2d.drawLine(x, y, x + blockSize - 1, y);
		                }

		                if ((screendata[i] & 4) != 0) { 
		                    g2d.drawLine(x + blockSize - 1, y, x + blockSize - 1,
		                            y + blockSize - 1);
		                }

		                if ((screendata[i] & 8) != 0) { 
		                    g2d.drawLine(x, y + blockSize - 1, x + blockSize - 1,
		                            y + blockSize - 1);
		                }

		                if ((screendata[i] & 16) != 0) { 
		                    g2d.setColor(dotColor);
		                    g2d.fillRect(x + 11, y + 11, 2, 2);
		                }

		                i++;
		            }
		        }
		    }

		    private void initGame() {

		        pacsleft = 3;
		        score = 0;
		        initLevel();
		    }

		    private void initLevel() {

		        int i;
		        for (i = 0; i < nrofblocks * nrofblocks; i++) {
		            screendata[i] = leveldata[i];
		        }

		        continueLevel();
		    }

		    private void continueLevel() {

		        short i;
		        int dx = 1;
		        int random;

		        for (i = 0; i < nrofghosts; i++) {

		            ghosty[i] = 4 * blockSize;
		            ghostx[i] = 4 * blockSize;
		            ghostdy[i] = 0;
		            ghostdx[i] = dx;
		            dx = -dx;
		            random = (int) (Math.random() * (currentspeed + 1));

		            if (random > currentspeed) {
		                random = currentspeed;
		            }

		            ghostspeed[i] = validspeeds[random];
		        }

		        pacmanx = 7 * blockSize;
		        pacmany = 11 * blockSize;
		        pacmandx = 0;
		        pacmandy = 0;
		        reqdx = 0;
		        reqdy = 0;
		        viewdx = -1;
		        viewdy = 0;
		        dead = false;
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

		    @Override
		    public void paintComponent(Graphics g) {
		        super.paintComponent(g);

		        doDrawing(g);
		    }

		    private void doDrawing(Graphics g) {

		        Graphics2D g2d = (Graphics2D) g;

		        g2d.setColor(Color.black);
		        g2d.fillRect(0, 0, dimension.width, dimension.height);

		        drawMaze(g2d);
		        drawScore(g2d);
		        doAnim();

		        if (duringGame) {
		            playGame(g2d);
		        } else {
		            showIntroScreen(g2d);
		        }

		        g2d.drawImage(ii, 5, 5, this);
		        Toolkit.getDefaultToolkit().sync();
		        g2d.dispose();
		    }

		    class TAdapter extends KeyAdapter {

		        @Override
		        public void keyPressed(KeyEvent e) {

		            int key = e.getKeyCode();

		            if (duringGame) {
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
		                    duringGame = false;
		                } else if (key == KeyEvent.VK_PAUSE) {
		                    if (timer.isRunning()) {
		                        timer.stop();
		                    } else {
		                        timer.start();
		                    }
		                }
		            } else {
		                if (key == 's' || key == 'S') {
		                    duringGame = true;
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
public void actionPerformed(ActionEvent e)
{
	repaint();
	
}
}

