/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.model.Handler;
import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.presenter.launcher.Game;

/**
 *This action command implements everything it is necessary for a hit
 * action
 * @author Emilio
 */
public class HitCommand extends ActionCommand {
    
    public HitCommand(Handler handler, BasicCharacter ch) {
        super(handler, ch);
    }
    
    /**
     * It does actually start or continue hit action and in a certain fixed frame
     * called "pivot" it actually checks if there'is some enemy or destructable object to 
     * be damaged
     */
    public void hit(){
        //enemy = _game.getCollision(_ch.getPosition()) ;
        
        //_ch.takeDamage(_ch.getStrength());
        
        _count++ ;
    }
    
}
