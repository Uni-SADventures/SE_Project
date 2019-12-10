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
public class SkyTile extends Tile {

   public SkyTile(int id,double x, double y) {
        super(Assets.sky, id,x,y);
    }
}
