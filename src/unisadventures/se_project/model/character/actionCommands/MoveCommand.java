/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import java.awt.Rectangle;
import unisadventures.se_project.model.Handler;
import unisadventures.se_project.model.basicObjects.Tile;
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
    
    Handler handler;

    public MoveCommand(Handler handler,BasicCharacter ch) {
        super(handler,ch);
        bounds.x=14;
        bounds.y=24;
        bounds.width=64;
        bounds.height=64;
    }
    /**
     * It moves the chatracter a bit on the left
     */
     
    public void moveLeft() {
      int tx=(int) (_ch.getPosition().getFirstElement() -_ch.getSpeed() + bounds.x )/ Tile.TILEWIDTH;
      if(!collisionWithTile(tx,(int) (_ch.getPosition().getSecondElement()+ bounds.y)/Tile.TILEHEIGHT ) 
          && !collisionWithTile(tx,(int) (_ch.getPosition().getSecondElement()+ bounds.y+bounds.height)/Tile.TILEHEIGHT)){
              move(DirectionType.LEFT) ;
      }else {
          _ch.setxPosition(tx*Tile.TILEWIDTH+Tile.TILEWIDTH-bounds.x);
      }
           
    }
    /**
     * It moves the chatracter a bit on the right
     */
    public void moveRight(){
         int tx=(int) (_ch.getPosition().getFirstElement() + _ch.getSpeed() + bounds.x + bounds.width)/ Tile.TILEWIDTH;
         if(!collisionWithTile(tx,(int) (_ch.getPosition().getSecondElement()+ bounds.y)/Tile.TILEHEIGHT  ) && !collisionWithTile(tx,(int) (_ch.getPosition().getSecondElement()+ bounds.y+bounds.height)/Tile.TILEHEIGHT)){
            move(DirectionType.RIGHT) ; 
         }else{
             _ch.setxPosition(tx*Tile.TILEWIDTH - bounds.x - bounds.width -1);
         }
     }
    
       
    
    private void move(DirectionType d){
        double delta = _ch.getSpeed() ;
        if (d==DirectionType.LEFT)
            delta = -delta ;
        _ch.setxPosition(_ch.getPosition().getFirstElement() + delta);
        if(_ch instanceof PlayerCharacter)
            _handler.getCam().centerOnEntity((PlayerCharacter) _ch);
        
        _count++ ;
    }
    
      protected boolean collisionWithTile(int x, int y){
          
        return _handler.getWorld().getTile(x, y).isSolid();
        
    }
    
}
