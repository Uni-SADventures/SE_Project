/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.Model.character;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import unisadventures.se_project.util.* ;
/**
 *
 * @author Francesco
 */
public class EnemyCharacter extends BasicCharacter {
    
    public EnemyCharacter(Image sprite, String name, int healthBar, int strenght, int maxHealth, double maxJump) {
        super(sprite, name, healthBar, strenght, maxHealth, maxJump);
    }
    
    public AnimationTimer animationPattern(double R,double L){
       AnimationTimer enemyTimer = new AnimationTimer() {
            private int start = -1 ;
                    @Override
                    public void handle(long now) {
                      start++;
                      if(start <= 20)
                      move(R,DirectionType.RIGHT);
                      if(start>20 && start<40)
                         move(L,DirectionType.LEFT);
                      if(start>60)
                          start=-1;
                    }
       };    
        return enemyTimer;
         
        
       
    }

    @Override
    public void attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void grab() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
