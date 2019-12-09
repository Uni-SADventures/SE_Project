package unisadventures.se_project.model.basicObjects;


import unisadventures.se_project.model.WorldObject;
import unisadventures.se_project.model.LevelManager;
import java.util.ArrayList;
import unisadventures.se_project.util.CollectibleType;

public class CollectibleItem extends WorldObject{
    
    private final ArrayList<String> _imageFileNameList;
    private final CollectibleType _type;
    private final int _listSize;
    private int _counter;
    
    public CollectibleItem(LevelManager manager, double xPosition, double yPosition, double height, double width, ArrayList<String> imageFileNameList, CollectibleType type) {
        super(manager, xPosition, yPosition, height, width);
        _imageFileNameList = imageFileNameList;
        _type = type;
        _listSize = _imageFileNameList.size();
        _counter = 0;
    }
    
    // Temporary function, to update
    public String getNextImageFileName() {
        int nextImageIndex = _counter;
        _counter++;
        if(_counter == _listSize) {
            _counter = 0;
           
        }
        return _imageFileNameList.get(nextImageIndex);
    }
    // Temporary function, to update
    public CollectibleType getCollectibleType() {
        return _type;
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
