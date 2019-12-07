/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.presenter.launcher.Game;

/**
 *
 * @author Emilio
 */
public class HitCommand extends ActionCommand {
    
    public HitCommand(Game game, BasicCharacter ch) {
        super(game, ch);
    }
    
    public void hit(){
        //enemy = _game.getCollision(_ch.getPosition()) ;
        
        //_ch.takeDamage(_ch.getStrength());
        
        _count++ ;
    }
    
}
