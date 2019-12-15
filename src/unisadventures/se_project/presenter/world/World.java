/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.world;

import unisadventures.se_project.model.basicObjects.Tile;
import java.awt.Graphics;
import java.io.IOException;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.presenter.states.GameState;
import unisadventures.se_project.presenter.states.State;
import unisadventures.se_project.util.Utils;

/**
 *
 * @author krist
 */
public class World {
    private int width,height;
    private int spawnX, spawnY;
    private int [][] tiles;
    private Handler handler;
    private int scenarioImage ;
    
    public int getScenarioImage() {
        return scenarioImage;
    }

    public void setScenarioImage(int scenarioImage) {
        this.scenarioImage = scenarioImage;
    }
    
    public World(Handler handler,String path) throws IOException {
        this.handler=handler;
        loadWorld(path);
    }
    
    public void tick(){
        
    }
 
    public Tile getTile(int x, int y){
      if (x<0 || y<0 || x>= width || y>=height)
          return Tile.rockTile;
      Tile t= Tile.tiles[tiles[x][y]];
      if(t==null)
          return Tile.skyTile;
      return t;
    }
    
    private void loadWorld(String path) {
        String file =Utils.loadFileAsString(path);
        String[] tokens=file.split("\\s+");
        width=Utils.ParseInt(tokens[0]);
        height=Utils.ParseInt(tokens[1]);
        spawnX=Utils.ParseInt(tokens[2]);
        spawnY=Utils.ParseInt(tokens[3]);
        
        tiles= new int[width][height];
        
        for (int y=0; y<height;y++){
            for(int x=0; x<width;x++){
                tiles[x][y]=Utils.ParseInt(tokens[(x+y*width)+4]);
            }
        }
        
     }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
}
