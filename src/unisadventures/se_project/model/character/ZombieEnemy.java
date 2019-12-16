/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import java.awt.Rectangle;
import unisadventures.se_project.model.character.actionCommands.Command;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.presenter.states.GameState;
import unisadventures.se_project.presenter.states.State;
import unisadventures.se_project.util.CharacterType;

/**
 *
 * @author Paolo
 */
public class ZombieEnemy extends EnemyCharacter {

    private boolean _moving;
    private boolean _movingLeft;
    private Command _moveCommand;
    private Command _hitCommand;
    private Command _jumpCommand;

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

    public Command getMoveCommand() {
        return _moveCommand;
    }

    public Command getHitCommand() {
        return _hitCommand;
    }

    public Command getJumpCommand() {
        return _jumpCommand;
    }

    public void setMoveCommand(Command moveCommand) {
        _moveCommand = moveCommand;
    }

    public void setHitCommand(Command hitCommand) {
        _hitCommand = hitCommand;
    }

    public void setJumpCommand(Command jumpCommand) {
        _jumpCommand = jumpCommand;
    }


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
    private void movement() {
        if (!_moving) {
            _moving = true;
            _movingLeft = true;
        }
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

            if (checkVerticalCollision()) {
                this.setHealthBar(-1);
               // player.jump();
            }

        }
    }

    private boolean checkVerticalCollision() {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            PlayerCharacter player = gamestate.getPlayer();
            Rectangle rect = new Rectangle(player.getxPosition(), player.getyPosition(), player.getDimension().getFirstElement(), player.getDimension().getSecondElement());
            if (rect.intersects(new Rectangle(this.getxPosition(), this.getyPosition(), this.getDimension().getFirstElement(), this.getDimension().getSecondElement()))) {
                if (this.getyPosition() == player.getyPosition() + player.getDimension().getSecondElement()) {
                    return true;
                }
            }
        }
        return false;
    }
/*
    private boolean checkHorizontalCollision() {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            PlayerCharacter player = gamestate.getPlayer();
            int px = player.getPosition().getFirstElement();
            int pw = player.getDimension().getSecondElement();
            
            Rectangle rect = new Rectangle(player.getxPosition(), player.getyPosition(), player.getDimension().getFirstElement(), player.getDimension().getSecondElement());
            if (rect.intersects(new Rectangle(this.getxPosition(), this.getyPosition(), this.getDimension().getFirstElement(), this.getDimension().getSecondElement()))) {
                
            }
        }
        return false;
    }
*/
}
