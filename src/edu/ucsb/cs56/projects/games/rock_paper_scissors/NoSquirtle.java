package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
 
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
            
            if (selected == "Bulbasaur"){
                //make bulbasaur image
                //ImageIcon image = new ImageIcon(path1);
                //button2 = new JButton(bulbasaur);
                //first = "src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg";
                //second = "src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg";
                first = "Squirtle";
                second = "Bulbasaur";
                new TicTacToe(first, second);
                dispose();
            }
            if (selected == "Charmander"){
                //make Charmander image
                //ImageIcon image = new ImageIcon(path1);
                //button3 = new JButton(charmander);
                // first = "src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg";
                // second = "src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg";
                first = "Squirtle";
                second = "Charmander";
                new TicTacToe(first, second);
                dispose();
            }

      
       }
    }

    public void getImage2(){}


}
