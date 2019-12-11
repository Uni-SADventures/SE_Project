/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.presenter.states.GameState;
import unisadventures.se_project.presenter.states.State;
import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.util.DirectionType;

/**
 *
 * @author Paolo
 */
public class ZombieEnemy extends EnemyCharacter {

    private boolean isMoving;
    private boolean movingLeft;

    public ZombieEnemy(Handler handler, int xPosition, int yPosition, int height, int width, CharacterType type, int healthBar, int strength, int maxHealth, int maxJump) {
        super(handler, xPosition, yPosition, height, width, type, healthBar, strength, maxHealth, maxJump);
        isMoving = false;
        movingLeft = false;
        this.setSpeed(1);
    }

    @Override

    public void tick() {
        attack();
        getDamage();
        movement();

    }

    /**
     *
     * @param speed the speed at which the enemy moves* Move the enemy speed
     * pixels to the right. if speed is less than 0, it moves to the left
     */
    public void move(double speed) {
        this._xPosition += speed;
    }

    /**
     * This method implements the movement pattern of the zombie enemy. it moves
     * left and right without stopping
     */
    private void movement() {
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
            if (this._xPosition + this.getSpeed() < this.getHandler().getGame().getWidth()) {
                move(this.getSpeed());
            } else {
                movingLeft = true;
                move(-this.getSpeed());
            }
        }
    }

    /**
     * This method implements the attack of the zombie, when the zombie and the
     * player meets, the player loses health.
     *
     */
    public void attack() {
        if (State.getState() instanceof GameState) {
            GameState gstate = (GameState) State.getState();
            PlayerCharacter player = gstate.getPlayer();

            int x = getPosition().getFirstElement();
            int y = getPosition().getSecondElement();
            int width = getDimension().getFirstElement();
            int heigth = getDimension().getSecondElement();
            if (x + width == x
                    || x == x + width) {
                if (y < y + heigth && y + heigth >= y + heigth) {
                    player.setHealthBar(player.getHealthBar() - 1);
                }
            }
        }
    }

    /**
     * This method implements the attack of the player on a zombie enemy. When
     * the player jumps over the zombie, it dies.
     */
    public void getDamage() {
        if (State.getState() instanceof GameState) {
            GameState gstate = (GameState) State.getState();
            PlayerCharacter player = gstate.getPlayer();

            if (this.getHealthBar() == -1) {
                return;
            }

            int x = player.getPosition().getFirstElement();
            int y = player.getPosition().getSecondElement();
            int width = player.getDimension().getFirstElement();
            int heigth = player.getDimension().getSecondElement();
            if ((x + width >= x && x + width <= x + width)
                    || (x >= x && x <= x + width)) {
                if (y + heigth == y) {
                    this.setHealthBar(-1);

                }
            }
        }
    }

    public int getxPosition() {
        return _xPosition;
    }

    public int getyPosition() {
        return _yPosition;
    }
    
}
