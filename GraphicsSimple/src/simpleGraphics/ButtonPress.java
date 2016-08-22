package simpleGraphics;

import java.awt.event.*;
import javax.swing.*;

public class ButtonPress implements ActionListener
{
	JButton button;
public static void main(String[] args)
{
	ButtonPress press = new ButtonPress();
	press.go();
}
public void go()
{
	JFrame frame = new JFrame();
	button = new JButton("Click Me");
	//make a frame and a button, pass the button constructor the text on button
	button.addActionListener(this);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//makes the program quit has soon has you close the window, if you leave
	//this out, it will sit on the screen forever
	frame.getContentPane().add(button);
	//add the button to the frames content pane
	frame.setSize(300, 300);
	//give the frame a size in pixles
	frame.setVisible(true);
	//make the frame visible
}
@Override
public void actionPerformed(ActionEvent event)
{
	button.setText("help");
}
}