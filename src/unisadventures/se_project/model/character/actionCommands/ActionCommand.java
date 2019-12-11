/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import java.awt.Rectangle;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.presenter.launcher.Game;

/**
 *USED PATTERN: COMMAND PATTERN
 * This class implement the base for every action that can be executed by a character
 * _ch is the basic character which this action is related to
 * _game of course is the main object of the presenter to make everything work
 * _count just keeps counting how many frame have been passed while executing the action
 * it is useful to retrieve a list of sprites for animations
 * 
 * @author Emilio
 */
public abstract class ActionCommand {
    protected BasicCharacter _ch ;
    protected Handler _handler ;
    protected int _count ;
    protected Rectangle _bounds;
    
    public ActionCommand(Handler handler, BasicCharacter ch) {
        _handler = handler ;
        _ch = ch;
        _count = 0;
        _bounds=new Rectangle(0,0,_ch.getDimension().getFirstElement(),_ch.getDimension().getSecondElement());
        
    }

    public int getCount() {
        return _count;
    }
    
    
    /**
     * This method just resets frame counter to 0, to be used when an action has
     * been stopped.
     */
    public void resetCounter(){
        _count = 0 ;
    }
    protected boolean collisionWithTile(int x, int y){
          
        return _handler.getWorld().getTile(x, y).isSolid();
        
    }
    
}
