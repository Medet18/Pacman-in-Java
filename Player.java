package com;
public interface Player{
//abstract methods to move the ball to the right, left, up and down respectively
	public void moveRight();
	public void moveLeft();
	public void moveUp();
	public void moveDown();
//returns the position of the ball	
	public Position getPosition();
}