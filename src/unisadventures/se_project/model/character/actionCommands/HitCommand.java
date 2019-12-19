/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import java.awt.Rectangle;
import java.util.LinkedList;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.model.character.EnemyCharacter;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.presenter.states.GameState;
import unisadventures.se_project.presenter.states.State;
import unisadventures.se_project.util.DirectionType;

/**
 *This action command implements everything it is necessary for a hit
 * action
 * @author Emilio
 */
public class HitCommand extends ActionCommand {
    private Rectangle _hitArea ;
    public HitCommand( Handler handler, BasicCharacter ch) {
        super(handler, ch);
        _hitArea = new Rectangle(ch.getxPosition() + ch.getDimension().getFirstElement(),
        ch.getyPosition() + ch.getDimension().getSecondElement()/3, ch.getDimension().getFirstElement()/2,
        ch.getDimension().getSecondElement()/3) ;
        
    }
    
    /**
     * It does actually start or continue hit action and in a certain fixed frame
     * called "pivot" it actually checks if there'is some enemy or destructable object to 
     * be damaged
     */
    public boolean hit(){
        
        updateHitbox() ;
        if(_count == 5 ){
            LinkedList<EnemyCharacter> enemies = ((GameState) State.getState()).getEnemies() ;
            LinkedList<EnemyCharacter> oldEnemies = (LinkedList<EnemyCharacter>) enemies.clone() ;
            for (EnemyCharacter e : oldEnemies){
                int posX = e.getxPosition() + e.getDimension().getFirstElement()/4 ;
                int posY = e.getyPosition() + e.getDimension().getSecondElement()/2 ;
                
                if( e.getxPosition() + e.getDimension().getFirstElement()/2 >= _hitArea.x - _hitArea.width*0.5 &&
                        e.getxPosition() + e.getDimension().getFirstElement()/2 <= _hitArea.x + _hitArea.width*1.5 &&
                      e.getyPosition() + e.getDimension().getSecondElement()/2 >= _hitArea.y  - _hitArea.height  *2 &&
                     e.getyPosition() + e.getDimension().getSecondElement()/2 <= _hitArea.y + _hitArea.height  *2      )
                    
                    e.setHealthBar(e.getHealthBar() - _ch.getStrength());
                if(e.getHealthBar() <= 0 )
                    enemies.remove(e) ;
            }
        }
        //enemy = _handler.getCollision(_ch.getPosition()) ;
        
        //_ch.takeDamage(_ch.getStrength());
        
        _count++ ;
        if (_count < 60 )
            return true ;
        else{ 
            resetCounter() ;
            return false ;
            
        }
    }
    
    
    
    private void updateHitbox(){
        
        if(_ch.getFacing() == DirectionType.RIGHT)
            _hitArea = new Rectangle((int) (_ch.getxPosition() + _ch.getDimension().getFirstElement() - _handler.getCam().getxOffset()),
            _ch.getyPosition() + _ch.getDimension().getSecondElement()/3, _ch.getDimension().getFirstElement()/2,
            _ch.getDimension().getSecondElement()/3) ;
        else
            _hitArea = new Rectangle((int) (_ch.getxPosition() - _ch.getDimension().getFirstElement()/2 - _handler.getCam().getxOffset()),
            _ch.getyPosition() + _ch.getDimension().getSecondElement()/3, _ch.getDimension().getFirstElement()/2,
            _ch.getDimension().getSecondElement()/3) ;
    }
    
}
