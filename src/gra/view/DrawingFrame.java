package gra.view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gra.controler.DrawingControler;
import gra.view.DrawingPanel;

public class DrawingFrame extends JFrame
{
	private DrawingControler baseController;
	private DrawingPanel basePanel;
	
	public DrawingFrame(DrawingControler baseController)
	{
		this.baseController = baseController;
		basePanel = new DrawingPanel (baseController);
		setupFrame();
	}
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setTitle("Art!!!");
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	
	
	public DrawingControler getBaseController()
	{
		return baseController;
	}



}
