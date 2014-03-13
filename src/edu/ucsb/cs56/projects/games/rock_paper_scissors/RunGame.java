package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/**
    A rock paper scissor game that has a command line interface
    as well as a graphical user interface. Game is 1 player.
    Also a tic tac toe game with 2 players.


    @author Lesley Khuu   (previous authors Gerard Gonzalez and Connor Tinsely (Original:Dennis Huynh and Aki Stankoski) )
 
    @version for CS56, Winter 14, UCSB
*/ 

public class RunGame extends JFrame {
    
    private ButtonGroup group;
    
    public RunGame() {
        super( "RunGame" );
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout( new GridLayout( 1, 4 ) );
        group = new ButtonGroup();
        JRadioButton ttt = new JRadioButton( "Tic Tac Toe", true );
        JRadioButton rps = new JRadioButton( "Rock Paper Scissors" );
        ttt.setActionCommand( "Tic Tac Toe" );
        rps.setActionCommand( "Rock Paper Scissors" );
        group.add( ttt );
        group.add( rps );
        radioPanel.add( ttt );
        radioPanel.add( rps );
        getContentPane().add( radioPanel, BorderLayout.CENTER );
        JPanel buttonPanel = new JPanel();
        JButton pickGame = new JButton( "Let's Play!" );
        pickGame.addActionListener( new pickGameListener() );
        buttonPanel.add( pickGame );
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize( 600, 300 );
        setVisible( true );
    }
    
    public static void main( String[] arg ) {
        new RunGame();
    }
    
    private class pickGameListener implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            String selected = group.getSelection().getActionCommand();
            if ( selected == "Tic Tac Toe" ){
                  new FirstPlayer();
        dispose();
            }
            if ( selected == "Rock Paper Scissors" ){
                GameGUI a = new GameGUI();
                a.setUpHomeScreen();
		dispose();
            }


      
       }
    }
}
