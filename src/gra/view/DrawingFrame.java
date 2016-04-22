package gra.view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gra.controler.DrawingControler;
import gra.view.DrawingPanel;


public class DrawingFrame extends JPanel
{


	
	private DrawingControler baseController;
	private ShapePanel basePanel;
	public DrawingFrame(DrawingControler baseController)
	{
		this.baseController = baseController;
		basePanel = new ShapePanel (baseController);
		setupFrame();
	}
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	private void setResizable(boolean b)
	{
		// TODO Auto-generated method stub
		
	}
	private void setContentPane(ShapePanel basePanel2)
	{
		// TODO Auto-generated method stub
		
	}




}
