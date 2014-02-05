package com.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class SnakeSquare extends FillableShape {

	private double length;
	private int snakeSize = 10;
	private Color color2;
	
	 
	public SnakeSquare (double x, double y, Color color, double length){
		super(x, y, color);
		this.length = length;
		this.color2 = color;
	}
 
	public double getLength(){
		return length;
	}
 
	public void paint(Graphics g){
		g.setColor(this.color2);
		
		g.drawRect((int)getX(),(int)getY(),(int)length, (int)length);
		g.fillRect((int)getX(),(int)getY(),(int)length, (int)length);
		g.setColor(Color.black);
		g.drawRect((int)getX(), (int)getY(), (int)length, (int)length);
	}
	
	public void increaseLength(){
		
	}

	public int getSnakeSize() {
		return snakeSize;
	}

	public void setSnakeSize(int snakeSize) {
		this.snakeSize = snakeSize;
	}
}
