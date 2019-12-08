package unisadventures.se_project.view.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import unisadventures.se_project.presenter.states.State;


/**
 * This class is used to create canvas and frame to visualize all elements in a window.
 * It is intended to be used to firstly createc the window and then to manage it
 * @author Panzuti
 */
public class Display {

	private JFrame frame;
	private Canvas canvas;
	private BufferStrategy bs;
	private String title;
	private int width, height;
	private Graphics g;
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	/**
         * After being initialized first window creation is triggered
         */
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}

	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
        /**
         * This method renders on screen what it's needed to render
         */
        public void render(){
		bs = getCanvas().getBufferStrategy();
		if(bs == null){
			getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
               
		//Clear Screen
		g.clearRect(0, 0, width, height);
                
		//Draw Here!
		
		if(State.getState() != null)
			State.getState().displayView(g);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	
}