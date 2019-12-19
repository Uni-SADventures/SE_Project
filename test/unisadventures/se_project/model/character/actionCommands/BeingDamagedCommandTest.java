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
public class BeingDamagedCommandTest {
    private PlayerCharacter _p ;
    private Handler _handler ;
    private final int _damageFrames ;
    public BeingDamagedCommandTest() {
        _handler = null ;
        _p = new PlayerCharacter(null,0,0,20,20,CharacterType.USER,20,2,20,5,"Jack") ;
        _damageFrames = 3 ;
    }
    
    /**
     * Test of idle method, of class ActionManager.
     */
    @Test
    public void testTakeDamage() {
        BeingDamagedCommand com = new BeingDamagedCommand(_handler,_p,_damageFrames) ;
        int initalEnergy = _p.getHealthBar() ;
        com.takeDamage(5) ;
        assertEquals(_p.getHealthBar(),initalEnergy) ;
        com.takeDamage(5) ;
        
        com.takeDamage(5) ;
        assertEquals(com._ch.getHealthBar(),(initalEnergy-5)) ;
        com.takeDamage(5) ;
        assertEquals(com.getCount(),0) ;
    }

    
}
