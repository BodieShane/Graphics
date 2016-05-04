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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;



public class DrawingPanel extends JPanel
{
	private int ws;
	private int ad;
	private int counter;
	private ShapePanel shapePanel;
	private JButton drawRectangleButton;
	private JButton drawCircleButton;
	private JButton drawSquareButton;
	private JButton drawTriangleButton;
	private JButton drawEllipseBButton;
	private JButton clearButton;
	private JTextField pcounter;
	private SpringLayout baseLayout;
	private ArrayList<Rectangle> rectangleList;
 
	public DrawingPanel (DrawingControler baseController)
	{
		ws = 0;
		ad = 0;
		counter = 0;
		baseLayout = new SpringLayout();
		drawRectangleButton = new JButton("draw the Rectangle");
		drawRectangleButton.setFocusable(false);
		pcounter  = new JTextField ("the y posision is " + ws + "and the x posision is " + ad);
		this.setFocusable(true);
		
		rectangleList = new ArrayList<Rectangle>();
		shapePanel = new ShapePanel(baseController);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -20, SpringLayout.NORTH, pcounter);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -10, SpringLayout.EAST, this);
		setupPanel();
		setupLayout();
		setupListeners();
	}

	
private void setupListeners()
	{
	
	this.addKeyListener(new KeyListener()
	{
		public void keyPressed(KeyEvent e) 
		{
			char key = e.getKeyChar();
			if(key == 'w')
			{
				ws -=10; 
			}
			else if(key == 's')
			{
				ws +=10;
			}
			else if(key == 'a')
			{
				ad -=10;
			}
			else if(key == 'd')
			{
				ad +=10;
			}
			makeRectangle();
			pcounter.setText("the y posision is " + ws + "and the x posision is " + ad);
        }

		@Override
		public void keyTyped(KeyEvent e)
		{
			char key = e.getKeyChar();
			if(key == 'w')
			{
				ws -=1; 
			}
			else if(key == 's')
			{
				ws +=1;
			}
			else if(key == 'a')
			{
				ad -=1;
			}
			else if(key == 'd')
			{
				ad +=1;
			}
			pcounter.setText("the y posision is " + ws + "and the x posision is " + ad);
			makeRectangle();
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			
			
		}
		
	});
	
	this .addMouseMotionListener(new MouseMotionListener()
	{
		public void mouseMoved(MouseEvent moved)
		{
			
		}
		
		public void mouseDragged(MouseEvent dragged)
		{
		
			//makeRectangle();
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
	int yPosition = ws;
	int xPosition = ad;
	int width = (int)(Math.random() * 50);
	
	int height = (int)(Math.random() * 50);
	
	
	rectangleList.add(new Rectangle(xPosition,yPosition,width,height));
	repaint();
	counter ++;
	drawRectangleButton.setText("There are: "+ counter + " rectangles");
	
}

private void setupLayout()
	{
	baseLayout.putConstraint(SpringLayout.SOUTH, pcounter, -6, SpringLayout.NORTH, drawRectangleButton);
	baseLayout.putConstraint(SpringLayout.EAST, pcounter, -10, SpringLayout.EAST, this);
	
	baseLayout.putConstraint(SpringLayout.WEST, drawRectangleButton, 143, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.SOUTH, drawRectangleButton, -10, SpringLayout.SOUTH, this);
		
	}


private void setupPanel()
	{
		
		this.setLayout(baseLayout);
		this.add(shapePanel);
		this.add(drawRectangleButton);
		this.add(pcounter);
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
		int alpha =(int)(Math.random() *255);
		
		mainGraphics.setColor(new Color(red,green,blue,alpha));
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