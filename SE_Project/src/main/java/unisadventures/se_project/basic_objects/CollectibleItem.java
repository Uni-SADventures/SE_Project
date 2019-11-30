/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.basic_objects;

import unisadventures.se_project.basic_objects.CollectibleItemInterface;
import java.util.ArrayList;
import unisadventures.se_project.util.Pair;
import unisadventures.se_project.util.CollectibleType;
/**
 *
 * @author arno
 */
public class CollectibleItem implements CollectibleItemInterface{
    
    private int _xPosition;
    private int _yPosition;
    private int _height;
    private int _width;
    private ArrayList<String> _imageFileNameList;
    private CollectibleType _type;
    private int _listSize;
    private int _counter;
    
    public CollectibleItem(int xPosition, int yPosition, int height, int width, ArrayList<String> imageFileNameList, CollectibleType type) {
        _xPosition = xPosition;
        _yPosition = yPosition;
        _height = height;
        _width = width;
        _imageFileNameList = imageFileNameList;
        _type = type;
        _listSize = _imageFileNameList.size();
        _counter = 0;
    }
    
    public Pair<Integer, Integer> getPosition() {
        Pair<Integer, Integer> positionPair = new Pair<Integer, Integer>(_xPosition, _yPosition);
        return positionPair;
    }
    
    public Pair<Integer, Integer> getDimension() {
         Pair<Integer, Integer> dimensionPair = new Pair<Integer, Integer>(_width, _height);
        return dimensionPair;
    }
    
    public String getNextImageFileName() {
        int nextIndex = _counter;
        _counter++;
        if(_counter == _listSize) {
            _counter = 0;
           
        }
        return _imageFileNameList.get(nextIndex);
    }
    public CollectibleType getCollectibleType() {
        return _type;
    }
    
}
