package unisadventures.se_project.model.basicObjects;



import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import unisadventures.se_project.util.CollectibleType;

public class CollectibleItem implements CollectibleItemInterface {
    
    private LinkedList<Integer> _imageFileNameList;
    private final CollectibleType _type;
    private int _counter;
    private int _xPosition ;
    private int _yPosition;
    private int _height ;
    private int _width ;
    
    
    public CollectibleItem(int xPosition, int yPosition, int height, int width, CollectibleType type) {
        _xPosition = xPosition ;
        _yPosition = yPosition ;
        _height = height ;
        _width = width ;
        _type = type;
        _counter = 0;
        _imageFileNameList = new LinkedList<>() ;
    }
    
    @Override
    public int getNextImageFileName() {
        if(_imageFileNameList.isEmpty())
            return 0;
        _counter++;
        int temp = _imageFileNameList.get((_counter-1)%_imageFileNameList.size());
        return temp;
    }
    @Override
    public CollectibleType getCollectibleType() {
        return _type;
    }

    public void setImageFileNameList(List<Integer> _imageFileNameList) {
        this._imageFileNameList = (LinkedList<Integer>) _imageFileNameList;
    }

    public int getxPosition() {
        return _xPosition;
    }

    public int getyPosition() {
        return _yPosition;
    }

    public int getWidth() {
        return _width;
    }

    public CollectibleType getType() {
        return _type;
    }

    public int getHeight() {
        return _height;
    }

    public void setxPosition(int _xPosition) {
        this._xPosition = _xPosition;
    }

    public void setyPosition(int _yPosition) {
        this._yPosition = _yPosition;
    }
    
    
    
    
    
    
    
    
    public void resetCounter(){
        _counter = 0 ;
    }


    
}
