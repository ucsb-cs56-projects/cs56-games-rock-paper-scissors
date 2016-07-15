package edu.ucsb.cs56.projects.games.rock_paper_scissors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
/**
 *This class allows the second player to choose their Pokemon depending on what player one selected
 *@author Giovanni Dominguez and Issac Holguin Previous Authors:Nicole Moghaddas and Laura Anthony (previous authors: Jordan Nguyen, Brandon Wicka)
 *@version for CS56, W16
 */
public class SecondPlayer extends JFrame{

    private ButtonGroup group;
    String first;
    String second;
    String third;
    JRadioButton firstPokemon;
    JRadioButton secondPokemon;
    JRadioButton thirdPokemon;
    JButton pickFirst;
    JPanel buttonPanel;
    String player1name;
    String player2name;

    public SecondPlayer(final int x, String s, String t) {
        super("Pick your Pokemon " + t + "!");
        JPanel radioPanel = new JPanel();
        radioPanel.setBackground(Color.BLACK);
	player1name = s;
	player2name = t;
        radioPanel.setLayout( new GridLayout(2, 4) );
        group = new ButtonGroup();
        // if bulbasaur was selected first
        if (x == 0) {
            firstPokemon = new JRadioButton("Charmander", true);
            firstPokemon.setActionCommand("Charmander");
            firstPokemon.setForeground(Color.RED);
            secondPokemon = new JRadioButton("Squirtle");
            secondPokemon.setActionCommand("Squirtle");
            secondPokemon.setForeground(Color.BLUE);
	    thirdPokemon = new JRadioButton("Pikachu");
            thirdPokemon.setActionCommand("Pikachu");
            thirdPokemon.setForeground(Color.YELLOW);
	    JLabel charmanderp = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg"));
	    radioPanel.add(charmanderp);
	    JLabel squirtlep = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg"));
	    radioPanel.add(squirtlep);
	    JLabel pikachup = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/pikachu.jpg"));
	    radioPanel.add(pikachup);

	  
        }
        // if squirtle was selected first
        else if (x == 1) {
            firstPokemon = new JRadioButton("Bulbasaur", true);
            firstPokemon.setActionCommand("Bulbasaur");
            Color customColor = new Color(0,198,0);
            firstPokemon.setForeground(customColor);
            secondPokemon = new JRadioButton("Charmander");
            secondPokemon.setActionCommand("Charmander");
            secondPokemon.setForeground(Color.RED);
	        thirdPokemon = new JRadioButton("Pikachu");
            thirdPokemon.setActionCommand("Pikachu");
            thirdPokemon.setForeground(Color.YELLOW);
	    JLabel bulbasaurp = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg"));
	    radioPanel.add(bulbasaurp);
	    JLabel charmanderp = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg"));
	    radioPanel.add(charmanderp);
	    JLabel pikachup = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/pikachu.jpg"));
	    radioPanel.add(pikachup);
        }
        // if charmander was selected first
        else if (x == 2) {
            firstPokemon = new JRadioButton("Bulbasaur", true);
            firstPokemon.setActionCommand("Bulbasaur");
            Color customColor = new Color(0,198,0);
            firstPokemon.setForeground(customColor);
            secondPokemon = new JRadioButton("Squirtle");
            secondPokemon.setActionCommand("Squirtle");
            secondPokemon.setForeground(Color.BLUE);
	    thirdPokemon = new JRadioButton("Pikachu");
            thirdPokemon.setActionCommand("Pikachu");
            thirdPokemon.setForeground(Color.YELLOW);
	    JLabel bulbasaurp = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg"));
	    radioPanel.add(bulbasaurp);
	    JLabel squirtlep = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg"));
	    radioPanel.add(squirtlep);
	    JLabel pikachup = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/pikachu.jpg"));
	    radioPanel.add(pikachup);
        }

	else {//pika selected
            firstPokemon = new JRadioButton("Bulbasaur", true);
            firstPokemon.setActionCommand("Bulbasaur");
	        Color customColor = new Color(0,198,0);
            firstPokemon.setForeground(customColor);
            secondPokemon = new JRadioButton("Squirtle");
            secondPokemon.setActionCommand("Squirtle");
            secondPokemon.setForeground(Color.BLUE);
	    thirdPokemon = new JRadioButton("Charmander");
            thirdPokemon.setActionCommand("Charmander");
            thirdPokemon.setForeground(Color.RED);
	    JLabel bulbasaurp = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg"));
	    radioPanel.add(bulbasaurp);
	    JLabel squirtlep = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg"));
	    radioPanel.add(squirtlep);
	    JLabel charmanderp = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg"));
	    radioPanel.add(charmanderp);
	}
	
        group.add(firstPokemon);
        group.add(secondPokemon);
	group.add(thirdPokemon);
        radioPanel.add(firstPokemon);
        radioPanel.add(secondPokemon);
	radioPanel.add(thirdPokemon);
        getContentPane().add( radioPanel, BorderLayout.CENTER );
        buttonPanel = new JPanel();
        pickFirst = new JButton("I choose you!");
        buttonPanel.setBackground(Color.BLACK);

        buttonPanel.add(pickFirst);
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        setDefaultCloseOperation( EXIT_ON_CLOSE);
        setSize(600, 300);
        setVisible(true);

        pickFirst.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                String selected = group.getSelection().getActionCommand();

                if (selected == "Squirtle" && x == 0){
                    ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg");
                    ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg");
                    new TicTacToe(first, second, player1name, player2name);
                    dispose();
                }

                if (selected == "Squirtle" && x == 2){
                    ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg");
                    ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg");
                    new TicTacToe(first, second, player1name, player2name);
                    dispose();
                }
		
		if (selected == "Squirtle" && x == 3){
                    ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/pikachu.jpg");
                    ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg");
                    new TicTacToe(first, second, player1name, player2name);
                    dispose();
                }

                if (selected == "Bulbasaur" && x == 1){
                    ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg");
                    ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg");
                    new TicTacToe(first, second, player1name, player2name);
                    dispose();
                }

                if (selected == "Bulbasaur" && x == 2){
                    ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg");
                    ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg");
                    new TicTacToe(first, second, player1name, player2name);
                    dispose();
                }
		
                if (selected == "Bulbasaur" && x == 3){
                    ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/pikachu.jpg");
                    ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg");
                    new TicTacToe(first, second, player1name, player2name);
                    dispose();
                }
                if (selected == "Charmander" && x == 0){
                    ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg");
                    ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg");
                    new TicTacToe(first, second, player1name, player2name);
                    dispose();
                }

                if (selected == "Charmander" && x == 1){
                    ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg");
                    ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg");
                    new TicTacToe(first, second, player1name, player2name);
                    dispose();
                }

		if (selected == "Charmander" && x == 3){
                    ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/pikachu.jpg");
                    ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg");
                    new TicTacToe(first, second, player1name, player2name);
                    dispose();
                }

		if (selected == "Pikachu" && x == 0){
                    ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg");
                    ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/pikachu.jpg");
                    new TicTacToe(first, second, player1name, player2name);
                    dispose();
                }

                if (selected == "Pikachu" && x == 1){
                    ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg");
                    ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/pikachu.jpg");
                    new TicTacToe(first, second, player1name, player2name);
                    dispose();
                }

		if (selected == "Pikachu" && x == 2){
                    ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg");
                    ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/pikachu.jpg");
                    new TicTacToe(first, second, player1name, player2name);
                    dispose();
                }
            }
        });
    }

}




