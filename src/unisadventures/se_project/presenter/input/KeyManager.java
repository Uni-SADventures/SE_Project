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
	public boolean up, down, left, right,hit,enter, esc;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
        /**
         * This method is the one who check if there are some updates from key events
         */
	public void tick(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
                hit = keys[KeyEvent.VK_B];
                enter = keys[KeyEvent.VK_ENTER];
                esc=keys[KeyEvent.VK_ESCAPE];
           
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

}
