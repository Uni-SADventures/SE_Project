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
 *This class implements an action command wich moves left and right the character keeping
 * track of the game camera
 * @author Emilio
 */
public class MoveCommand extends ActionCommand {

    public MoveCommand(Game game,BasicCharacter ch) {
        super(game,ch);
    }
    /**
     * It moves the chatracter a bit on the left
     */
     
    public void moveLeft() {
       move(DirectionType.LEFT) ;           
    }
    /**
     * It moves the chatracter a bit on the right
     */
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
