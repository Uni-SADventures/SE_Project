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
            if (this._xPosition + this.getSpeed() < this.getGame().getWidth()) {
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
        PlayerCharacter player = this.getGame().getGameState().getPlayer();

        if (this._xPosition + this.getWidth() == player.getxPosition()
                || this._xPosition == player.getxPosition() + player.getWidth()) {
            if (this._yPosition < player.getyPosition() + player.getHeight()
                    && this._yPosition + this.getHeight() >= player.getyPosition() + player.getHeight()) {
                player.setHealthBar(player.getHealthBar() - 1);
            }
        }
    }

    /**
     * This method implements the attack of the player on a zombie enemy. When
     * the player jumps over the zombie, it dies.
     */
    public void getDamage() {
        PlayerCharacter player = this.getGame().getGameState().getPlayer();
        if (this.getHealthBar() == -1) {
            return;
        }
        if ((player.getxPosition() + player.getWidth() >= this.getxPosition() && player.getxPosition() + player.getWidth() <= this.getxPosition() + this.getWidth())
                || (player.getxPosition() >= this.getxPosition() && player.getxPosition() <= this.getxPosition() + this.getWidth())) {
            if (player.getyPosition() + player.getHeight() == this.getyPosition()) {
                this.setHealthBar(-1);

            }
        }
    }
}