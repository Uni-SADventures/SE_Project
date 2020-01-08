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

/**
 *This class implements an action command wich moves left and right the character keeping
 * track of the game camera
 * @author Emilio
 */
public class IdleCommand extends ActionCommand {

    public IdleCommand(Handler handler,BasicCharacter ch) {
        super(handler,ch);
        
      
    }
    /**
     * It moves the chatracter a bit on the left
     */
  public void idle(){
    _count++ ;
  }

    
}
