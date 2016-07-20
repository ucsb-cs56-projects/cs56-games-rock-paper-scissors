package edu.ucsb.cs56.projects.games.rock_paper_scissors;
import java.awt.*;

public class PlayerTTT{
	private String image;
//need to add javadoc comment for constructor
	public PlayerTTT(){}//end constructor

	//getters and setters for image

	public String getImage(){
		return this.image;
	}
	public void setImage(String imageName){
		if (imageName == "Squirtle")
			this.image = "src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/squirtle.jpg";
		if (imageName == "Bulbasaur")
			this.image = "src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/bulbasaur.jpg";
		if (imageName == "Charmander")
			this.image = "src/edu/ucsb/cs56/projects/games/rock_paper_scissors/images/charmander.jpg";
	}
}//end Player