package unisadventures.se_project.Model.basic_objects;

import unisadventures.se_project.Model.WorldObject;

public class Platform extends WorldObject implements FixedImageObjectInterface {
    
    private final String _imageFileName;
    
    public Platform(double xPosition, double yPosition, double height, double width, String imageFileName) {
        super(xPosition, yPosition, height, width);
        _imageFileName = imageFileName;
    }
    
    @Override
    public String getImageFileName(){
        return _imageFileName;
    }
}
