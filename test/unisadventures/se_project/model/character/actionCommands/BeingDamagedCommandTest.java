/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.util.CharacterType;


public class BeingDamagedCommandTest {
    
    private PlayerCharacter _p ;
    
    public BeingDamagedCommandTest() {
        _p = new PlayerCharacter(null,0,0,20,20,CharacterType.USER,20,2,20,5,"Jack") ;
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of takeDamage method, of class BeingDamagedCommand.
     */
    @Test
    public void testTakeDamage() {
        System.out.println("takeDamage");
        BeingDamagedCommand com = new BeingDamagedCommand(null,_p,3) ;
        int initalEnergy = _p.getHealthBar() ;
        com.takeDamage(5) ;
        assertEquals(com._ch.getHealthBar(),(initalEnergy-5)) ;
    }

}