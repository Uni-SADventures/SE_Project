package unisadventures.se_project.model.basicObjects;

import unisadventures.se_project.model.WorldObject;



public class Platform extends WorldObject {
    
    private final String _imageFile;
    
    public Platform( double xPosition, double yPosition, int height, int width, String imageFile) {
        super( xPosition, yPosition, height, width);
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
