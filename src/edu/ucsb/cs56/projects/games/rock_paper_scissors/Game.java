package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import java.awt.*;
import java.util.*;
import java.io.*;
/**
 A Class that sets up the game board. 
 
 */
public class Game{
	//score[0] => Player
	//score[1] => Computer
	//score[2] => Ties
	private int[] score = {0,0,0};

	public Game(){}
	public int getScore(int i){
		return score[i];
		}
	/** 	
		This method takes in two ints and compares them to see 
		which player won. Then it increments the correct index
		in score and then return 1, 2, or 3. 
		1=Player wins
		2=Computer wins
		3=Tie 
	*/
	public int getWinner(int playerMove, int computerMove){
		//makes sure they are not equal	
		if(playerMove!=computerMove){
			if(playerMove==0 && computerMove==1){
				score[0]++;
				return 1;
				}
			if(playerMove==0 && computerMove==2){
				score[1]++;
				return 2;
				}
			if(playerMove==1 && computerMove==2){
				score[0]++;
				return 1;
				}
			if(playerMove==1 && computerMove==0){
				score[1]++;
				return 2;
				}
			if(playerMove==2 && computerMove==0){
				score[0]++;
				return 1;
				}	
			if(playerMove==2 && computerMove==1){
				score[1]++;
				return 2;
				}
			}//end !=	
			//otherwise it was a tie
		else
			score[2]++;
			return 3;
			
		
	}//end getWinner
}//end Game
