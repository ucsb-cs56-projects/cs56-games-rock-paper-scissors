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

public class FirstPlayer extends JFrame {
    
    private ButtonGroup group;
    private String name;
    char opponent;
    
    public FirstPlayer(String s, char c) {

        super("Pick your Pokemon " + s + "!");
	name = s;
	opponent=c;
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout( new GridLayout(2, 4) );
        group = new ButtonGroup();
        JRadioButton charmander = new JRadioButton("Charmander", true );
        JRadioButton bulbasaur = new JRadioButton("Bulbasaur");
        JRadioButton squirtle = new JRadioButton("Squirtle");
	//	JRadioButton eevee = new JRadioButton("Eevee");
	JRadioButton pik = new JRadioButton("Pikachu");
        charmander.setActionCommand("Charmander");
        bulbasaur.setActionCommand("Bulbasaur");
        squirtle.setActionCommand("Squirtle");
	//	eevee.setActionCommand("Eevee");
	pik.setActionCommand("Pikachu");
        group.add(charmander);
        group.add(bulbasaur);
        group.add(squirtle);
	//	group.add(eevee);
	group.add(pik);
        radioPanel.add(charmander);
        radioPanel.add(bulbasaur);
        radioPanel.add(squirtle);
	//	radioPanel.add(eevee);
	radioPanel.add(pik);

	JLabel charmanderp = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg"));
	radioPanel.add(charmanderp);

	JLabel bulbasaurp = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg"));
	radioPanel.add(bulbasaurp);

	JLabel squirtlep = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg"));
	radioPanel.add(squirtlep);

	JLabel pikachup = new JLabel(new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/pikachu.jpg"));
	radioPanel.add(pikachup);

	
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

	    if (opponent=='c') {
		ImageIcon first = null;
		ImageIcon second = null;
		if (selected == "Squirtle") {
		    first = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg");
		    second = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/pikachu.jpg");
		}
		if (selected == "Bulbasaur") {
		    first = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg");
		    second = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg");
		}
		if (selected == "Charmander") {
		    first = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg");
		   second = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg");
		}
		if (selected == "Pikachu") {
		    first = new ImageIcon ("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/pikachu.jpg");
		    second = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg");
		}
		
		new TicTacToe(first,second,name, "Computer");
		dispose();
		
	    }
	    else {
            //make Squirtle image for first player
            if (selected == "Squirtle"){
                new PlayerName(2, 1, name);
		        dispose();
            }
            
            //make bulbasaur image for first player
            if (selected == "Bulbasaur"){
                new PlayerName(2, 0, name);
                dispose();
            }
            
            //make Charmander image for first player
            if (selected == "Charmander"){
                new PlayerName(2, 2, name);
                dispose();
            }
            
            //make Pikachu image for first player
            if (selected == "Pikachu"){
                new PlayerName(2, 3, name);
                dispose();
            }

	    }
       }
    }



}
