
package unisadventures.se_project.model;

import unisadventures.se_project.util.Pair;



/**
 * This class represents every element present in a world level, may it be
 * a character ora a static/dynamic object
 * It keeps track of its position and its dimension
 */
public abstract class WorldObject {

    LevelManager _manager;
    protected double _xPosition;  // Because position may vary in some objects
    protected double _yPosition;  // (may not be the cleanest option, refactor?)
    private final double _height;
    private final double _width;
    
    

    public WorldObject(LevelManager manager, double x, double y, double height, double width) {
        _manager = manager;
        _xPosition = x;
        _yPosition = y;
        _height = height;
        _width = width;;
    }

    /**
     * 
     * @return position x and y as a pair
     */
    public Pair<Double, Double> getPosition() {
        Pair<Double, Double> positionPair = new Pair<>(_xPosition, _yPosition);
        return positionPair;
    }

    /**
     * 
     * @return width and heigth as a pair
     */
    public Pair<Double, Double> getDimensions() {
        Pair<Double, Double> dimensionPair = new Pair<>(_width, _height);
        return dimensionPair;
    }
    
    /**
     * Compute the next frame of the object
     */
    public abstract void tick();
    
    /**
     * Resolve the reception of damage by the object (might have no effect)
     * @param damage 
     */
    public abstract void takeDamage(int damage);
    
    
    public abstract String getCurrentSprite();

    

}

