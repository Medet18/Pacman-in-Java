package com;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class MyPlayer implements Player{
//private fields
private Circle ball;
private Map map;
private Position position;

  MyPlayer(Map map){
  //this.map - means MyPlayer's data field "map"  
    this.map = map;  
  //setting the ball's position by getting start position from the map  
    position = map.getStartPosition();
  //creating the ball using constructor of the Circle (centerX, centerY, radius)
  //centerX = position.getX()+map.getUnit()/2   because we need the centerX of the circle be in the center of the rectangle
  //radius = map.getUnit()/2  because radius of the ball should be equal the half of the UNIT variable
    ball = new Circle(position.getX()*map.getUnit()+map.getUnit()/2, position.getY()*map.getUnit()+map.getUnit()/2, map.getUnit()/2);
  //setting ball's color to red  
    ball.setFill(Color.RED);
  //adding the ball into the map(map extends Pane, so we use "getChildren().add()"" method to add the ball  
    map.getChildren().add(ball);
  }

//overriding abstract methods from the Player interface

public void moveRight(){  
  boolean insideTheMap = this.getPosition().getX() < map.getSize()-1;
//make that we are inside the map and checking that right side doesn't have any walls
  if(insideTheMap && map.getValue(this.getPosition().getY(), this.getPosition().getX()+1)!=1) 
      ball.setCenterX(ball.getCenterX() + map.getUnit());  //changing ball's senter's position if we can move
  else  //printing message if we cannot move in this direction
     System.out.println("Invalid position");
 
}

public void moveLeft(){  
  boolean insideTheMap = this.getPosition().getX() > 0;
//make that we are inside the map and checking that left side doesn't have any walls
  if(insideTheMap && map.getValue(this.getPosition().getY(), this.getPosition().getX()-1)!=1)   
      ball.setCenterX(ball.getCenterX() - map.getUnit());  //changing ball's senter's position if we can move
  else  //printing message if we cannot move in this direction
     System.out.println("Invalid position");
 }

 public void moveUp(){
  boolean insideTheMap = this.getPosition().getY() > 0;
//make that we are inside the map and checking that upper side doesn't have any walls
  if(insideTheMap && map.getValue(this.getPosition().getY()-1, this.getPosition().getX())!=1)    
      ball.setCenterY(ball.getCenterY() - map.getUnit());  //changing ball's senter's position if we can move
  else  //printing message if we cannot move in this direction
     System.out.println("Invalid position");
 }

 public void moveDown(){
  boolean insideTheMap = this.getPosition().getY()<map.getSize()-1;
//make that we are inside the map and checking that down side doesn't have any walls
  if(insideTheMap && map.getValue(this.getPosition().getY()+1, this.getPosition().getX())!=1) 
     ball.setCenterY(ball.getCenterY() + map.getUnit());  //changing ball's center's position if we can move
  else  //printing message if we cannot move in this direction
     System.out.println("Invalid position");
 }
//getting the current position of the ball by dividing it's center's coordinations to the UNIT variable
//getCenterX() and getCenterY() methods returns double values, so we have to rounding it down by converting it to integer
  public Position getPosition(){  
    return new Position((int)(ball.getCenterX()/map.getUnit()), (int)(ball.getCenterY()/map.getUnit())); 
}

}