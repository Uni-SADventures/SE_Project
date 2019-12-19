/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;


import unisadventures.se_project.presenter.launcher.Handler;

import unisadventures.se_project.util.CharacterType;

/**
 *Extension of BasicCharacter class to represent a character which is the enemy to overcome
 * the player
 * @author Francesco
 */
public abstract class EnemyCharacter extends BasicCharacter {
    
    public EnemyCharacter(Handler hand,int xPosition, int yPosition, int height, int width, CharacterType type, int healthBar, int strength, int maxHealth, int maxJump) {
        super(hand,xPosition, yPosition, height, width, type, healthBar, strength, maxHealth, maxJump);
    }
 
    public abstract void tick();
    /*public void tick(){
        
    }*/
    
    public abstract boolean horizontalCollision() ;
   
    public abstract boolean checkVerticalCollision() ;
 
}
