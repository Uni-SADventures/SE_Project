package unisadventures.se_project.presenter.launcher;


import unisadventures.se_project.view.display.Display;
import unisadventures.se_project.model.FrameListener;
import unisadventures.se_project.presenter.camera.GameCamera;
import unisadventures.se_project.presenter.input.KeyManager;
import unisadventures.se_project.presenter.states.*;
import unisadventures.se_project.view.display.AudioManager;


/**
 * This class is the most important to assure the correct execution of the entire game
 * it has in storage display, width and height of the window, its title, camera,
 * clock, actual state and keymanager. It links view and model part in a lot how ways to assure
 * that at each instant every entity is updated both in position and in sprite
 * @author Emilio
 */
public class Game extends FrameListener {

	private Display display;
	public int displayWidth, displayHeight;
	public String title;
	private GameCamera cam;
	private boolean running = false;
	private FrameClock thread;
        private int countCFU=0;
	
	
	
	
	//States
	private State gameState;
	private State menuState;
        private boolean stateIsMenu;
        
	//Input
	private final KeyManager keyManager;
        
        //Button management
        private boolean playButtonPressed;  // True if game launched from the main menu using the "Play" button

    public Display getDisplay() {
        return display;
    }
	
	public Game(String title, int width, int height){
		this.displayWidth = width;
		this.displayHeight = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
        /**
         * Other than the costructor, this class actually initializes assets, states
         * and display
         */
	private void init(Handler hand){
		display = new Display(title, displayWidth, displayHeight);
         
		display.getFrame().addKeyListener(keyManager);
                
                AudioManager.loadAudio();
                
		gameState = new GameState(hand,0);
		menuState = new MenuState(hand);
                

                
		State.setState(menuState);
                stateIsMenu = true;
                AudioManager.gameMenuLoop();
                playButtonPressed = false;
	}
	
        
        /**
         * This method updates each entity position at each frame
         */
	private void tick(){
		keyManager.tick();
                /*MouseListener click=new MouseListener(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                
                }
		FrameListener f = new FrameListener(){
                    @Override
                    public void update() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };*/
		if(State.getState() != null)
			State.getState().tick();
        
                // gameState may be initialized from menu state by pressing Enter or clicking a button
                if ( (keyManager.enter || playButtonPressed) && stateIsMenu) {
                    State.setState(gameState);
                    stateIsMenu = false;
                    AudioManager.gameLevelLoop();
                }
                if ( keyManager.esc  && stateIsMenu) {
                    System.exit(0);
                }

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
        
    public void pressPlayButton() {
        playButtonPressed = true;
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
    
    public int getDisplayWidth(){
        return displayWidth ;
    }
    public int getDisplayHeight(){
        return displayHeight ;
    }
}


