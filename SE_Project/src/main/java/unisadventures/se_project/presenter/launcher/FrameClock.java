/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.launcher;

import model.FrameObserver;
import java.util.*;

/**
 *
 * @author Emilio
 */
public class FrameClock extends Thread{
    List<FrameObserver> observerList; 

    public FrameClock() {
        
        observerList = new LinkedList<>() ;
    }
    
    
    
    
    
    @Override
    public void run() {
       
        boolean running = true ;
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                notifyObservers() ;
                ticks++;
                delta--;
                System.out.println("Frames: " + ticks);
            }
/*
            if (timer >= 1000000000) {
                //System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
*/
        }

    }
    
    public void registerObserver(FrameObserver o) { 
        observerList.add(o); 
    } 
  
    public void unregisterObserver(FrameObserver o) { 
        observerList.remove(observerList.indexOf(o)); 
    } 
  
    public void notifyObservers() 
    { 
        for (Iterator<FrameObserver> it = 
              observerList.iterator(); it.hasNext();) 
        { 
            FrameObserver o = it.next(); 
            o.update(); 
        } 
    } 


}
