/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.states;

import java.awt.Graphics;
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
public class GameStateTest {
    
    public GameStateTest() {
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
     * Test of tick method, of class GameState.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        GameState instance = null;
        instance.tick();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayView method, of class GameState.
     */
    @Test
    public void testDisplayView() {
        System.out.println("displayView");
        Graphics g = null;
        GameState instance = null;
        instance.displayView(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
