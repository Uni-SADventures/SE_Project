package unisadventures.se_project.presenter.states;

import java.awt.Graphics;

import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.view.gfx.StateGraphics;


public abstract class State {

	private static State currentState = null;
        
	
	public static void setState(State state){
		currentState = state;
                
	}
	
	public static State getState(){
		return currentState;
	}
	
	//CLASS
	
	protected Game game;
	protected final StateGraphics view ;
	public State(Game game /*,World world*/){
		this.game = game;
                view = new StateGraphics(game /*,world*/) ;
	}
	
	public abstract void tick();
	
	
        public abstract void displayView(Graphics g);
	
}
