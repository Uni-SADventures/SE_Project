package unisadventures.se_project.presenter.launcher;


import unisadventures.se_project.view.display.Display;
import unisadventures.se_project.model.FrameListener;
import unisadventures.se_project.presenter.camera.GameCamera;

import unisadventures.se_project.view.gfx.Assets;
import unisadventures.se_project.presenter.input.KeyManager;
import unisadventures.se_project.presenter.states.*;


/**
 * This class is the most important to assure the correct execution of the entire game
 * it has in storage display, width and height of the window, its title, camera,
 * clock, actual state and keymanager. It links view and model part in a lot how ways to assure
 * that at each instant every entity is updated both in position and in sprite
 * @author Emilio
 */
public class Game extends FrameListener {

	private Display display;
	public int width, height;
	public String title;
	private GameCamera cam ;
	private boolean running = false;
	private FrameClock thread;
	
	
	
	
	//States
	private State gameState;
	private State menuState;
	
	//Input
	private KeyManager keyManager;

    public Display getDisplay() {
        return display;
    }
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
        /**
         * Other than the costructor, this class actually initializes assets, states
         * and display
         */
	private void init(Handler hand){
		display = new Display(title, width, height);
         
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
                
		gameState = new GameState(hand);
		menuState = new MenuState(hand);

                
		State.setState(gameState);
	}
	
        
        /**
         * This method updates each entity position at each frame
         */
	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	/**
         * This method let main frameclock thread to start and it registers this
         * instance as the observer to be updated
         */
	public synchronized void start(){
		if(running)
			return;
		running = true;
                FrameClock clock = new FrameClock() ;
                Handler hand = new Handler(this) ;
                
                cam = new GameCamera(hand,0,0) ;
		thread = clock;
                thread.registerObserver(this);
                
                init(hand);
		thread.start();
	}
	

    public GameCamera getCam() {
        return cam;
    }
    
    
    /**
     * This method stops frameclock
     */
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

    public void wait(Thread thread) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * This method makes sure to update both position and graphic sprite for each entity
     * This is invoked by frameclock at each new frame
     */
    @Override
    public void update() {
            tick() ;
            display.render() ;
            
    }
    
    public int getWidth(){
        return width ;
    }
    public int getHeight(){
        return height ;
    }
}


