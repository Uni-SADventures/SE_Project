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
public class IdleCommandTest {
    private PlayerCharacter _p ;
    private Handler _handler ;
    public IdleCommandTest() {
         _handler = null ;
         _p = new PlayerCharacter(null,0,0,20,20,CharacterType.USER,20,2,20,5,"Jack") ;
       
    }
    
   

    /**
     * Test of hit method, of class HitCommand.
     */
    @Test
    public void testIdle() {
        IdleCommand idle = new IdleCommand(_handler,_p) ;
        assertEquals(idle.getCount(), 0);
        idle.idle();
        assertEquals(idle.getCount(), 1);
        idle.resetCounter(); 
        assertEquals(idle.getCount(),0) ;
    }
    
}
