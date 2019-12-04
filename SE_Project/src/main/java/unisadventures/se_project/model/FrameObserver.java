/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Emilio
 */
public abstract class FrameObserver {
    private long frames ;

    public FrameObserver() {
        frames = 0 ;
    }
    
    public void update() {
        
        frames++ ;
        doSmthGiveSprite() ;
        
    }
    
    public abstract String doSmthGiveSprite() ;
    
}
