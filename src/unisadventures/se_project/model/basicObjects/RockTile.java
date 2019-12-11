/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.basicObjects;

import unisadventures.se_project.presenter.world.Tile;
import unisadventures.se_project.view.gfx.Assets;

/**
 *
 * @author krist
 */
public class RockTile extends Tile {

   public RockTile(int id,int x, int y) {
        super(Assets.rock, id,x,y);
    }

    @Override
    public boolean isSolid() {
        return true; 
    }
    
}
