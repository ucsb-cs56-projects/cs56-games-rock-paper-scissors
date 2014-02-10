package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import java.awt.*;
import java.util.*;
/**
 *Class that creates a computer for the user to play against
 *
 *@author Connor Tinsley and Gerard Gonzalez
 *@version for cs56, Spring 12, UCSB
 *
 */



public class Computer{
                private String name;
                private int move;
//need to add javadoc comment for constructor
        public Computer(){
		name="Computer";
                }//end constructor

        //getters and setters for name and move
        public String getName(){ return this.name;}
        public int getMove(){return this.move;}
	public void setMove(int x){
		this.move = x;
	}
        public void setMove(){
               	//generates a random number between 0 and 2
		Random rnd = new Random();
		int min=0;
		int max=2;
		int rndInt = rnd.nextInt(max - min + 1) + min;
		this.move=rndInt;}

}//end Computer
