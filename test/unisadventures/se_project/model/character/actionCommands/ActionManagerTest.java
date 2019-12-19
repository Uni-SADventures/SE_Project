/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.util.CharacterType;

/**
 *
 * @author Emilio
 */
public class ActionManagerTest {
    private PlayerCharacter _p ;
    private Handler _handler ;
    public ActionManagerTest() {
        _handler = null ;
        _p = new PlayerCharacter(null,0,0,20,20,CharacterType.USER,20,2,20,5,"Jack") ;
        
    }
    
    /**
     * Test of idle method, of class ActionManager.
     */
    @Test
    public void testGetPowered() {
        ActionManager am = new ActionManager(_handler,_p) ;
        PlayerCharacter powered = am.getPowered(_p) ;
        assertNotNull(powered);
    }

    
}
