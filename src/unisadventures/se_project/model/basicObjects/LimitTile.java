/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.basicObjects;

import unisadventures.se_project.view.gfx.Assets;

/**
 *
 * @author krist
 */
public class LimitTile extends Tile {

    public LimitTile(int id, int x, int y) {
        super(Assets.limit,id,x,y);
    }

    @Override
    public boolean isSolid() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
