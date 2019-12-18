/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.util.CharacterType;

/**
 *
 * @author Emilio
 */
public class HitCommandTest {
    private PlayerCharacter _p ;
    private Handler _handler ;
    public HitCommandTest() {
         _handler = null ;
         _p = new PlayerCharacter(null,0,0,20,20,CharacterType.USER,20,2,20,5,"Jack") ;
       
    }
    
   

    /**
     * Test of hit method, of class HitCommand.
     */
    @Test
    public void testHit() {
        HitCommand hit = new HitCommand(_handler,_p) ;
        assertEquals(hit.getCount(), 0);
        hit.hit();
        assertEquals(hit.getCount(), 1);
        hit.resetCounter(); 
        assertEquals(hit.getCount(),0) ;
    }
    
}
