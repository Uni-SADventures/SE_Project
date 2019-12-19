package unisadventures.se_project.presenter.launcher ;

import unisadventures.se_project.view.gfx.Assets;

/**
 * This is the main class whitch launches the game
 * @author Emilio
 */
public class Launcher {

	public static void main(String[] args){
                Assets.init();
		Game game = new Game("Uni-SADventures", 1100, 600);
		game.start();
                
	}
	
}
