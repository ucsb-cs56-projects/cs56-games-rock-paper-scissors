package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


/**
*This class allows the first player to choose their Pokemon. It creates a window that gives the first player the options.
*@author Lesley Khuu
*@version for CS56, W14
*/

public class PlayerName extends JFrame {

    int player; // can be 1 or 2
    int character;
    String player1name;
    JPanel panel;
    JLabel label;
    JTextField field;
    char opponent;
    
    public PlayerName(int i, char c) {

	
	super("Choose your player name");
		player = i;
		opponent=c;
        panel = new JPanel();
	label = new JLabel("Player Name: ");
        field = new JTextField("Enter name", 20);
	panel.add(label);
	panel.add(field);
	getContentPane().add( panel, BorderLayout.CENTER );
	field.addActionListener(new TextFieldListener());
	setDefaultCloseOperation( EXIT_ON_CLOSE );
	setSize(600, 300);
	setVisible(true);
    }
    
    public PlayerName(int i, int j, String s) {

	super("Choose your player name");
	player = i;
	character = j;
	player1name = s;
        panel = new JPanel();
        label = new JLabel("Player Name: ");
        field = new JTextField("Enter name", 20);
	panel.add(label);
	panel.add(field);
	getContentPane().add( panel, BorderLayout.CENTER );
	field.addActionListener(new TextFieldListener());
	setDefaultCloseOperation( EXIT_ON_CLOSE );
	setSize(600, 300);
	setVisible(true);
    }
    
    private class TextFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	    //  field.setText("");
	    String name = field.getText();
	    if (player == 1)
		new FirstPlayer(name, opponent);
	    else
		new SecondPlayer(character, player1name, name);
	    dispose();
       }
    }

}
