package unisadventures.se_project.model.character;

import java.awt.Graphics;
import unisadventures.se_project.model.WorldObject;
import java.util.*;
import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.util.Pair;
import unisadventures.se_project.view.gfx.Assets;

public abstract class BasicCharacter extends WorldObject implements MovementsInterface {
    
    // I put underscores in front of all attribute to avoid this.randomAttribute = randomAttribute

    private CharacterType _typeOfCharacter; // changed from name to typeOfCharacter
    private int _healthBar;
    private int _strength;  // For future reference, "strength" is spelled with "th", not "ht"
    private int _maxHealth;
    private double _maxJump;
    private double _initJump;
    private double _speed;
    private DirectionType _facing ;

    
    private Pair<Boolean, Integer> _walking;
    private Pair<Boolean, Integer> _jumping;
    private Pair<Boolean, Integer> _falling;
    private Pair<Boolean, Integer> _idling;
    private Pair<Boolean, Integer> _punching;
    private Pair<Boolean, Integer> _beingDamaged;
    
    //all the sets of sprites
    private Pair<List<String>, List<String>> _walk;
    private Pair<List<String>, List<String>> _jump;
    private Pair<List<String>, List<String>> _fall;
    private Pair<List<String>, List<String>> _idle;
    private Pair<List<String>, List<String>> _punch;
    private Pair<List<String>, List<String>> _beDamaged;

    public BasicCharacter(double xPosition, double yPosition, double height, double width, CharacterType type, int healthBar, int strength, int maxHealth, double maxJump) {
        super(xPosition, yPosition, height, width);
        _typeOfCharacter = type;
        _healthBar = healthBar;
        _strength = strength;
        _maxHealth = maxHealth;
        _maxJump = maxJump;
        _initJump = -1;
        _speed = 5;
        _facing = DirectionType.RIGHT ;
        
        _walking = new Pair(false,0) ;
        _jumping = new Pair(false,0) ;
        _falling = new Pair(false,0) ;
        _idling = new Pair(false,0) ;
        _punching = new Pair(false,0) ;
        _beingDamaged = new Pair(false,0) ;
        
        
    }
    
    // READ THIS COMMENT!!!
    // The following implementation completely ruins the single responsibility principle.
    // https://medium.com/@severinperez/writing-flexible-code-with-the-single-responsibility-principle-b71c4f3f883f
    
    // All below is a classic example of the State pattern. To refactor.

    public DirectionType getFacing() {
        return _facing;
    }

    public void setFacing(DirectionType facing) {
        _facing = facing;
    }

    public Pair<Boolean, Integer> getWalking() {
        return _walking;
    }

    public void setWalking(Pair<Boolean, Integer> walking) {
        _walking = walking;
    }

    public Pair<Boolean, Integer> getJumping() {
        return _jumping;
    }

    public void setJumping(Pair<Boolean, Integer> jumping) {
        _jumping = jumping;
    }

    public Pair<Boolean, Integer> getFalling() {
        return _falling;
    }

    public void setFalling(Pair<Boolean, Integer> falling) {
        _falling = falling;
    }

    public Pair<Boolean, Integer> getIdling() {
        return _idling;
    }

    public void setIdling(Pair<Boolean, Integer> idling) {
        _idling = idling;
    }

    public Pair<Boolean, Integer> getPunching() {
        return _punching;
    }

    public void setPunching(Pair<Boolean, Integer> punching) {
        _punching = punching;
    }

    public Pair<Boolean, Integer> getBeingDamaged() {
        return _beingDamaged;
    }

    public void setBeingDamaged(Pair<Boolean, Integer> beingDamaged) {
        _beingDamaged = beingDamaged;
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
        if (d == DirectionType.LEFT) {
            return _beDamaged.getFirstElement();
        } else if (d == DirectionType.RIGHT) {
            return _beDamaged.getSecondElement();
        } else {
            return null;
        }
    }

    public List<String> getIdleSprites(DirectionType d) {
        if (d == DirectionType.LEFT) {
            return _idle.getFirstElement();
        } else if (d == DirectionType.RIGHT) {
            return _idle.getSecondElement();
        } else {
            return null;
        }
    }

    public List<String> getJumpSprites(DirectionType d) {
        if (d == DirectionType.LEFT) {
            return _jump.getFirstElement();
        } else if (d == DirectionType.RIGHT) {
            return _jump.getSecondElement();
        } else {
            return null;
        }
    }

    public List<String> getFallSprites(DirectionType d) {
        if (d == DirectionType.LEFT) {
            return _fall.getFirstElement();
        } else if (d == DirectionType.RIGHT) {
            return _fall.getSecondElement();
        } else {
            return null;
        }
    }

    public List<String> getPunchSprites(DirectionType d) {
        if (d == DirectionType.LEFT) {
            return _punch.getFirstElement();
        } else if (d == DirectionType.RIGHT) {
            return _punch.getSecondElement();
        } else {
            return null;
        }
    }

    public List<String> getWalkSprites(DirectionType d) {
        if (d == DirectionType.LEFT) {
            return _walk.getFirstElement();
        } else if (d == DirectionType.RIGHT) {
            return _walk.getSecondElement();
        } else {
            return null;
        }
    }
    
    // Some of the things below really should be implemented with the Command pattern...
    // E.g. not all emenies can jump! The Jump command should be separated!
    // To refactor.

    public double getMaxJump() {
        return _maxJump;
    }

    public void setMaxJump(double maxJump) {
        this._maxJump = maxJump;
    }

    public double getInitJump() {
        return _initJump;
    }

    public void setInitJump(double initJump) {
        this._initJump = initJump;
    }

    public double getSpeed() {
        return _speed;
    }

    public void setSpeed(double speed) {
        this._speed = speed;
    }

    public CharacterType getCharacterType() {  // Removed the corresponding set method.
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
    
    

    @Override
    public void move(double W, DirectionType d) {
    /*    final double charCenterX = this.getBoundsInLocal().getWidth() / 2;
        final double charCenterY = this.getBoundsInLocal().getHeight() / 2;

        double absolX = charCenterX + this.getLayoutX();
        double absolY = charCenterY + this.getLayoutY();

        if (d == DirectionType.LEFT) {
            absolX -= speed;
        } else if (d == DirectionType.RIGHT) {
            absolX += speed;
        }

        if (absolX - charCenterX >= 0
                && absolX + charCenterX <= W) {
            this.relocate(absolX - charCenterX, absolY - charCenterY);
        }*/
    }

    @Override
    public boolean jump(double H) {
/*
        final double charCenterX = getBoundsInLocal().getWidth() / 2;
        final double charCenterY = getBoundsInLocal().getHeight() / 2;

        double absolX = charCenterX + getLayoutX();
        double absolY = charCenterY + getLayoutY() - 10;
        if (this.initJump == -1) {
            this.initJump = H - absolY;
        }

        if (absolY - charCenterY >= 0
                && absolY + charCenterY <= H
                && (H - absolY) - initJump < maxJump) {

            relocate(absolX - charCenterX, absolY - charCenterY);
            return true;
        }
*/
        return false;
    }

    @Override
    public void takeDamage(int dam) {
        if (_healthBar > dam) {
            _healthBar -= dam;
        } else {
            die();
        }
    }

    public void die() {
        //when health goes to 0 we have to manage how to put away a life when we have a menu
    }

    @Override
    public boolean fall(double H) {
/*
        double charCenterX = getBoundsInLocal().getWidth() / 2;
        double charCenterY = getBoundsInLocal().getHeight() / 2;

        double absolX = charCenterX + getLayoutX();
        double absolY = charCenterY + getLayoutY() + 10;

        if (absolY + charCenterY <= H - 100) {

            relocate(absolX - charCenterX, absolY - charCenterY);
            return true;
        } else {
            initJump = -1;
            return false;
        }
*/
    return false ;
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) _xPosition, (int) _yPosition, null);
    }
}
