/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.util.CollectibleType;

/**
 *
 * @author Emilio
 */
public class PowerupCommand extends ActionCommand{
    
    private CollectibleType _type ;
    private int _maxTime ;
    private int _origInt ;
    private String _origStr ; //IT MAY BE DISCARDED IF IT SEEMS TO BE USELESS
    
    //TIME 0 = INFINITY
    public PowerupCommand(Handler handler, BasicCharacter ch, int time, CollectibleType type) {
        super(handler, ch);
        _type = type ;
        _maxTime = time;
    }
    
    public boolean managePowerup(){
        _count++;
        if(_maxTime == 0){
            if(_type == CollectibleType.COFFEE){
              _origInt = _ch.getSpeed() ;
              _ch.setSpeed(_origInt * 2);
          }
            return true ; 
        } else if(_count == 1){
          if(_type == CollectibleType.COFFEE){
              _origInt = _ch.getSpeed() ;
              _ch.setSpeed(_origInt * 2);
          }
          return true ;  
        } else if(_count == _maxTime){
          if(_type == CollectibleType.COFFEE){
              _ch.setSpeed(_origInt);
          }
          return false ;
        }
        
        return true ;
        
    }

    public CollectibleType getType() {
        return _type;
    }
    
    
}
