package unisadventures.se_project.model.basicObjects;


import java.util.ArrayList;
import unisadventures.se_project.util.CollectibleType;

public class CollectibleItem  implements CollectibleItemInterface {
    
    private int _xPosition;  // Because position may vary in some objects
    private int _yPosition;  // (may not be the cleanest option, refactor?)
    private final int _height;
    private final int _width;
    private final ArrayList<String> _imageFileNameList;
    private final CollectibleType _type;
    private final int _listSize;
    private int _counter;
    
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

    


    
}
