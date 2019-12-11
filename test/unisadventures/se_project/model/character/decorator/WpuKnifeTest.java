/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.decorator;

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
public class WpuKnifeTest {
    
    public WpuKnifeTest() {
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
     * Test of attack method, of class WpuKnife.
     */
    @Test
    public void testAttack() {
        //System.out.println("attack");
        WpuKnife instance = null;
        instance.attack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveLeft method, of class WpuKnife.
     */
    @Test
    public void testMoveLeft() {
        //System.out.println("moveLeft");
        WpuKnife instance = null;
        instance.moveLeft();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of jump method, of class WpuKnife.
     */
    @Test
    public void testJump() {
        //System.out.println("jump");
        WpuKnife instance = null;
        instance.jump();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fall method, of class WpuKnife.
     */
    @Test
    public void testFall() {
        //System.out.println("fall");
        WpuKnife instance = null;
        instance.fall();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takeDamage method, of class WpuKnife.
     */
    @Test
    public void testTakeDamage() {
        //System.out.println("takeDamage");
        int damage = 0;
        WpuKnife instance = null;
        instance.takeDamage(damage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPowered method, of class WpuKnife.
     */
    @Test
    public void testGetPowered() {
        //System.out.println("getPowered");
        PlayerCharacter p = null;
        WpuKnife instance = null;
        PlayerCharacter expResult = null;
        PlayerCharacter result = instance.getPowered(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of grab method, of class WpuKnife.
     */
    @Test
    public void testGrab() {
        //System.out.println("grab");
        WpuKnife instance = null;
        instance.grab();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveRight method, of class WpuKnife.
     */
    @Test
    public void testMoveRight() {
        //System.out.println("moveRight");
        WpuKnife instance = null;
        instance.moveRight();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
