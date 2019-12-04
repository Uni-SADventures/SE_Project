
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

    public Pair<Double, Double> getPosition() {
        Pair<Double, Double> positionPair = new Pair<>(_xPosition, _yPosition);
        return positionPair;
    }

    public Pair<Double, Double> getDimension() {
        Pair<Double, Double> dimensionPair = new Pair<>(_width, _height);
        return dimensionPair;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}

