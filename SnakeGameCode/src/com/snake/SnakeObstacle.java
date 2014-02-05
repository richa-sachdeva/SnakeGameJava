package com.snake;

import java.awt.Color;
import java.awt.Graphics;

public class SnakeObstacle extends FillableShape {
	
	private double diameter;
	 
	public SnakeObstacle(double x, double y, Color color, double diameter){
		super(x, y, color);
		this.diameter = diameter;
	}
 
	public double getDiameter(){
		return diameter;
	}
 
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.fillOval((int)getX(), (int)getY(), (int)diameter, (int)diameter);
		g.setColor(Color.black);
		g.drawOval((int)getX(), (int)getY(), (int)diameter, (int)diameter);
	}
	

}
