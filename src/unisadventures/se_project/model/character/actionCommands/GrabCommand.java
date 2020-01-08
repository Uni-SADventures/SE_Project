/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.util.DirectionType;

/**
 *
 * @author Paolo
 */
public class GrabCommand extends BasicCommand{

    public GrabCommand(){
        
    }
    
    @Override
    public void execute(DirectionType type) {
        if(type == DirectionType.GRAB)
            _player.grab(_count);
    }
    
}
