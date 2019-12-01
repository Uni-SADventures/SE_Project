package unisadventures.se_project.Model.basic_objects;

import unisadventures.se_project.Model.WorldObject;
import java.util.ArrayList;

public class DestructibleObject extends WorldObject implements DestructibleObjectInterface {
    
    private final ArrayList<String> _imageFileNameList;
    private final int _listSizeMinusOne;
    private int _nextImageImage;
    private static final int INTACT_OBJECT_IMAGE_FILE_NAME_INDEX = 0;
    
    public DestructibleObject(int xPosition, int yPosition, int height, int width, ArrayList<String> imageFileNameList) {
        super(xPosition, yPosition, height, width);
        _imageFileNameList = imageFileNameList;
        _listSizeMinusOne = _imageFileNameList.size() - 1;
        _nextImageImage = 0;
    }
    
    @Override
    public String getIntactImageFileName() {
        return _imageFileNameList.get(INTACT_OBJECT_IMAGE_FILE_NAME_INDEX);
    }
    
    @Override
    public String getNextDestructionImageFileName() {
        if (_nextImageImage == _listSizeMinusOne) {
            return null;
        }
        _nextImageImage++;
        return _imageFileNameList.get(_nextImageImage);
    }
    
}
