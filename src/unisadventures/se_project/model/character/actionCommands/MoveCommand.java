/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.util.DirectionType;

/**
 *
 * @author Emilio
 */
public class MoveCommand extends ActionCommand {

    public MoveCommand(Game game,BasicCharacter ch) {
        super(game,ch);
    }

    public void moveLeft() {
       move(DirectionType.LEFT) ;           
    }
    public void moveRight(){
        move(DirectionType.RIGHT) ; 
    }
    
    private void move(DirectionType d){
        double delta = _ch.getSpeed() ;
        if (d==DirectionType.LEFT)
            delta = -delta ;
        _ch.setxPosition(_ch.getPosition().getFirstElement() + delta);
        if(_ch instanceof PlayerCharacter)
            _game.getCam().centerOnEntity((PlayerCharacter) _ch);
        
        _count++ ;
    }
    
}
