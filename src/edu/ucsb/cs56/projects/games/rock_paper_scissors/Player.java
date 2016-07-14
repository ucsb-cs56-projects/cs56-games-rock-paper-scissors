package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import java.awt.*;
/**
 A Class that creates the player and his Options for moves
 
 
 @author Connor Tinsley and Gerard Gonzalez
 @version for cs56, Spring 12, UCSB
 
 
*/
public class Player{
	private String name;
	private int move;
//need to add javadoc comment for constructor
	public Player(){}//end constructor

	//getters and setters for name and move
	public String getName(){ return this.name;}		
	public int getMove(){return this.move;}
	public void setName(String playerName){
		this.name=playerName;}
	public void setMove(String playerMove){
		if(playerMove=="Squirtle"){
			this.move=0;	
			}
		if(playerMove=="Bulbasaur"){
			this.move=1;
			}
		if(playerMove=="Charmander"){
			this.move=2;}			
		}
}//end Player
