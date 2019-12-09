/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.basicObjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author krist
 */
public class Tile {
    //Static stuff
    public static Tile []tiles = new Tile[256];
    public static Tile rockTile = new RockTile(0);
    public static Tile grassTile = new GrassTile(1);
    public static Tile dirtTile= new DirtTile(2);
    
    //Class
    public static final int TILEHEIGHT = 64;
    public static final int TILEWIDTH=64;
    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;
    }

    public int getId() {
        return id;
    }
    public void tick(){
        
    }
    public void render(Graphics g,int x,int y){
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }
    public boolean isSolid(){
        return false;
    }
    
}
