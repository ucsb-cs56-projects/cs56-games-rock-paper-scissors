package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Color;


/**
 * Class that creates the Tic Tac Toe game.
 *
 * @author Laura Anthony and Nicole Moghaddas (previous author: Lesley Khuu)
 * @version for CS56, W16
 */


public class TicTacToe extends JFrame{

    JPanel panel;
    JButton[] button;
    JLabel label;
    int count = 0;
    int sign = 0;
    int [] isSet = new int[9];
    JButton gameChange = new JButton( "Go back to Game Selection" );
    ImageIcon image1;
    ImageIcon image2;
    String name1;
    String name2;
    AudioClip pok1, pok2;
    URL bulba, charm, squirt;


	public TicTacToe(ImageIcon first, ImageIcon second, String firstName, String secondName){
	    
	    label = new JLabel("It's " + firstName + "'s turn!");
	    label.setHorizontalAlignment(SwingConstants.CENTER);
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
	    this.add( label, BorderLayout.NORTH);
            this.setSize(600,600);
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

        //load pokemon sound files
        try {
            bulba = new URL("file:src/edu/ucsb/cs56/projects/games/rock_paper_scissors/sounds/bulbasaur.wav");
        }
        catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        try {
            squirt = new URL("file:src/edu/ucsb/cs56/projects/games/rock_paper_scissors/sounds/squirtle.wav");
        }
        catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        try {
            charm = new URL("file:src/edu/ucsb/cs56/projects/games/rock_paper_scissors/sounds/charmander.wav");
        }
        catch (MalformedURLException ex) {
            ex.printStackTrace();
        }

        //check which pokemon are in use and import their correct sounds
        if (name1 == "Bulbasaur") {
            pok1 = java.applet.Applet.newAudioClip(bulba);
        }
        else
            if(name1 == "Squirtle") {

                pok1 = java.applet.Applet.newAudioClip(squirt);
            }
        else {
                pok1 = java.applet.Applet.newAudioClip(charm);
        }

        //load sounds for player 2
        if (name2 == "Bulbasaur") {

            pok2 = java.applet.Applet.newAudioClip(bulba);
        }
        else
        if(name2 == "Squirtle") {

            pok2 = java.applet.Applet.newAudioClip(squirt);
        }
        else
            pok2 = java.applet.Applet.newAudioClip(charm);

	if (name2=="Computer") {
	    for (int i = 0; i <= 8; i++){
		if (button[i].equals(e.getSource())){
			button[i].setIcon(image1);
			button[i].setDisabledIcon(image1);
			pok1.play();
			button[i].setEnabled(false);
			isSet[i] = 1;
	      
	        
			if (count <5) {
			int randomSpot = (int) (Math.random()*9);
			while (isSet[randomSpot]!=0) {
			    randomSpot = (int) (Math.random()*9);
			}
			button[randomSpot].setIcon(image2);
			button[randomSpot].setDisabledIcon(image2);
			pok2.play();
			button[randomSpot].setEnabled(false);
			isSet[randomSpot]=2;
			label.setText("It's " + name1 + "'s turn!");
			}
		}
	    }
	    checkWinner();
	}
	else {

	    for (int i = 0; i <= 8; i++){
		if (button[i].equals(e.getSource())){
		    if (sign%2 == 0){
			button[i].setIcon(image1);
			button[i].setDisabledIcon(image1);
			pok1.play();
			button[i].setEnabled(false);
			isSet[i] = 1;
			label.setText("It's " + name2 + "'s turn!");
		    }
		    else{
			button[i].setIcon(image2);
			button[i].setDisabledIcon(image2);
			pok2.play();
			button[i].setEnabled(false);
			isSet[i] = 2;
			label.setText("It's " + name1 + "'s turn!");  
		    }
		}
	    }
	    sign++;
	    checkWinner();
	}
	
        if ( (count >= 9 && name2!="Computer") || (name2=="Computer"&&count>=5)) {
	    JOptionPane.showMessageDialog(null, "Tie!");
	    for (int j = 0; j <= 8; j++){
                    button[j].setText("");
                    button[j].setEnabled(true);
                    isSet[j] = 0;
                    button[j].setIcon(null);
                }
		count = 0;
		sign = 0;
		label.setText("It's " + name1 + "'s turn!"); 
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
		label.setText("It's " + name1 + "'s turn!"); 
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
