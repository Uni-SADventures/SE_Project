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
import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.util.DirectionType;

/**
 *
 * @author Emilio
 */
public class ActionManagerTest {
    
    private PlayerCharacter _player ;
    private ActionManager _manager;
    
    public ActionManagerTest() {
        
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
        _player = new PlayerCharacter(null,0,0,20,20,CharacterType.USER,20,2,20,5,"Jack") ;
        _manager = new ActionManager(null, _player);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    /**
     * Test of takeDamage method, of class ActionManager.
     */
    @org.junit.jupiter.api.Test
    public void testTakeDamage() {
        System.out.println("takeDamage");
        int dam = 1;
        int formerHealth = _player.getHealthBar();
        _manager.takeDamage(dam);
        assertEquals(formerHealth - dam, _player.getHealthBar());
        
        
    }

    /**
     * Test of moveLeft method, of class ActionManager.
     */
    // Can't test everything the method does
    @org.junit.jupiter.api.Test
    public void testMoveLeft() {
        System.out.println("moveLeft");
        _manager.moveLeft();
        assertEquals(DirectionType.LEFT, _player.getFacing());
    }

    /**
     * Test of moveRight method, of class ActionManager.
     */
    @org.junit.jupiter.api.Test
    public void testMoveRight() {
        System.out.println("moveRight");
        _manager.moveRight();
        assertEquals(DirectionType.RIGHT, _player.getFacing());
    }
    

    
}
