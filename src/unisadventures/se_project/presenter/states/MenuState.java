package unisadventures.se_project.presenter.states;

import java.awt.Graphics;
import unisadventures.se_project.presenter.launcher.Handler;
/**
 * This class extends state and implements gamestate, the actual state were the game is not
 * playable and frametime can't go on. That's the case when the menu has been invoked
 * It has every instance to be updated each frame as parameter
 * @author Emilio
 */
import unisadventures.se_project.presenter.launcher.Game;

public class MenuState extends State {

	public MenuState(Handler handler){
		super(handler);
	}

	@Override
	public void tick() {
		
	}

    @Override
    public void displayView(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	
	
}
