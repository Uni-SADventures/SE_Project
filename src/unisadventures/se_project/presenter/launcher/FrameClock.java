/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.launcher;

import unisadventures.se_project.model.FrameListener;
import java.util.*;


/**
 *This class implements a clock that ticks 60 times per second at regular intervals
 * It is an observed object so it does keep track of the observers to update
 * @author Emilio
 */
public class FrameClock extends Thread{
    List<FrameListener> observerList; 

    public FrameClock() {
        
        observerList = new LinkedList<>() ;
    }
    
    
    
    
    /***
     * This method is the actual clock, it counts and every ticks it does every observer
     * is advised
     */
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
    
            }

        }

    }
    
    /**
     * This method adds a new observer to this object
     * @param o 
     */
    public void registerObserver(FrameListener o) { 
        observerList.add(o); 
    } 
    /**
     * This method removeds an observer to this object
     * @param o 
     */
    public void unregisterObserver(FrameListener o) { 
        observerList.remove(observerList.indexOf(o)); 
    } 
    
    /**
     * This method calls update method of every framelistener.
     * Useful to be called every time the clock ticks
     */
    public void notifyObservers() 
    { 
        for (Iterator<FrameListener> it = 
              observerList.iterator(); it.hasNext();) 
        { 
            FrameListener o = it.next(); 
            o.update(); 
        } 
    } 


}
