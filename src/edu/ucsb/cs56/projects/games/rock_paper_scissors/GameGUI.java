package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Transparency;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Dimension;
import java.applet.*;
import java.net.*;


/**
 * This class creates the GUI for the game.  It allows you to select your options for moves, as well as tell you how many games you've played, wont, lost, and tied.  There are also animations that appears on the screen when the player and the computer have chosen their moves.
 *
 *
 *Authors:Giovanni Dominguez and Issac Holguin Previous authors:  Nicole Moghaddas and Laura Anthony previous authors: (Lesley Khuu (previous authors: Gerard Gonzalez and Connor Tinsely (Original:Dennis Huynh and Aki Stankoski)))
 Version for CS56 for Summer 16
 */

public class GameGUI extends JPanel {
    JFrame frame = new JFrame();
    JPanel thePanel = new JPanel(new GridBagLayout());
    JLabel title = new JLabel("Rock Paper Scissors Game");
    JLabel wins = new JLabel("Wins");
    JLabel losses = new JLabel("Losses");
    JLabel ties = new JLabel("Ties");
    JLabel gamesPlayed = new JLabel("Games Played");
    JButton rock = new JButton("Charmander");
    JButton scissors = new JButton("Squirtle");
    JButton paper = new JButton("Bulbasaur");
    JButton changeGame = new JButton ("Go back to Game Selection");

    JTextField played = new JTextField(10);
    JTextField win = new JTextField(10);
    JTextField lose = new JTextField(10);
    JTextField tie = new JTextField(10);
    JTextArea text = new JTextArea(20, 30);
    JTextArea key = new JTextArea(10, 10);
    JScrollPane scroll = new JScrollPane(text);
    JScrollPane kscroll = new JScrollPane(key);
    Player player = new Player();
    Computer computer = new Computer();
    Game game = new Game();
    String move;
    int winner;
    int games=0;
    JLabel picLabel;
    JLabel label0, label1, label2, label3, label4, label5, label6;



    public void setUpHomeScreen(){
	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();  

	gc.gridx = 0;
	gc.gridy = 0;
	gc.insets = new Insets(20,20,0,0);
        key.setEditable(false);
        //kscroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //kscroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        kscroll.setPreferredSize(new Dimension(270,250));
        kscroll.setBackground(Color.GRAY);
	key.setLineWrap(true);
	key.append("This is your average rock- \npaper-scissors game, BUT \nplayed with your favorite \nPokemon characters! \n");
	key.append("KEY: \n");
	key.append("     Charmander = Rock \n");
	key.append("     Bulbasaur = Paper \n");
	key.append("     Squirtle = Scissors \n");
	key.append("\n");
	key.append("This game is played \nagainst the computer.\nClick on your \nfavorite Pokemon to see if \nhe can defeat the opponent.");
	key.setFont(new Font("Courier", Font.ITALIC,13));
	key.setForeground(Color.WHITE);
	key.setBackground(Color.BLACK); //CHANGED TEXT IN BOX
	frame.add(kscroll, gc);
	
		gc.gridx = 0;
		gc.gridy = 1;
		//String path1 = "/Users/edwardgonzalez/Desktop/CHOICE/src/rps/images/charmander.jpg";
		//String path2 = "/Users/edwardgonzalez/Desktop/CHOICE/src/rps/images/squirtle.jpg";
		//String path3 = "/Users/edwardgonzalez/Desktop/CHOICE/src/rps/images/bulbasaur.jpg";

		try {
			java.net.URL path1 = new URL("http://cs.ucsb.edu/~gegonzalez/cs56/S12/issues/0000513/browse/src/rps/images/charmander.jpg");
			java.net.URL path2 = new URL("http://cs.ucsb.edu/~gegonzalez/cs56/S12/issues/0000513/browse/src/rps/images/squirtle.jpg");
			java.net.URL path3 = new URL("http://cs.ucsb.edu/~gegonzalez/cs56/S12/issues/0000513/browse/src/rps/images/bulbasaur.jpg");

			
			ImageIcon image = new ImageIcon(path1); //charmander
			label1 = new JLabel(" ", image, JLabel.LEFT);
			frame.add(label1,gc);
			label1.setVisible(false);		
			
			ImageIcon image2 = new ImageIcon(path2); // squirtle
			label2 = new JLabel(" ", image2, JLabel.LEFT);
			frame.add(label2,gc);
			label2.setVisible(false);
			
			ImageIcon image3 = new ImageIcon(path3); //bulb
			label3 = new JLabel(" ", image3, JLabel.LEFT);
			frame.add(label3,gc);
			label3.setVisible(false);
			
			gc.gridx = 3;
			gc.gridy = 1;
			
			label4 = new JLabel(" ", image, JLabel.LEFT);
			frame.add(label4,gc);
			label4.setVisible(false);		
			
			label5 = new JLabel(" ", image2, JLabel.LEFT);
			frame.add(label5,gc);
			label5.setVisible(false);
			
			label6 = new JLabel(" ", image3, JLabel.LEFT);
			frame.add(label6,gc);
			label6.setVisible(false);
		}
		catch (IOException ioe) {
			//log the error
		}
		
		
		
		
        gc.insets = new Insets(5,75,5,5);
        gc.gridx=1;
        gc.gridy=0;
        frame.add(title, gc);
	title.setFont(new Font("Courier", Font.BOLD,36));// change size
	title.setForeground(Color.CYAN);
        gc.gridx=1;
        gc.gridy=1;
        text.setEditable(false);
        text.setFont(new Font("Courier", Font.ITALIC,17));
        text.append("Choose a Pokemon to start!\n");
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(400,300));
        frame.add(scroll, gc);
        scroll.setBackground(Color.BLACK);
            gc.gridx=1;
        gc.gridy=2;
        frame.add(gamesPlayed, gc);
        gamesPlayed.setForeground(Color.RED);
	gamesPlayed.setFont(new Font("Courier", Font.BOLD,22));
        gc.gridx=1;
        gc.gridy=3;
        played.setEditable(false);
        frame.add(played, gc);
        gc.gridx=0;
        gc.gridy=4;
        rock.addActionListener(new RockListener());
	rock.setFont(new Font("Courier", Font.BOLD, 22));
        rock.setForeground(Color.RED);// BUTTON RED CHARMANDER
        frame.add(rock, gc);
        gc.gridy=5;
        paper.addActionListener(new PaperListener());
	Color customColorGreen = new Color(0,198, 0);
	paper.setForeground(customColorGreen); //BUTTON GREEN BULBASAUR
	paper.setFont(new Font("Courier", Font.BOLD,22));
	frame.add(paper, gc);
        gc.gridy=6;
        scissors.addActionListener(new ScissorsListener());
	scissors.setForeground(Color.BLUE); //BUTTON BLUE SQUIRTLE
	scissors.setFont(new Font("Courier", Font.BOLD,22));
	frame.add(scissors, gc);
        gc.gridx=2;
        gc.gridy=4;
        gc.gridx=1;
        changeGame.addActionListener( new ChangeGameListener());
        frame.add(changeGame, gc);
        Color newOrange = new Color(255, 140, 0);
        changeGame.setForeground(newOrange);
	changeGame.setFont(new Font("Courier", Font.BOLD,22));
        gc.gridx=2;
        gc.insets = new Insets(5,5,5,5);
        frame.add(wins, gc);
        wins.setForeground(Color.RED);
	wins.setFont(new Font("Courier", Font.BOLD,22));
        gc.gridy=5;
        frame.add(losses, gc);
        gc.gridy=6;
        frame.add(ties, gc);
        losses.setForeground(customColorGreen);
	losses.setFont(new Font("Courier", Font.BOLD,22));
        ties.setForeground(Color.BLUE);
	ties.setFont(new Font("Courier", Font.BOLD,22));
        gc.insets = new Insets(5,5,5,75);
        gc.gridx=3;
        gc.gridy=4;
        win.setEditable(false);
        frame.add(win, gc);
        gc.gridy=5;
        lose.setEditable(false);
        frame.add(lose, gc);
        gc.gridy=6;
        tie.setEditable(false);
        frame.add(tie, gc);
        frame.setSize(500,800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.pack();
       frame.setVisible(true);    
        
		
    }//end setUpHomeScreen
    
	
    
    class RockListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
			label3.setVisible(false);
			label2.setVisible(false);
			label1.setVisible(true);

            player.setMove("Charmander");
            computer.setMove();
            winner = game.getWinner(player.getMove(), computer.getMove());
	    
            text.append("------------------\n");
            text.append("   Game: " + (games+1) + "\n");
            text.append("------------------\n");
            text.append("You played: Charmander \n");
        	if(computer.getMove()==0){
            		 move = "Bulbasaur";
				label4.setVisible(false);
				label5.setVisible(false);
				label6.setVisible(true);
				
		}
                if(computer.getMove()==1){
            		 move = "Squirtle";
					label4.setVisible(false);
					label6.setVisible(false);
					label5.setVisible(true);
					
                }
                if(computer.getMove()==2){
            		 move = "Charmander";
					label6.setVisible(false);
					label5.setVisible(false);
					label4.setVisible(true);
                }
            text.append("Computer played: " + move + "\n");
                if(winner==1){
            		 text.append("You WIN!\n\n");
		}
                if(winner==2){
		    text.append("You LOSE!\n\n");
                }
                if(winner==3){
            		 text.append("You TIE!\n\n");
                }
            win.setText(""+game.getScore(0));
            lose.setText(""+game.getScore(1));
            tie.setText(""+game.getScore(2));
            games++;
            played.setText(""+games);
        }
    }//end RockListener
        
    class PaperListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
			label1.setVisible(false);
			label2.setVisible(false);
			label3.setVisible(true);
            player.setMove("Bulbasaur");
            computer.setMove();
            winner = game.getWinner(player.getMove(), computer.getMove());
            text.append("------------------\n");
            text.append("   Game: " + (games+1) + "\n");
            text.append("------------------\n");
            text.append("You played: Bulbasaur \n");
        	if(computer.getMove()==0){
				move = "Charmander";
				label6.setVisible(false);
				label5.setVisible(false);
				label4.setVisible(true);
				
			}
			if(computer.getMove()==1){
				move = "Bulbasaur";
				label5.setVisible(false);
				label4.setVisible(false);
				label6.setVisible(true);
				
			}
			if(computer.getMove()==2){
				move = "Squirtle";
				label6.setVisible(false);
				label4.setVisible(false);
				label5.setVisible(true);
			}
            text.append("Computer played: " + move + "\n");
                if(winner==1){
            		 text.append("You WIN!\n\n");
		}
                if(winner==2){
            		 text.append("You LOSE!\n\n");
                }
                if(winner==3){
            		 text.append("You TIE!\n\n");
                }
            win.setText(""+game.getScore(0));
            lose.setText(""+game.getScore(1));
            tie.setText(""+game.getScore(2));
            games++;
            played.setText(""+games);
        }
    }//end PaperListener
        
    class ScissorsListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
			label1.setVisible(false);
			label3.setVisible(false);
			label2.setVisible(true);

            player.setMove("Squirtle");
            computer.setMove();
            winner = game.getWinner(player.getMove(), computer.getMove());
            text.append("------------------\n");
            text.append("   Game: " + (games+1) + "\n");
            text.append("------------------\n");
            text.append("You played: Squirtle \n");
	    if(computer.getMove()==0){
		move = "Squirtle";
		label6.setVisible(false);
		label4.setVisible(false);
		label5.setVisible(true);
		
	    }
	    if(computer.getMove()==1){
		move = "Charmander";
		label5.setVisible(false);
		label6.setVisible(false);
		label4.setVisible(true);
		
	    }
	    if(computer.getMove()==2){
		move = "Bulbasaur";
		label5.setVisible(false);
		label4.setVisible(false);
		label6.setVisible(true);
	    }
            text.append("Computer played: " + move + "\n");
	        if(winner==1){
		    text.append("You WIN!\n\n");
		}
                if(winner==2){
            		 text.append("You LOSE!\n\n");
                }
                if(winner==3){
            		 text.append("You TIE!\n\n");
                }
            win.setText(""+game.getScore(0));
            lose.setText(""+game.getScore(1));
            tie.setText(""+game.getScore(2));
            games++;
            played.setText(""+games);
        }
    }//end ScissorsListener
  
          
    class ChangeGameListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    frame.dispose();
	    new RunGame();
	    }
    }

}//end GameGUI



