package unisadventures.se_project.model.character;

import java.awt.Rectangle;
import java.util.LinkedList;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.presenter.states.*;
import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.util.DirectionType;

/**
 * This is the main class of the enemy of type zombie. it implements the methods
 * for attacking, receiving attacks from the character and movement
 *
 * @author Paolo Emanuela
 */
public class ZombieEnemy extends EnemyCharacter {
    
    private DirectionType _facing;

    public ZombieEnemy(Handler handler, int xPosition, int yPosition, int height, int width, CharacterType type, int healthBar, int strength, int maxHealth, int maxJump,DirectionType facing) {
        super(handler, xPosition, yPosition, height, width, type, healthBar, strength, maxHealth, maxJump);
        _facing=facing;
        this.setSpeed(1);
    }

    public DirectionType getFacing() {
        return _facing;
    }

    public void setFacing(DirectionType _facing) {
        this._facing = _facing;
    }
    
    

    
}
