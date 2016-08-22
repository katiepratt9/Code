package SimpleAnimation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation
{
	int x = 70;
	int y = 70;

	// make two instance varibles in the main gui class for the x and y
	// coordinates of the circle
	public static void main(String[] args)
	{
		Animation gui = new Animation();
		gui.go();
	}

	private void go()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyDrawPanel draw = new MyDrawPanel();

		frame.getContentPane().add(draw);
		frame.setSize(300, 300);
		frame.setVisible(true);

		for (int i = 0; i < 130; i++)
		{
			x++;
			y++;
			// increment x and y coordinates
			draw.repaint();
			// tell panel to repaint itself so we can see the circle in a new
			// location
			try
			{
				Thread.sleep(50);
				// slow it down so that you can see the circle move
			} catch (Exception ex)
			{
			}
		}
	}

	class MyDrawPanel extends JPanel
	{
		@Override
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.green);
			g.fillOval(x, y, 40, 40);
			// use the continually updated x,y of the outer class
		}
	}
}
