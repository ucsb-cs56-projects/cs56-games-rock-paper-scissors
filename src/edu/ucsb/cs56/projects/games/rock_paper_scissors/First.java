package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
 
public class First extends JFrame {
    
    private ButtonGroup group;
    
    //PlayerTTT first = new PlayerTTT();

    public First() {
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
        pickFirst.addActionListener(new pickGameListener());
        buttonPanel.add(pickFirst);
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize(600, 300);
        setVisible(true);
    }
    
    // public static void main( String[] arg ) {
    //     // int x = 1;
    //     // if ( x == 1 ){
    //     //     new TicTacToe();
    //     //    // b.TicTacToe();
    //     // }
    //     // if ( x == 2 ){
    //     //     GameGUI a = new GameGUI();
    //     //     a.setUpHomeScreen();
    //     // }
    //     new RunGame();
    // }
    
    private class pickGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selected = group.getSelection().getActionCommand();
            if (selected == "Squirtle"){
                //make squirtle image
                //ImageIcon image = new ImageIcon(path1);
                //button1 = new JButton(squirtle);
                //first.setImage(selected);
                new NoSquirtle();
		        dispose();
            }
            if (selected == "Bulbasaur"){
                //make bulbasaur image
                //ImageIcon image = new ImageIcon(path1);
                //button2 = new JButton(bulbasaur);
                //first.setImage(selected);
		        //new NoCharmander();
                dispose();
            }
            if (selected == "Charmander"){
                //make Charmander image
                //ImageIcon image = new ImageIcon(path1);
                //button3 = new JButton(charmander);
                //first.setImage(selected);
                //new NoBulbasaur();
                dispose();
            }

      
       }
    }

    public void getImage2(){}


}
