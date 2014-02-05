package com.snake;

import java.awt.Color;
import java.awt.Graphics;

class Line extends Shape {
	 
	private double x2;
	private double y2;
 
	public Line (double x, double y, Color color, double x2, double y2){
		super(x, y, color);
		this.x2 = x2;
		this.y2 = y2;
	}
 
	public double getX2(){
		return x2;
	}
 
	public double getY2(){
		return y2;
	}
 
	public void paint (Graphics g){
		g.setColor(Color.red);
		g.drawLine((int) getX(), (int) getY(), (int) getX(), (int) y2);
	}
}
