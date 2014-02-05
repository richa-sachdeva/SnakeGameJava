package com.snake;

import java.util.ArrayList;
import java.util.List;

public class SnakeList {
	
	private List<SnakeSquare> snakeList;
	
	public SnakeList(){
		snakeList = new ArrayList<SnakeSquare>();
	}
	
	public List<SnakeSquare> getSnakeList() {
		return snakeList;
	}

	public void setSnakeList(List<SnakeSquare> snakeList) {
		this.snakeList = snakeList;
	}
	
	public void addSnakeElement(SnakeSquare ss){
		snakeList.add(ss);
	}
	
	public int getSize(){
		return snakeList.size();
	}
	
	public SnakeSquare getElement(int i){
		return snakeList.get(i);
	}
	
	// can possibly add methods to shift/modify the list -> more modular!!

}
