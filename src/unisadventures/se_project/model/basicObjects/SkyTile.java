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

    public SkyTile(int texture, int id, int x, int y) {
        super(texture, id, x, y);
        _skyTile = this;
    }

}
