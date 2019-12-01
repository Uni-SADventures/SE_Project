package unisadventures.se_project.Model;

import unisadventures.se_project.util.Pair;

public abstract class WorldObject {
    
    protected int _xPosition;  // Because position may vary in some objects
    protected int _yPosition;  // (may not be the cleanest option, refactor?)
    private final int _height;
    private final int _width;
    
    public WorldObject(int xPosition, int yPosition, int height, int width){
        _xPosition = xPosition;
        _yPosition = yPosition;
        _height = height;
        _width = width;
    }
    
    public Pair<Integer, Integer> getPosition() {
        Pair<Integer, Integer> positionPair = new Pair<>(_xPosition, _yPosition);
        return positionPair;
    }
    
    public Pair<Integer, Integer> getDimension() {
         Pair<Integer, Integer> dimensionPair = new Pair<>(_width, _height);
        return dimensionPair;
    }
    
    // No need to put a setPosition method at this level
    
}
