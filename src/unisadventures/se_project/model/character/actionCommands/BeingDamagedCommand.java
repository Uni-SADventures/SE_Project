/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.model.basicObjects.Tile;
import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.presenter.audio.AudioManager;

/**
 *This class implements an action command wich moves left and right the character keeping
 * track of the game camera
 * @author Emilio
 */
public class BeingDamagedCommand extends ActionCommand {

    private final int _damageFrames ;
    
    public BeingDamagedCommand(Handler handler,BasicCharacter ch,int damageFrames) {
        super(handler,ch);
       _damageFrames = damageFrames;
      
    }
    /**
     * It moves the chatracter a bit on the left
     */
  
    public boolean takeDamage(int dam){
        
        System.out.println(_count);
        if(_count == 2){
            _ch.setHealthBar(_ch.getHealthBar() - 1);
            _count++ ;
            AudioManager.playPlayerDamage();
            return true ;
        }
        else if(_count == _damageFrames){
            this.resetCounter();
            return false ;
        } else {
            _count++;
            return true ;
        }
       
    }
}
