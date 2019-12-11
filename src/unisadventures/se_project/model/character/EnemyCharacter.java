/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import unisadventures.se_project.model.LevelManager;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.util.CharacterType;

/**
 *Extension of BasicCharacter class to represent a character which is the enemy to overcome
 * the player
 * @author Francesco
 */
public class EnemyCharacter extends BasicCharacter {
    
    public EnemyCharacter(LevelManager manager, Game game, double xPosition, double yPosition, double width, double height, CharacterType type, int healthBar, int strength, int maxHealth, double maxJump) {
        super(manager, game, xPosition, yPosition, width, height, type, healthBar, strength, maxHealth, maxJump);
    }

 
}
