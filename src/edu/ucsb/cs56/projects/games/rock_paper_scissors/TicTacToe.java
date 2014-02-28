package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//import java.awt.image.*;
//import javax.imageio.ImageIO;

//import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
//import javax.swing.*;
import java.awt.Dimension;
import java.applet.*;
import java.net.*;

//public class TicTacToe extends JFrame implements ActionListener{
public class TicTacToe extends JFrame{

	JPanel panel;
	JButton[] button;
	//JButton squirtle, bulbasaur
	JLabel[] label;
	int count = 0;
	int sign = 0;
	int [] isSet = new int[9];
    JButton gameChange = new JButton( "Go back to Game Selection" );
	// java.net.URL path1 = new URL("http://cs.ucsb.edu/~gegonzalez/cs56/S12/issues/0000513/browse/src/rps/images/charmander.jpg");
	// java.net.URL path2 = new URL("http://cs.ucsb.edu/~gegonzalez/cs56/S12/issues/0000513/browse/src/rps/images/squirtle.jpg");
	// java.net.URL path3 = new URL("http://cs.ucsb.edu/~gegonzalez/cs56/S12/issues/0000513/browse/src/rps/images/bulbasaur.jpg");
	//JLabel label1, label2, label3;
	ImageIcon image1 = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg");
	ImageIcon image2 = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg");
    PlayerTTT firstImage = new PlayerTTT();
    PlayerTTT secondImage = new PlayerTTT();
    ImageIcon first = new ImageIcon();
    ImageIcon second = new ImageIcon();

	public TicTacToe(){
	//public TicTacToe(String image1, String image2){
		panel = new JPanel ();
		panel.setLayout (new GridLayout(3,3));
		this.add(panel);
		
		button = new JButton[9];
		for (int i = 0; i <=8; i++){
			button [i] = new JButton();
			panel.add(button[i]);
			button[i].setEnabled(true);
			//button[i].addActionListener(this);
			button[i].addActionListener( new ticTacListener() );
		}

// //	
		//try{
		ImageIcon image1 = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg");
		ImageIcon image2 = new ImageIcon("src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg");
		//firstImage.setImage(image1);
		//secondImage.setImage(image2);
		// ImageIcon first = new ImageIcon(firstImage.getImage());
		// ImageIcon second = new ImageIcon(secondImage.getImage());

 		//label = new JLabel[9];
		/*
		for (int i = 0; i<=8; i++){
			label[i] = new JLabel();
			label[i].setText(i + "");
			panel.add(label[i]);
			label[i].setEnabled(false);

		}
		*/
	//}
	// catch (IOException ioe) {
	// 		//log the error
	// 	}
// //
 		gameChange.setPreferredSize( new Dimension(50,100));
 		gameChange.addActionListener ( new changeGameListener() );	
		



		//
		
		
		// squirtle = new JButton(image1);
		// bulbasaur = new JButton(image2);
		// add(squirtle);
		// add(bulbasaur);
			// Image image = ImageIO.read(path1);
			// //ImageIcon image = new ImageIcon(path1);
			// label1 = new JLabel(image);
			// this.add(label1);
			// label1.setVisible(true);		
			

			// Image image2 = ImageIO.read(path2);
			// //ImageIcon image2 = new ImageIcon(path2);
			// label2 = new JLabel(image2);
			// this.add(label2);
			// label2.setVisible(true);
///////



	this.add( gameChange, BorderLayout.SOUTH);
		this.setSize(600,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

      class changeGameListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    dispose();
	    new RunGame();
	}
    }

    class ticTacListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    /// PROBLEM: ENDS EARLY FIRST GAME.

	    count ++;
		for (int i = 0; i <= 8; i++){
			if (button[i] == e.getSource()){
				if (sign%2 == 0){
					//button[i].setText("X");
					button[i].setIcon(image1);
					//button[i].setIcon(first);
					

					button[i].setEnabled(false);
					//label[i].setEnabled(true);
					isSet[i] = 1;

				}
				else{
					//button[i].setText("O");
					button[i].setIcon(image2);
					//button[i].setIcon(second);

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
	public void checkWinner(){
		//X wins case
		if (isSet [0] == 1 && isSet[1] == 1 && isSet[2] == 1){
			JOptionPane.showMessageDialog(null, "Squirtle Wins!");
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
		if (isSet [3] == 1 && isSet[4] == 1 && isSet[5] == 1){
			JOptionPane.showMessageDialog(null, "Squirtle Wins!");
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
		if (isSet [6] == 1 && isSet[7] == 1 && isSet[8] == 1){
			JOptionPane.showMessageDialog(null, "Squirtle Wins!");
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
		if (isSet [0] == 1 && isSet[3] == 1 && isSet[6] == 1){
			JOptionPane.showMessageDialog(null, "Squirtle Wins!");
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
		if (isSet [1] == 1 && isSet[4] == 1 && isSet[7] == 1){
			JOptionPane.showMessageDialog(null, "Squirtle Wins!");
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
		if (isSet [2] == 1 && isSet[5] == 1 && isSet[8] == 1){
			JOptionPane.showMessageDialog(null, "Squirtle Wins!");
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
		if (isSet [0] == 1 && isSet[4] == 1 && isSet[8] == 1){
			JOptionPane.showMessageDialog(null, "Squirtle Wins!");
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
		if (isSet [2] == 1 && isSet[4] == 1 && isSet[6] == 1){
			JOptionPane.showMessageDialog(null, "Squirtle Wins!");
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

		//O wins case
		if (isSet [0] == 2 && isSet[1] == 2 && isSet[2] == 2){
			JOptionPane.showMessageDialog(null, "Bulbasaur Wins!");
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
		if (isSet [3] == 2 && isSet[4] == 2 && isSet[5] == 2){
			JOptionPane.showMessageDialog(null, "Bulbasaur Wins!");
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
		if (isSet [6] == 2 && isSet[7] == 2 && isSet[8] == 2){
			JOptionPane.showMessageDialog(null, "Bulbasaur Wins!");
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
		if (isSet [0] == 2 && isSet[3] == 2 && isSet[6] == 2){
			JOptionPane.showMessageDialog(null, "Bulbasaur Wins!");
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
		if (isSet [1] == 2 && isSet[4] == 2 && isSet[7] == 2){
			JOptionPane.showMessageDialog(null, "Bulbasaur Wins!");
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
		if (isSet [2] == 2 && isSet[5] == 2 && isSet[8] == 2){
			JOptionPane.showMessageDialog(null, "Bulbasaur Wins!");
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
		if (isSet [0] == 2 && isSet[4] == 2 && isSet[8] == 2){
			JOptionPane.showMessageDialog(null, "Bulbasaur Wins!");
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
		if (isSet [2] == 2 && isSet[4] == 2 && isSet[6] == 2){
			JOptionPane.showMessageDialog(null, "Bulbasaur Wins!");
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

	// public static void main (String[] args) {
	// 	new TicTacToe();

	// }

}
