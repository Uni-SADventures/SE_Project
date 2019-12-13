package unisadventures.se_project.model;

import unisadventures.se_project.model.basicObjects.Tile;
import java.io.IOException;
import unisadventures.se_project.util.Utils;

/**
 * Class that stores the 
 */
public class GameLevel {
    private int _worldWidth, _worldHeight;
    private int _spawnX, _spawnY;
    private int [][] tiles;
    
    public GameLevel(String path) throws IOException {
        loadWorld(path);
    }
    
    public void tick() {
        
    }
 
    public Tile getTile(int x, int y){
      if (x<0 || y<0 || x>= _worldWidth || y>=_worldHeight)
          return Tile.rockTile;
      Tile t= Tile.tiles[tiles[x][y]];
      if(t==null)
          return Tile.skyTile;
      return t;
    }
    
    private void loadWorld(String path) {
        String file =Utils.loadFileAsString(path);
        String[] tokens=file.split("\\s+");
        _worldWidth=Utils.ParseInt(tokens[0]);
        _worldHeight=Utils.ParseInt(tokens[1]);
        _spawnX=Utils.ParseInt(tokens[2]);
        _spawnY=Utils.ParseInt(tokens[3]);
        
        tiles= new int[_worldWidth][_worldHeight];
        
        for (int y=0; y<_worldHeight;y++){
            for(int x=0; x<_worldWidth;x++){
                tiles[x][y]=Utils.ParseInt(tokens[(x+y*_worldWidth)+4]);
            }
        }
        
     }

    public int getWidth() {
        return _worldWidth;
    }

    public int getHeight() {
        return _worldHeight;
    }
    
}
