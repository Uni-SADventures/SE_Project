package unisadventures.se_project.model.character;

import java.awt.Rectangle;
import unisadventures.se_project.presenter.states.*;

/**
 * This is the main class of the enemy of type zombie. it implements the methods
 * for attacking, receiving attacks from the character and movement
 *
 * @author Paolo Emanuela
 */
public class ZombieEnemy extends BasicEnemy {



    public ZombieEnemy(int xPosition, int yPosition, int height, int width) {
        super(xPosition, yPosition, height, width);
    }

    /**
     * This method implements the movement pattern of the zombie enemy. it moves
     * left and right without stopping
     */
    @Override
    public void movement() {

        if (!_moving) {
            _moving = true;
            _movingLeft = true;
        }
        //change direction after a collision with the player
        if (rightHorizontalCollision()) {
            if (_movingLeft) {
                move(-this.getSpeed());
                return;
            } else {
                _movingLeft = false;
                move(this.getSpeed());
                return;
            }
        }
        if (leftHorizontalCollision()) {
            if (_movingLeft) {
                _movingLeft = false;
                move(this.getSpeed());
                return;
            } else {
                move(this.getSpeed());
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
            GameState state = (GameState)State.getState();
            if (this.getxPosition() + this.getSpeed() < _maxMovement) {
                move(this.getSpeed());
            } else {
                _movingLeft = true;
                move(-this.getSpeed());
            }
        }
    }

    
    
}
