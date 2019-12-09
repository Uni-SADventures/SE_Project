package unisadventures.se_project.presenter.launcher;

import unisadventures.se_project.model.LevelManager;


/**
 * This is the main class whitch launches the game
 * @author Emilio
 */
public class Launcher {

	public static void main(String[] args){
                
		Game game = new Game(new LevelManager(640,360,"resources/images/scenario.jpg"),"Tile Game!");
		game.start();
                
	}
	
}
