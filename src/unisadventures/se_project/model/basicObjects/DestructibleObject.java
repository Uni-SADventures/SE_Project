package unisadventures.se_project.model.basicObjects;


import unisadventures.se_project.model.WorldObject;
import unisadventures.se_project.model.LevelManager;
import java.util.ArrayList;

public class DestructibleObject extends WorldObject implements DestructibleObjectInterface {
    
    private final ArrayList<String> _imageFileNameList;
    private final int _listSizeMinusOne;
    private int _nextImageIndex;
    private static final int INTACT_OBJECT_IMAGE_FILE_NAME_INDEX = 0;
    
    public DestructibleObject(LevelManager manager, double xPosition, double yPosition, double height, double width, ArrayList<String> imageFileNameList) {
        super(manager, xPosition, yPosition, height, width);
        _imageFileNameList = imageFileNameList;
        _listSizeMinusOne = _imageFileNameList.size() - 1;
        _nextImageIndex = 0;
    }
    
    @Override
    public String getIntactImageFileName() {
        return _imageFileNameList.get(INTACT_OBJECT_IMAGE_FILE_NAME_INDEX);
    }
    
    // Temporary function, to update
    public String getNextDestructionImageFileName() {
        if (_nextImageIndex == _listSizeMinusOne) {
            return null;
        }
        _nextImageIndex++;
        return _imageFileNameList.get(_nextImageIndex);
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void takeDamage(int damage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCurrentFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
