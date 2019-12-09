package unisadventures.se_project.model.basicObjects;

import unisadventures.se_project.model.WorldObject;
import unisadventures.se_project.model.LevelManager;


public class Platform extends WorldObject {
    
    private final String _imageFile;
    
    public Platform(LevelManager manager, double xPosition, double yPosition, double height, double width, String imageFile) {
        super(manager, xPosition, yPosition, height, width);
        _imageFile = imageFile;
    }

    @Override
    public void tick() {
    }

    @Override
    public void takeDamage(int damage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCurrentSprite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
