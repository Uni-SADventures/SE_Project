package unisadventures.se_project;

import unisadventures.se_project.util.Pair;

public interface WorldObject {
    
    public Pair<Integer, Integer> getPosition();
    public Pair<Integer, Integer> getDimension();
    // No need to put a setPosition method at this level; 
    
}
