package com.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class StartScreen extends JPanel {
	
	private int width = 600, height = 480;
	
	public StartScreen(){
		if (width != getWidth() || height != getHeight()){
			width = getWidth(); height = getHeight();}

		Rectangle box = new Rectangle(width, height);
		// Set the background color
		setBackground(Color.LIGHT_GRAY);
		// Set the the dimensions of the drawing area 
		setPreferredSize(new Dimension(width, height));
	}

}
