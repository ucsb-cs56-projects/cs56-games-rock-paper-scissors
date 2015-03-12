cs56-games-rock-paper-scissors
==============================

project history
===============
```
 W14 | bkiefer13 4pm | lesleykhuu | (jcneally) rock paper scissors game using Pokemon
 W15 | mliou (mentor) | brandonwicka & jordannguyen 4pm | (jcneally) rock paper scissors game using Pokemon
```

## Overview

This program allows a choice between two games. The first game is a two player tic tac toe. The players get to choose which Pokemon (Squirtle, Bulbasaur, and Charmander) they want to be as their "X" and "O" pieces. The second game is rock-paper-scissors which also uses Squirtle, Bulbasaur, and Charmander as rock, paper, and scissors, respectively, to play against the computer.

![](http://i.imgur.com/qDigMC5.jpg)

>This is the home screen where a game is selected to play.


![](http://imgur.com/rnlcT9J.jpg)

>This is a game of tic tac toe taking place. A window will pop up when either player wins or there is a tie.


![](http://i.imgur.com/rfJGuJZ.png)

>This is a session of rock-paper-scissors taking place. The user selects a Pokemon to use, and the computer will randomly generate its own Pokemon to use. Wins, losses, and ties will be recorded in the bottom right of the screen.


## Documentation

```java
public class RunGame extends JFrame {
    
    private ButtonGroup group;
    
    public RunGame() {
        ...
        
        group = new ButtonGroup();
        JRadioButton ttt = new JRadioButton( "Tic Tac Toe", true );
        JRadioButton rps = new JRadioButton( "Rock Paper Scissors" );
        ttt.setActionCommand( "Tic Tac Toe" );
        rps.setActionCommand( "Rock Paper Scissors" );
        
        ...
    }
    
    public static void main( String[] arg ) {
        new RunGame();
    }
}

```
>This is a snippet of code from the RunGame.java file, which is the class that starts up the program. It uses a group of JRadioButtons for the game selection options. The main function runs the constructor, which loads up the Home Screen. 

```java
public TicTacToe(ImageIcon first, ImageIcon second, String firstName, String secondName){
            this.image1 = first;
            this.image2 = second;
            this.name1 = firstName;
            this.name2 = secondName;
            panel = new JPanel ();
            panel.setLayout (new GridLayout(3,3));
            this.add(panel);
            button = new JButton[9];
            for (int i = 0; i <=8; i++){
				button [i] = new JButton();
				panel.add(button[i]);
				button[i].setEnabled(true);
				button[i].addActionListener( new TicTacListener() );
			}
	    ...
		
	}
```
>This is part of the TicTacToe constructor, which is located in the TicTacToe.java file. The SecondPlayer class is the one that calls the TicTacToe constructor with the correct parameters after both players have selected their Pokemon. The tic tac toe game board is made up of 9 JButtons placed on a 3x3 GridLayout.

```java
gc.insets = new Insets(5,75,5,5);
        ...
   
        gc.gridx=0;
        gc.gridy=4;
        rock.addActionListener(new RockListener());
        frame.add(rock, gc);
        gc.gridy=5;
        paper.addActionListener(new PaperListener());
        frame.add(paper, gc);
        gc.gridy=6;
        scissors.addActionListener(new ScissorsListener());
        frame.add(scissors, gc);
        
        ...  
        
		
    }
```
>The layout for rock-paper-scissors is set up on the GameGUI.java class. This snippet of code shows that the rock-paper-scissors interface uses a GridBagLayout, which easily sets the (x,y) coordinates of JButtons and other JComponents.


## How to run 
To start the game, use `ant run`. 
