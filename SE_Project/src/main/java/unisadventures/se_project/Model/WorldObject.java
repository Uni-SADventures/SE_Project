package unisadventures.se_project.Model;

import unisadventures.se_project.util.Pair;

public abstract class WorldObject {
    
    protected double _xPosition;  // Because position may vary in some objects
    protected double _yPosition;  // (may not be the cleanest option, refactor?)
    private final double _height;
    private final double _width;
    
    public WorldObject(double xPosition, double yPosition, double height, double width){
        _xPosition = xPosition;
        _yPosition = yPosition;
        _height = height;
        _width = width;
    }
    
    public Pair<Double, Double> getPosition() {
        Pair<Double, Double> positionPair = new Pair<>(_xPosition, _yPosition);
        return positionPair;
    }
    
    public Pair<Double, Double> getDimension() {
         Pair<Double, Double> dimensionPair = new Pair<>(_width, _height);
        return dimensionPair;
    }
    
    // No need to put a setPosition method at this level
    
}
