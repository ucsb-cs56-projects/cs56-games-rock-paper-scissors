package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JDialog;
import java.io.*;
import java.awt.Color;
import java.awt.Window;
import javax.swing.JOptionPane;
/**
    A rock paper scissor game that has a command line interface
    as well as a graphical user interface. Game is 1 player.
    Also a tic tac toe game with 2 players or one player 
    against the computer.


    @authors Giovanni Dominguez and Issac Holguin
    Previous Authors: Nicole Moghaddas and Laura Anthony (previous authors: Lesley Khuu   (previous authors Gerard Gonzalez and Connor Tinsely (Original:Dennis Huynh and Aki Stankoski) ) )
 
    @version for CS56, Summer 16, UCSB
*/ 

public class RunGame extends JFrame {
    
    private ButtonGroup group;
    
    public RunGame() {
        super( "RunGame" );
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout( new GridLayout( 1, 4 ) );
	
	radioPanel.setOpaque(true);
        
        group = new ButtonGroup();
        JRadioButton ttt = new JRadioButton( "Tic Tac Toe", true );
	ttt.setBackground(Color.BLACK);
	ttt.setFont(new Font("Courier", Font.BOLD,22));
        JRadioButton rps = new JRadioButton( "Rock Paper Scissors" );
	rps.setBackground(Color.BLACK);
	rps.setFont(new Font("Courier", Font.BOLD,22));
        ttt.setActionCommand( "Tic Tac Toe" );
        rps.setActionCommand( "Rock Paper Scissors" );
        ttt.setForeground(Color.RED);
        rps.setForeground(Color.BLUE);//   HGHFHFH
        group.add( ttt );
        group.add( rps );
        radioPanel.add( ttt );
        radioPanel.add( rps );
        getContentPane().add( radioPanel, BorderLayout.CENTER );
	radioPanel.setBackground(Color.BLACK);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        JButton pickGame = new JButton( "Let's Play!" );
        /*



        */
        GridBagConstraints gc = new GridBagConstraints(); 
        gc.gridx = 2;
        gc.gridy = 4;
        gc.gridx = 1;
        JButton help = new JButton();

        help.setText("HELP");
        
        //buttonPanel.pack();

        help.addActionListener(new HelpListener());
         buttonPanel.add(help, gc);
        
        pickGame.addActionListener( new PickGameListener() );
        Color customColorGreen = new Color(0,198, 0);
        pickGame.setForeground(customColorGreen);
        buttonPanel.add( pickGame );
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize( 600, 300 );
        setVisible( true );
    }
    
    public static void main( String[] arg ) {
        new RunGame();
    }
    
    private class PickGameListener implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            String selected = group.getSelection().getActionCommand();
            if ( selected == "Tic Tac Toe" ){
		new ChooseOpponent();
		dispose();
            }
            if ( selected == "Rock Paper Scissors" ){
                GameGUI a = new GameGUI();
                a.setUpHomeScreen();
		dispose();
            }


      
       }
    }

  /*  private class HelpListener implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            String path = JOptionPane.showInputDialog("Enter a path");
        }
    }
*/
    private class HelpListener implements ActionListener{ //used for help button
        @Override
        public void actionPerformed(ActionEvent evt){
            
            JOptionPane.showMessageDialog(null, "HOW TO PLAY: \n \n Select a game to play and hit 'Lets Play!' to start the game of your choice.\n\n Tic Tac Toe: You have the choice to choose if you want to play the computer or a person next to you. Enter your name(s) and select a pokemon to represent your O or X. \n Then face your opponent! \n \n Rock Paper Scissors: You will play the computer. There is a key on the top left corner that describes what represents rock, paper, or scissors as pokemon.\n (this makes RPS more fun).On the bottom left corner are the buttons you can select to represent the move you make.\n The bottom corner keeps track of how many times you've won, lost, or tied with the computer. You can select 'return to game selection' to come back to original menu.");

        }
    }


}
