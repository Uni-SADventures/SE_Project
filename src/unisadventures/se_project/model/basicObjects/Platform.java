package unisadventures.se_project.model.basicObjects;

import unisadventures.se_project.model.WorldObject;
import java.awt.Graphics;



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

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        
    }
}
