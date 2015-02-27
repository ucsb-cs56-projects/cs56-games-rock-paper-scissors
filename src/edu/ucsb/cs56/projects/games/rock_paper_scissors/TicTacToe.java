package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.applet.*;
import java.net.*;


//BUGS: WHEN BUTTON IS CLICKED, POKEMON IS BLACK AND WHITE, NO COLOR.

/**
 * Class that creates the Tic Tac Toe game.
 *
 * @author Lesley Khuu
 * @version for CS56, W14
 */


public class TicTacToe extends JFrame{

    JPanel panel;
    JButton[] button;
    JLabel[] label;
    int count = 0;
    int sign = 0;
    int [] isSet = new int[9];
    JButton gameChange = new JButton( "Go back to Game Selection" );
    ImageIcon image1;
    ImageIcon image2;
    String name1;
    String name2;


	public TicTacToe(ImageIcon first, ImageIcon second, String firstName, String secondName){
            this.image1 = first;
            this.image2 = second;
            this.name1 = firstName;
            this.name2 = secondName;
            panel = new JPanel ();
            panel.setLayout (new GridLayout(3,3));
            this.add(panel);
            button = new JButton[9];
            for (int i = 0; i <=8; i++){
				button [i] = new JButton();
				panel.add(button[i]);
				button[i].setEnabled(true);
				button[i].addActionListener( new TicTacListener() );
			}

            gameChange.setPreferredSize( new Dimension(50,100));
            gameChange.addActionListener ( new ChangeGameListener() );	
            this.add( gameChange, BorderLayout.SOUTH);
            this.setSize(600,600);
  	    this.setLocationRelativeTo(null); //Center frame
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setVisible(true);
	}

      class ChangeGameListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    dispose();
	    new RunGame();
	}
    }

    class TicTacListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    count ++;
		for (int i = 0; i <= 8; i++){
                    if (button[i].equals(e.getSource())){
                        if (sign%2 == 0){
                            button[i].setIcon(image1);
                            button[i].setEnabled(false);
                            isSet[i] = 1;
			}
                    else{
			button[i].setIcon(image2);
                        button[i].setEnabled(false);
			isSet[i] = 2;
			}
                    }
                }
	    sign++;
            checkWinner();
            if (count >= 9) {
		JOptionPane.showMessageDialog(null, "Tie!");
		for (int j = 0; j <= 8; j++){
                    button[j].setText("");
                    button[j].setEnabled(true);
                    isSet[j] = 0;
                    button[j].setIcon(null);
                }
		count = 0;
		sign = 0;
		return;
            }	
	}
    }
        public void firstPlayerWins(){
            JOptionPane.showMessageDialog(null, name1 + " Wins!");
			for (int j = 0; j <= 8; j++){
				button[j].setText("");
				button[j].setEnabled(true);
				isSet[j] = 0;
				button[j].setIcon(null);

			}
			count = 0;
			sign = 0;
			return;
        }
        
        public void secondPlayerWins(){
            JOptionPane.showMessageDialog(null, name2 + " Wins!");
			for (int j = 0; j <= 8; j++){
				button[j].setText("");
				button[j].setEnabled(true);
				isSet[j] = 0;
				button[j].setIcon(null);

			}
			count = 0;
			sign = 0;
			return;
        }
        
	public void checkWinner(){
		//First Player wins case
		if (isSet [0] == 1 && isSet[1] == 1 && isSet[2] == 1){
                    firstPlayerWins();
		}
		if (isSet [3] == 1 && isSet[4] == 1 && isSet[5] == 1){
                    firstPlayerWins();
		}
		if (isSet [6] == 1 && isSet[7] == 1 && isSet[8] == 1){
                    firstPlayerWins();
		}
		if (isSet [0] == 1 && isSet[3] == 1 && isSet[6] == 1){
                    firstPlayerWins();
		}
		if (isSet [1] == 1 && isSet[4] == 1 && isSet[7] == 1){
                    firstPlayerWins();
		}
		if (isSet [2] == 1 && isSet[5] == 1 && isSet[8] == 1){
                    firstPlayerWins();
		}
		if (isSet [0] == 1 && isSet[4] == 1 && isSet[8] == 1){
                    firstPlayerWins();
		}
		if (isSet [2] == 1 && isSet[4] == 1 && isSet[6] == 1){
                    firstPlayerWins();
		}

                
                
		//Second Player wins case
		if (isSet [0] == 2 && isSet[1] == 2 && isSet[2] == 2){
			secondPlayerWins();
		}
		if (isSet [3] == 2 && isSet[4] == 2 && isSet[5] == 2){
			secondPlayerWins();
		}
		if (isSet [6] == 2 && isSet[7] == 2 && isSet[8] == 2){
			secondPlayerWins();
		}
		if (isSet [0] == 2 && isSet[3] == 2 && isSet[6] == 2){
			secondPlayerWins();
		}
		if (isSet [1] == 2 && isSet[4] == 2 && isSet[7] == 2){
			secondPlayerWins();
		}
		if (isSet [2] == 2 && isSet[5] == 2 && isSet[8] == 2){
			secondPlayerWins();
		}
		if (isSet [0] == 2 && isSet[4] == 2 && isSet[8] == 2){
			secondPlayerWins();
		}
		if (isSet [2] == 2 && isSet[4] == 2 && isSet[6] == 2){
			secondPlayerWins();
		}

	}

}
