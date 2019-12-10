package unisadventures.se_project.presenter.launcher;

import java.io.IOException;



/**
 * This is the main class whitch launches the game
 * @author Emilio
 */
public class Launcher {

	public static void main(String[] args) throws IOException{
                
		Game game = new Game("Tile Game!",1000 , 600);
		game.start();
                
	}
	
}
