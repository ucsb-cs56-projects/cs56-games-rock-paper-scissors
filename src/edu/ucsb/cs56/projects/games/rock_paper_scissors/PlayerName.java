package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


/**
*This class allows the  player to add their name to the game screen to personalize their play. It creates a window that gives the player the place to type.
*@author Laura Anthony and Nicole Moghaddas
*@version for CS56, W16
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
	panel.setBackground(Color.BLACK);
	label = new JLabel("Player Name: ");
	label.setForeground(Color.BLUE);
	label.setFont(new Font("Courier", Font.BOLD,22));
        field = new JTextField("Enter name", 20);
	field.setFont(new Font("Courier", Font.BOLD,22));
	field.setForeground(Color.RED);
	panel.add(label);
	panel.add(field);
	getContentPane().add( panel, BorderLayout.CENTER );
	field.addActionListener(new TextFieldListener());
	field.addMouseListener(new MouseAdapter(){  ////clears field text
        	@Override
        	public void mouseClicked(MouseEvent e){
        		field.setText("");
        	}
        });
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
	panel.setBackground(Color.BLACK);
	label = new JLabel("Player Name: ");
	label.setForeground(Color.BLUE);
	label.setFont(new Font("Courier", Font.BOLD,22));
        field = new JTextField("Enter name", 20);
       

	field.setFont(new Font("Courier", Font.BOLD,22));
	field.setForeground(Color.RED);
	panel.add(label);
	panel.add(field);
	getContentPane().add( panel, BorderLayout.CENTER );
	field.addActionListener(new TextFieldListener());
    field.addMouseListener(new MouseAdapter(){  ////clears field text
        	@Override
        	public void mouseClicked(MouseEvent e){
        		field.setText("");
        	}
        });

	setDefaultCloseOperation( EXIT_ON_CLOSE );
	setSize(600, 300);
	setVisible(true);
    }
    
    private class TextFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
	    String name = field.getText();
	    if (player == 1)
		new FirstPlayer(name, opponent);
	    else
		new SecondPlayer(character, player1name, name);
	    dispose();
       }
    }

   


}
