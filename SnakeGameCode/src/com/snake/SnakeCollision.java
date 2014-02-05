package com.snake;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Float;
import java.util.List;

public class SnakeCollision {
	
//	private SnakeSquare sSquare;
//	private SnakeFood sFood;
//	private SnakeObstacle sObst;
	
	public static boolean detectFoodCollision(SnakeSquare singleSnake, SnakeFood sFood){
		// if snake square's touches food's circle then a collision has happened :-/
		boolean collided = false;
		SnakeSquare sSquare = singleSnake;
		double snakeX = sSquare.getX();
		double snakeY = sSquare.getY();
		double snakeLen = sSquare.getLength();
		
		double foodX = sFood.getX();
		double foodY = sFood.getY();
		double foodDia = sFood.getDiameter();
		
		double snakeYComp = snakeY - snakeLen/2;
		double foodXComp = foodX + foodDia;
		
		int randomPosX = ( int )( Math.random() * 399 );
		if(randomPosX < 100)
			randomPosX += 101;
		
		int randomPosY = (int)(Math.random() * 359);
		if(randomPosY < 40)
			randomPosY += 41;
		
		Rectangle snake = getRectangle(snakeX, snakeY, snakeLen, snakeLen);
		Rectangle food = getRectangle(foodX, foodY, foodDia/2, foodDia/2);
		
		
		if( snake.intersects(food) ){
			System.out.println("Food Collision detected");
			sFood.setPosition(randomPosX, randomPosY);
	//		snakeList.add(singleSnake);
			collided = true;
		}
		return collided;
	}
	
	public static boolean detectObstacleCollision(SnakeSquare singleSnake, SnakeObstacle sObst){
		// if snake square's touches food's circle then a collision has happened :-/
		boolean collide = false;
		
		double snakeX = singleSnake.getX();
		double snakeY = singleSnake.getY();
		double snakeLen = singleSnake.getLength();
		
		double foodX = sObst.getX();
		double foodY = sObst.getY();
		double foodDia = sObst.getDiameter();
		
		Rectangle snake = getRectangle(snakeX, snakeY, snakeLen, snakeLen);
		Rectangle food = getRectangle(foodX, foodY, foodDia/2, foodDia/2);
			
		if( snake.intersects(food) ){
			System.out.println("Obstacle Collision detected, hence stopping/Game over");		
			collide = true;
		}
		return collide;
	}
	
	private static Rectangle getRectangle(double snakeX, double snakeY, double snakeLen, double snakeLen2) {
		return new Rectangle((int)snakeX, (int)snakeY, (int)snakeLen, (int)snakeLen2);
	}

	public static boolean detectBoundaryCollision(SnakeSquare ss, BoundaryRect boundary) {
		// TODO Auto-generated method stub
		boolean collide = false;
		
		double snakeX = ss.getX();
		double snakeY = ss.getY();
		double snakeLen = ss.getLength();
		
		double boundX = boundary.getX();
		double boundY = boundary.getY();
		double boundLen = boundary.getLength();
		double boundWidth = boundary.getBreadth();
		double totalLen = boundX + boundLen;
		double totalWid = boundY + boundWidth;
		
	//	Rectangle r1 = new Rectangle(100, 100, 100, 100);
		Line2D l1 = new Line2D.Float((int)boundX, (int)boundY, (int)totalLen, (int)boundY);
		Line2D l2 = new Line2D.Float((int)boundX, (int)boundY, (int)boundX, (int)totalWid);
		Line2D l3 = new Line2D.Float((int)boundX, (int)totalWid, (int)totalLen, (int)totalWid);
		Line2D l4 = new Line2D.Float((int)totalLen, (int)boundY, (int)totalLen, (int)totalWid);
	//	System.out.println("l1.intsects(r1) = " + l1.intersects(r1));
		
		Rectangle snake = getRectangle(snakeX, snakeY, snakeLen, snakeLen);
		//Rectangle food = getRectangle(boundX, boundY, boundLen, boundWidth);
			
		if( l1.intersects(snake) || l2.intersects(snake) || l3.intersects(snake) || l4.intersects(snake) ){
			System.out.println("Obstacle Collision detected, hence stopping/Game over");
			System.out.println(snakeX + " :" + snakeY);
			collide = true;
		}
		return collide;
	}

}
