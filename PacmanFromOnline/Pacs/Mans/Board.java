package Mans;
//http://zetcode.com/tutorials/javagamestutorial/pacman/
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

	public class Board extends JPanel implements ActionListener {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Dimension d;
		//set font to large, "kind of font", bolded font, size 
	    private final Font largefont = new Font("Helvetica", Font.BOLD, 14);
//image of pacma
	    private Image ii;
	    //create dot, set dotcolor?size?
	private final Color dotcolor = new Color(192, 192, 0);
	    private Color mazecolor;

	    private boolean ingame = false;
	    private boolean dying = false;

	    //set block size 
	    private final int blocksize = 24;
	    //set number of blocks
	    private final int nrofblocks = 15;
	   //screen size = # of blocks * the blocksize
	    private final int scrsize = nrofblocks * blocksize;
	    //pac animation delay changes by 2
	    private final int pacanimdelay = 2;
	    //pac animation count is by 4
	    private final int pacmananimcount = 4;
	    //ghostSpeed?
	    private final int maxghosts = 12;
	    //pacSpeed
	    private final int pacmanspeed = 6;

	    // pac animation count = same has pac animation delay
	    private int pacanimcount = pacanimdelay;
	    //pac direction = 1?
	    private int pacanimdir = 1;
	    //pacman position?
	    private int pacmananimpos = 0;
	    //# of ghosts
	    private int nrofghosts = 6;
	    //dots left to get and score
	    private int pacsleft, score;
	    //dimensions x axsis,dimensions y axsis
	    private int[] dx, dy;
	    //ghosts value left, ghosts value up, ghost direction left, ghost direction up, ghost speed 
	    private int[] ghostx, ghosty, ghostdx, ghostdy, ghostspeed;

	    //ghost image
	    private Image ghost;
	    //images of pacman basic(round), faceup,faceleft,faceright,facedown
	    private Image pacman1, pacman2up, pacman2left, pacman2right, pacman2down;
	   //?
	    private Image pacman3up, pacman3down, pacman3left, pacman3right;
	    private Image pacman4up, pacman4down, pacman4left, pacman4right;

	    private int pacmanx, pacmany, pacmandx, pacmandy;
//	    The first two variables store the x and y coordinates of the Pacman sprite. The last two variables are the delta changes in horizontal and vertical directions.
	    private int reqdx, reqdy, viewdx, viewdy;

	    private final short leveldata[] = {
	        19, 26, 26, 26, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
	        21, 0, 0, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
	        21, 0, 0, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
	        21, 0, 0, 0, 17, 16, 16, 24, 16, 16, 16, 16, 16, 16, 20,
	        17, 18, 18, 18, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 20,
	        17, 16, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 16, 24, 20,
	        25, 16, 16, 16, 24, 24, 28, 0, 25, 24, 24, 16, 20, 0, 21,
	        1, 17, 16, 20, 0, 0, 0, 0, 0, 0, 0, 17, 20, 0, 21,
	        1, 17, 16, 16, 18, 18, 22, 0, 19, 18, 18, 16, 20, 0, 21,
	        1, 17, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 20, 0, 21,
	        1, 17, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 20, 0, 21,
	        1, 17, 16, 16, 16, 16, 16, 18, 16, 16, 16, 16, 20, 0, 21,
	        1, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0, 21,
	        1, 25, 24, 24, 24, 24, 24, 24, 24, 24, 16, 16, 16, 18, 20,
	        9, 8, 8, 8, 8, 8, 8, 8, 8, 8, 25, 24, 24, 24, 28
	    };
//	    These numbers make up the maze. They provide information out of which we create the corners and the points. Number 1 is a left corner. Numbers 2, 4 and 8 represent top, right, bottom corners respectively. Number 16 is a point. These number can be added, for example number 19 in the upper left corner means that the square will have top and left borders and a point (16 + 2 + 1).
	    private final int validspeeds[] = {1, 2, 3, 4, 6, 8};
	    private final int maxspeed = 6;

	    private int currentspeed = 3;
	    private short[] screendata;
	    private Timer timer;
	  //makes board
	    public Board() {

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

	    @Override
	    public void addNotify() {
	        super.addNotify();
//initialize game?
	        initGame();
	    }
//does animation
	    private void doAnim() {
//pac animaition count -1
	        pacanimcount--;
//if pacanimation count <=0, pacanimcount = pacanimdelay,pacanimposition + pacanimdirection
	        if (pacanimcount <= 0) {
	            pacanimcount = pacanimdelay;
	            pacmananimpos = pacmananimpos + pacanimdir;
//if pacanimposition = pacanimcount -1, pacanimdirection - pacanimdirection
	            if (pacmananimpos == (pacmananimcount - 1) || pacmananimpos == 0) {
	                pacanimdir = -pacanimdir;
	            }
	        }
	    }
//plays game
	    private void playGame(Graphics2D g2d) {
//if pacman runs into ghost-dies
	        if (dying) {

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
//checks maze to see if complete
	    private void checkMaze() {

	        short i = 0;
	        boolean finished = true;

	        //while i<the # of blocks*the#ofblocks && finished = true
	        while (i < nrofblocks * nrofblocks && finished) {

	        	//if 48 dots dont = 0
	            if ((screendata[i] & 48) != 0) {
	            	//finished = false
	                finished = false;
	            }
//index +1
	            i++;
	        }
//if finished = true
	        if (finished) {
//score += 50
	            score += 50;
//if # of ghosts<maxghosts
	            if (nrofghosts < maxghosts) {
	            	//#of ghosts +=1
	                nrofghosts++;
	            }
//if currentspeed<maxspeed
	            if (currentspeed < maxspeed) {
	            	//currentspeed+=1
	                currentspeed++;
	            }
//re-initialize level
	            initLevel();
	        }
	    }
//runs if pacman dies
	    private void death() {
//lives left -=1
	        pacsleft--;
//if lives left = 0
	        if (pacsleft == 0) {
	            ingame = false;
	        }

	        continueLevel();
	    }

	    private void moveGhosts(Graphics2D g2d) {

	        short i;
	        int pos;
	        int count;

	        for (i = 0; i < nrofghosts; i++) {
	            if (ghostx[i] % blocksize == 0 && ghosty[i] % blocksize == 0) {
	                pos = ghostx[i] / blocksize + nrofblocks * (int) (ghosty[i] / blocksize);

	                count = 0;

	                if ((screendata[pos] & 1) == 0 && ghostdx[i] != 1) {
	                    dx[count] = -1;
	                    dy[count] = 0;
	                    count++;
	                }

	                if ((screendata[pos] & 2) == 0 && ghostdy[i] != 1) {
	                    dx[count] = 0;
	                    dy[count] = -1;
	                    count++;
	                }

	                if ((screendata[pos] & 4) == 0 && ghostdx[i] != -1) {
	                    dx[count] = 1;
	                    dy[count] = 0;
	                    count++;
	                }

	                if ((screendata[pos] & 8) == 0 && ghostdy[i] != -1) {
	                    dx[count] = 0;
	                    dy[count] = 1;
	                    count++;
	                }

	                if (count == 0) {

	                    if ((screendata[pos] & 15) == 15) {
	                        ghostdx[i] = 0;
	                        ghostdy[i] = 0;
	                    } else {
	                        ghostdx[i] = -ghostdx[i];
	                        ghostdy[i] = -ghostdy[i];
	                    }

	                } else {

	                    count = (int) (Math.random() * count);

	                    if (count > 3) {
	                        count = 3;
	                    }

	                    ghostdx[i] = dx[count];
	                    ghostdy[i] = dy[count];
	                }

	            }

	            ghostx[i] = ghostx[i] + (ghostdx[i] * ghostspeed[i]);
	            ghosty[i] = ghosty[i] + (ghostdy[i] * ghostspeed[i]);
	            drawGhost(g2d, ghostx[i] + 1, ghosty[i] + 1);

	            if (pacmanx > (ghostx[i] - 12) && pacmanx < (ghostx[i] + 12)
	                    && pacmany > (ghosty[i] - 12) && pacmany < (ghosty[i] + 12)
	                    && ingame) {

	                dying = true;
	            }
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

	        if (pacmanx % blocksize == 0 && pacmany % blocksize == 0) {
	            pos = pacmanx / blocksize + nrofblocks * (int) (pacmany / blocksize);
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

	        for (y = 0; y < scrsize; y += blocksize) {
	            for (x = 0; x < scrsize; x += blocksize) {

	                g2d.setColor(mazecolor);
	                g2d.setStroke(new BasicStroke(2));

	                if ((screendata[i] & 1) != 0) { 
	                    g2d.drawLine(x, y, x, y + blocksize - 1);
	                }

	                if ((screendata[i] & 2) != 0) { 
	                    g2d.drawLine(x, y, x + blocksize - 1, y);
	                }

	                if ((screendata[i] & 4) != 0) { 
	                    g2d.drawLine(x + blocksize - 1, y, x + blocksize - 1,
	                            y + blocksize - 1);
	                }

	                if ((screendata[i] & 8) != 0) { 
	                    g2d.drawLine(x, y + blocksize - 1, x + blocksize - 1,
	                            y + blocksize - 1);
	                }

	                if ((screendata[i] & 16) != 0) { 
	                    g2d.setColor(dotcolor);
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
	        nrofghosts = 6;
	        currentspeed = 3;
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

	            ghosty[i] = 4 * blocksize;
	            ghostx[i] = 4 * blocksize;
	            ghostdy[i] = 0;
	            ghostdx[i] = dx;
	            dx = -dx;
	            random = (int) (Math.random() * (currentspeed + 1));

	            if (random > currentspeed) {
	                random = currentspeed;
	            }

	            ghostspeed[i] = validspeeds[random];
	        }

	        pacmanx = 7 * blocksize;
	        pacmany = 11 * blocksize;
	        pacmandx = 0;
	        pacmandy = 0;
	        reqdx = 0;
	        reqdy = 0;
	        viewdx = -1;
	        viewdy = 0;
	        dying = false;
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
	        g2d.fillRect(0, 0, d.width, d.height);

	        drawMaze(g2d);
	        drawScore(g2d);
	        doAnim();

	        if (ingame) {
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
	}

