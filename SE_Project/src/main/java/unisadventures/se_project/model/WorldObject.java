package unisadventures.se_project.Model;

import unisadventures.se_project.util.Pair;

public abstract class WorldObject {
    
    /* Little convention reminder:
     * x and y refer to the position of the upper left corner of the object.
     * The x axis goes left-right, and the y axis goes top-down.
     * height/width correspond to the hitbox of the character.
     */
    
    
    protected double _xPosition;  // Because position may vary in some objects
    protected double _yPosition;  // (may not be the cleanest option, refactor?)
    
    private final double _width;
    private final double _height;
    
    public WorldObject(double xPosition, double yPosition, double width, double height){
        _xPosition = xPosition;
        _yPosition = yPosition;
        _width = width;
        _height = height;

    }
    
    // Output as (xPosition, yPosition)
    public Pair<Double, Double> getPosition() {
        Pair<Double, Double> positionPair = new Pair<>(_xPosition, _yPosition);
        return positionPair;
    }
    
    // Output as (width, height)
    public Pair<Double, Double> getDimension() {
         Pair<Double, Double> dimensionPair = new Pair<>(_width, _height);
        return dimensionPair;
    }
    
    // No need to put a setPosition method at this level
    
}
