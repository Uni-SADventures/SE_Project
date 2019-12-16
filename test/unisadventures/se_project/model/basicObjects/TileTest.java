/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.basicObjects;

import unisadventures.se_project.model.character.actionCommands.*;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.util.CharacterType;

/**
 *
 * @author Emilio
 */
public class TileTest {
    private int _texture,_id,_x,_y ;
    public TileTest() {
        _texture = 0 ;
        _id = 0 ;
        _x = 0 ;
        _y = 0 ;
    }
    
   

    /**
     * Test of hit method, of class HitCommand.
     */
    @Test
    public void testCreaction() {
        Tile inst = new Tile(_texture,_id,_x,_y) ;
        assertNotNull(inst);
    }
    
}
