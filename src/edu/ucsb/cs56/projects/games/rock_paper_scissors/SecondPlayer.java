package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
 
/**
*This class allows the second player to choose their Pokemon depending on what first player chose.
*@author Andrew Ferguson
*@version for CS56, W15
*/

public class SecondPlayer extends JFrame {
    
    private ButtonGroup group;
    String first, second, player1Selection;
    
                
    public SecondPlayer(String firstSelected) {
        super("Pick your Pokemon Gary!");
	player1Selection = firstSelected;
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout( new GridLayout(1, 4) );
        group = new ButtonGroup();
	
        JRadioButton charmander = new JRadioButton("Charmander");
	JRadioButton squirtle  = new JRadioButton("Squirtle");
        JRadioButton bulbasaur = new JRadioButton("Bulbasaur");
        charmander.setActionCommand("Charmander");
        bulbasaur.setActionCommand("Bulbasaur");
	squirtle.setActionCommand("Squirtle");

	if(firstSelected == "Squirtle"){
	    group.add(charmander);
	    group.add(bulbasaur);
	    radioPanel.add(charmander);
	    radioPanel.add(bulbasaur);
	}
	else if(firstSelected == "Charmander"){
	    group.add(squirtle);
	    group.add(bulbasaur);
	    radioPanel.add(squirtle);
	    radioPanel.add(bulbasaur);
	}
	else if(firstSelected == "Bulbasaur"){
	    group.add(charmander);
	    group.add(squirtle);
	    radioPanel.add(charmander);
	    radioPanel.add(squirtle);
	}

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
	    ImageIcon first = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/"+player1Selection+".jpg");
	    ImageIcon second = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/"+selected+".jpg");
	    new TicTacToe(first, second, player1Selection, selected);
	    dispose();
      
       }
    }


}
