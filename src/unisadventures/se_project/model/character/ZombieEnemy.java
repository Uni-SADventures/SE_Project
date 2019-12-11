/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import unisadventures.se_project.model.Handler;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.util.DirectionType;

/**
 *
 * @author Paolo
 */
public class ZombieEnemy extends EnemyCharacter {

    private boolean isMoving;
    private boolean movingLeft;

    public ZombieEnemy(Handler hand, int xPosition, int yPosition, int height, int width, CharacterType type, int healthBar, int strength, int maxHealth, int maxJump) {
        super(hand, xPosition, yPosition, height, width, type, healthBar, strength, maxHealth, maxJump);
        isMoving = false;
        movingLeft = false;
        this.setSpeed(1);
    }

    @Override
    /**
     * @Author Emanuela Paolo 
     * @param 
     * This method implements the movement pattern of the zombie enemy. it moves left and right without stopping
     */
    public void tick() {
        if (!isMoving) {
            isMoving = true;
            movingLeft = true;
        }
        if (isMoving && movingLeft) {
            if (this._xPosition - this.getSpeed() < 0) {
                movingLeft = false;
                move(this.getSpeed());
            } else {
                move(-this.getSpeed());
            }
        } else if (isMoving && !movingLeft) {
            if (this._xPosition + this.getSpeed() < getHandler().getGame().getWidth()) {
                move(this.getSpeed());
            } else {
                movingLeft = true;
                move(-this.getSpeed());
            }
        }
    }

    /**
     * @Author Emanuela Paolo
     * @param speed the speed at which the enemy moves* Move the enemy speed
     * pixels to the right. if speed is less than 0, it moves to the left
     */
    public void move(int speed) {
        this._xPosition += speed;
    }

}
