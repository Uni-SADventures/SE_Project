/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unisadventures.se_project.basic_objects;

import unisadventures.se_project.util.Pair;
import unisadventures.se_project.basic_objects.FixedImageObjectInterface;

/**
 *
 * @author arno
 */
public class Platform implements FixedImageObjectInterface {
    
    private int _xPosition;
    private int _yPosition;
    private int _height;
    private int _width;
    private String _imageFileName;
    
    public Platform(int xPosition, int yPosition, int height, int width, String imageFileName) {
    
        _xPosition = xPosition;
        _yPosition = yPosition;
        _height = height;
        _width = width;
        _imageFileName = imageFileName;
    }
    
    
    public Pair<Integer, Integer> getPosition() {
        Pair<Integer, Integer> positionPair = new Pair<Integer, Integer>(_xPosition, _yPosition);
        return positionPair;
    }
    
    public Pair<Integer, Integer> getDimension() {
         Pair<Integer, Integer> dimensionPair = new Pair<Integer, Integer>(_width, _height);
        return dimensionPair;
    }
    public String getImageFileName(){
        return _imageFileName;
    }
}
