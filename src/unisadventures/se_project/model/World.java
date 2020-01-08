package unisadventures.se_project.model;

import unisadventures.se_project.model.basicObjects.Tile;
import java.io.IOException;
import java.lang.Integer;
import java.util.LinkedList;
import unisadventures.se_project.model.basicObjects.CollectibleItem;
import unisadventures.se_project.util.CollectibleType;
import unisadventures.se_project.util.Utils;

/**
 * Class that stores the 
 */
public class World {
    private int _width, _height;
    private int _spawnX, _spawnY;
    private String _pathScenarioImage;
    private String _pathLoadingImage;
    private int _scenarioImage;
    private int [][] tiles;
    private LinkedList<CollectibleItem> _collectibles;
    
    public World(String path, String path1) throws IOException {
        loadWorld(path,path1);
    }

    
    public Tile getTile(int x, int y){
      if (x<0 || y<0 || x>= _width || y>=_height)
          return Tile._rockTile;
      Tile t = Tile.tiles[tiles[x][y]];
      if(t == null)
          return Tile._skyTile;
      return t;
    }
    
    private void loadWorld(String path,String path1) {
        
        String file = Utils.loadFileAsString(path);
        String fileCollectible = Utils.loadFileAsString(path1);
        String[] tokens=file.split("\\s+");
        String [] tokensCollectible=fileCollectible.split("\\s+");
        _width=Integer.parseInt(tokens[0]);
        _height=Integer.parseInt(tokens[1]);
        _spawnX=Integer.parseInt(tokens[2]);
        _spawnY=Integer.parseInt(tokens[3]);
        _pathScenarioImage=tokens[4];
        int j=0,i=0;
        
        while(i<=tokensCollectible.length-1){
            _collectibles.add(j, new CollectibleItem(Integer.parseInt(tokensCollectible[i]), Integer.parseInt(tokensCollectible[i+1]), 32, 32, CollectibleType.CFU));
            i+=2;
            j+=1;
        }
        
        tiles= new int[_width][_height];
        
        for (int y=0; y<_height;y++){
            for(int x=0; x<_width;x++){
                tiles[x][y]=Integer.parseInt(tokens[(x+y*_width)+5]);
            }
        }
        
     }

    public int getWidth() {
        return _width;
    }

    public int getHeight() {
        return _height;
    }

    public String getPathLoadingImage() {
        return _pathLoadingImage;
    }

    public int getSpawnX() {
        return _spawnX;
    }

    public void setSpawnX(int _spawnX) {
        this._spawnX = _spawnX;
    }

    public int getSpawnY() {
        return _spawnY;
    }

    public void setSpawnY(int _spawnY) {
        this._spawnY = _spawnY;
    }

    public String getPathScenarioImage() {
        return _pathScenarioImage;
    }

    public void setPathScenarioImage(String _pathScenarioImage) {
        this._pathScenarioImage = _pathScenarioImage;
    }

    public int getScenarioImage() {
        return _scenarioImage;
    }

    public void setScenarioImage(int _scenarioImage) {
        this._scenarioImage = _scenarioImage;
    }

    public int[][] getTiles() {
        return tiles;
    }

    public void setTiles(int[][] tiles) {
        this.tiles = tiles;
    }

    public LinkedList<CollectibleItem> getCollectibles() {
        return _collectibles;
    }

    public void setCollectibles(LinkedList<CollectibleItem> _collectibles) {
        this._collectibles = _collectibles;
    }

    
    
    
}
