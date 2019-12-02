package unisadventures.se_project.Model.basic_objects;

import unisadventures.se_project.Model.WorldObject;
import java.util.ArrayList;
import unisadventures.se_project.util.CollectibleType;

public class CollectibleItem extends WorldObject implements CollectibleItemInterface {
    
    private final ArrayList<String> _imageFileNameList;
    private final CollectibleType _type;
    private final int _listSize;
    private int _counter;
    
    public CollectibleItem(int xPosition, int yPosition, int height, int width, ArrayList<String> imageFileNameList, CollectibleType type) {
        super(xPosition, yPosition, height, width);
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
    
}
