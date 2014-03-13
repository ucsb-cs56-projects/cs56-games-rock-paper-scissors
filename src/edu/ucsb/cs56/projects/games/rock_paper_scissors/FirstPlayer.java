package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


/**
*This class allows the first player to choose their Pokemon.
*@author Lesley Khuu
*@version for cs56, W14
*/

public class FirstPlayer extends JFrame {
    
    private ButtonGroup group;
    
    public FirstPlayer() {
        super("Pick your Pokemon Ashe!");
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout( new GridLayout(1, 4) );
        group = new ButtonGroup();
        JRadioButton charmander = new JRadioButton("Charmander", true );
        JRadioButton bulbasaur = new JRadioButton("Bulbasaur");
        JRadioButton squirtle = new JRadioButton("Squirtle");
        charmander.setActionCommand("Charmander");
        bulbasaur.setActionCommand("Bulbasaur");
        squirtle.setActionCommand("Squirtle");
        group.add(charmander);
        group.add(bulbasaur);
        group.add(squirtle);
        radioPanel.add(charmander);
        radioPanel.add(bulbasaur);
        radioPanel.add(squirtle);
        getContentPane().add( radioPanel, BorderLayout.CENTER );
        JPanel buttonPanel = new JPanel();
        JButton pickFirst = new JButton("I choose you!");
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
            if (selected == "Squirtle"){
                new NoSquirtle();
		dispose();
            }
            
            //make bulbasaur image for first player
            if (selected == "Bulbasaur"){
                new NoBulbasaur();
                dispose();
            }
            
            //make Charmander image for first player
            if (selected == "Charmander"){
                new NoCharmander();
                dispose();
            }

      
       }
    }



}
