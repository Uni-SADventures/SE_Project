
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
        System.out.println("C");
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        mousePressed = true;
        mouseXPosition = e.getX();
        mouseYPosition = e.getY();
        System.out.println("A");
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        mousePressed = false;
        System.out.println("B");
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
