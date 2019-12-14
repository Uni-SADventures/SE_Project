package unisadventures.se_project.model.basicObjects;



import java.awt.Graphics;
import java.util.ArrayList;
import unisadventures.se_project.util.CollectibleType;

public class CollectibleItem implements CollectibleItemInterface {
    
    private final ArrayList<String> _imageFileNameList;
    private final CollectibleType _type;
    private final int _listSize;
    private int _counter;
    private int _xPosition ;
    private int _yPosition;
    private int _height ;
    private int _width ;
    
    
    public CollectibleItem(int xPosition, int yPosition, int height, int width, ArrayList<String> imageFileNameList, CollectibleType type) {
        _xPosition = xPosition ;
        _yPosition = yPosition ;
        _height = height ;
        _width = width ;
        _imageFileNameList = imageFileNameList;
        _type = type;
        _listSize = _imageFileNameList.size();
        _counter = 0;
    }
    
    @Override
    public String getNextImageFileName() {
        int nextImageIndex = _counter;
        _counter++;
        if(_counter == _listSize) {
            _counter = 0;
           
        }
        return _imageFileNameList.get(nextImageIndex);
    }
    @Override
    public CollectibleType getCollectibleType() {
        return _type;
    }

    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public void takeDamage(int dam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCurrentSprite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
