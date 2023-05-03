package com;
import java.util.Scanner;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.io.File;
import java.io.FileNotFoundException;

public class Map extends Pane{
//height and width of one cell	
	private int UNIT=30;
//size of the map	
	private int size;
//two dimensional array of integers	
	private int[][] map;
//start position of the ball, which is equal to value "2" inside the map	
	private Position start;

	public Map(String nameOfTheFile){
		try{
	//creating the instance of the file
			File source = new File(nameOfTheFile);
	//reading from the file
			Scanner input = new Scanner(source);
	//defining the size of the map 
			size = input.nextInt();
	//creating the array of integers which will have the values 0,1 or 2
			map = new int[size][size];
	//filling the arrays with integers from the file		
			for(int i=0;i<size;i++)
				for(int j=0;j<size;j++)
					map[i][j] = input.nextInt();
}catch(FileNotFoundException e){
	System.out.println("File doesn't exist");
	System.exit(0);
		}
//drawing rectangles inside the map
	for(int i=0;i<size;i++)
		for(int j=0;j<size;j++){
			Rectangle rectangle = new Rectangle(UNIT*j,UNIT*i,UNIT,UNIT);
			//every rectangle will have black stroke
				rectangle.setStroke(Color.BLACK);
			//if the value of the map at this position equal to "0" , it means we don't have walls here
				//so we fill this rectangle with WHITE color
			if(map[i][j] == 0)
				rectangle.setFill(Color.WHITE);
		//if the value equal to "2", we create the start position and filling the rectangle with WHITE color
		//when creating the new Position we swapped the "i" and "j" because "i" represents row, which is "y" parameter
		//"j" represents column, which is the "x" parameter of the Position instance	
			else if(map[i][j] == 2){
				rectangle.setFill(Color.WHITE);
				start = new Position(j, i);		}
			//if the value is "1", it means we have the wall here, so we fill the rectangle with BLACK color
			else if(map[i][j] == 1)
				rectangle.setFill(Color.BLACK);
		//adding the rectangle into the Map(which exrends Pane, so we can use getChildren() method)
			this.getChildren().add(rectangle);
		}
	}
//returns the height or width of one rectangle
public int getUnit(){
	return UNIT;
}
//returns size
public int getSize(){
	return size;
}
//returns the value of the of the array of integer at some row and column
public int getValue(int x, int y){
	return map[x][y];
}
//returns the start position of the ball 
public Position getStartPosition(){
	return start;
}

}