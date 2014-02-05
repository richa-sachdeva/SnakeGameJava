package com.snake;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends FillableShape {
	
	private double diameter;
	 
	public Circle (double x, double y, Color color, double diameter){
		super(x, y, color);
		this.diameter = diameter;
	}
 
	public double getDiameter(){
		return diameter;
	}
 
	public void paint(Graphics g){
		g.setColor(Color.orange);
	//	g.fillOval((int)getX(), (int)getY(), (int)diameter, (int)diameter);
	
		
		g.drawRect(10,10,(int)diameter, (int)diameter);
	}
}
