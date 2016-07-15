package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.Color;


/**
*This class allows the player to choose their opponent (another player or the computer). It creates a window that gives the player the two options.

Authors: Laura Anthony and Nicole Moghaddas
*@version for CS56, W16
*/

public class ChooseOpponent extends JFrame {
    
    private ButtonGroup group;
    
    public ChooseOpponent() {

        super("Choose your Opponent!");
        JPanel radioPanel = new JPanel();
	getContentPane().setBackground(Color.WHITE);
        radioPanel.setLayout( new GridLayout(1, 2) );
	radioPanel.setOpaque(true);
	//radioPanel.setBackground(Color.BLACK);
        group = new ButtonGroup();
        JRadioButton computer = new JRadioButton("Computer", true );
        JRadioButton person = new JRadioButton("Person");
	computer.setFont(new Font("Courier", Font.BOLD,25));
	person.setFont(new Font("Courier", Font.BOLD,25));
	computer.setBackground(Color.BLACK);// RADIO BG CHANGE
	person.setBackground(Color.BLACK);//

        computer.setActionCommand("Computer");
	computer.setForeground(Color.BLUE);
        person.setActionCommand("Person");
	person.setForeground(Color.RED);
	
        group.add(computer);
        group.add(person);

        radioPanel.add(computer);
        radioPanel.add(person);

        getContentPane().add( radioPanel, BorderLayout.CENTER );
        JPanel buttonPanel = new JPanel();
	buttonPanel.setBackground(Color.BLACK);
        JButton pickFirst = new JButton("Challenge Accepted");
	Color customGreen = new Color(0,198,0);
	pickFirst.setForeground(customGreen);
        pickFirst.addActionListener(new PickGameListener());
        buttonPanel.add(pickFirst);
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize(600, 300);
        setVisible(true);
    }

    
    private class PickGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selected = group.getSelection().getActionCommand();
            
            if (selected == "Computer"){
                new PlayerName(1,'c');
		        dispose();
            }
            
            if (selected == "Person"){
                new PlayerName(1,'p');
                dispose();
            } 
	}
    }
}
