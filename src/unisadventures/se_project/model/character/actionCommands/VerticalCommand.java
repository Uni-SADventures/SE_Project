/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.presenter.launcher.Game;

/**
 *
 * @author Emilio
 */
public class VerticalCommand extends ActionCommand {
    private double _initJump ;
    public VerticalCommand(Game game, BasicCharacter ch) {
        super(game, ch);
        _initJump = -1;
    }
    
    public boolean jump() {
        if(_initJump == -1){
            this.resetCounter();
            _initJump = _ch.getPosition().getSecondElement() ;
        }
        
        double newPos = _ch.getPosition().getSecondElement() - _ch.getSpeed() ;
        
        
        
        _count++ ;
        
        if( newPos <= _ch.getMaxJump() ){
            _ch.setyPosition(newPos);
            return true ;
        }
        else{
            _initJump = -1 ;
            return false ;
        }
        
        
        
    }
    
    public void fall(){
        boolean fall = true ;
        double newPos = _ch.getPosition().getSecondElement() + _ch.getSpeed() ;
     //   fall = _game.checkFloor(_ch.getPosition().getFirstElement(),newPos) ; TODO
        _count++ ;
        if(fall)
            _ch.setyPosition(newPos);
        else{
            resetCounter() ;
            if(_ch instanceof PlayerCharacter )
                _game.getCam().centerOnEntityFloor((PlayerCharacter) _ch);
        }
    }
    
    @Override
    public void resetCounter(){
        super.resetCounter();
        _initJump = -1;
    }
    
}
