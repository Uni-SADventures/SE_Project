package unisadventures.se_project.presenter.launcher;

import unisadventures.se_project.view.display.Display;
import unisadventures.se_project.model.FrameListener;
import unisadventures.se_project.presenter.camera.GameCamera;
import unisadventures.se_project.presenter.input.KeyManager;
import unisadventures.se_project.presenter.states.*;

/**
 * This class is the most important to assure the correct execution of the
 * entire game it has in storage display, width and height of the window, its
 * title, camera, clock, actual state and keymanager. It links view and model
 * part in a lot how ways to assure that at each instant every entity is updated
 * both in position and in sprite
 *
 * @author Emilio
 */
public class Game extends FrameListener {

    private String title;
    private Display display;
    private boolean running = false;
    private FrameClock thread;
    
    //States
    public State gameState;
    public State menuState;

    //Input
    private final KeyManager keyManager;

    public Game(String title, int width, int height) {
        this.display = new Display(title, width, height);
        this.title = title;
        this.keyManager = new KeyManager();
        start();
    }

    /**
     * Other than the costructor, this class actually initializes assets, states
     * and display
     */
    private void init() {
        display.createDisplay();
        display.getFrame().addKeyListener(keyManager);
        //Assets.init()

        gameState = new GameState(this,0);
        menuState = new MenuState(this);

        State.setState(gameState);
    }

        /**
     * This method makes sure to update both position and graphic sprite for
     * each entity This is invoked by frameclock at each new frame
     */
    @Override
    public void update() {
        keyManager.tick();

        if (State.getState() != null) {
            State.getState().tick();
        }

        display.render();

    }
    /**
     * This method let main frameclock thread to start and it registers this
     * instance as the observer to be updated
     */
    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        FrameClock clock = new FrameClock();
        thread = clock;
        thread.registerObserver(this);

        init();
        thread.start();
    }

    /**
     * This method stops frameclock
     */
    public synchronized void stop() {
        if (!running) {
            return;
        }
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public FrameClock getThread() {
        return thread;
    }

    public void setThread(FrameClock thread) {
        this.thread = thread;
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }
    
}
