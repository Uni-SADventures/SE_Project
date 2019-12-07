
package unisadventures.se_project.model;

import java.awt.Graphics;
import unisadventures.se_project.util.Pair;

public abstract class WorldObject {

    protected double _xPosition;  // Because position may vary in some objects
    protected double _yPosition;  // (may not be the cleanest option, refactor?)
    private final double _height;
    private final double _width;

    public WorldObject(double x, double y, double height, double width) {
        _xPosition = x;
        _yPosition = y;
        _height = height;
        _width = width;;
    }

    public void setxPosition(double _xPosition) {
        this._xPosition = _xPosition;
    }

    public void setyPosition(double _yPosition) {
        this._yPosition = _yPosition;
    }

    public Pair<Double, Double> getPosition() {
        Pair<Double, Double> positionPair = new Pair<>(_xPosition, _yPosition);
        return positionPair;
    }

    public Pair<Double, Double> getDimension() {
        Pair<Double, Double> dimensionPair = new Pair<>(_width, _height);
        return dimensionPair;
    }

    // Are you SURE this is common to all elements that extend WorldObject?
    // Will a platform really need a tick method?
    // If not, put them in an interface!
    
    public abstract void tick();

    public abstract void render(Graphics g);

}

