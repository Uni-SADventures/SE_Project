package unisadventures.se_project.model.character;

import java.util.*;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.model.character.actionCommands.ActionManager;

import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.util.Pair;

/**
 * This class represents the basilar character class needed for both enemy and
 * player It keeps a final CharacterType, to tell which type it is, actual and
 * max character health , its strenght and max jump height as maxjump, its speed
 * and even witch direction (left or right) is actually facing In the end there
 * are a lot of pairs of image paths in strings pair for every sprite needed for
 * every animation in both left and right directions
 *
 * @author Emilio
 */
public abstract class BasicCharacter {

    private final CharacterType _typeOfCharacter;
    private int _healthBar;
    private int _strength;
    private int _maxHealth;
    private int _maxJump;
    private int _speed;
    private DirectionType _facing;
    private int _xPosition;
    private int _yPosition;
    private int _height;
    private int _width ;
    //all the sets of sprites for actions, with left and right versions
    private Pair<List<Integer>, List<Integer>> _walk;
    private Pair<List<Integer>, List<Integer>> _jump;
    private Pair<List<Integer>, List<Integer>> _fall;
    private Pair<List<Integer>, List<Integer>> _idle;
    private Pair<List<Integer>, List<Integer>> _punch;
    private Pair<List<Integer>, List<Integer>> _beDamaged;

    private final Handler _handler;
    private final ActionManager _actions;
    

    public BasicCharacter(Handler hand, int xPosition, int yPosition, int height, int width, CharacterType type, int healthBar, int strength, int maxHealth, int maxJump) {
        _xPosition = xPosition;
        _yPosition = yPosition;
        _height = height;
        _width = width;
        _typeOfCharacter = type;
        _healthBar = healthBar;
        _strength = strength;
        _maxHealth = maxHealth;
        _maxJump = maxJump;
        _speed = 5;
        _facing = DirectionType.RIGHT;
        _handler = hand ;
        _actions = new ActionManager(_handler, this);

    }

    // READ THIS COMMENT!!!
    // The following implementation completely ruins the single responsibility principle.
    // https://medium.com/@severinperez/writing-flexible-code-with-the-single-responsibility-principle-b71c4f3f883f
    // All below is a classic example of the State pattern. To refactor.
    //Emilio: I don't know what do you mean, for now all actions movements and states and other similiar fanfares have been moved to different
    //classes. If needed we can refractor of course
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
                    return _beDamaged.getFirstElement();
                case RIGHT:
                    return _beDamaged.getSecondElement();
                default:
                    return null;
            }
        }
    }

    public Handler getHandler() {
        return _handler;
    }

    public List<Integer> getIdleSprites(DirectionType d) {
        if (null == d) {
            return null;
        } else {
            switch (d) {
                case LEFT:
                    return _idle.getFirstElement();
                case RIGHT:
                    return _idle.getSecondElement();
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
                    return _jump.getFirstElement();
                case RIGHT:
                    return _jump.getSecondElement();
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
                    return _fall.getFirstElement();
                case RIGHT:
                    return _fall.getSecondElement();
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
                    return _punch.getFirstElement();
                case RIGHT:
                    return _punch.getSecondElement();
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
                    return _walk.getFirstElement();
                case RIGHT:
                    return _walk.getSecondElement();
                default:
                    return null;
            }
        }
    }

    public int getMaxJump() {
        return _maxJump;
    }

    public void setMaxJump(int maxJump) {
        this._maxJump = maxJump;
    }

    public int getSpeed() {
        return _speed;
    }

    public void setSpeed(int speed) {
        this._speed = speed;
    }

    public CharacterType getCharacterType() {
        return _typeOfCharacter;
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

    /**
     *
     * @param dam
     */
  
    public void takeDamage(int dam) {
        if (_healthBar > dam) {
            _healthBar -= dam;
        } else {
            die();
        }
    }

    /**
     * It substracts one life from the character and, if the character is a
     * player and ther is no any other life present, it brings to game over
     */
    public void die() {
        //when health goes to 0 we have to manage how to put away a life when we have a menu
    }

    /**
     * Method called every time it is the moment to update all actions.
     */

   
    

    public int getCurrentSprite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setxPosition(int _xPosition) {
        this._xPosition = _xPosition;
    }

    public void setyPosition(int _yPosition) {
        this._yPosition = _yPosition;
    }

    /**
     * 
     * @return position x and y as a pair
     */
    public Pair<Integer, Integer> getPosition() {
        Pair<Integer, Integer> positionPair = new Pair<>(_xPosition, _yPosition);
        return positionPair;
    }

    /**
     * 
     * @return width and heigth as a pair
     */
    public Pair<Integer, Integer> getDimension() {
        Pair<Integer, Integer> dimensionPair = new Pair<>(_width, _height);
        return dimensionPair;
    }

    
 public int getxPosition() {
        return _xPosition;
    }

    public int getyPosition() {
        return _yPosition;
    }
    
   
}
