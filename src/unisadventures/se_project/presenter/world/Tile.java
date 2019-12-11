/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import unisadventures.se_project.model.WorldObject;
import unisadventures.se_project.model.basicObjects.LimitTile;
import unisadventures.se_project.model.basicObjects.RockTile;
import unisadventures.se_project.model.basicObjects.SkyTile;

/**
 *
 * @author krist
 */
public class Tile extends WorldObject{
    //Static stuff
    public static Tile []tiles = new Tile[256];
    public static Tile rockTile = new RockTile(2,200,200);
    public static Tile skyTile = new SkyTile(3,200,200);
    public static Tile limitTile= new LimitTile(4,200,200);
    
    //Class
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id,int x,int y) {
        super(x,y,TILEWIDTH,TILEHEIGHT);
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    public int getId() {
        return id;
    }
    @Override
    public void tick(){
        
    }
    public void render(Graphics g,int x,int y){
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }
    public boolean isSolid(){
        return false;
    }

    @Override
    public void takeDamage(int damage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCurrentSprite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
