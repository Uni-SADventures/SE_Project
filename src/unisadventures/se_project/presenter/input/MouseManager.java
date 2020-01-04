
package unisadventures.se_project.presenter.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener {
    
    public boolean mousePressed;
    public int mouseXPosition;
    public int mouseYPosition;
    
    public MouseManager() {
        mousePressed = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        mousePressed = true;
        mouseXPosition = e.getX();
        mouseYPosition = e.getY();
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        mousePressed = false;
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
