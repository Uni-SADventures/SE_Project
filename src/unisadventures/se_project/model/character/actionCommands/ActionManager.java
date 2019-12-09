/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.model.character.MovementsInterface;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.util.DirectionType;

/**
 * This class manages all available actions and their relative dependancies.
 * It has every possible actions for a character.
 * It keeps track of which action is being executed with all booleans such as walking
 * or jumping
 * @author Emilio
 */
public class ActionManager implements MovementsInterface {
    private final MoveCommand _movement ;
    private final VerticalCommand _jumpFall ;
    private final HitCommand _combat ;
    private final Game _game ;
    private final BasicCharacter _ch ;

    private boolean _walking,_jumping,_falling,_idling,_hitting,_beingDamaged;
            
    public ActionManager(Game _game, BasicCharacter _ch) {
        
        _walking = false ;
        _jumping = false ;
        _falling = false ;
        _idling = false ;
        _hitting = false ;
        _beingDamaged = false ;
        
        
        this._game = _game;
        this._ch = _ch;
        _movement = new MoveCommand(_game,_ch) ;
        _jumpFall = new VerticalCommand(_game,_ch) ;
        _combat = new HitCommand(_game,_ch) ;
    }
    
    
    /**
     * This method interprets user inputs if the character is user's one and if not
     * it checks what should a character do, for example if there is a floor under their feet
     */
    public void execute(){
        if(_ch instanceof PlayerCharacter){
            if(_game.getKeyManager().left)
                moveLeft();
            else if(_game.getKeyManager().right)
                moveRight();
            else
                _walking = false ;
            
            if(_game.getKeyManager().up)
                jump();
            else if(!_game.getKeyManager().up)
                _jumping = false ;
         //   else if(!_game.checkFloor(_ch.getPosition().getFirstElement(),_ch.getPosition().getSecondElement()))
            //    _jumpFall.fall();
            
            if(_game.getKeyManager().hit)
                attack();
            else
                _hitting = false ;
            
            if(!_game.getKeyManager().up && !_game.getKeyManager().left && !_game.getKeyManager().right && !_game.getKeyManager().hit)
                idle() ;
        
        }else{
        //    if(!_game.checkFloor(_ch.getPosition().getFirstElement(),_ch.getPosition().getSecondElement()))
        //        _jumpFall.fall();
        
        }
            
        
        //MANAGING MOVEMENTS 
    }
    
    /**
     * This method execute basic idle action, useful when user is not giving input and if
     * its character is in a stable position
     */
    public void idle() {
        //TODO
    }
    
    /**
     * This method moves a character one step on the left according to his speed
     */
    @Override
    public void moveLeft(){
        if(!_walking){
            _movement.resetCounter();
            _walking = true ;
        }
        _movement.moveLeft();
    }
    /**
     * This method moves a character one step on the right according to his speed
     */
    @Override
    public void moveRight(){
        if(!_walking){
            _movement.resetCounter();
            _walking = true ;
        }
        _movement.moveRight();
    }
    
    /**
     * This method let a character jump one step up according to his speed
     */
    @Override
    public void jump(){
        if(!_jumping){
            _jumpFall.resetCounter();
            _jumping = true ;
        }
        
        _jumping = _jumpFall.jump();
 
    }
    
    /**
     * This method let the character begin or continue his attack move.
     */
    @Override
    public void attack(){
        if(!_hitting){
            _combat.resetCounter();
            _hitting = true ;
        }
        
        _combat.hit();
    }
    
    
    /**
     * This method let a character fall one step down according to his speed
     */
    @Override
    public void fall(){
        if(!_falling){
            _jumpFall.resetCounter();
            _falling = true ;
        }
        _jumpFall.fall();
    }

  /**
   * 
   * @param damage is the sum to remove from character's actual health
   */
    @Override
    public void takeDamage(int damage) {
        _ch.takeDamage(damage);
    }

    
    /**
     * This method checks if a character has run into some collectible
     */
    @Override
    public void grab() {
      //TODO once we have some collectibles
    }

    
    /**
     * 
     * @param p is the actual character wich is going to change some of his parameters
     * and actions because of some powerup
     * @return decorated player character
     */
    @Override
    public PlayerCharacter getPowered(PlayerCharacter p) {
        //TODO once we have some powerups or weapons
        //it should return a decorated player character
        return null ; // <- da levare
    }

   
}