package unisadventures.se_project.model.basicObjects;


import java.util.LinkedList;

public class DestructibleObject implements DestructibleObjectInterface {
    
    private LinkedList<Integer> _imageFileNameList;
    private int _nextImageIndex;
    private static final int INTACT_OBJECT_IMAGE_FILE_NAME_INDEX = 0;
    private int _xPosition ;
    private int _yPosition;
    private final int _height ;
    private final int _width ;
    
    
    public DestructibleObject(int xPosition, int yPosition, int height, int width) {
        _xPosition = xPosition ;
        _yPosition = yPosition ;
        _height = height ;
        _width = width ;
        _imageFileNameList = new LinkedList<>();
        _nextImageIndex = 0;
    }
    
    @Override
    public int getIntactImageFileName() {
        return _imageFileNameList.get(INTACT_OBJECT_IMAGE_FILE_NAME_INDEX);
    }
    
    @Override
    public int getNextDestructionImageFileName() {
        
        return _imageFileNameList.get(_nextImageIndex);
    }



    public void takeDamage(int dam) {
        if ((_nextImageIndex + dam)<= (_imageFileNameList.size()-1) ) {
             _nextImageIndex+= dam;
        } else
            _nextImageIndex = _imageFileNameList.size()-1 ;
       
    }

    public int getxPosition() {
        return _xPosition;
    }

    public void setxPosition(int _xPosition) {
        this._xPosition = _xPosition;
    }

    public int getyPosition() {
        return _yPosition;
    }

    public void setyPosition(int _yPosition) {
        this._yPosition = _yPosition;
    }

    public int getHeight() {
        return _height;
    }

    public int getWidth() {
        return _width;
    }

    public void setImageFileNameList(LinkedList<Integer> _imageFileNameList) {
        this._imageFileNameList = _imageFileNameList;
    }
    
    
    
    
}
