package unisadventures.se_project.model.character;

import unisadventures.se_project.model.WorldObject;
import java.util.*;
import unisadventures.se_project.model.Handler;
import unisadventures.se_project.model.character.actionCommands.ActionManager;
import unisadventures.se_project.presenter.launcher.Game;
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
public abstract class BasicCharacter extends WorldObject {

    private final CharacterType _typeOfCharacter;
    private int _healthBar;
    private int _strength;
    private int _maxHealth;
    private int _maxJump;
    private int _speed;
    private DirectionType _facing;

    //all the sets of sprites for actions, with left and right versions
    private Pair<List<String>, List<String>> _walk;
    private Pair<List<String>, List<String>> _jump;
    private Pair<List<String>, List<String>> _fall;
    private Pair<List<String>, List<String>> _idle;
    private Pair<List<String>, List<String>> _punch;
    private Pair<List<String>, List<String>> _beDamaged;

    private final Handler _handler;
    private final ActionManager _actions;
    

    public BasicCharacter(Handler hand, int xPosition, int yPosition, int height, int width, CharacterType type, int healthBar, int strength, int maxHealth, int maxJump) {
        super(xPosition, yPosition, height, width);
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

    public void setBeDamaged(List<String> left, List<String> right) {
        _beDamaged = new Pair(left, right);
    }

    public void setWalk(List<String> left, List<String> right) {
        _walk = new Pair(left, right);
    }

    public void setIdle(List<String> left, List<String> right) {
        _idle = new Pair(left, right);
    }

    public void setPunch(List<String> left, List<String> right) {
        _punch = new Pair(left, right);
    }

    public void setJump(List<String> left, List<String> right) {
        _jump = new Pair(left, right);
    }

    public void setFall(List<String> left, List<String> right) {
        _fall = new Pair(left, right);
    }

    public List<String> getBeDamagedSprites(DirectionType d) {
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

    public List<String> getIdleSprites(DirectionType d) {
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

    public CharacterType getTypeOfCharacter() {
        return _typeOfCharacter;
    }

    public Pair<List<String>, List<String>> getWalk() {
        return _walk;
    }

    public Pair<List<String>, List<String>> getJump() {
        return _jump;
    }

    public Pair<List<String>, List<String>> getFall() {
        return _fall;
    }

    public Pair<List<String>, List<String>> getIdle() {
        return _idle;
    }

    public Pair<List<String>, List<String>> getPunch() {
        return _punch;
    }

    public Pair<List<String>, List<String>> getBeDamaged() {
        return _beDamaged;
    }

    public ActionManager getActions() {
        return _actions;
    }

    public int getxPosition() {
        return _xPosition;
    }

    public int getyPosition() {
        return _yPosition;
    }
    

    public List<String> getJumpSprites(DirectionType d) {
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

    public List<String> getFallSprites(DirectionType d) {
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

    public List<String> getPunchSprites(DirectionType d) {
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

    public List<String> getWalkSprites(DirectionType d) {
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
    @Override
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
    @Override
    public void tick() {
System.out.println("dawefedwqdfqfewf");
        //  _game.start();
        _actions.execute();

    }
    
    
   @Override
    public String getCurrentSprite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
