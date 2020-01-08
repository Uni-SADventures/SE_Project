/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.model.character.Player;
/**
 *
 * @author Paolo
 */
public abstract class BasicCommand implements Command{
    
    protected Player _player;
    protected int _count;
    
    
    public BasicCommand(){
        _player = Player.getPlayer();
        _count = 0;
    }
    
    public int getCount() {
        return _count;
    }

    /**
     * This method just resets frame counter to 0, to be used when an action has
     * been stopped.
     */
    public void resetCounter() {
        _count = 0;
    }


    
    
}
