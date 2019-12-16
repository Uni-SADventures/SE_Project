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
public class MoveCommandTest {
    private PlayerCharacter _p ;
    private Handler _handler ;
    public MoveCommandTest() {
         _handler = null ;
         _p = new PlayerCharacter(null,0,0,20,20,CharacterType.USER,20,2,20,5,"Jack") ;
       
    }
    
   

    /**
     * Test of hit method, of class HitCommand.
     */
    @Test
    public void testCreaction() {
        MoveCommand inst = new MoveCommand(_handler,_p) ;
        assertNotNull(inst);
    }
    
}
