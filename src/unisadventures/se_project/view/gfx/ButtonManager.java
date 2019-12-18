package unisadventures.se_project.view.gfx;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class that allows for the displaying of buttons on the main JFrame object
 */
public class ButtonManager {
    
    private static JFrame _frame;
    
    public static void init(JFrame frame) {
        _frame = frame;
    }
    
    public static void addButton(int xPosition, int yPosition, int width, int height, String text, ActionListener buttonActionListener) {
        JButton button = new JButton(text);
        button.setBackground(Color.red);
        
        button.setBounds(xPosition, yPosition, width, height);
        button.addActionListener(buttonActionListener);
        _frame.add(button);
        _frame.revalidate();
        //_frame.repaint();
    }
    
}
