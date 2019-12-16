/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.basicObjects;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author Emilio
 */
public class SkyTileTest {
    private int _id,_x,_y ;
    public SkyTileTest() {
        _id = 0 ;
        _x = 0 ;
        _y = 0 ;
    }
    
   

    /**
     * Test of hit method, of class HitCommand.
     */
    @Test
    public void testCreaction() {
        SkyTile inst = new SkyTile(_id,_x,_y) ;
        assertNotNull(inst);
    }
    
}
