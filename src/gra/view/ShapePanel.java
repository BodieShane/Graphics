package gra.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import gra.view.*;
import gra.controler.DrawingControler;

public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectangleList;//finished
	private ArrayList<Polygon> triangleList;//finished
	private	ArrayList<Polygon> polygonList;//finished
	private ArrayList<Ellipse2D> circleList;// Finished
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Rectangle> squareList;
	private JButton drawRectangleButton;
	private JButton drawCircleButton;
	private JButton drawSquareButton;
	private JButton drawTriangleButton;
	private JButton drawEllipseBButton;
	private JButton clearButton;
	
	
	public ShapePanel(DrawingControler baseController)
	{
		drawRectangleButton = new JButton ("add Rectangle");
		drawCircleButton = new JButton ("add Circle");
		drawSquareButton = new JButton ("add Square");
		drawTriangleButton = new JButton ("add Triangle");
		drawEllipseBButton = new JButton ("add Ellipse");
		clearButton = new JButton ("clear the list");
		rectangleList = new ArrayList<Rectangle>();
		triangleList= new ArrayList <Polygon>();
		polygonList = new ArrayList <Polygon>();
		circleList = new ArrayList <Ellipse2D>();
		ellipseList = new ArrayList <Ellipse2D>();
		squareList = new ArrayList<Rectangle>();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupListeners()
	{
		
		
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
				{
				addRectangle();
				
				}

		});
		drawCircleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
				{
				addCircle();
				
				}

		});
		drawSquareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
				{
				addSquare();
				
				}

		});
		
		drawTriangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
				{
				
				addTriangle();
				}

		});
		
		drawEllipseBButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
				{
				addEllipse();
				
				}

		});
		
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
				{
				clear();
				
				}

		});
		
		
		
		
		
		
		
		this .addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent moved)
			{
				
					
			
			}
			
			public void mouseDragged(MouseEvent dragged)
			{
			
				addCircle();
				
			}
			
		});
	}

	private void setupLayout()
	{
		// TODO Auto-generated method stub
		
	}

	private void setupPanel()
	{
		this.add(drawRectangleButton);
		this.add(drawCircleButton);
		this.add(drawSquareButton);
		this.add(drawTriangleButton);
		this.add(drawEllipseBButton);
		this.add(clearButton);
		
	}

	public void addRectangle()
	{
		int xPosition = (int)(Math.random() * 600);
		int yPosition = (int)(Math.random() * 600);
		int width = (int)(Math.random() * 50);
		
		int height = (int)(Math.random() * 50);
		
		
		rectangleList.add(new Rectangle(xPosition,yPosition,width,height));
		repaint();
	}
	public void addSquare()
	{
		int xPosition = (int)(Math.random() * 600);
		int yPosition = (int)(Math.random() * 600);
		int thing = (int)(Math.random() * 50);
		
		
		
		
		squareList.add(new Rectangle(xPosition,yPosition,thing,thing));
		repaint();
	}

	public void addEllipse()
	{
		int xPoint = (int)(Math.random() * 250);
		int yPoint = (int)(Math.random() * 250);
		int diameter = (int)(Math.random() * 100);
		int diameter2 = (int)(Math.random() * 100);
		
		Ellipse2D circle = new Ellipse2D.Double(xPoint,yPoint , diameter,diameter2);
		
		
		circleList.add(circle);
		repaint();
	}
	
	public void addCircle()
	{
		int xPoint = (int)(Math.random() * 250);
		int yPoint = (int)(Math.random() * 250);
		int diameter = (int)(Math.random() * 100);
		
		Ellipse2D circle = new Ellipse2D.Double(xPoint,yPoint , diameter,diameter);
		
		
		circleList.add(circle);
		repaint();
	}

	public void addTriangle()
	{
		int [] xPoints = new int [3];
		int [] yPoints = new int [3];
		xPoints[0] = (int)(Math.random() * 250);
		xPoints =new int []{(int)(Math.random() * 250), (int)(Math.random() * 250), (int)(Math.random() * 250)};
		yPoints =new int []{ (int)(Math.random() * 250), (int)(Math.random() * 250), (int)(Math.random() * 250)};
	
		Polygon triangle = new Polygon (xPoints,yPoints,3);
		
		
		triangleList.add(triangle);
		repaint();
	}
	
	public void addPolygon()
	{
		int numberOfSides = (int )(Math.random() * 15);
		int [] xPoints = new int [numberOfSides];
		int [] yPoints = new int [numberOfSides];
		for(int sides= 0;sides < numberOfSides; sides ++)
		{
			xPoints[sides] = (int)(Math.random() * 300);
			yPoints[sides] = (int)(Math.random() * 300);
		}
		Polygon myPolygon = new Polygon (xPoints,yPoints,numberOfSides);
		
		polygonList.add(myPolygon);
	}
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		
		for(Rectangle rectangle : rectangleList)
		{
			
			int red =(int)(Math.random() *256);
			int blue =(int)(Math.random() *256);
			int green =(int)(Math.random() *256);
			int alfa =(int)(Math.random() *255);
			
			
			int pencilSize =(int)(Math.random() * 50);
			
			mainGraphics.setColor(new Color(red,green,blue,alfa));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			mainGraphics.draw(rectangle);
		}
		for(Ellipse2D circle : circleList)
		{
			
			int red =(int)(Math.random() *256);
			int blue =(int)(Math.random() *256);
			int green =(int)(Math.random() *256);
			int alfa =(int)(Math.random() *255);
			
			mainGraphics.setColor(new Color(red,green,blue,alfa));
			mainGraphics.draw(circle);
		}
		for(Polygon triangle : triangleList)
		{
			
			int red =(int)(Math.random() *256);
			int blue =(int)(Math.random() *256);
			int green =(int)(Math.random() *256);
			int alfa =(int)(Math.random() *255);
			
			mainGraphics.setColor(new Color(red,green,blue,alfa));
			mainGraphics.draw(triangle);
		}
		for(Ellipse2D ellipse : ellipseList)
		{
			
			int red =(int)(Math.random() *256);
			int blue =(int)(Math.random() *256);
			int green =(int)(Math.random() *256);
			int alfa =(int)(Math.random() *255);
			
			mainGraphics.setColor(new Color(red,green,blue,alfa));
			mainGraphics.draw(ellipse);
		}
		for(Rectangle square : squareList)
		{
			
			int red =(int)(Math.random() *256);
			int blue =(int)(Math.random() *256);
			int green =(int)(Math.random() *256);
			int alfa =(int)(Math.random() *255);
			
			mainGraphics.setColor(new Color(red,green,blue,alfa));
			mainGraphics.draw(square);
		}

	}

	public void clear()
	{
		rectangleList.clear();
		triangleList.clear();
		circleList.clear();
		polygonList.clear();
		squareList.clear();
		repaint();
	}
}
