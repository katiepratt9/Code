package simpleGraphics;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DrawPanel extends JPanel 
{//make a subclass of Jpanel, a widget that you can add to a frame
	//except it will be your own customized widget
public void paintcomponent(Graphics graphics)
{//a graphics method, will never call for yourself, the system calls it or you.
	graphics.setColor(Color.orange);
	//your telling graphics what color to paint with and what shape to paint
	//with cordinates of where the shape should go and how big it is
	graphics.fillRect(20, 50, 100, 100);
	graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
	//fill the entire panle black- the default color
	//the irst two #s define x,y upperleft corner reletive to the panle, for where the drawing starts
	//this says: start 0 pixles from the left edge and 0 pixles from the top edge
	//the other two args say: make the width of this rectangl as wide as the panel and the height
	//as tall as the panle.
	int red = (int) (Math.random() * 256);
	int green = (int) (Math.random() * 256);
	int blue = (int) (Math.random() * 256);
	
	Color randomColor = new Color(red,green,blue);
	//you make a color by passing in 3 ints to represent the rgb values 
	graphics.setColor(randomColor);
	graphics.fillOval(70,70,100,100);
	//says:start 70 pixles from the left, 70 from the top, make it 100 pixles wide, and 100 pixles tall.
	Graphics2D g2d = (Graphics2D) graphics;
	//cast it to call something that Graphics2D has that Graphics doesn't
	GradientPaint gradient = new GradientPaint(70,70,Color.blue,150,150,Color.orange);
	//(StartingPoint,StartingColor,EndingPoint,EndingColor)
g2d.setPaint(gradient);
//set virtual paint brush to gradient instead of solid
g2d.fillOval(70, 70, 100, 100);
//the fill oval method really means, fill oval with whatever is loaded on your paintbrush
Graphics2D g2d1 = (Graphics2D) graphics;

int red1 = (int) (Math.random() * 256);
int green1 = (int) (Math.random() * 256);
int blue1 = (int) (Math.random() * 256);
Color startColor = new Color(red1,green1,blue1);

red1 = (int) (Math.random() * 256);
green1 = (int) (Math.random() * 256);
blue1 = (int) (Math.random() * 256);
Color endColor = new Color(red1,green1,blue1);

GradientPaint gradient1 = new GradientPaint(70,70,startColor,150,150,endColor);
g2d1.setPaint(gradient1);
g2d1.fillOval(70, 70, 100, 100);
}
//public void paintComponent(Graphics graphics)
//{//a graphics method, will never call for yourself, the system calls it or you.
//	Image image = new ImageIcon("FileName.jpg").getImage();
//	graphics.drawImage(image, 3, 4, this);
//	//the x,y coordinates for where the pictures top left corner should go 
//	//this says 3 pixles from the left edge of the panel and 4 pixles from the top edge
//	//these numbers are always reletive to the widget(your jpanel subclass), not the entire frame
//}

}
