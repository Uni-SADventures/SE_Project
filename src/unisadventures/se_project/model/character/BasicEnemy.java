/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import java.awt.Rectangle;
import java.util.List;
import unisadventures.se_project.presenter.states.GameState;
import unisadventures.se_project.presenter.states.State;
import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.util.Pair;

/**
 * Extension of BasicCharacter class to represent a character which is the enemy
 * to overcome the player
 *
 * @author Francesco
 */
public class BasicEnemy implements Enemy {
    
    protected int _healthBar;
    protected int _strength;
    protected int _maxHealth;
    protected int _speed;
    private DirectionType _facing;
    protected int _xPosition;
    protected int _yPosition;
    protected int _height;
    protected int _width;
    protected boolean _moving;
    protected boolean _movingLeft;
    protected int _maxMovement;
    private Pair<List<Integer>, List<Integer>> _walk;
    private Pair<List<Integer>, List<Integer>> _jump;
    private Pair<List<Integer>, List<Integer>> _fall;
    private Pair<List<Integer>, List<Integer>> _idle;
    private Pair<List<Integer>, List<Integer>> _punch;
    private Pair<List<Integer>, List<Integer>> _beDamaged;
    
    public BasicEnemy(int xPosition, int yPosition, int height, int width) {
        _xPosition = xPosition;
        _yPosition = yPosition;
        _width = width;
        _height = height;
        _maxHealth = 6;
        _healthBar = _maxHealth;
        _speed = 1;
        _strength = 1;
        _moving = false;
        _movingLeft = false;
        _maxMovement = 800;
    }
    
    public void tick() {
        movement();
    }

    /**
     *
     * @param speed the speed at which the enemy moves* Move the enemy speed
     * pixels to the right. if speed is less than 0, it moves to the left
     */
    protected void move(int speed) {
        this.setxPosition(getxPosition() + speed);
    }

    /**
     * This method implements the movement pattern of the zombie enemy.it moves
     * left and right without stopping
     *
     * @param maxMovement
     */
    public void movement() {
        if (!_moving) {
            _moving = true;
            _movingLeft = true;
        }
        move(-this.getSpeed());
    }

    public int getxPosition() {
        return _xPosition;
    }
    
    public void setxPosition(int _xPosition) {
        this._xPosition = _xPosition;
    }
    
    public int getyPosition() {
        return _yPosition;
    }
    
    public void setyPosition(int _yPosition) {
        this._yPosition = _yPosition;
    }
    
    public int getHeight() {
        return _height;
    }
    
    public void setHeight(int _height) {
        this._height = _height;
    }
    
    public int getWidth() {
        return _width;
    }
    
    public void setWidth(int _width) {
        this._width = _width;
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
    
    public DirectionType getFacing() {
        return _facing;
    }
    
    public void setFacing(DirectionType facing) {
        _facing = facing;
    }
    
    public void setBeDamaged(List<Integer> left, List<Integer> right) {
        _beDamaged = new Pair(left, right);
    }
    
    public void setWalk(List<Integer> left, List<Integer> right) {
        _walk = new Pair(left, right);
    }
    
    public void setIdle(List<Integer> left, List<Integer> right) {
        _idle = new Pair(left, right);
    }
    
    public void setPunch(List<Integer> left, List<Integer> right) {
        _punch = new Pair(left, right);
    }
    
    public void setJump(List<Integer> left, List<Integer> right) {
        _jump = new Pair(left, right);
    }
    
    public void setFall(List<Integer> left, List<Integer> right) {
        _fall = new Pair(left, right);
    }
    
    public List<Integer> getBeDamagedSprites(DirectionType d) {
        if (null == d) {
            return null;
        } else {
            switch (d) {
                case LEFT:
                    return _beDamaged.getFirst();
                case RIGHT:
                    return _beDamaged.getSecond();
                default:
                    return null;
            }
        }
    }
    
    public List<Integer> getIdleSprites(DirectionType d) {
        if (null == d) {
            return null;
        } else {
            switch (d) {
                case LEFT:
                    return _idle.getFirst();
                case RIGHT:
                    return _idle.getSecond();
                default:
                    return null;
            }
        }
    }
    
    public List<Integer> getJumpSprites(DirectionType d) {
        if (null == d) {
            return null;
        } else {
            switch (d) {
                case LEFT:
                    return _jump.getFirst();
                case RIGHT:
                    return _jump.getSecond();
                default:
                    return null;
            }
        }
    }
    
    public List<Integer> getFallSprites(DirectionType d) {
        if (null == d) {
            return null;
        } else {
            switch (d) {
                case LEFT:
                    return _fall.getFirst();
                case RIGHT:
                    return _fall.getSecond();
                default:
                    return null;
            }
        }
    }
    
    public List<Integer> getPunchSprites(DirectionType d) {
        if (null == d) {
            return null;
        } else {
            switch (d) {
                case LEFT:
                    return _punch.getFirst();
                case RIGHT:
                    return _punch.getSecond();
                default:
                    return null;
            }
        }
    }
    
    public List<Integer> getWalkSprites(DirectionType d) {
        if (null == d) {
            return null;
        } else {
            switch (d) {
                case LEFT:
                    return _walk.getFirst();
                case RIGHT:
                    return _walk.getSecond();
                default:
                    return null;
            }
        }
    }
    
    public int getSpeed() {
        return _speed;
    }
    
    public void setSpeed(int speed) {
        this._speed = speed;
    }
    
    public int getHealthBar() {
        return _healthBar;
    }
    
    public void setHealthBar(int healthBar) {
        this._healthBar = healthBar;
    }
    
    public int getStrength() {
        return _strength;
    }
    
    public void setStrength(int strength) {
        _strength = strength;
    }
    
    public int getMaxHealth() {
        return _maxHealth;
    }
    
    public void setMaxHealth(int maxHealth) {
        _maxHealth = maxHealth;
    }
    
    public int getMaxMovement() {
        return _maxMovement;
    }
    
    public void setMaxMovement(int _maxMovement) {
        this._maxMovement = _maxMovement;
    }
    
    public Pair<List<Integer>, List<Integer>> getWalk() {
        return _walk;
    }
    
    public void setWalk(Pair<List<Integer>, List<Integer>> _walk) {
        this._walk = _walk;
    }
    
    public Pair<List<Integer>, List<Integer>> getJump() {
        return _jump;
    }
    
    public void setJump(Pair<List<Integer>, List<Integer>> _jump) {
        this._jump = _jump;
    }
    
    public Pair<List<Integer>, List<Integer>> getFall() {
        return _fall;
    }
    
    public void setFall(Pair<List<Integer>, List<Integer>> _fall) {
        this._fall = _fall;
    }
    
    public Pair<List<Integer>, List<Integer>> getIdle() {
        return _idle;
    }
    
    public void setIdle(Pair<List<Integer>, List<Integer>> _idle) {
        this._idle = _idle;
    }
    
    public Pair<List<Integer>, List<Integer>> getPunch() {
        return _punch;
    }
    
    public void setPunch(Pair<List<Integer>, List<Integer>> _punch) {
        this._punch = _punch;
    }
    
    public Pair<List<Integer>, List<Integer>> getBeDamaged() {
        return _beDamaged;
    }
    
    public void setBeDamaged(Pair<List<Integer>, List<Integer>> _beDamaged) {
        this._beDamaged = _beDamaged;
    }
    
}
