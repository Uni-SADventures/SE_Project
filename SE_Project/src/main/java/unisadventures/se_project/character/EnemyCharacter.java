/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.character;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
/**
 *
 * @author Francesco
 */
public class EnemyCharacter extends Character {
    
    public EnemyCharacter(Image sprite, String name, int healthBar, int strenght, int maxHealth, double maxJump) {
        super(sprite, name, healthBar, strenght, maxHealth, maxJump);
    }
    
    public AnimationTimer animationPattern(double R){
       AnimationTimer enemyTimer = new AnimationTimer() {

                    @Override
                    public void handle(long now) {
                      moveRight(R);
                    }
       };    
        return enemyTimer;
            
    }

 
}
