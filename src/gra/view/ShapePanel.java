package gra.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JPanel;

import gra.view.*;
import gra.controler.DrawingControler;

public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Polygon> triangleList;//finished
	private	ArrayList<Polygon> polygonList;//finished
	private ArrayList<Ellipse2D> circleList;
	public ShapePanel()
	{
		
	}
	
	public ShapePanel(DrawingControler baseController)
	{
		rectangleList = new ArrayList<Rectangle>();
		triangleList= new ArrayList <Polygon>();
		polygonList = new ArrayList <Polygon>();
		circleList = new ArrayList <Ellipse2D>();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupListeners()
	{
		
	}

	private void setupLayout()
	{
		// TODO Auto-generated method stub
		
	}

	private void setupPanel()
	{
		// TODO Auto-generated method stub
		
	}

	public void addRewctangle()
	{
		
	}
	public void addSquare()
	{
		
	}

	public void addEllipse()
	{
		
	}
	
	public void addCircle()
	{
		int xPoint = (int)(Math.random() * 1000);
		int yPoint = (int)(Math.random() * 1000);
		int diameter = (int)(Math.random() * 100);
		
		Ellipse2D circle = new Ellipse2D.Double(xPoint,yPoint , diameter,diameter);
		
		
		circleList.add(circle);
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
	protected void paintCompent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		
		for(Polygon triangle : triangleList)
		{
			
			int red =(int)(Math.random() *256);
			int blue =(int)(Math.random() *256);
			int green =(int)(Math.random() *256);
			
			int pencilSize =(int)(Math.random() * 50);
			
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			mainGraphics.draw(triangle);
		}
	}

	public void clear()
	{
		rectangleList.clear();
		triangleList.clear();
		circleList.clear();
		polygonList.clear();
		polygonList.clear();
		repaint();
	}
}
