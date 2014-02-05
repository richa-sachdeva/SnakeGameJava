package com.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.snake.KeyboardEvents.Direction;

public class SnakePanel extends JPanel implements Runnable, ActionListener{
	
	private int width = 600, height = 480;
	private Thread thread;
	
	private static List<SnakeSquare> sSquare;
	private BoundaryRect boundary;
	private SnakeObstacle sObst;
	private SnakeFood sFood;
	long startTime, endTime;	
	private volatile boolean running = true;
	
	public static final int SPRITE_WIDTH = 20;
	public static final int PANEL_WIDTH = 400;
    public static final int PANEL_HEIGHT = 400;
    
    private int snakeSize = 10;
  
	public void actionPerformed(ActionEvent e) {}
	
	public static List<SnakeSquare> getSnakeList(){
		return sSquare;
	}
	
	public SnakePanel() {		
		startTime = System.nanoTime();
	
		int x1 = 0, x2 = width/2, x3 = height/2, x4 = width/4, x5 = height/4;
		int snakeFood = 12, snakeObst = 16, offset = 0;
 
		Color color = Color.orange;
 
		sSquare = new ArrayList<SnakeSquare>();
		
		sSquare.add(new SnakeSquare(x2, x3, new Color(255, 0, 0), snakeSize));
		sSquare.add(new SnakeSquare(x2, x3+snakeSize+offset, color, snakeSize));
		
		boundary = new BoundaryRect(100, 40, color, 400, 360);
		
		System.out.println("in constructor: "+sSquare.size());
		
		sObst = new SnakeObstacle(110, x4, color, snakeObst);
		sFood = new SnakeFood(x4, x5, color, snakeFood);
		
		for(SnakeSquare ss: sSquare){
			setupKeyBinding(ss);
		}
		setupKeyBinding(sSquare.get(0));

		// Set the background color
		setBackground(Color.LIGHT_GRAY);
		// Set the the dimensions of the drawing area 
		setPreferredSize(new Dimension(width, height));		
	} 
	
	public void startThread(){
		// Create the thread-object, responsible for the animation
		running = true;
		thread = new Thread(this);
		thread.start();
	}
 
	public void terminate() {
        running = false;
   //     thread.destroy();
   //     thread.
    }
	/** Define what to draw. Called by repaint().  */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(SnakeSquare i:sSquare)i.paint(g);
		sObst.paint(g);
		sFood.paint(g);
		boundary.paint(g);
	}
 
	/** Update the position of the ball and repaint.
	 *  This method is executed by the thread-object.
	 */
	public void run() {
		
		while(running) {
 
			if (width != getWidth() || height != getHeight()){
				width = getWidth(); height = getHeight();}
 
			Rectangle box = new Rectangle(width, height);
			
			for(SnakeSquare ss : sSquare)
				ss.setBoundingBox(box);
			
			sObst.setBoundingBox(box);
			sFood.setBoundingBox(box);
			
			for(SnakeSquare ss : sSquare)ss.move();
			
			moveSnake();
			
			repaint(); // Calls paintComponent(g)
 
			// Sleep for 20 ms before next update
			try {
					Thread.sleep(20);
					endTime = System.nanoTime();
					boolean collide = false;
					for(SnakeSquare ss : sSquare){
						if(SnakeCollision.detectFoodCollision(ss, sFood)){
						//	sSquare.add(new SnakeSquare(ss.getX(), ss.getY(), ss.getColor(), ss.getLength()));
							collide = true;
						}
						// likewise detect obstacle collision
						if(SnakeCollision.detectObstacleCollision(ss, sObst)){
							terminate();
							JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
						}
						if(SnakeCollision.detectBoundaryCollision(ss, boundary)){
							terminate();
							JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
						}
						// check if snake has touched the boundaries (??)
					}
					if(collide)
						addAnotherElement();
				}
			catch(InterruptedException e) {}
		}
	}
	
	 private void addAnotherElement() {
		// TODO Auto-generated method stub
		 SnakeSquare ss = sSquare.get(sSquare.size() - 1);
		 double velX = ss.getDX();
		 double velY = ss.getDY();
		 
		 double x = ss.getX();
		 double y = ss.getY();
		 double len = ss.getLength();
		 Color c = ss.getColor();
//		 double snakeSize = 10.0f;
		 
		 if(velX == 0 && velY == 0){sSquare.add(new SnakeSquare(x, y + snakeSize, c, len));}
		 if(velX == 0 && velY == 1){sSquare.add(new SnakeSquare(x, y - snakeSize, c, len));}//move down;
		 if(velX == 0 && velY == -1){sSquare.add(new SnakeSquare(x, y + snakeSize, c, len));}//move up;
		 if(velX == 1 && velY == 0){sSquare.add(new SnakeSquare(x+ snakeSize, y, c, len));}//move right;
		 if(velX == -1 && velY == 0){sSquare.add(new SnakeSquare(x - snakeSize, y, c, len));}// move left;
		
	}

	private void moveSnake() {		
		
		SnakeSquare ss, curr;
		double velX, velY, x, y, len;
		Color c;
		
		for(int i=1; i<sSquare.size(); i++) {
			
			ss = sSquare.get(i-1);
			curr = sSquare.get(i);
			velX = ss.getDX();
			velY = ss.getDY();
			x = ss.getX();
			y = ss.getY();
			
			 if(velX == 0 && velY == 1){curr.setPosition(x, y - snakeSize); }//move down;
			 if(velX == 0 && velY == -1){curr.setPosition(x, y+snakeSize);}//move up;
			 if(velX == 1 && velY == 0){curr.setPosition(x - snakeSize, y);}//move right;
			 if(velX == -1 && velY == 0){curr.setPosition(x + snakeSize,y);}// move left;
			 curr.loopThrough(velX, velY);
		}
	}


	private void setupKeyBinding(SnakeSquare ss) {
	      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
	      InputMap inMap = getInputMap(condition);
	      ActionMap actMap = getActionMap();

	      // this uses an enum of Direction that holds ints for the arrow keys
	      for (Direction direction : Direction.values()) {
	         int key = direction.getKey();
	         String name = direction.name();

	         // add the key bindings for arrow key and shift-arrow key
	         inMap.put(KeyStroke.getKeyStroke(key, 0), name);
	         inMap.put(KeyStroke.getKeyStroke(key, InputEvent.SHIFT_DOWN_MASK), name);
	      //   for(SnakeSquare ss : sSquare)
	        	 actMap.put(name, new SnakeKeyAction(ss, direction));
	      }
	   }
	 
	private static final long serialVersionUID = 1L;
}
	

	