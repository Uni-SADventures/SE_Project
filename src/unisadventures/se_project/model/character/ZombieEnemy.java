/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

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

    public ZombieEnemy(Game game, double xPosition, double yPosition, double height, double width, CharacterType type, int healthBar, int strength, int maxHealth, double maxJump) {
        super(game, xPosition, yPosition, height, width, type, healthBar, strength, maxHealth, maxJump);
        isMoving = false;
        movingLeft = false;
        this.setSpeed(1);
    }

    @Override
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
        } else if(isMoving && !movingLeft){
            if (this._xPosition + this.getSpeed() < this.getGame().getWidth()) {
                move(this.getSpeed());
            } else {
                movingLeft = true;
                move(-this.getSpeed());
            }
        }
    }
    
    public void move(double speed){
        this._xPosition += speed;
    }

}
