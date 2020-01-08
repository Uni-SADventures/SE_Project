package unisadventures.se_project.model.character;

import java.awt.Rectangle;
import java.util.List;
import unisadventures.se_project.model.basicObjects.CollectibleItem;
import unisadventures.se_project.model.basicObjects.Tile;
import unisadventures.se_project.presenter.states.GameState;
import unisadventures.se_project.presenter.states.LoadingState;
import unisadventures.se_project.presenter.states.State;
import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.util.Pair;

/**
 * Extension of BasicCharacter class to represent a character which is the one
 * beign used by the player
 *
 * @author Emilio
 */
public class Player {

    //general player variables
    private static Player player = null;
    private int _healthBar;
    private int _strength;
    private int _maxHealth;
    private int _maxJump;
    private int _speed;
    private DirectionType _facing;
    private int _xPosition;
    private int _yPosition;
    private int _height;
    private int _width;
    private Rectangle _bounds;
    private final String _username;
    private int _cfu;
    private int _lives;

    //all the sets of sprites for actions, with left and right versions
    private Pair<List<Integer>, List<Integer>> _walk;
    private Pair<List<Integer>, List<Integer>> _jump;
    private Pair<List<Integer>, List<Integer>> _fall;
    private Pair<List<Integer>, List<Integer>> _idle;
    private Pair<List<Integer>, List<Integer>> _punch;
    private Pair<List<Integer>, List<Integer>> _beDamaged;
    private int _actualId;
    //player states variables
    private boolean _walking, _jumping, _falling, _idling, _hitting, _beingDamaged;
    private boolean _leftcollision, _rightcollision, _verticalcollision;

    private Player(int xPosition, int yPosition, int height, int width, String username) {
        _username = username;
        _cfu = 0;
        _lives = 3;
        _xPosition = xPosition;
        _yPosition = yPosition;
        _height = height;
        _width = width;
        _healthBar = 6;
        _strength = 1;
        _maxHealth = 6;
        _maxJump = 170;
        _speed = 5;
        _facing = DirectionType.RIGHT;
        _bounds = new Rectangle(12, 0, _width - 18, _height);
        _walking = false;
        _jumping = false;
        _falling = true;
        _idling = true;
        _hitting = false;
        _beingDamaged = false;
        _leftcollision = false;
        _rightcollision = false;
        _verticalcollision = false;
    }

    public static Player getPlayer() {
        if (player == null) {
            player = new Player(90, 90, 64, 64, "me");
        }
        return player;
    }

    public int getHealthBar() {
        return _healthBar;
    }

    public void setHealthBar(int _healthBar) {
        this._healthBar = _healthBar;
    }

    public int getStrength() {
        return _strength;
    }

    public void setStrength(int _strength) {
        this._strength = _strength;
    }

    public int getMaxHealth() {
        return _maxHealth;
    }

    public void setMaxHealth(int _maxHealth) {
        this._maxHealth = _maxHealth;
    }

    public int getMaxJump() {
        return _maxJump;
    }

    public void setMaxJump(int _maxJump) {
        this._maxJump = _maxJump;
    }

    public int getSpeed() {
        return _speed;
    }

    public void setSpeed(int _speed) {
        this._speed = _speed;
    }

    public DirectionType getFacing() {
        return _facing;
    }

    public void setFacing(DirectionType _facing) {
        this._facing = _facing;
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

    public Rectangle getBounds() {
        return _bounds;
    }

    public void setBounds(Rectangle _bounds) {
        this._bounds = _bounds;
    }

    public int getWidth() {
        return _width;
    }

    public void setWidth(int _width) {
        this._width = _width;
    }

    public Pair<List<Integer>, List<Integer>> getWalk() {
        return _walk;
    }

    public void setWalk(List<Integer> left, List<Integer> right) {
        _walk = new Pair(left, right);
    }

    public Pair<List<Integer>, List<Integer>> getJump() {
        return _jump;
    }

    public void setJump(List<Integer> left, List<Integer> right) {
        _jump = new Pair(left, right);
    }

    public Pair<List<Integer>, List<Integer>> getFall() {
        return _fall;
    }

    public void setFall(List<Integer> left, List<Integer> right) {
        _fall = new Pair(left, right);
    }

    public Pair<List<Integer>, List<Integer>> getIdle() {
        return _idle;
    }

    public void setIdle(List<Integer> left, List<Integer> right) {
        _idle = new Pair(left, right);
    }

    public Pair<List<Integer>, List<Integer>> getPunch() {
        return _punch;
    }

    public void setPunch(List<Integer> left, List<Integer> right) {
        _punch = new Pair(left, right);
    }

    public Pair<List<Integer>, List<Integer>> getBeDamaged() {
        return _beDamaged;
    }

    public void setBeDamaged(List<Integer> left, List<Integer> right) {
        _beDamaged = new Pair(left, right);
    }

    public boolean isLeftcollision() {
        return _leftcollision;
    }

    public void setLeftcollision(boolean _leftcollision) {
        this._leftcollision = _leftcollision;
    }

    public boolean isRightcollision() {
        return _rightcollision;
    }

    public void setRightcollision(boolean _rightcollision) {
        this._rightcollision = _rightcollision;
    }

    public boolean isVerticalcollision() {
        return _verticalcollision;
    }

    public void setVerticalcollision(boolean _verticalcollision) {
        this._verticalcollision = _verticalcollision;
    }

    public int getCfu() {
        return _cfu;
    }

    public void setCfu(int _cfu) {
        this._cfu = _cfu;
    }

    public int getLives() {
        return _lives;
    }

    public void setLives(int _lives) {
        this._lives = _lives;
    }

    public int getActualId() {
        return _actualId;
    }

    public void setActualId(int _actualId) {
        this._actualId = _actualId;
    }

    public boolean isWalking() {
        return _walking;
    }

    public void setWalking(boolean _walking) {
        this._walking = _walking;
    }

    public boolean isJumping() {
        return _jumping;
    }

    public void setJumping(boolean _jumping) {
        this._jumping = _jumping;
    }

    public boolean isFalling() {
        return _falling;
    }

    public void setFalling(boolean _falling) {
        this._falling = _falling;
    }

    public boolean isIdling() {
        return _idling;
    }

    public void setIdling(boolean _idling) {
        this._idling = _idling;
    }

    public boolean isHitting() {
        return _hitting;
    }

    public void setHitting(boolean _hitting) {
        this._hitting = _hitting;
    }

    public boolean isBeingDamaged() {
        return _beingDamaged;
    }

    public void setBeingDamaged(boolean _beingDamaged) {
        this._beingDamaged = _beingDamaged;
    }

    public void takeDamage(int dam) {
        if (this.getHealthBar() >= dam) {
            this.setHealthBar(this.getHealthBar() - dam);
        } else {
            if (_lives > 1) {
                _lives--;
                _jumping = false;
                this.setHealthBar(this.getMaxHealth());
                if (State.getState() instanceof GameState) {
                    GameState gstate = (GameState) State.getState();
                    State.setState(new LoadingState(gstate.getGame(), gstate.getId()));
                }
            } else {

            }
        }
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

    /**
     * This method execute basic idle action, useful when user is not giving
     * input and if its character is in a stable position
     */
    public int idle(int count) {
        if (!_idling) {
            count = 0;
            _idling = true;
        }
        count++;
        int length = this.getIdleSprites(this.getFacing()).size();
        _actualId = this.getIdleSprites(this.getFacing()).get(count % length);
        return count;
    }

    /**
     * This method moves a character one step on the left according to his speed
     */
    public int moveLeft(int count) {
        int tx = (int) (_xPosition - _speed + _bounds.x) / Tile.TILEWIDTH;
        if (!_walking) {
            count = 0;
            _walking = true;
        }
        if (!_leftcollision) {
            if (!collisionWithTile(tx, (int) (_yPosition + _bounds.y) / Tile.TILEHEIGHT)
                    && !collisionWithTile(tx, (int) (_yPosition + _bounds.y + _bounds.height) / Tile.TILEHEIGHT)) {
                _xPosition += _speed;
            } else {
                _xPosition = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - _bounds.x;
            }
            count++;
            int length = this.getWalkSprites(DirectionType.LEFT).size();
            _actualId = this.getWalkSprites(DirectionType.LEFT).get(count % length);
        }
        return count;
    }

    /**
     * This method moves a character one step on the right according to his
     * speed
     */
    public int moveRight(int count) {
        int tx = (int) (_xPosition + _speed + _bounds.x + _bounds.width) / Tile.TILEWIDTH;
        if (!_walking) {
            count = 0;
            _walking = true;
        }
        if (!_rightcollision) {
            if (!collisionWithTile(tx, (int) (_yPosition + _bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (_yPosition + _bounds.y + _bounds.height) / Tile.TILEHEIGHT)) {
                _xPosition += _speed;
            } else {
                _xPosition = tx * Tile.TILEWIDTH - _bounds.x - _bounds.width - 1;
            }
            count++;
            int length = this.getWalkSprites(DirectionType.RIGHT).size();
            _actualId = this.getWalkSprites(DirectionType.RIGHT).get(count % length);
        }
        return count;
    }

    /**
     * This method let a character jump one step up according to his speed
     */
    public int jump(int count) {
        if (!_jumping) {
            count = 0;
            _jumping = true;
        }

        int ty = (int) (_yPosition + _speed + _bounds.y + _bounds.height) / Tile.TILEHEIGHT;
        if (!collisionWithTile((int) (_xPosition + _bounds.x) / Tile.TILEWIDTH, ty)
                && !collisionWithTile((int) (_xPosition + _bounds.x + _bounds.width) / Tile.TILEWIDTH, ty)) {
            _yPosition += ((int) _speed * 1.17);
            count++;
            _jumping = true;

        } else {
            _yPosition = (ty * Tile.TILEHEIGHT - _bounds.y - _bounds.height - 1);
            count = 0;
            _jumping = false;

        }
        int length = this.getJumpSprites(this.getFacing()).size();
        _actualId = this.getJumpSprites(this.getFacing()).get(count % length);
        return count;
    }

    /**
     * This method let the character begin or continue his attack move.
     *
     * @return the image id for the next image to be displayed
     */
    public int attack(int count) {
        if (!_hitting) {
            count = 0;
            _hitting = true;
        }

        count++;
        int length = this.getPunchSprites(this.getFacing()).size();
        _actualId = this.getPunchSprites(this.getFacing()).get(count % length);
        return count;
    }

    /**
     * This method let a character fall one step down according to his speed
     */
    public int fall(int count) {

        if (!collisionWithTile(_xPosition, _yPosition)) {
            System.exit(1);
        }

        if (!_falling) {
            count = 0;
            _falling = true;
        }
        int tx1 = (int) (_xPosition + _bounds.x) / Tile.TILEWIDTH;
        int tx2 = (int) (_xPosition + _bounds.x + _bounds.width) / Tile.TILEWIDTH;
        int ty = (int) (_yPosition + _speed + _bounds.y + _bounds.height) / Tile.TILEHEIGHT;
        if (!collisionWithTile(tx1, ty) && !collisionWithTile(tx2, ty)) {
            _yPosition += ((int) _speed * 1.17);
            count++;
            _falling = true;

        } else {
            _yPosition = ty * Tile.TILEHEIGHT - _bounds.y - _bounds.height - 1;
            count = 0;
            _falling = false;

        }
        int length = this.getFallSprites(this.getFacing()).size();
        _actualId = this.getFallSprites(this.getFacing()).get(count % length);
        return count;
    }

    /**
     * This method checks if a character has run into some collectible
     */
    public int grab(int count) {
        int chx = this.getxPosition(), chy = this.getyPosition(), chw = this.getWidth(), chh = this.getHeight();
        State state = State.getState();
        if (state instanceof GameState) {
            List<CollectibleItem> collectibles = (List<CollectibleItem>) ((GameState) state).getWorld().getCollectibles().clone();
            for (CollectibleItem coll : collectibles) {
                int collx = coll.getxPosition(), colly = coll.getyPosition(), collw = coll.getWidth(), collh = coll.getHeight();

                if (collx >= chx && (chx + chw) >= (collx + collw)
                        && colly >= chy && (chy + chh) >= (colly + collh)) {
                    ((GameState) state).getWorld().getCollectibles().remove(coll);
                    this.setCfu(this.getCfu() + 1);

                }
            }
        }
        return count;
    }

    
    private boolean collisionWithTile(int x, int y){
        if(State.getState() instanceof GameState){
            GameState state = (GameState)State.getState();
            return state.getWorld().getTile(x, y).isSolid();
        }else{
            return false;
        }
    }
}
