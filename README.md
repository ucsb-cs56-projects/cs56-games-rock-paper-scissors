cs56-games-rock-paper-scissors
==============================

project history
===============
```
 W14 | bkiefer13 4pm | lesleykhuu | (jcneally) rock paper scissors game using Pokemon
```


This program allows you to choose between two games. The first one is a tic tac toe game, which allows two players. The players get to choose which Pokemon (Squirtle, Bulbasaur, and Charmander) they want to be as the "X" and "O" pieces. 

![](http://i.imgur.com/lVaMkEt.png)

--------------------------------------------------------------------------------

The second game is a rock paper scissors game that uses the Pokemon Squirtle, Bulbasaur, and Charmander as rock, paper, and scissors.

![](http://i.imgur.com/X0VDCM5.png)

--------------------------------------------------------------------------------

>This is the Home Screen. This is where you choose which game you want to play.

>If the player selects the Tic Tac Toe game, this screen will appear.
The first player gets to choose which Pokemon they want to use for the game. In this picture they chose Charmander.


>The second player now gets to choose their Pokemon, but they can't choose the Pokemon that the first player chose. In this picture they chose Bulbasaur.

![](http://i.imgur.com/XjD5ydT.jpg)

>This is an empty board.

![](http://i.imgur.com/NBk6c2a.jpg])

>This is the game taking place. 

![](http://i.imgur.com/2krgqty.jpg)

>When a player wins, a window will appear that says who won. If it's a tie, it will just say "Tie!".

![](http://i.imgur.com/7B8GJ3b.jpg)

>This is the format of the Rock Paper Scissors game. 

![](http://i.imgur.com/rfJGuJZ.png)

>When a Pokemon is selected from the bottom left, the computer will generate a random Pokemon as well. If the player win, loses, or ties against the computer, then it will say it in the center text box. The score is kept on the bottom right of the screen.




## Documentation

```java
public class RunGame extends JFrame {
    
    private ButtonGroup group;
    
    public RunGame() {
        super( "RunGame" );
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout( new GridLayout( 1, 4 ) );
        group = new ButtonGroup();
        JRadioButton ttt = new JRadioButton( "Tic Tac Toe", true );
        JRadioButton rps = new JRadioButton( "Rock Paper Scissors" );
        ttt.setActionCommand( "Tic Tac Toe" );
        rps.setActionCommand( "Rock Paper Scissors" );
        group.add( ttt );
        group.add( rps );
        radioPanel.add( ttt );
        radioPanel.add( rps );
        getContentPane().add( radioPanel, BorderLayout.CENTER );
        JPanel buttonPanel = new JPanel();
        JButton pickGame = new JButton( "Let's Play!" );
        pickGame.addActionListener( new pickGameListener() );
        buttonPanel.add( pickGame );
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize( 600, 300 );
        setVisible( true );
    }
    
    public static void main( String[] arg ) {
        new RunGame();
    }
    
    private class pickGameListener implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            String selected = group.getSelection().getActionCommand();
            if ( selected == "Tic Tac Toe" ){
                  new FirstPlayer();
        dispose();
            }
            if ( selected == "Rock Paper Scissors" ){
                GameGUI a = new GameGUI();
                a.setUpHomeScreen();
		dispose();
            }


      
       }
    }
}

```
>This code is from the RunGame.java file. It uses JRadioButtons for the game selection options. The main runs the constructor, which loads up the Home Screen. 

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

            gameChange.setPreferredSize( new Dimension(50,100));
            gameChange.addActionListener ( new ChangeGameListener() );	
            this.add( gameChange, BorderLayout.SOUTH);
            this.setSize(600,600);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setVisible(true);
	}
```
>This is the TicTacToe constructor, which is located in the TicTacToe.java file. The parameters depend on what the players select. The NoSquirtle, NoBulbasaur, and NoCharmander classes are the ones that call the TicTacToe constructor with the correct parameters.

```java
gc.insets = new Insets(5,75,5,5);
        gc.gridx=1;
        gc.gridy=0;
        frame.add(title, gc);
        gc.gridx=1;
        gc.gridy=1;
        text.setEditable(false);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(400,300));
        frame.add(scroll, gc);
        gc.gridx=1;
        gc.gridy=2;
        frame.add(gamesPlayed, gc);
        gc.gridx=1;
        gc.gridy=3;
        played.setEditable(false);
        frame.add(played, gc);
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
        gc.gridx=2;
        gc.gridy=4;
        gc.gridx=1;
        changeGame.addActionListener( new ChangeGameListener());
        frame.add(changeGame, gc);
        gc.gridx=2;
        gc.insets = new Insets(5,5,5,5);
        frame.add(wins, gc);
        gc.gridy=5;
        frame.add(losses, gc);
        gc.gridy=6;
        frame.add(ties, gc);
        gc.insets = new Insets(5,5,5,75);
        gc.gridx=3;
        gc.gridy=4;
        win.setEditable(false);
        frame.add(win, gc);
        gc.gridy=5;
        lose.setEditable(false);
        frame.add(lose, gc);
        gc.gridy=6;
        tie.setEditable(false);
        frame.add(tie, gc);
        frame.setSize(500,500);
        frame.setBackground(Color.WHITE);
        frame.pack();
       frame.setVisible(true);    
        
		
    }
```
>The Rock Paper Scissors uses a GridBagLayout. The way to set up where the buttons go is by changing the x and y coordinates and adding in the button with the actionListener.

## How to run 
To start the game, use `ant run`. 

## More Information
More information on the gameplay can be found at the link below:  
https://github.com/UCSB-CS56-Projects/cs56-games-rock-paper-scissors/wiki
