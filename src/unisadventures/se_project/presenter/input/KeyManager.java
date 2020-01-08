package unisadventures.se_project.presenter.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class is inteded to support game mechanics by keeping track of what key has
 * been pressed or released by each frame tick.
 * Its keys array parameter are used as support to store last input
 * As boolean there are its memorizable inputs
 * @author Emilio
 */
public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	private boolean up, down, left, right,hit,enter;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
        /**
         * This method is the one who check if there are some updates from key events
         */
	public void tick(){
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
                hit = keys[KeyEvent.VK_SPACE];
                enter = keys[KeyEvent.VK_ENTER];
           
	}
        /**
         * It puts on true an element of key where its index is the same as keycode pressed
         * @param e is the keyevent to check
         */
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
                
	}
        
        /**
         * It puts on true an element of key where its index is the same as keycode pressed
         * @param e is the keyevent to check
         */
        
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
        
      
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

    public boolean[] getKeys() {
        return keys;
    }

    public void setKeys(boolean[] keys) {
        this.keys = keys;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public boolean isEnter() {
        return enter;
    }

    public void setEnter(boolean enter) {
        this.enter = enter;
    }

}
