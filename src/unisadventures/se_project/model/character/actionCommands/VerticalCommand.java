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
 *This class does implement all vertical movements, may they be jumping or falling.
 * Those two are put togheter thanks to their strong dependency
 * Init jump has to be used to keep track of initial jump height
 * @author Emilio
 */
public class VerticalCommand extends ActionCommand {
    private double _initJump ;
    public VerticalCommand(Game game, BasicCharacter ch) {
        super(game, ch);
        _initJump = -1;
    }
    
    /**
     * It makes a character move a step higher
     * @return true if that character may be able to go even higher
     * false if jump's reached maximal jumo height
     */
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
    /**
     * It starts or reiterates a fall action by one step below, it doesn't let a
     * character going down another time if there's a platform below
     */
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
