/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.model.Handler;
import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.presenter.world.Tile;

/**
 *This class does implement all vertical movements, may they be jumping or falling.
 * Those two are put togheter thanks to their strong dependency
 * Init jump has to be used to keep track of initial jump height
 * @author Emilio
 */
public class VerticalCommand extends ActionCommand {
    private int _initJump ;
    public VerticalCommand(Handler handler, BasicCharacter ch) {
        super(handler, ch);
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
        
        int newPos = _ch.getPosition().getSecondElement() - _ch.getSpeed() ;
        
          int ty=(int)(_ch.getPosition().getSecondElement()-_ch.getSpeed()+ _bounds.y)/Tile.TILEHEIGHT;
            if(!collisionWithTile((int)(_ch.getPosition().getFirstElement()+_bounds.x)/Tile.TILEWIDTH, ty) 
                && !collisionWithTile((int)(_ch.getPosition().getFirstElement()+_bounds.x+_bounds.width)/Tile.TILEWIDTH, ty) &&
                    newPos >= -_ch.getMaxJump()+_initJump){
                
                _ch.setyPosition(newPos);
                _count++ ;
                return true ;
            }else {
                _ch.setyPosition(ty*Tile.TILEHEIGHT + Tile.TILEHEIGHT -_bounds.y);
                this.resetCounter();
                return false ;
            }
            
       
        
        
    }
    /**
     * It starts or reiterates a fall action by one step below, it doesn't let a
     * character going down another time if there's a platform below
     */
    public boolean fall(){
    
       int ty=(int)(_ch.getPosition().getSecondElement()+_ch.getSpeed()+ _bounds.y + _bounds.height)/Tile.TILEHEIGHT;
            if(!collisionWithTile((int)(_ch.getPosition().getFirstElement()+_bounds.x)/Tile.TILEWIDTH, ty) 
                && !collisionWithTile((int)(_ch.getPosition().getFirstElement()+_bounds.x+_bounds.width)/Tile.TILEWIDTH, ty) ){
                _ch.setyPosition((int) (_ch.getPosition().getSecondElement() +(int) _ch.getSpeed()*1.5));
                _count++ ;
                return true ;
                
            }else {
                _ch.setyPosition(ty*Tile.TILEHEIGHT  - _bounds.y - _bounds.height -1);
                this.resetCounter();
                return false ;
                
            }
       
        
    
    }
    
    @Override
    public void resetCounter(){
        super.resetCounter();
        _initJump = -1;
    }
    
}
