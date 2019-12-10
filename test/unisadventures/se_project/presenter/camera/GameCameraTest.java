/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.camera;

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
public class GameCameraTest {
    
    public GameCameraTest() {
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
     * Test of centerOnEntity method, of class GameCamera.
     */
    @Test
    public void testCenterOnEntity() {
        System.out.println("centerOnEntity");
        PlayerCharacter p = null;
        GameCamera instance = null;
        instance.centerOnEntity(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of centerOnEntityFloor method, of class GameCamera.
     */
    @Test
    public void testCenterOnEntityFloor() {
        System.out.println("centerOnEntityFloor");
        PlayerCharacter p = null;
        GameCamera instance = null;
        instance.centerOnEntityFloor(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class GameCamera.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        float xAmt = 0.0F;
        float yAmt = 0.0F;
        GameCamera instance = null;
        instance.move(xAmt, yAmt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getxOffset method, of class GameCamera.
     */
    @Test
    public void testGetxOffset() {
        System.out.println("getxOffset");
        GameCamera instance = null;
        float expResult = 0.0F;
        float result = instance.getxOffset();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setxOffset method, of class GameCamera.
     */
    @Test
    public void testSetxOffset() {
        System.out.println("setxOffset");
        float xOffset = 0.0F;
        GameCamera instance = null;
        instance.setxOffset(xOffset);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getyOffset method, of class GameCamera.
     */
    @Test
    public void testGetyOffset() {
        System.out.println("getyOffset");
        GameCamera instance = null;
        float expResult = 0.0F;
        float result = instance.getyOffset();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setyOffset method, of class GameCamera.
     */
    @Test
    public void testSetyOffset() {
        System.out.println("setyOffset");
        float yOffset = 0.0F;
        GameCamera instance = null;
        instance.setyOffset(yOffset);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
