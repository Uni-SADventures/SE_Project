/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model;


/**
 * USED PATTERN: observer
 * This class represents a frame observer which has an update method that is called
 * by frameclock every time passes a new frame
 * All observers need to be registered in a relative frameclock instance
 * @author Emilio
 */
public abstract class FrameListener {
    //frame counter
    private long _frames ;
    
    public FrameListener() {
        _frames = 0 ;
    }
    
    /**
     * this method calls all the actions needed to update graphics and object/character
     * positions each frame
     */
    public abstract void update() ;
    
}
