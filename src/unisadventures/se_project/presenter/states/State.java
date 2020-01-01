package unisadventures.se_project.presenter.states;

import java.awt.Graphics;
import unisadventures.se_project.presenter.launcher.Handler;

import unisadventures.se_project.view.gfx.StateGraphics;

/**
 * USED PATTERN: STATE PATTERN
 * This class is used ha ancestor for classes relative to different game states
 * where actions to be executed are pretty different
 * It statically takes in count in wich class we are
 * @author Emilio
 */



public abstract class State {

	private static State currentState = null;
        
	public static void setState(State state){
		currentState = state;
                
	}
	
	public static State getState(){
		return currentState;
	}
	
	//CLASS
	
	protected Handler _handler;
	protected final StateGraphics view ;
	public State(Handler handler /*,World world*/){
		_handler = handler;
                view = new StateGraphics(_handler /*,world*/) ;
	}
	
        /**
         * It updates every entity position
         */
	public abstract void tick();
	
	/**
         * It updates every entity sprite
         * @param g is the graphical element
         */
        public abstract void displayView(Graphics g);
        public abstract void loadImages();
        public abstract int getCountCFU();
        
        

    
	 
        
}
