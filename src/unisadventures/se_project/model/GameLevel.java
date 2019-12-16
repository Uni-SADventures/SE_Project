package unisadventures.se_project.model;

import unisadventures.se_project.model.basicObjects.Tile;
import java.io.IOException;
import unisadventures.se_project.util.Utils;

/**
 * Class that stores the 
 */
public class GameLevel {
    private int _levelWidth, _levelHeight;
    private int _displayWidth, _displayHeight;
    private int _spawnX, _spawnY;
    private int _scenarioImage;
    private int [][] tiles;
    
    public GameLevel(String path, int displayWidth, int displayHeight) throws IOException {
        _displayWidth = displayWidth;
        _displayHeight = displayHeight;
        loadWorld(path);
    }
    
    public int getScenarioImage() {
        return _scenarioImage;
    }

    public void setScenarioImage(int scenarioImage) {
        _scenarioImage = scenarioImage;
    }
    
    public void tick() {
        
    }
 
    public Tile getTile(int x, int y){
      if (x<0 || y<0 || x>= _levelWidth || y>=_levelHeight)
          return Tile.rockTile;
      Tile t= Tile.tiles[tiles[x][y]];
      if(t==null)
          return Tile.skyTile;
      return t;
    }
    
    private void loadWorld(String path) {
        String file =Utils.loadFileAsString(path);
        String[] tokens=file.split("\\s+");
        _levelWidth=Utils.ParseInt(tokens[0]);
        _levelHeight=Utils.ParseInt(tokens[1]);
        _spawnX=Utils.ParseInt(tokens[2]);
        _spawnY=Utils.ParseInt(tokens[3]);
        
        tiles= new int[_levelWidth][_levelHeight];
        
        for (int y=0; y<_levelHeight;y++){
            for(int x=0; x<_levelWidth;x++){
                tiles[x][y]=Utils.ParseInt(tokens[(x+y*_levelWidth)+4]);
            }
        }
        
     }

    public int getLevelWidth() {
        return _levelWidth;
    }

    public int getLevelHeight() {
        return _levelHeight;
    }
    
    public int getDisplayWidth() {
        return _displayWidth;
    }

    public int getDisplayHeight() {
        return _displayHeight;
    }
    
}
