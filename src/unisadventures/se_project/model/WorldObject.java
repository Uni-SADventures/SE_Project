
package unisadventures.se_project.model;

import unisadventures.se_project.util.Pair;



/**
 * This class represents every element present in a world level, may it be
 * a character ora a static/dynamic object
 * It keeps track of its position and its dimension
 * @author Emilio
 */
public abstract class WorldObject {

    protected int _xPosition;  // Because position may vary in some objects
    protected int _yPosition;  // (may not be the cleanest option, refactor?)
    private final int _height;
    private final int _width;

    public WorldObject(int x, int y, int height, int width) {
        _xPosition = x;
        _yPosition = y;
        _height = height;
        _width = width;;
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

    // Are you SURE this is common to all elements that extend WorldObject?
    // Will a platform really need a tick method?
    // If not, put them in an interface!
    
    //EMILIO: I dunno, lets see if we may use it with moving platforms or interactive
    //objects, if useless we can delete it and put it when necessary
    
    public abstract void tick();
    
    public abstract void takeDamage(int dam) ;
    public abstract String getCurrentSprite() ;
    

}

