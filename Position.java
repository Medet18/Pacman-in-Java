package com;
public class Position{
	private int x;
	private int y;
//constructure with 2 arguments
	public Position(int x, int y){
		this.x = x;	
		this.y = y;	}
//getter methods
	public int getX(){return x;}
	public int getY(){return y;}
//setter methods
	public void setX(int x){
		this.x = x;	}
	public void setY(int y){
		this.y = y;	}
//boolean method witch returns true if the main Position has the same (x;y) with otherPosition	
	public boolean equals(Position otherPosition){
		if(this.x == otherPosition.getX() && this.y == otherPosition.getY()){
			return true;	}
		else{
			return false;	}
	}
}