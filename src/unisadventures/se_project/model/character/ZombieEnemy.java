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

    private boolean _moving;
    private boolean _movingLeft;

    public ZombieEnemy(Handler handler, int xPosition, int yPosition, int height, int width, CharacterType type, int healthBar, int strength, int maxHealth, int maxJump) {
        super(handler, xPosition, yPosition, height, width, type, healthBar, strength, maxHealth, maxJump);
        _moving = false;
        _movingLeft = false;
        this.setSpeed(1);
    }

    public boolean isMoving() {
        return _moving;
    }

    public void setIsMoving(boolean isMoving) {
        _moving = isMoving;
    }

    public boolean isMovingLeft() {
        return _movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        _movingLeft = movingLeft;
    }

    /**
     * This method updates the enemy at each frame. It checks if the enemy's
     * attacking, or there is an attack incoming from the player and it moves
     */
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
    public void move(int speed) {
        this.setxPosition(getxPosition() + speed);
    }

    /**
     * This method implements the movement pattern of the zombie enemy. it moves
     * left and right without stopping
     */
    public void movement() {

        if (!_moving) {
            _moving = true;
            _movingLeft = true;
        }
        //change direction after a collision with the player
        if (horizontalCollision()) {
            if (_movingLeft) {
                _movingLeft = false;
                move(this.getSpeed());
                return;
            } else {
                _movingLeft = true;
                move(-this.getSpeed());
                return;
            }
        }
        //change direction if it touches the edges of the world
        if (_moving && _movingLeft) {
            if (this.getxPosition() - this.getSpeed() < 0) {
                _movingLeft = false;
                move(this.getSpeed());
            } else {
                move(-this.getSpeed());
            }

        } else if (_moving && !_movingLeft) {
            if (this.getxPosition() + this.getSpeed() < this.getHandler().getGame().getDisplayWidth()) {
                move(this.getSpeed());
            } else {
                _movingLeft = true;
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
            if (horizontalCollision()) {
               ((GameState)State.getState()).getPlayerActionManager().takeDamage(-1);
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
            if (this.getHealthBar() == -1) {
                return;
            }
            if (checkVerticalCollision()) {
                this.setHealthBar(-1);
            }
        }
    }

    /**
     * This method check if there is a right horizontal collision between the
     * character and the enemy. A left collision is the collision between the
     * right part of the player and the left part of the enemy
     *
     * @return true if there is a horizontal collision, false otherwise
     */
    public boolean rightHorizontalCollision() {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            PlayerCharacter player = gamestate.getPlayer();
            int px = player.getPosition().getFirstElement(); //x position
            int py = player.getPosition().getSecondElement();
            int pw = player.getDimension().getFirstElement(); //width
            int ph = player.getDimension().getSecondElement();
            int ex = this.getPosition().getFirstElement(); // x position
            int ey = this.getPosition().getSecondElement();
            int ew = this.getDimension().getFirstElement(); //width
            int eh = this.getDimension().getSecondElement();
            Rectangle rect = new Rectangle(px + pw - 2, py, 2, pw);

            if (((ex == px + pw) && ((py + ph <= ey + eh) && (py + ph >= ey))) || rect.intersects(new Rectangle(ex, ey, 2, eh))) {
                if ((ex + ew - px) > (px - ex)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method check if there is a left horizontal collision between the
     * character and the enemy. A left collision is the collision between the
     * left part of the player and the right part of the enemy
     *
     * @return true if there is a horizontal collision, false otherwise
     */
    public boolean leftHorizontalCollision() {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            PlayerCharacter player = gamestate.getPlayer();
            int px = player.getPosition().getFirstElement(); //x position
            int py = player.getPosition().getSecondElement();
            int pw = player.getDimension().getFirstElement(); //width
            int ph = player.getDimension().getSecondElement();
            int ex = this.getPosition().getFirstElement(); // x position
            int ey = this.getPosition().getSecondElement();
            int ew = this.getDimension().getFirstElement(); //width
            int eh = this.getDimension().getSecondElement();

            Rectangle rect = new Rectangle(px, py, 2, ph);
            if (((ex + ew) == px && ((py + ph) <= (ey + eh) && (py + ph) >= ey)) || rect.intersects(new Rectangle(ex + ew - 2, ey, 2, eh))) {
                if (((px + pw) - (ex + ew)) > (ex + ew - px)) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * This method check if there is a horizontal collision between the
     * character and the enemy.
     *
     * @return true if there is a horizontal collision, false otherwise
     */
    public boolean horizontalCollision() {
        return leftHorizontalCollision() || rightHorizontalCollision();
    }

    /**
     * This method check if there is a vertical collision between the character
     * and the enemy.
     *
     * @return true if there is a vertical collision, false otherwise
     */
    public boolean checkVerticalCollision() {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            PlayerCharacter player = gamestate.getPlayer();
            int px = player.getPosition().getFirstElement(); //x position
            int py = player.getPosition().getSecondElement();
            int pw = player.getDimension().getFirstElement(); //width
            int ph = player.getDimension().getSecondElement();
            int ex = this.getPosition().getFirstElement(); // x position
            int ey = this.getPosition().getSecondElement();
            int ew = this.getDimension().getFirstElement(); //width
            int eh = this.getDimension().getSecondElement();
            Rectangle rect = new Rectangle(player.getxPosition(), py, player.getDimension().getFirstElement(), ph);
            if (ey == (py + ph) && ((px >= ex && px <= ex + ew) || (px + pw >= ex && px + pw <= ex + ew)) || rect.intersects(new Rectangle(ex + 2, ey, ew - 4, 2))) {
                if ((ey + eh - py - ph) > (py + ph - ey)) {
                    return true;
                }
            }

        }
        return false;
    }
}
