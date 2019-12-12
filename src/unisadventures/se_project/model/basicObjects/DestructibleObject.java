package unisadventures.se_project.model.basicObjects;


import java.util.ArrayList;

public class DestructibleObject  implements DestructibleObjectInterface {
    
    private final ArrayList<String> _imageFileNameList;
    private final int _listSizeMinusOne;
    private int _nextImageIndex;
    private static final int INTACT_OBJECT_IMAGE_FILE_NAME_INDEX = 0;
    private int _xPosition;
    private int _yPosition;
    private int _height;
    private int _width;
    
    public DestructibleObject(int xPosition, int yPosition, int height, int width, ArrayList<String> imageFileNameList) {
        _xPosition = xPosition ;
        _yPosition = yPosition ;
        _height = height ;
        _width = width ;
        _imageFileNameList = imageFileNameList;
        _listSizeMinusOne = _imageFileNameList.size() - 1;
        _nextImageIndex = 0;
    }
    
    @Override
    public String getIntactImageFileName() {
        return _imageFileNameList.get(INTACT_OBJECT_IMAGE_FILE_NAME_INDEX);
    }
    
    @Override
    public String getNextDestructionImageFileName() {
        if (_nextImageIndex == _listSizeMinusOne) {
            return null;
        }
        _nextImageIndex++;
        return _imageFileNameList.get(_nextImageIndex);
    }

  

    
    
}
