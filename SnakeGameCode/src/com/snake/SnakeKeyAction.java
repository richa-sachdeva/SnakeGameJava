// code is taken from < code from http://stackoverflow.com/a/6887354/522444>

package com.snake;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;

import com.snake.KeyboardEvents.Direction;

//Actions for the key binding
	 @SuppressWarnings("serial")
	 class SnakeKeyAction extends AbstractAction {
	    private SnakeSquare draw;
	    private Direction direction;
	 //   private List<SnakeSquare> snakeList;
	    private SnakeList snakeList;

	    public SnakeKeyAction(SnakeSquare ss, Direction direction) {
	    		this.draw = ss;
	    		this.direction = direction;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	snakeList = new SnakeList();
	    	snakeList.setSnakeList(SnakePanel.getSnakeList());
	    	//snakeList = SnakePanel.getSnakeList();
	    	int len = snakeList.getSize();
	    	int snakeSize = draw.getSnakeSize();
	    	
	       switch (direction) {
	       case UP:
	    	   System.out.println("up : " + snakeSize);
	          draw.loopThrough(0.0, -1.0);
	       /*   if(len>2){
	        	  if( snakeList.getElement(len-1).getY() - snakeList.getElement(len-2).getY() == snakeSize){
	        		  System.out.println("up inside :"+snakeList.getElement(len-2).getY()+ " :"+snakeList.getElement(len-1).getY());
	        		  
	        	  }
	        	  
	          }*/
	          System.out.println("draw:" + draw.getDX() + " dy:"+ draw.getDY() + " :"+len);
	          break;
	       case DOWN:
	    	   System.out.println("down");
	    	   draw.loopThrough(0.0, 1.0);
	    	   System.out.println("draw:" + draw.getDX() + " dy:"+ draw.getDY());
	          break;
	       case LEFT:
	    	   System.out.println("left");
	    	   draw.loopThrough(-1.0, 0.0);
	    	   
	    	   for (int i=1; i<len; i++){
	    		   // first one has moved to the left, rest 3 are downwards, all up
	    		   
	    	   }
	    	   System.out.println("draw:" + draw.getDX() + " dy:"+ draw.getDY());
	          break;
	       case RIGHT:
	    	   System.out.println("right");
	    	   draw.loopThrough(1.0, 0.0);
	    	   System.out.println("draw:" + draw.getDX() + " dy:"+ draw.getDY());
	          break;

	       default:
	          break;
	       }
	    }
	 }
	 
	
