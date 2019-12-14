/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.basicObjects;

/**
 *
 * @author krist
 */
public class Tile {
    //Static stuff
    public static Tile []tiles = new Tile[256];
    public static Tile rockTile;
    public static Tile skyTile;
    public static Tile limitTile  = new LimitTile(4,200,200);
    public static int rockIdImage ;
    public static int skyIdImage ;
    public static int limitIdImage ;
   /*
    public static Tile rockTile = new RockTile(2,200,200);
    public static Tile skyTile = new SkyTile(3,200,200);
    public static Tile limitTile= new LimitTile(4,200,200);
    */
     //Static stuff
    /*
    public static Tile []tiles = new Tile[256];
    public static Tile rockTile = new RockTile(2,200,200);
    public static Tile skyTile = new SkyTile(3,200,200);
    public static Tile limitTile= new LimitTile(4,200,200);
    */
    //Class
    public static final int TILEWIDTH = 74, TILEHEIGHT = 74;
    protected final int texture;
    protected final int id;
    private int x ;
    private int y ;
    
    
    
    public static int getRockIdImage() {
        return rockIdImage;
    }

    public static void setRockIdImage(int rockIdImage) {
        Tile.rockIdImage = rockIdImage;
        rockTile  = new RockTile(2,200,200);
        
    }

    public static int getSkyIdImage() {
        return skyIdImage;
    }

    public static void setSkyIdImage(int skyIdImage) {
        Tile.skyIdImage = skyIdImage;
        skyTile  = new SkyTile(3,200,200);
    }

    public static int getLimitIdImage() {
        return limitIdImage;
    }

    public static void setLimitIdImage(int limitIdImage) {
        Tile.limitIdImage = limitIdImage;
        limitTile  = new LimitTile(4,200,200);
    }
    
    
    
    
    
    
    
    public Tile(int texture, int id,int x,int y) {
        this.x = x ;
        this.y = y ;
      
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    public int getId() {
        return id;
    }

    public int getTexture() {
        return texture;
    }

    public boolean isSolid(){
        return false;
    }


}
