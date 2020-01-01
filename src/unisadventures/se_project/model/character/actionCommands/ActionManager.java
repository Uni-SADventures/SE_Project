/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import java.util.List;
import unisadventures.se_project.model.basicObjects.CollectibleItem;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.model.character.EnemyCharacter;
import unisadventures.se_project.model.character.MovementsInterface;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.model.character.ZombieEnemy;
import unisadventures.se_project.presenter.states.GameState;
import unisadventures.se_project.presenter.states.State;
import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.view.display.AudioManager;

/**
 * This class manages all available actions and their relative dependancies. It
 * has every possible actions for a character. It keeps track of which action is
 * being executed with all booleans such as walking or jumping
 *
 * @author Emilio
 */
public class ActionManager implements MovementsInterface {

    private final MoveCommand _movement;
    private final VerticalCommand _jumpFall;
    private final IdleCommand _idle;
    private final HitCommand _combat;
    private final BeingDamagedCommand _beDamaged;
    private final Handler _handler;
    private final BasicCharacter _ch;
    private int _actualId;

    private boolean _walking, _jumping, _falling, _idling, _hitting, _beingDamaged;
    private int _incomingDamage;

    public ActionManager(Handler _handler, BasicCharacter _ch) {

        _walking = false;
        _jumping = false;
        _falling = false;
        _idling = false;
        _hitting = false;
        _beingDamaged = false;
        _incomingDamage = 0;

        this._handler = _handler;
        this._ch = _ch;
        _movement = new MoveCommand(_handler, _ch);
        _jumpFall = new VerticalCommand(_handler, _ch);
        _combat = new HitCommand(_handler, _ch);
        _idle = new IdleCommand(_handler, _ch);
        _beDamaged = new BeingDamagedCommand(_handler, _ch, 20);
        _actualId = 0;
    }

    /**
     * This method interprets user inputs if the character is user's one and if
     * not it checks what should a character do, for example if there is a floor
     * under their feet
     */
    @Override
    public void tick() {

        //_handler.getCam().centerOnEntity((PlayerCharacter)_ch);
        if (_ch instanceof PlayerCharacter) {
            if (!_jumping) {
                fall();
            }
            _handler.getCam().centerOnEntity((PlayerCharacter) _ch);
            if (_handler.getKeyManager().left) {

                moveLeft();
                _ch.setFacing(DirectionType.LEFT);
            } else if (_handler.getKeyManager().right) {
                moveRight();
                _ch.setFacing(DirectionType.RIGHT);
            } else {
                _walking = false;
            }

            if (_handler.getKeyManager().up && !_falling) {
                jump();
            } else if (!_handler.getKeyManager().up) {
                _jumping = false;
            }
            //   else if(!_hanlder.checkFloor(_ch.getPosition().getFirstElement(),_ch.getPosition().getSecondElement()))
            //    _jumpFall.fall();

            if (_handler.getKeyManager().hit && !_hitting) {
                attack();
            } else if(_hitting){
                attack() ;
            }
            grab();
        } else {
            if (!_jumping) {
                fall();
            }

        }

        if (!_walking && !_jumping && !_falling && !_hitting && !_beingDamaged) {
            idle();
        }

        if (_beingDamaged) {
   
            _beingDamaged = _beDamaged.takeDamage(_incomingDamage);
            
            int length = _ch.getBeDamagedSprites(_ch.getFacing()).size();
             _actualId = _ch.getBeDamagedSprites(_ch.getFacing()).get(_beDamaged.getCount() % length);

            
            if (_beingDamaged) {
                if (_ch.getFacing() == DirectionType.LEFT) {
                    _movement.moveRight();
                    jump();
                } else {
                    _movement.moveLeft();
                    jump() ;
                }
            } else {
                _incomingDamage = 0;
            }
             _actualId = _ch.getBeDamagedSprites(_ch.getFacing()).get(_beDamaged.getCount() % length);
        }

        //CHECKING IF THERE IS SOME COLLECTIBLE
    }

    /**
     *
     * @param dam is the sum to remove from character's actual health
     */
    @Override
    public void takeDamage(int dam) {
        if (!_beingDamaged) {
            _incomingDamage = dam;
         //   _jumping = false;
            _beingDamaged = true ;
        }
        
        
                
    }

    public BasicCharacter getCh() {
        return _ch;
    }

    /**
     * This method execute basic idle action, useful when user is not giving
     * input and if its character is in a stable position
     */
    public void idle() {
        if (!_idling) {
            _idle.resetCounter();
            _idling = true;
        }
        _idle.idle();
        int length = _ch.getIdleSprites(_ch.getFacing()).size();
        _actualId = _ch.getIdleSprites(_ch.getFacing()).get(_idle.getCount() % length);

    }

    /**
     * This method moves a character one step on the left according to his speed
     */
    @Override
    public void moveLeft() {
        if (!_walking) {
            _movement.resetCounter();
            _walking = true;
        }
        if (!leftCollisionEnemies()) {
            _movement.moveLeft();
            int length = _ch.getWalkSprites(DirectionType.LEFT).size();
            _actualId = _ch.getWalkSprites(DirectionType.LEFT).get(_movement.getCount() % length);
        }
    }

    /**
     * This method moves a character one step on the right according to his
     * speed
     */
    @Override
    public void moveRight() {
        if (!_walking) {
            _movement.resetCounter();
            _walking = true;
        }
        if (!rightCollisionEnemies()) {
            _movement.moveRight();
            int length = _ch.getWalkSprites(DirectionType.RIGHT).size();
            _actualId = _ch.getWalkSprites(DirectionType.RIGHT).get(_movement.getCount() % length);
        }

    }

    /**
     * This method let a character jump one step up according to his speed
     */
    @Override
    public void jump() {
        if (!_jumping) {
            _jumpFall.resetCounter();
            _jumping = true;
        }

        _jumping = _jumpFall.jump();
        int length = _ch.getJumpSprites(_ch.getFacing()).size();
        _actualId = _ch.getJumpSprites(_ch.getFacing()).get(_jumpFall.getCount() % length);
    }

    /**
     * This method let the character begin or continue his attack move.
     *
     * @return the image id for the next image to be displayed
     */
    @Override
    public void attack() {
        if (!_hitting) {
            _combat.resetCounter();
            _hitting = true;
        }

        _hitting = _combat.hit();
        int length = _ch.getPunchSprites(_ch.getFacing()).size();
        _actualId = _ch.getPunchSprites(_ch.getFacing()).get(_combat.getCount() % length);
    }

    /**
     * This method let a character fall one step down according to his speed
     */
    @Override
    public void fall() {

        if (!_jumpFall.collisionWithTile(_ch.getPosition().getFirstElement(), _ch.getPosition().getSecondElement())) {
            System.exit(1);
        }

        if (!_falling) {
            _jumpFall.resetCounter();
            _falling = true;
        }

        _falling = _jumpFall.fall();
        int length = _ch.getFallSprites(_ch.getFacing()).size();
        _actualId = _ch.getFallSprites(_ch.getFacing()).get(_jumpFall.getCount() % length);

    }

    /**
     * This method checks if a character has run into some collectible
     */
    @Override
    public void grab() {
        int chx = _ch.getxPosition(), chy = _ch.getyPosition(), chw = _ch.getDimension().getFirstElement(), chh = _ch.getDimension().getSecondElement();
        State state = State.getState();
        if (!(state instanceof GameState)) {
            return;
        }
        List<CollectibleItem> collectibles = (List<CollectibleItem>) ((GameState) state).getCollectibles().clone();
        for (CollectibleItem coll : collectibles) {
            int collx = coll.getxPosition(), colly = coll.getyPosition(), collw = coll.getWidth(), collh = coll.getHeight();

            if (collx >= chx && (chx + chw) >= (collx + collw)
                    && colly >= chy && (chy + chh) >= (colly + collh)) {
                ((GameState) state).getCollectibles().remove(coll);
                ((PlayerCharacter) _ch).setCfu(((PlayerCharacter) _ch).getCfu() + 1);
                AudioManager.playCoinGrab();

            }
        }
    }

    /**
     *
     * @param p is the actual character wich is going to change some of his
     * parameters and actions because of some powerup
     * @return decorated player character
     */
    @Override
    public PlayerCharacter getPowered(PlayerCharacter p) {
        //TODO once we have some powerups or weapons
        //it should return a decorated player character
        return null; // <- da levare
    }

    public int getActualId() {
        return _actualId;
    }

    /**
     * This method check if the player is colliding to the right with an enemy
     *
     * @return true if the player is colliding with an enemy, false otherwise
     */
    private boolean rightCollisionEnemies() {
        if (State.getState() instanceof GameState) {
            GameState state = (GameState) State.getState();
            for (EnemyCharacter enemy : state.getEnemies()) {
                if (enemy instanceof ZombieEnemy) {
                    ZombieEnemy zombie = (ZombieEnemy) enemy;
                    if (zombie.rightHorizontalCollision()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * This method check if the player is colliding to the left with an enemy
     *
     * @return true if the player is colliding with an enemy, false otherwise
     */
    private boolean leftCollisionEnemies() {
        if (State.getState() instanceof GameState) {
            GameState state = (GameState) State.getState();
            for (EnemyCharacter enemy : state.getEnemies()) {
                if (enemy instanceof ZombieEnemy) {
                    ZombieEnemy zombie = (ZombieEnemy) enemy;
                    if (zombie.leftHorizontalCollision()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
