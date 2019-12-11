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

/**
 *
 * @author Emilio
 */
public class VerticalCommandTest {
    
    public VerticalCommandTest() {
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
     * Test of jump method, of class VerticalCommand.
     */
    @Test
    public void testJump() {
        //System.out.println("jump");
        VerticalCommand instance = null;
        boolean expResult = false;
        boolean result = instance.jump();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fall method, of class VerticalCommand.
     */
    @Test
    public void testFall() {
        //System.out.println("fall");
        VerticalCommand instance = null;
        instance.fall();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetCounter method, of class VerticalCommand.
     */
    @Test
    public void testResetCounter() {
        //System.out.println("resetCounter");
        VerticalCommand instance = null;
        instance.resetCounter();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
