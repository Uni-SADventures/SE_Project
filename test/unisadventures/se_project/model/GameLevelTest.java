/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.model.basicObjects.Tile;
import unisadventures.se_project.util.Pair;

/**
 *
 * @author mathieu
 */
public class GameLevelTest {
    
    public GameLevelTest() {
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
     * Test of getScenarioImage method, of class GameLevel.
     */
    @Test
    public void testGetScenarioImage() {
        System.out.println("getScenarioImage");
        GameLevel instance = null;
        int expResult = 0;
        int result = instance.getScenarioImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnemiesPositions method, of class GameLevel.
     */
    @Test
    public void testGetEnemiesPositions() {
        System.out.println("getEnemiesPositions");
        GameLevel instance = null;
        ArrayList<Pair<Integer, Integer>> expResult = null;
        ArrayList<Pair<Integer, Integer>> result = instance.getEnemiesPositions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPathScenarioImage method, of class GameLevel.
     */
    @Test
    public void testGetPathScenarioImage() {
        System.out.println("getPathScenarioImage");
        GameLevel instance = null;
        String expResult = "";
        String result = instance.getPathScenarioImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCollectiblePositions method, of class GameLevel.
     */
    @Test
    public void testGetCollectiblePositions() {
        System.out.println("getCollectiblePositions");
        GameLevel instance = null;
        ArrayList<Pair<Integer, Integer>> expResult = null;
        ArrayList<Pair<Integer, Integer>> result = instance.getCollectiblePositions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScenarioImage method, of class GameLevel.
     */
    @Test
    public void testSetScenarioImage() {
        System.out.println("setScenarioImage");
        int scenarioImage = 0;
        GameLevel instance = null;
        instance.setScenarioImage(scenarioImage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tick method, of class GameLevel.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        GameLevel instance = null;
        instance.tick();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTile method, of class GameLevel.
     */
    @Test
    public void testGetTile() {
        System.out.println("getTile");
        int x = 0;
        int y = 0;
        GameLevel instance = null;
        Tile expResult = null;
        Tile result = instance.getTile(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoffeePositions method, of class GameLevel.
     */
    @Test
    public void testGetCoffeePositions() {
        System.out.println("getCoffeePositions");
        GameLevel instance = null;
        ArrayList<Pair<Integer, Integer>> expResult = null;
        ArrayList<Pair<Integer, Integer>> result = instance.getCoffeePositions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCoffeePositions method, of class GameLevel.
     */
    @Test
    public void testSetCoffeePositions() {
        System.out.println("setCoffeePositions");
        ArrayList<Pair<Integer, Integer>> coffeePositions = null;
        GameLevel instance = null;
        instance.setCoffeePositions(coffeePositions);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLevelWidth method, of class GameLevel.
     */
    @Test
    public void testGetLevelWidth() {
        System.out.println("getLevelWidth");
        GameLevel instance = null;
        int expResult = 0;
        int result = instance.getLevelWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLevelHeight method, of class GameLevel.
     */
    @Test
    public void testGetLevelHeight() {
        System.out.println("getLevelHeight");
        GameLevel instance = null;
        int expResult = 0;
        int result = instance.getLevelHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisplayWidth method, of class GameLevel.
     */
    @Test
    public void testGetDisplayWidth() {
        System.out.println("getDisplayWidth");
        GameLevel instance = null;
        int expResult = 0;
        int result = instance.getDisplayWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisplayHeight method, of class GameLevel.
     */
    @Test
    public void testGetDisplayHeight() {
        System.out.println("getDisplayHeight");
        GameLevel instance = null;
        int expResult = 0;
        int result = instance.getDisplayHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPathLoadingImage method, of class GameLevel.
     */
    @Test
    public void testGetPathLoadingImage() {
        System.out.println("getPathLoadingImage");
        GameLevel instance = null;
        String expResult = "";
        String result = instance.getPathLoadingImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJetpackPositions method, of class GameLevel.
     */
    @Test
    public void testGetJetpackPositions() {
        System.out.println("getJetpackPositions");
        GameLevel instance = null;
        ArrayList<Pair<Integer, Integer>> expResult = null;
        ArrayList<Pair<Integer, Integer>> result = instance.getJetpackPositions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeartPositions method, of class GameLevel.
     */
    @Test
    public void testGetHeartPositions() {
        System.out.println("getHeartPositions");
        GameLevel instance = null;
        ArrayList<Pair<Integer, Integer>> expResult = null;
        ArrayList<Pair<Integer, Integer>> result = instance.getHeartPositions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
