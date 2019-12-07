package unisadventures.se_project.presenter.launcher;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import unisadventures.se_project.view.display.Display;
import unisadventures.se_project.model.FrameListener;
import unisadventures.se_project.presenter.camera.GameCamera;

import unisadventures.se_project.view.gfx.Assets;
import unisadventures.se_project.presenter.input.KeyManager;
import unisadventures.se_project.presenter.states.*;


public class Game extends FrameListener {

	private Display display;
	public int width, height;
	public String title;
	private GameCamera cam ;
	private boolean running = false;
	private FrameClock thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
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
	
	private void init(){
		display = new Display(title, width, height);
         
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this);

                
		State.setState(gameState);
	}
	
	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
               
		//Clear Screen
		g.clearRect(0, 0, width, height);
                
		//Draw Here!
		
		if(State.getState() != null)
			State.getState().render(g,5,5);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
                FrameClock clock = new FrameClock() ;
                cam = new GameCamera(this,0,0) ;
		thread = clock;
                thread.registerObserver(this);
                init();
		thread.start();
	}
	

    public GameCamera getCam() {
        return cam;
    }
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

    @Override
    public String doSmthGiveSprite() {
            tick() ;
            render() ;
            return null ;
    }
    
    public int getWidth(){
        return width ;
    }
    public int getHeight(){
        return height ;
    }
}


