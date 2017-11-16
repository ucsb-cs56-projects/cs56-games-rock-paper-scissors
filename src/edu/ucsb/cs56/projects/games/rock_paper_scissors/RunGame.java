package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.ArrayList;
/**
    A rock paper scissor game that has a command line interface
    as well as a graphical user interface. Game is 1 player.
    Also a tic tac toe game with 2 players or one player 
    against the computer.


    @authors Giovanni Dominguez and Issac Holguin
    Previous Authors: Nicole Moghaddas and Laura Anthony (previous authors: Lesley Khuu   (previous authors Gerard Gonzalez and Connor Tinsely (Original:Dennis Huynh and Aki Stankoski) ) )
 
    @version for CS56, Summer 16, UCSB
*/ 
//this is the test for pull request
public class RunGame extends JFrame {
    
    private ButtonGroup group;
    private JPanel radioPanel;
    private JPanel buttonPanel;
    private JLabel label;
	private int player;
	private char opponent;
	private JTextField field;
	public int character;
	public String player1name;
	LayoutManager layoutSize;
	private String name;
	private String player2name;
	private JRadioButton firstPokemon;
	private JRadioButton secondPokemon;
	private JRadioButton thirdPokemon;
	private JButton pickFirst;
	public ArrayList<Integer> pokemon;
	private JRadioButton fourthPokemon;

    public RunGame() {
        super( "Tic Tac Toe / Rock Paper Scissors" );
        radioPanel = new JPanel();
        layoutSize = radioPanel.getLayout();
        label = new JLabel("Welcome");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        radioPanel.setLayout( new GridLayout( 1, 4 ) );
        radioPanel.setOpaque(true);
        
        group = new ButtonGroup();
        JRadioButton ttt = new JRadioButton( "Tic Tac Toe", true );
        ttt.setBackground(Color.BLACK);
        ttt.setFont(new Font("Courier", Font.BOLD,22));
        JRadioButton rps = new JRadioButton( "Rock Paper Scissors" );
        rps.setBackground(Color.BLACK);
        rps.setFont(new Font("Courier", Font.BOLD,22));
        ttt.setActionCommand( "Tic Tac Toe" );
        rps.setActionCommand( "Rock Paper Scissors" );
        ttt.setForeground(Color.RED);
        rps.setForeground(Color.BLUE);
        group.add( ttt );
        group.add( rps );
        radioPanel.add( ttt );
        radioPanel.add( rps );
        getContentPane().add( radioPanel, BorderLayout.CENTER );
        radioPanel.setBackground(Color.BLACK);
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        JButton pickGame = new JButton( "Let's Play!" );
        /*



        */
        GridBagConstraints gc = new GridBagConstraints(); 
        gc.gridx = 2;
        gc.gridy = 4;
        gc.gridx = 1;
        JButton help = new JButton();

        help.setText("HELP");

        help.addActionListener(new HelpListener());
        buttonPanel.add(help, gc);
        this.add(label, BorderLayout.NORTH);
        pickGame.addActionListener( new PickGameListener() );
        Color customColorGreen = new Color(0,198, 0);
        pickGame.setForeground(customColorGreen);
        buttonPanel.add( pickGame );
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize( 600, 300 );
        setVisible( true );

       
    }
    
   
    
    public static void main( String[] arg ) {
        new RunGame();
    }
    
    private class PickGameListener implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            String selected = group.getSelection().getActionCommand();
            if ( selected == "Tic Tac Toe" ){
            	ChooseOpponent();
            }
            if ( selected == "Rock Paper Scissors" ){
                GameGUI a = new GameGUI();
                a.setUpHomeScreen();
                dispose();
            }
            if (selected == "Computer"){
                PlayerName(1,'c');
            }
            
            if (selected == "Person"){
                PlayerName(1,'p');
            } 


      
       }

		
    }
    
    private class TextFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	    String name = field.getText();
        //set the condition that the name cannot be empty
        if (name.length() != 0) {
	       if (player == 1)
		      FirstPlayer(name, opponent);
	       else
	           SecondPlayer(character, player1name, name);
        }
       }
    }

    private class HelpListener implements ActionListener{ //used for help button
        @Override
        public void actionPerformed(ActionEvent evt){
            
            JOptionPane.showMessageDialog(null, "HOW TO PLAY: \n \n Select a game to play and hit 'Lets Play!' to start the game of your choice.\n\n Tic Tac Toe: You have the choice to choose if you want to play the computer or a person next to you. Enter your name(s) and select a pokemon to represent your O or X. \n Then face your opponent! \n \n Rock Paper Scissors: You will play the computer. There is a key on the top left corner that describes what represents rock, paper, or scissors as pokemon.\n (this makes RPS more fun).On the bottom left corner are the buttons you can select to represent the move you make.\n The bottom corner keeps track of how many times you've won, lost, or tied with the computer. You can select 'return to game selection' to come back to original menu.");

        }
    }
    
    private class PickGameListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selected = group.getSelection().getActionCommand();

	    if (opponent=='c') {
		ImageIcon first = null;
		ImageIcon second = null;
		if (selected == "Squirtle") {
		    first = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Squirtle.jpg");
		    second = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Pikachu.jpg");
		}
		if (selected == "Bulbasaur") {
		    first = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Bulbasaur.jpg");
		    second = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Charmander.jpg");
		}
		if (selected == "Charmander") {
		    first = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Charmander.jpg");
		   second = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Squirtle.jpg");
		}
		if (selected == "Pikachu") {
		    first = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Pikachu.jpg");
		    second = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Bulbasaur.jpg");
		}
		//delin sun changes: this if statement makes sure that the user choose one pokemon.
		if(first!=null){
		    new TicTacToe(first,second,name, "Computer");
		    dispose();
		}
		
	    }
	    else {
		//make Squirtle image for first player
		if (selected == "Squirtle"){
		    PlayerName(2, 1, name);
		}
		
		//make bulbasaur image for first player
		if (selected == "Bulbasaur"){
		    PlayerName(2, 0, name);
		}
		
		//make Charmander image for first player
		if (selected == "Charmander"){
		    PlayerName(2, 2, name);
		}
		
		//make Pikachu image for first player
		if (selected == "Pikachu"){
		    PlayerName(2, 3, name);
		}
	    }
	}
    }

	public void PlayerName(int i, char c) {
	    radioPanel.removeAll();
		buttonPanel.removeAll();
        label.setText("Choose your player name");
		radioPanel.setLayout(layoutSize);
		player = i;
		opponent=c;
		label = new JLabel("Player Name: ");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Courier", Font.BOLD,22));
	    field = new JTextField("Enter name", 20);
		field.setFont(new Font("Courier", Font.BOLD,22));
		field.setForeground(Color.RED);
		radioPanel.add(label);
		radioPanel.add(field);
		getContentPane().add( radioPanel, BorderLayout.CENTER );
		field.addActionListener(new TextFieldListener());
		field.addMouseListener(new MouseAdapter(){  //clears field text
	        	@Override
	        	public void mouseClicked(MouseEvent e){
	        		field.setText("");
	        	}
	        });
		setVisible(true);
		
	}
	
	public void PlayerName(int i, int j, String s) {
		label.setText("Choose your player name");
		radioPanel.removeAll();
		buttonPanel.removeAll();
		player = i;
		character = j;
		player1name = s;
		radioPanel.setLayout(layoutSize);
		label = new JLabel("Player Name: ");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Courier", Font.BOLD,22));
	        field = new JTextField("Enter name", 20);
	       

		field.setFont(new Font("Courier", Font.BOLD,22));
		field.setForeground(Color.RED);
		radioPanel.add(label);
		radioPanel.add(field);
		getContentPane().add( radioPanel, BorderLayout.CENTER );
		field.addActionListener(new TextFieldListener());
	    field.addMouseListener(new MouseAdapter(){  ////clears field text
	        	@Override
	        	public void mouseClicked(MouseEvent e){
	        		field.setText("");
	        	}
	        });

		setVisible(true);
	    }



	public void ChooseOpponent() {
		radioPanel.removeAll();
		buttonPanel.removeAll();
        label.setText("Choose your Opponent!");
		getContentPane().setBackground(Color.WHITE);
        radioPanel.setLayout( new GridLayout(1, 2) );
        radioPanel.setOpaque(true);
        JRadioButton computer = new JRadioButton("Computer", true );
        JRadioButton person = new JRadioButton("Person");
        computer.setFont(new Font("Courier", Font.BOLD,25));
        person.setFont(new Font("Courier", Font.BOLD,25));
        computer.setBackground(Color.BLACK);// RADIO BG CHANGE
        person.setBackground(Color.BLACK);

        computer.setActionCommand("Computer");
        computer.setForeground(Color.BLUE);
        person.setActionCommand("Person");
        person.setForeground(Color.RED);
        
        group.add(computer);
        group.add(person);

        radioPanel.add(computer);
        radioPanel.add(person);

        getContentPane().add( radioPanel, BorderLayout.CENTER );
        buttonPanel.setBackground(Color.BLACK);
        JButton pickFirst = new JButton("Challenge Accepted");
        Color customGreen = new Color(0,198,0);
        pickFirst.setForeground(customGreen);
        pickFirst.addActionListener(new PickGameListener());
        buttonPanel.add(pickFirst);
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        setVisible(true);
		
	}
	
	
	
	
	public void FirstPlayer(String s, char c) {
		
		radioPanel.removeAll();
		buttonPanel.removeAll();
        label.setText("Pick your Pokemon " + s + "!");
		name = s;
		opponent=c;
        radioPanel.setLayout( new GridLayout(2, 4) );
        radioPanel.setBackground(Color.BLACK);
        JRadioButton charmander = new JRadioButton("Charmander", true);
		charmander.setFont(new Font("SomeRandomFont",Font.BOLD, 16));
		charmander.setForeground(Color.ORANGE);
		charmander.setBackground(Color.BLACK);
		
        JRadioButton bulbasaur = new JRadioButton("Bulbasaur");
		bulbasaur.setFont(new Font("SomeRandomFont",Font.BOLD, 16));
		Color customGreen = new Color(0,198, 0);// fix!!!!!!!!
		bulbasaur.setForeground(customGreen);
		bulbasaur.setBackground(Color.BLACK);
        JRadioButton squirtle = new JRadioButton("Squirtle");
    	squirtle.setFont(new Font("SomeRandomFont",Font.BOLD, 16));
		squirtle.setForeground(Color.BLUE);
		squirtle.setBackground(Color.BLACK);
		squirtle.setBackground(Color.BLACK);
		JRadioButton pik = new JRadioButton("Pikachu");
		pik.setFont(new Font("SomeRandomFont",Font.BOLD, 16));
		pik.setForeground(Color.YELLOW);
		pik.setBackground(Color.BLACK);
        charmander.setActionCommand("Charmander");
        bulbasaur.setActionCommand("Bulbasaur");
        squirtle.setActionCommand("Squirtle");
        pik.setActionCommand("Pikachu");
	
        group.add(charmander);
        group.add(bulbasaur);
        group.add(squirtle);
        group.add(pik);
	
        radioPanel.add(charmander);
        radioPanel.add(bulbasaur);
        radioPanel.add(squirtle);
        radioPanel.add(pik);

        JLabel charmanderp = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Charmander.jpg"));
        radioPanel.add(charmanderp);

        JLabel bulbasaurp = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Bulbasaur.jpg"));
        radioPanel.add(bulbasaurp);

        JLabel squirtlep = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Squirtle.jpg"));
        radioPanel.add(squirtlep);

        JLabel pikachup = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Pikachu.jpg"));
        radioPanel.add(pikachup);
	
        getContentPane().add( radioPanel, BorderLayout.CENTER );
        JButton pickFirst = new JButton("I choose you!");
        buttonPanel.setBackground(Color.BLACK);
        pickFirst.addActionListener(new PickGameListener2());
        buttonPanel.add(pickFirst);
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        setVisible(true);
    }
	
	
	
	public void SecondPlayer(final int x, String s, String t) {
		
		radioPanel.removeAll();
		buttonPanel.removeAll();

        radioPanel.setBackground(Color.BLACK);
		player1name = s;
		player2name = t;
        radioPanel.setLayout( new GridLayout(2, 4) );
        
        pokemon = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) { 
        	pokemon.add(i);
        }
        pokemon.remove(x); 
        for ( int i : pokemon ) {
        	if (i == 0) { // Bulbasaur is in the Array (was never chosen)
        		firstPokemon = new JRadioButton("Bulbasaur", true);
                firstPokemon.setActionCommand("Bulbasaur");
    	        Color customColor = new Color(0,198,0);
                firstPokemon.setForeground(customColor);
                firstPokemon.setBackground(Color.BLACK);
                JLabel bulbasaurp = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Bulbasaur.jpg"));
        	    radioPanel.add(bulbasaurp);
        	}
        	if (i == 1) { // Squirtle
        		secondPokemon = new JRadioButton("Squirtle");
                secondPokemon.setActionCommand("Squirtle");
                secondPokemon.setForeground(Color.BLUE);
        	    secondPokemon.setBackground(Color.BLACK);
        	    JLabel squirtlep = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Squirtle.jpg"));
        	    radioPanel.add(squirtlep);
        	}
        	if (i == 2) { // Charmander
        		thirdPokemon = new JRadioButton("Charmander");
                thirdPokemon.setActionCommand("Charmander");
                thirdPokemon.setForeground(Color.RED);
                thirdPokemon.setBackground(Color.BLACK);
                JLabel charmanderp = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Charmander.jpg"));
        	    radioPanel.add(charmanderp);
        	}
        	if (i == 3) { // Pikachu
        		fourthPokemon = new JRadioButton("Pikachu");
                fourthPokemon.setActionCommand("Pikachu");
                fourthPokemon.setForeground(Color.YELLOW);
    	        fourthPokemon.setBackground(Color.BLACK);
    	        JLabel pikachup = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Pikachu.jpg"));
    		    radioPanel.add(pikachup);
        	}	
        }
        for ( int i : pokemon ) {
        	if (i == 0) { // Bulbasaur 
        		group.add(firstPokemon);
        		radioPanel.add(firstPokemon);
        	}
        	if (i == 1) { // Squirtle
        		group.add(secondPokemon);
        		radioPanel.add(secondPokemon);
        	}
        	if (i == 2) { // Charmander
        		group.add(thirdPokemon);
        		radioPanel.add(thirdPokemon);
        	}
        	if (i == 3) { // Pikachu
        		group.add(fourthPokemon);
                radioPanel.add(fourthPokemon);
        	}
        }
        getContentPane().add( radioPanel, BorderLayout.CENTER );
        pickFirst = new JButton("I choose you!");
        buttonPanel.setBackground(Color.BLACK);
        label.setText("Pick your Pokemon " + s + "!");
        buttonPanel.add(pickFirst);
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        setDefaultCloseOperation( EXIT_ON_CLOSE);
        setVisible(true);

        pickFirst.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                String selected1 = group.getSelection().getActionCommand();
		ImageIcon first = null;
		ImageIcon second = null;
                if (x == 0) { // Bulbasaur 
                	first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Bulbasaur.jpg");
			second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/" + selected1 + ".jpg");
			if(selected1!="Bulbasaur"){
                            new TicTacToe(first,second,player1name,player2name);
                            dispose();
			}
                }
                if (x == 1) { // Squirtle
                	first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Squirtle.jpg");
			second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/" + selected1 + ".jpg");
			if(selected1!="Squirtle"){
                            new TicTacToe(first,second,player1name,player2name);
                            dispose();
			}
                }
                if (x == 2) { // Charmander
                	first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Charmander.jpg");
			second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/" + selected1 + ".jpg");
			if(selected1!="Charmander"){
                            new TicTacToe(first,second,player1name,player2name);
                            dispose();
			}
                }
                if (x == 3) { // Pikachu
                	first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/Pikachu.jpg");
			second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/" + selected1 + ".jpg");
			if(selected1!="Pikachu"){
	                    new TicTacToe(first,second,player1name,player2name);
        	            dispose();
                	}
		}
            }
        });
    }

}
	



