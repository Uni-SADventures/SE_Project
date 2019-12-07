package unisadventures.se_project.model.character;

import java.awt.Graphics;
import unisadventures.se_project.model.WorldObject;
import java.util.*;
import unisadventures.se_project.model.character.actionCommands.ActionManager;
import unisadventures.se_project.model.character.actionCommands.MoveCommand;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.util.Pair;
import unisadventures.se_project.view.gfx.Assets;

public abstract class BasicCharacter extends WorldObject  {
    
    // I put underscores in front of all attribute to avoid this.randomAttribute = randomAttribute

    private CharacterType _typeOfCharacter; // changed from name to typeOfCharacter
    private int _healthBar;
    private int _strength;  // For future reference, "strength" is spelled with "th", not "ht"
    private int _maxHealth;
    private double _maxJump;
    private double _initJump;
    private double _speed;
    private DirectionType _facing ;


    
    //all the sets of sprites
    private Pair<List<String>, List<String>> _walk;
    private Pair<List<String>, List<String>> _jump;
    private Pair<List<String>, List<String>> _fall;
    private Pair<List<String>, List<String>> _idle;
    private Pair<List<String>, List<String>> _punch;
    private Pair<List<String>, List<String>> _beDamaged;
    
    private Game _game ;
    private ActionManager _actions ;

    public BasicCharacter(  Game game,double xPosition, double yPosition, double height, double width, CharacterType type, int healthBar, int strength, int maxHealth, double maxJump) {
        super(xPosition, yPosition, height, width);
        _typeOfCharacter = type;
        _healthBar = healthBar;
        _strength = strength;
        _maxHealth = maxHealth;
        _maxJump = maxJump;
        _initJump = -1;
        _speed = 5;
        _facing = DirectionType.RIGHT ;
        _game = game;
        _actions = new ActionManager(_game,this) ;
        
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
     public void tick() {
        
         _game.start();
      /*  if(!_game.getKeyManager().up && getJumping().getFirstElement() ){
            if(getJumping().getSecondElement() < 16)
               
                setFalling(new Pair(true,16-getJumping().getSecondElement()));
           
            setJumping(new Pair(false,0));
           // setFalling(new Pair(true,16-getJumping().getSecondElement()));
        //    if(getFalling().getSecondElement() == 16)
          //      setFalling(new Pair(false,0));
        }
         if (_game.getKeyManager().up && !getJumping().getFirstElement()) {
            int timeElapsed = getJumping().getSecondElement() ;
            setJumping(new Pair(true,timeElapsed + 1));
            _yPosition -= getSpeed() + timeElapsed;
            System.out.println("time elapsed " + getJumping().getSecondElement() + " postion " + _yPosition);
       
           // System.out.println("speed " + getSpeed() - timeElapsed + " postion " + _yPosition);
        }
        if (getJumping().getFirstElement() && !getFalling().getFirstElement() ) {
            int timeElapsed = getJumping().getSecondElement() ;
            setJumping(new Pair(true,timeElapsed + 1));
            
            if (timeElapsed == 15) {
                _yPosition -= getSpeed();
                
               //setJumping(new Pair(false,0));
                setFalling(new Pair(true,0));
                return;
            } else if (timeElapsed < 15)
                 _yPosition -= getSpeed();
           // speed -= 1;
            System.out.println("time elapsed " + getJumping().getSecondElement()+ " postion " + _yPosition);
        }
        
        
        if (getFalling().getFirstElement()) {
            int timeElapsed = getFalling().getSecondElement() ;
            setFalling(new Pair(true,timeElapsed + 1));
            
            if (timeElapsed == 15) {
                _yPosition += getSpeed();
                
                
                setFalling(new Pair(false,16));
                //setJumping(new Pair(false,0));
                return;
            } else if(timeElapsed < 15)
                _yPosition += getSpeed();
            
           // speed -= 1;
            System.out.println("time elapsed " + getFalling().getSecondElement()+ " postion " + _yPosition);
        }
    */
       _actions.execute();
    /*   
        MoveCommand move = new MoveCommand(_game, this) ;
        if (_game.getKeyManager().left)
            move.moveLeft();
        if (_game.getKeyManager().right)
            move.moveRight();
     */
    }
     
   
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) (_xPosition- _game.getCam().getxOffset()), (int) (_yPosition-_game.getCam().getyOffset()), null);
    }
}
