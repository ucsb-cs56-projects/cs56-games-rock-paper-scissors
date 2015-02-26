/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;

/**
*This class allows the second player to choose their Pokemon if first player chooses Charmander.
*@author Lesley Khuu
*@version for CS56, W14
*/
public class NoCharmander extends JFrame{
     private ButtonGroup group;
    String first, second;
    
                
    public NoCharmander() {
        super("Pick your Pokemon Gary!");
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout( new GridLayout(1, 4) );
        group = new ButtonGroup();
        JRadioButton bulbasaur = new JRadioButton("Bulbasaur", true );
        JRadioButton squirtle = new JRadioButton("Squirtle");
        bulbasaur.setActionCommand("Bulbasaur");
        squirtle.setActionCommand("Squirtle");
        group.add(bulbasaur);
        group.add(squirtle);
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
	setLocationRelativeTo(null); //Center frame
        setVisible(true);
        
        
    }
    private class PickGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selected = group.getSelection().getActionCommand();
            
            //make squirtle image for second player
            if (selected == "Squirtle"){
                ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg");
                ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg");
                new TicTacToe(first, second, "Charmander", "Squirtle");
                dispose();
            }
            
            //make bulbasaur image for second player
            if (selected == "Bulbasaur"){
                ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg");
                ImageIcon second = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg");
                new TicTacToe(first, second, "Charmander", "Bulbasaur");
                dispose();
            }

      
       }
    }
    
}
