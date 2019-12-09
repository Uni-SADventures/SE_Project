
package unisadventures.se_project.model;

import unisadventures.se_project.util.Pair;
import unisadventures.se_project.util.LevelStateMessenger;

/**
 * Class to manage the model part of a level
 */
public class LevelManager {
    
    public LevelManager(double levelWidth, double levelHeight, String backgroundImageName) {
        
        
    }
    
    /**
     * Adds a new object to the level
     * @param newObject the new object to add
     */
    public void addObjectToLevel(WorldObject newObject) {}
    
    /**
     * Removes an object from the level
     * @param objectToRemove the object to remove
     */
    public void removeObjectFromLevel(WorldObject objectToRemove) {}
    
    /** 
     * Compute the output of a tick for all elements of the level, including
     * attacks and collision
     * @return LevelStateMessenger Object to comunicate the states of the level to view.
     */
    public LevelStateMessenger tick() {
        return null;
          
    }
    
    /**
     * Checks if another object may be in the way of an object's movement
     * @param newObjectPosition the moving object's position (top left corner)
     * @param newObjectDimensions the moving object's dimensions
     * @return true if there is nothing in the way of the movement, false otherwise
     */
    public boolean resolveForCollisions(Pair<Double, Double> newObjectPosition, Pair<Double, Double> newObjectDimensions) {return false;}
    
    /**
     * Applies damage to any object in the attack zone
     * @param attackZonePosition the attack zone's position (top left corner)
     * @param attackZoneDimensions the attack zone's dimensions
     */
    public void resolveAttack(Pair<Double, Double> attackZonePosition, Pair<Double, Double> attackZoneDimensions) {}
    

  
}
