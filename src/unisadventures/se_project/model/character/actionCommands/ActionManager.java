/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import unisadventures.se_project.model.basicObjects.CollectibleItem;
import unisadventures.se_project.model.basicObjects.Tile;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.model.character.EnemyCharacter;
import unisadventures.se_project.model.character.MovementsInterface;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.model.character.ProfessorEnemy;
import unisadventures.se_project.presenter.states.GameState;
import unisadventures.se_project.presenter.states.State;
import unisadventures.se_project.util.CollectibleType;
import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.presenter.audio.AudioManager;

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
    private final LinkedList <PowerupCommand> _powerups ;

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
        _powerups = new LinkedList<>() ;
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
            handlePowerups() ;
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
            //_jumping = false;
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
            System.out.println("Jumping: False");
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
        if (_ch instanceof EnemyCharacter) {

            if (State.getState() instanceof GameState) {
                GameState gstate = (GameState) State.getState();
                PlayerCharacter player = gstate.getPlayer();
                if (horizontalCollision()) {
                    ((GameState) State.getState()).getPlayerActionManager().takeDamage(_ch.getStrength());
                }
            }

        } else {
            if (!_hitting) {
                _combat.resetCounter();
                _hitting = true;
            }

            _hitting = _combat.hit();
            int length = _ch.getPunchSprites(_ch.getFacing()).size();
            _actualId = _ch.getPunchSprites(_ch.getFacing()).get(_combat.getCount() % length);
        }
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
                if(coll.getType() == CollectibleType.CFU){
                    ((PlayerCharacter) _ch).setCfu(((PlayerCharacter) _ch).getCfu() + 1);
                    AudioManager.playCoinGrab();
                } else {
                    for(PowerupCommand p : _powerups)
                        if(p.getType() == coll.getType())
                            return ;
                    
                    if (coll.getType() == CollectibleType.COFFEE) {
                        AudioManager.playCoffeeSip();
                        PowerupCommand p = new PowerupCommand(_handler, _ch, 230, coll.getType());
                        _powerups.add(p);

                        p.managePowerup();
                    } else if (coll.getType() == CollectibleType.JETPACK) {
                        AudioManager.playJetpack();
                        PowerupCommand p = new PowerupCommand(_handler, _ch, 230, coll.getType());
                        _powerups.add(p);

                        p.managePowerup();
                    } else if (coll.getType() == CollectibleType.HEART) {
                        AudioManager.playHeartTaken();
                        PowerupCommand p = new PowerupCommand(_handler, _ch, 1, coll.getType());
                        _powerups.add(p);

                        p.managePowerup();
                    }



                    
                }

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
            for (ActionManager enemy : state.getEnemies()) {
                if (enemy.getCh() instanceof ProfessorEnemy) {
                    if (enemy.rightHorizontalCollision()) {
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
            for (ActionManager enemy : state.getEnemies()) {
                if (enemy.getCh() instanceof ProfessorEnemy) {
               
                    if (enemy.leftHorizontalCollision()) {
                        return true;
                    }
                }
            }
        }
        return false;
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
            int ex = _ch.getPosition().getFirstElement(); // x position
            int ey = _ch.getPosition().getSecondElement();
            int ew = _ch.getDimension().getFirstElement(); //width
            int eh = _ch.getDimension().getSecondElement();
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
            int ex = _ch.getPosition().getFirstElement(); // x position
            int ey = _ch.getPosition().getSecondElement();
            int ew = _ch.getDimension().getFirstElement(); //width
            int eh = _ch.getDimension().getSecondElement();

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
        return leftHorizontalCollision() || rightHorizontalCollision() ;
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
            int ex = _ch.getPosition().getFirstElement(); // x position
            int ey = _ch.getPosition().getSecondElement();
            int ew = _ch.getDimension().getFirstElement(); //width
            int eh = _ch.getDimension().getSecondElement();
            Rectangle rect = new Rectangle(player.getxPosition(), py, player.getDimension().getFirstElement(), ph);
            if (ey == (py + ph) && ((px >= ex && px <= ex + ew) || (px + pw >= ex && px + pw <= ex + ew)) || rect.intersects(new Rectangle(ex + 2, ey, ew - 4, 2))) {
                if ((ey + eh - py - ph) > (py + ph - ey)) {
                    return true;
                }
            }

        }
        return false;
    }
        //private boolean _walking, _jumping, _falling, _idling, _hitting, _beingDamaged;
    /**
     * This method implements the movement pattern of the zombie enemy. it moves
     * left and right without stopping
     */
    public void movement() {

        if (!_walking) {
            _walking = true;
        }
        //change direction after a collision with the player
        
        if (horizontalCollision()) {//QUI
            if (_ch.getFacing() == DirectionType.LEFT) {
                _ch.setFacing(DirectionType.RIGHT);
                moveRight();
                return;
            } else {
                System.out.println(_ch.getFacing());
                _ch.setFacing(DirectionType.LEFT) ;
                moveLeft();
                return;
            }
        }
        //change direction if it touches the edges of the world
        if (_walking && _ch.getFacing() == DirectionType.LEFT ) {
                if(_movement.wallOnLeft()){
                _ch.setFacing(DirectionType.RIGHT) ;
                moveRight() ;
                }else{
                moveLeft() ;  
        }

        } else if (_walking && _ch.getFacing() == DirectionType.RIGHT) {
                if(_movement.wallOnRight()){
                _ch.setFacing(DirectionType.LEFT) ;
                moveLeft();
            } else {
                moveRight();
            }
        }
        
    }  
            
            
        
       

    

    private void handlePowerups() {
        if(_powerups.isEmpty())
            return ;
        boolean active ;
        LinkedList<PowerupCommand> pu = (LinkedList<PowerupCommand>) _powerups.clone() ;
       int i = 0 ;
        for(PowerupCommand p: pu){
            active = p.managePowerup() ;
            if(!active)
                _powerups.remove(i) ;
            i++ ;
            
        }
        
     
    }

    public void setFacing(DirectionType directionType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setJumping(boolean _jumping) {
        this._jumping = _jumping;
    }
    
    

}
