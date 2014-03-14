package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
 
/**
*This class allows the second player to choose their Pokemon if first player chooses Squirtle.
*@author Lesley Khuu
*@version for CS56, W14
*/

public class NoSquirtle extends JFrame {
    
    private ButtonGroup group;
    String first, second;
    
                
    public NoSquirtle() {
        super("Pick your Pokemon Gary!");
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout( new GridLayout(1, 4) );
        group = new ButtonGroup();
        JRadioButton charmander = new JRadioButton("Charmander", true );
        JRadioButton bulbasaur = new JRadioButton("Bulbasaur");
        charmander.setActionCommand("Charmander");
        bulbasaur.setActionCommand("Bulbasaur");
        group.add(charmander);
        group.add(bulbasaur);
        radioPanel.add(charmander);
        radioPanel.add(bulbasaur);
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
            
            //make bulbasaur image for second player
            if (selected == "Bulbasaur"){
                ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg");
                ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg");
                new TicTacToe(first, second, "Squirtle", "Bulbasaur");
                dispose();
            }
            
            //make charmander image for second player
            if (selected == "Charmander"){
                
                ImageIcon first = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg");
                ImageIcon second = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg");
                new TicTacToe(first, second, "Squirtle", "Charmander");
                dispose();
            }

      
       }
    }


}
