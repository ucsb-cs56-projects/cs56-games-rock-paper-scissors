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

## More info
Brief paths:
Choose to play Tic-Tac-Toe or Rock-Paper-Scissors

![](http://i.imgur.com/OhkItzG.png)

Tic-Tac-toe game looks like this:

![](https://i.imgur.com/ua0yaZL.png)

A player wins when he or she successfully places three pieces in a row. If the game board fills up before either player gets three in a row, a tie is declared. 

Rock-Paper-Scissors game looks like this:

![](https://i.imgur.com/by5GarX.png)

The user can select their Pokemon (Bulbasaur, Squirtle, or Charmander) from the bottom left to act as their rock, paper, or scissors. The computer simultaneously selects their own Pokemon randomly to play.

For a more in-depth look at this program, please visit the [wiki](https://github.com/UCSB-CS56-Projects/cs56-games-rock-paper-scissors/wiki).

## W16 Final Remarks
The RunGame.java class is the intial game screen, where the player is promted to pick one of the games. The ActionListener of each selection sets up the starting screen for that game. There is currently a Run.java class that is supposed to set up the game screen for the rock paper scissors game, but it currently serves no purpose because the RunGame.java class takes on that responsibility more effectively. The RunGame.java class creates an instance of the GameGUI.java class (which contains all of the code for rock paper scissors and is difficult to modify or extend) to start the rock paper scissors game if the player selects that game option, or creates an instance of the ChooseOpponent class which brings up a separate window where the player can choose to either play against a computer or second player if tic tac toe is selected as the game.
Since the previous editors/creators did not separate the rock paper scissors code into separate classes, it is very difficult to add features without introducing bugs into the rest of the code. So refactoring the code into a more object oriented design would be a good addition, but not an easy task. However, tic tac toe on the other hand, is nicely separated into classes and easier to modify. If tic tac toe is the game chosen, an instance of the PlayerName class is created and brings up a window where the user can enter his/her name to be displayed during the game(if there are two players, then two separate windows will appear successively for entering player names). If the player chooses computer as the opponent, the player is immediately redirected to pick their character and then to the tic tac toe game board; if a second player is playing, the second player will choose their character directly after the first player has chosen his/hers. Once both players have set up their game options, an instance of the actual tic tac toe class is created to bring up the game grid and calculates the winner of the game based on the player moves. The tic tac toe game is broken down into separate classes, while the rock paper scissors class is all implemented together in one class with several inner classes. One helpful addition to the code would be comments for each or most methods describing their function to the overall game. In TicTacToe.java, the firstPlayerWins() and secondPlayerWins() are almost identical and could be refactored into one function that takes the string name (the only variable that is different). In TicTacToe.java, the checkWinner() function duplicates code and could be refactored into a function that takes the player number as a paramater. In TicTacToe.java, some of the variable names (firstName, secondName, etc.) could be renamed for clarity.

## M16 Final Remarks
Still, RunGame.java is the initial game screen where we can choose either tic tac toe or rock paper scissors. We done alot of refactoring to the program, getting rid of 4 classes that would create new JFrame's, which was completely inefficient. RunGame.java will be the starting base for whoever decides to work on this next. I would reccomend still refactoring before anything, because this code leaves little room for expansion. Here are some issues you might want to tackle first:

Get these issues done before anything. I wo
