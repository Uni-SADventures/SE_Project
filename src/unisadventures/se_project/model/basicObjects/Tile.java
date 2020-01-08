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
    public static Tile _rockTile;
    public static Tile _skyTile;
    public static Tile _limitTile;
    public static final int TILEWIDTH = 74, TILEHEIGHT = 74;
    protected final int texture;
    protected final int id;
    private int x ;
    private int y ;
    

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
