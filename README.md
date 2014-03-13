cs56-games-rock-paper-scissors
==============================

W14 | jcneally | TBD | rock paper scissors game using Pokemon


# cs56-games-rock-paper-scissors

This game is actually not just one game. It allows you to choose between two games. The first one is a tic tac toe game, which allows two players. The players get to choose which Pokemon (Squirtle, Bulbasaur, and Charmander) they want to be as the "x" and "O" pieces. The second game is a rock paper scissors game that uses the Pokemon Squirtle, Bulbasaur, and Charmander as rock, paper, and scissors.

![](http://i.imgur.com/qDigMC5.jpg)

>This is the Home Screen. This is where you choose which game you want to play.





![](http://i.imgur.com/h5i4VaL.jpg)

>If the player selects the Tic Tac Toe game, this screen will appear.
The first player gets to choose which Pokemon they want to use for the game. In this picture they chose Charmander.

![](http://i.imgur.com/8jP7SRC.jpg)

>The second player now gets to choose their Pokemon, but they can't choose the Pokemon that the first player chose. In this picture they chose Bulbasaur.

![](http://i.imgur.com/XjD5ydT.jpg)

>This is an empty board.

![](http://i.imgur.com/NBk6c2a.jpg])

>This is the game taking place. 

![](http://i.imgur.com/2krgqty.jpg)

When a player wins, a window will appear that says who won. If it's a tie, it will just say "Tie!".

![](http://i.imgur.com/7B8GJ3b.jpg)

>This is the format of the Rock Paper Scissors game. 

![](http://i.imgur.com/rfJGuJZ.png)

>When a Pokemon is selected from the bottom right, the computer will generate a random Pokemon as well. If the player win, loses, or ties against the computer, then it will say it in the center text box. The score is kept on the bottom right of the screen.




## Documentation

* The code for reading in the file is located in the `FileRead` class. As you can see in the constructor, it is currently hard-coded for the one text file included. 


![](http://i.imgur.com/iWmslPQ.jpg)
>This code is from the RunGame.java file. It uses JRadioButtons for the game selection options. The main runs the constructor, which loads up the Home Screen.

![](http://i.imgur.com/5m9rejB.jpg)
>This is the TicTacToe constructor, which is located in the TicTacToe.java file. The parameters depend on what the players select. The NoSquirtle, NoBulbasaur, and NoCharmander classes are the ones that call the TicTacToe constructor with the correct parameters.

![](http://i.imgur.com/wKcI5Ax.jpg)
>The Rock Paper Scissors uses a GridBagLayout. The way to set up where the buttons go is by changing the x and y coordinates and adding in the button with the actionListner.

## How to run 
To start the game, use `ant run`. 