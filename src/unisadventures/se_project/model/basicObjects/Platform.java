package unisadventures.se_project.model.basicObjects;

import unisadventures.se_project.model.WorldObject;
import java.awt.Graphics;



public class Platform extends WorldObject implements FixedImageObjectInterface {
    
    private final String _imageFileName;
    
    public Platform(int xPosition, int yPosition, int height, int width, String imageFileName) {
        super(xPosition, yPosition, height, width);
        _imageFileName = imageFileName;
    }
    
    @Override
    public String getImageFileName(){
        return _imageFileName;
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void takeDamage(int dam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCurrentSprite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
