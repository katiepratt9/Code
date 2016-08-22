package katie.yahtzee;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class YahtzeeGUI
{
	static YahtzeeGame game;
	JTextArea textArea;
	JFrame frame;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	ImageIcon image;
	private final static String newline = "\n";

	public static void main(String[] args)
	{
		YahtzeeGUI gui = new YahtzeeGUI();
		gui.go();
	}

	public void go()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Yahtzee");
		JPanel panel1 = new JPanel(new BorderLayout());
		// panel2 = new JPanel();
		// panel3 = new JPanel();

		JButton buttonRoll = new JButton("roll the selected die?");
		buttonRoll.addActionListener(new ButtonRoll());

		JLabel dieOne = new JLabel("Die One");

		JLabel dieTwo = new JLabel("Die Two");

		JLabel dieThree = new JLabel("Die Three");

		JLabel dieFour = new JLabel("Die Four");

		JLabel dieFive = new JLabel("Die Five");

		JLabel aboveTextArea = new JLabel("It's player" + game.getPlayerNum() + " turn, your current ScoreSheet is: ");
		textArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		textArea.append(game.getPlayerScoreSheet() + newline);

		// make components of panel 1
		// make draw panel for images panel 1
		YahtzeeDrawPanel drawPanel = new YahtzeeDrawPanel();
		JPanel panel2 = new YahtzeeDrawPanel();
		panel2.setSize(100, 100);
		int count = 1;
		Image dieOneimg = new ImageIcon("dieSide" + count + ".jpg").getImage();
		Image dieTwoimg = new ImageIcon("dieSide" + (count + 1) + ".jpg").getImage();
		Image dieThreeimg = new ImageIcon("dieSide" + (count + 2) + ".jpg").getImage();
		Image dieFourimg = new ImageIcon("dieSide" + (count + 3) + ".jpg").getImage();
		Image dieFiveimg = new ImageIcon("dieSide" + (count + 4) + ".jpg").getImage();
		Image dieSiximg = new ImageIcon("dieSide" + (count + 5) + ".jpg").getImage();
		// add components to panel 1
		panel1.add(panel2, BorderLayout.CENTER);

		panel1.add(dieOne);
		panel1.add(dieTwo);
		panel1.add(dieThree);
		panel1.add(dieFour);
		panel1.add(dieFive);
		panel1.add(aboveTextArea);
		panel1.add(textArea);
		// set components preferred sizes, ultimatley decided by layout manager
		// of panel
		// add panels to frames
		frame.getContentPane().add(panel1, BoxLayout.Y_AXIS);
		// frame.getContentPane().add(panel2,BoxLayout.Y_AXIS);
		// frame.getContentPane().add(panel3,BoxLayout.Y_AXIS);
		// set panels preferred sizes, ultimatley decided by layout manager of
		// frame
		// set frame size and make it visible
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	// create inner classes for all the components that need listeners
	class ButtonRoll implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event)
		{

		}
	}

	class colorListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			frame.repaint();
		}
	}
}
