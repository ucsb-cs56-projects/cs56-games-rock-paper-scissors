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

public class ChooseOpponent extends JFrame {
    
    private ButtonGroup group;
    
    public ChooseOpponent() {

        super("Choose your Opponent!");
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout( new GridLayout(1, 2) );
        group = new ButtonGroup();
        JRadioButton computer = new JRadioButton("Computer", true );
        JRadioButton person = new JRadioButton("Person");

        computer.setActionCommand("Computer");
        person.setActionCommand("Person");


        group.add(computer);
        group.add(person);

        radioPanel.add(computer);
        radioPanel.add(person);

        getContentPane().add( radioPanel, BorderLayout.CENTER );
        JPanel buttonPanel = new JPanel();
        JButton pickFirst = new JButton("Challenge Accepted");
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
            
            //make Squirtle image for first player
            if (selected == "Computer"){
                new PlayerName(1,'c');
		        dispose();
            }
            
            //make bulbasaur image for first player
            if (selected == "Person"){
                new PlayerName(1,'p');
                dispose();
            }

	    
       }
    }



}
