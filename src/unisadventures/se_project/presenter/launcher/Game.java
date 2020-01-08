package unisadventures.se_project.presenter.launcher;


import java.util.ArrayList;
import unisadventures.se_project.view.display.Display;
import unisadventures.se_project.model.FrameListener;
import unisadventures.se_project.presenter.camera.GameCamera;
import unisadventures.se_project.presenter.input.KeyManager;
import unisadventures.se_project.presenter.input.MouseManager;
import unisadventures.se_project.presenter.states.*;
import unisadventures.se_project.presenter.audio.AudioManager;
import unisadventures.se_project.util.Pair;


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
	private ArrayList<Pair<String,String>> levelManager = new ArrayList();
	
	
	
	//States
	private State gameState;
	private MenuState menuState;
        private StoryState storyState;
        private boolean stateIsMenu;
        
        
	//Input
	private final KeyManager keyManager;
        private final MouseManager mouseManager;

    public Display getDisplay() {
        return display;
    }
	
	public Game(String title, int width, int height){
		this.displayWidth = width;
		this.displayHeight = height;
		this.title = title;
		keyManager = new KeyManager();
                mouseManager = new MouseManager();
                levelManager.add(new Pair("resources/levels/level1World.txt","resources/levels/level1Items.txt"));
                levelManager.add(new Pair("resources/levels/level2World.txt","resources/levels/level2Items.txt"));
                levelManager.add(new Pair("resources/levels/level3World.txt","resources/levels/level3Items.txt"));
                levelManager.add(new Pair("resources/levels/level4World.txt","resources/levels/level4Items.txt"));
                levelManager.add(new Pair("resources/levels/level5World.txt","resources/levels/level5Items.txt"));
                 
	}
	
        /**
         * Other than the costructor, this class actually initializes assets, states
         * and display
         */
	private void init(Handler hand){
		display = new Display(title, displayWidth, displayHeight);
         
		display.getFrame().addKeyListener(keyManager);
                display.getCanvas().addMouseListener(mouseManager);
                
                AudioManager.loadAudio();
                
		gameState = new GameState(hand,0);
		menuState = new MenuState(hand);
                storyState= new StoryState(hand,0);
                

                
		State.setState(menuState);
                stateIsMenu = true;
                AudioManager.gameMenuLoop();
	}
	
        
        /**
         * This method updates each entity position at each frame
         */
	private void tick(){
		keyManager.tick();
                
		if(State.getState() != null)
			State.getState().tick();
        
                // gameState may be initialized from menu state by pressing Enter or clicking a button
                if ( (keyManager.enter || playButtonClicked()) && stateIsMenu) {
                    State.setState(storyState);
                    stateIsMenu = false;
                }
                if ( (keyManager.esc || quitButtonClicked())  && stateIsMenu) {
                    System.exit(0);
                }

        }
	
	
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
        
        public MouseManager getMouseManager() {
            return mouseManager;
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
    
    public int getDisplayWidth(){
        return displayWidth ;
    }
    public int getDisplayHeight(){
        return displayHeight ;
    }

    public ArrayList<Pair<String, String>> getLevelManager() {
        return levelManager;
    }
    
    
    
    private boolean playButtonClicked() {
        if (mouseManager.mousePressed) {
            return menuState.playButtonPressed(mouseManager.mouseXPosition, mouseManager.mouseYPosition);
        }
        return false;
    }
    
    private boolean quitButtonClicked() {
        if (mouseManager.mousePressed) {
            return menuState.quitButtonPressed(mouseManager.mouseXPosition, mouseManager.mouseYPosition);
        }
        return false;
    }
}


