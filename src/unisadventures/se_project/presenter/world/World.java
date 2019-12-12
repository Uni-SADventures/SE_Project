/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.world;

import java.awt.Graphics;
import java.io.IOException;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.presenter.launcher.Game;
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
    
    public World(Handler handler,String path) throws IOException {
        this.handler=handler;
        loadWorld(path);
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        int xStart=(int)Math.max(0,handler.getCam().getxOffset()/Tile.TILEWIDTH-1);
        int xEnd=(int)Math.min(width,(handler.getCam().getxOffset() + handler.getWidth())/Tile.TILEWIDTH+1);
        int yStart=(int)Math.max(0,handler.getCam().getyOffset()/Tile.TILEHEIGHT);
        int yEnd=(int)Math.min(height,(handler.getCam().getyOffset() + handler.getHeight())/Tile.TILEHEIGHT+1);
        
        for(int y=yStart;y<yEnd;y++){
            for(int x=xStart;x<xEnd;x++){
                getTile(x, y).render(g, (int)(x*Tile.TILEWIDTH - handler.getCam().getxOffset()), (int)(y*Tile.TILEHEIGHT - handler.getCam().getyOffset()
                        ));
            }
        }
    
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
