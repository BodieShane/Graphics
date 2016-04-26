package gra.view;

import gra.controler.DrawingControler;
import gra.view.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;



public class DrawingPanel extends JPanel
{
	private ShapePanel shapePanel;
	private JButton drawRectangleButton;
	private JButton drawCircleButton;
	private JButton drawSquareButton;
	private JButton drawTriangleButton;
	private JButton drawEllipseBButton;
	private JButton clearButton;
	private SpringLayout baseLayout;
	private ArrayList<Rectangle> rectangleList;
 
	public DrawingPanel (DrawingControler baseController)
	{
		clearButton = new JButton ("clear the list");
		drawRectangleButton = new JButton("draw the Rectangle");
		rectangleList = new ArrayList<Rectangle>();
		setupPanel();
		setupLayout();
		setupListeners();
	}


private void setupListeners()
	{
	this .addMouseMotionListener(new MouseMotionListener()
	{
		public void mouseMoved(MouseEvent moved)
		{
			
				
		
		}
		
		public void mouseDragged(MouseEvent dragged)
		{
		
			
			
			makeRectangle();
		}
		
	});
	clearButton.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent click)
			{
				shapePanel.clear();
				repaint();
			}



	
	});
		
	drawRectangleButton.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent click)
			{
			
			
	
			
			makeRectangle();
			}



	
	});
		
		
	}

private void makeRectangle()
{
	int xPosition = (int)(Math.random() * 600);
	int yPosition = (int)(Math.random() * 600);
	int width = (int)(Math.random() * 50);
	
	int height = (int)(Math.random() * 50);
	rectangleList.add(new Rectangle(xPosition,yPosition,width,height));
	repaint();
}

private void setupLayout()
	{
		
		
	}


private void setupPanel()
	{
		this.add(drawRectangleButton);
		
	}


protected void paintComponent (Graphics currentGraphics)
{
	super.paintComponent(currentGraphics);
	Graphics2D mainGraphics = (Graphics2D) currentGraphics;
	mainGraphics.setColor(Color.GREEN);
	mainGraphics.setStroke(new BasicStroke(15));
	mainGraphics.draw(new Rectangle(90,10,20,40));
	
	for(Rectangle current : rectangleList)
	{
		int randomStroke = (int ) (Math.random() * 7);
		int red =(int)(Math.random() *256);
		int blue =(int)(Math.random() *256);
		int green =(int)(Math.random() *256);
		
		mainGraphics.setColor(new Color(red,green,blue));
		mainGraphics.setStroke(new BasicStroke(randomStroke));
		
		mainGraphics.fill(current);
	}
	
}
private void changeRandomColor()
{
	int red,green,blue;
	red = (int) (Math.random() * 256);
	green = (int) (Math.random() * 256);
	blue = (int) (Math.random() * 256);
	
	this.setBackground(new Color(red,green,blue));
			
}
}