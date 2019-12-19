package unisadventures.se_project.model;

import unisadventures.se_project.model.basicObjects.Tile;
import java.io.IOException;
import java.util.ArrayList;
import unisadventures.se_project.util.Pair;
import unisadventures.se_project.util.Utils;

/**
 * Class that stores the 
 */
public class GameLevel {
    private int _levelWidth, _levelHeight;
    private int _displayWidth, _displayHeight;
    private int _spawnX, _spawnY;
    private String _pathScenarioImage;
    private String _pathLoadingImage;
    private int _scenarioImage;
    private int [][] tiles;
    private ArrayList<Pair<Integer,Integer>> collectiblePositions = new ArrayList();
    private ArrayList<Pair<Integer,Integer>> enemiesPositions = new ArrayList();
    
    public GameLevel(String path, String path1, int displayWidth, int displayHeight) throws IOException {
        _displayWidth = displayWidth;
        _displayHeight = displayHeight;
        loadWorld(path,path1);
    }
    
    public int getScenarioImage() {
        return _scenarioImage;
    }

    public ArrayList<Pair<Integer, Integer>> getEnemiesPositions() {
        return enemiesPositions;
    }

    
    public String getPathScenarioImage() {
        return _pathScenarioImage;
    }
    
    
    public ArrayList<Pair<Integer, Integer>> getCollectiblePositions() {
        return collectiblePositions;
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
    
    private void loadWorld(String path,String path1) {
        
        String file =Utils.loadFileAsString(path);
        String fileCollectible =Utils.loadFileAsString(path1);
        String[] tokens=file.split("\\s+");
        String [] tokensCollectible=fileCollectible.split("\\s+");
        _levelWidth=Utils.ParseInt(tokens[0]);
        _levelHeight=Utils.ParseInt(tokens[1]);
        _spawnX=Utils.ParseInt(tokens[2]);
        _spawnY=Utils.ParseInt(tokens[3]);
        _pathScenarioImage=tokens[4];
        int j=0,i=0,k=0;
        
       while(i<=tokensCollectible.length-1){
            if("0".equals(tokensCollectible[i])){
                enemiesPositions.add(k,new Pair(Utils.ParseInt(tokensCollectible[i+1]),Utils.ParseInt(tokensCollectible[i+2])));
                k+=1;
                i+=3;
            }else {
                collectiblePositions.add(j, new Pair(Utils.ParseInt(tokensCollectible[i]),Utils.ParseInt(tokensCollectible[i+1])));
                i+=2;
                j+=1;
            }
        }
        tiles= new int[_levelWidth][_levelHeight];
        
        for (int y=0; y<_levelHeight;y++){
            for(int x=0; x<_levelWidth;x++){
                tiles[x][y]=Utils.ParseInt(tokens[(x+y*_levelWidth)+5]);
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

    public String getPathLoadingImage() {
        return _pathLoadingImage;
    }
    
    
}
