package unisadventures.se_project.model.character;

import java.awt.Rectangle;
import java.util.LinkedList;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.presenter.states.*;
import unisadventures.se_project.util.CharacterType;

/**
 * This is the main class of the enemy of type zombie. it implements the methods
 * for attacking, receiving attacks from the character and movement
 *
 * @author Paolo Emanuela
 */
public class ZombieEnemy extends EnemyCharacter {

    public ZombieEnemy(Handler handler, int xPosition, int yPosition, int height, int width, CharacterType type, int healthBar, int strength, int maxHealth, int maxJump) {
        super(handler, xPosition, yPosition, height, width, type, healthBar, strength, maxHealth, maxJump);
        this.setSpeed(1);
    }

    
}
