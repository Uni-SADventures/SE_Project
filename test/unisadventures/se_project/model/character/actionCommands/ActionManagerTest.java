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
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.model.character.PlayerCharacter;

/**
 *
 * @author Emilio
 */
public class ActionManagerTest {
    
    public ActionManagerTest() {
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
     * Test of execute method, of class ActionManager.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        ActionManager instance = null;
        instance.execute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of idle method, of class ActionManager.
     */
    @Test
    public void testIdle() {
        System.out.println("idle");
        ActionManager instance = null;
        instance.idle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveLeft method, of class ActionManager.
     */
    @Test
    public void testMoveLeft() {
        System.out.println("moveLeft");
        ActionManager instance = null;
        instance.moveLeft();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveRight method, of class ActionManager.
     */
    @Test
    public void testMoveRight() {
        System.out.println("moveRight");
        ActionManager instance = null;
        instance.moveRight();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of jump method, of class ActionManager.
     */
    @Test
    public void testJump() {
        System.out.println("jump");
        ActionManager instance = null;
        instance.jump();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attack method, of class ActionManager.
     */
    @Test
    public void testAttack() {
        System.out.println("attack");
        ActionManager instance = null;
        instance.attack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fall method, of class ActionManager.
     */
    @Test
    public void testFall() {
        System.out.println("fall");
        ActionManager instance = null;
        instance.fall();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takeDamage method, of class ActionManager.
     */
    @Test
    public void testTakeDamage() {
        System.out.println("takeDamage");
        int damage = 0;
        ActionManager instance = null;
        instance.takeDamage(damage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of grab method, of class ActionManager.
     */
    @Test
    public void testGrab() {
        System.out.println("grab");
        ActionManager instance = null;
        instance.grab();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPowered method, of class ActionManager.
     */
    @Test
    public void testGetPowered() {
        System.out.println("getPowered");
        PlayerCharacter p = null;
        ActionManager instance = null;
        PlayerCharacter expResult = null;
        PlayerCharacter result = instance.getPowered(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
