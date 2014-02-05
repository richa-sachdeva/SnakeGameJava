package com.snake;

import java.awt.Color;
import java.awt.Graphics;

public class BoundaryRect extends FillableShape {
	
	private double length;
	private double breadth;

	public BoundaryRect(double x, double y, Color color, double length, double breadth){
		super(x, y, color);
		this.length = length;
		this.breadth = breadth;
	}
	
	public double getLength(){
		return this.length;
	}
 
	public void paint(Graphics g){		
		g.setColor(Color.orange);
		g.drawRect((int)getX(), (int)getY(), (int)length, (int)breadth);
	}

	public double getBreadth() {
		// TODO Auto-generated method stub
		return this.breadth;
	}
	

}
