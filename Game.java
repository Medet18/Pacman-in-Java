package com;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.*;
import javafx.scene.input.KeyCode;

public class Game extends Application{
//private fields of the Game class which we will use to create the game
  private Map map;
  private Player player;
  private Food food;

  public void start(Stage stage){
    Scanner sc = new Scanner(System.in);
    System.out.println("Way to your Map: ");
    String s = sc.next();
    map = new Map(s);
//creating an instance of the MyPlayer with parameter Map
//type of reference is Player interface, type of object is MyPlayer class which implements Player interface
//creating instance in that way called the polymorthism    
    player = new MyPlayer(map);
//creating an instance of the food with paramenters Map and MyPlayer    
    food = new Food(map, player);
//setting the scene into the stage
    stage.setScene(new Scene(map, 500, 500));
//showing the stage    
    stage.show();
//printing the size of the map when the game is started
    System.out.println("The size of the map: " + map.getSize());

//setting keys from the keyboard to actions with lambda expression(e->)
map.setOnKeyPressed(e->{
//using switch to make action if value of the pressed key will be equal to one of the constants(UP,DOWN,RIGHT,LEFT)
    switch(e.getCode()){
    case UP: player.moveUp(); break;
    case DOWN: player.moveDown(); break;
    case RIGHT: player.moveRight(); break;
    case LEFT: player.moveLeft(); break;
} 
});
//requesting the focus to the map to be able to use keyboard to move the player(ball)
    map.requestFocus();

  }
}