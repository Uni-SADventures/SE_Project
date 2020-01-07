/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.util.Pair;

/**
 *
 * @author mathieu
 */
public class BasicCharacterTest {
    
    private BasicCharacterImpl _character;
    
    public BasicCharacterTest() {
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
     * Test of getBeDamagedSprites method, of class BasicCharacter.
     */
    @Test
    public void testGetBeDamagedSprites() {
        _character = new BasicCharacterImpl();
        System.out.println("getBeDamagedSprites");
        DirectionType left = DirectionType.LEFT;
        DirectionType right = DirectionType.RIGHT;
        List<Integer> leftFacingSprites = new ArrayList<>();
        leftFacingSprites.add(0);
        leftFacingSprites.add(1);
        List<Integer> rightFacingSprites = new ArrayList<>();
        rightFacingSprites.add(2);
        rightFacingSprites.add(3);
        _character.setBeDamaged(leftFacingSprites, rightFacingSprites);
        _character.setFacing(left);
        List<Integer> result = _character.getBeDamagedSprites(left);
        assertEquals(leftFacingSprites, result);
        _character.setFacing(right);
        result = _character.getBeDamagedSprites(right);
        assertEquals(leftFacingSprites, result);
    }


    /**
     * Test of getIdleSprites method, of class BasicCharacter.
     */
    @Test
    public void testGetIdleSprites() {
        _character = new BasicCharacterImpl();
        System.out.println("getIdleSprites");
        DirectionType left = DirectionType.LEFT;
        DirectionType right = DirectionType.RIGHT;
        List<Integer> leftFacingSprites = new ArrayList<>();
        leftFacingSprites.add(4);
        leftFacingSprites.add(5);
        List<Integer> rightFacingSprites = new ArrayList<>();
        rightFacingSprites.add(6);
        rightFacingSprites.add(7);
        _character.setIdle(leftFacingSprites, rightFacingSprites);
        _character.setFacing(left);
        List<Integer> result = _character.getIdleSprites(left);
        assertEquals(leftFacingSprites, result);
        _character.setFacing(right);
        result = _character.getIdleSprites(right);
        assertEquals(leftFacingSprites, result);
    }

    /**
     * Test of getJumpSprites method, of class BasicCharacter.
     */
    @Test
    public void testGetJumpSprites() {
        _character = new BasicCharacterImpl();
        System.out.println("getJumpSprites");
        DirectionType left = DirectionType.LEFT;
        DirectionType right = DirectionType.RIGHT;
        List<Integer> leftFacingSprites = new ArrayList<>();
        leftFacingSprites.add(8);
        leftFacingSprites.add(9);
        List<Integer> rightFacingSprites = new ArrayList<>();
        rightFacingSprites.add(10);
        rightFacingSprites.add(11);
        _character.setJump(leftFacingSprites, rightFacingSprites);
        _character.setFacing(left);
        List<Integer> result = _character.getJumpSprites(left);
        assertEquals(leftFacingSprites, result);
        _character.setFacing(right);
        result = _character.getJumpSprites(right);
        assertEquals(leftFacingSprites, result);
    }

    /**
     * Test of getFallSprites method, of class BasicCharacter.
     */
    @Test
    public void testGetFallSprites() {
        _character = new BasicCharacterImpl();
        System.out.println("getFallSprites");
        DirectionType left = DirectionType.LEFT;
        DirectionType right = DirectionType.RIGHT;
        List<Integer> leftFacingSprites = new ArrayList<>();
        leftFacingSprites.add(12);
        leftFacingSprites.add(13);
        List<Integer> rightFacingSprites = new ArrayList<>();
        rightFacingSprites.add(14);
        rightFacingSprites.add(15);
        _character.setFall(leftFacingSprites, rightFacingSprites);
        _character.setFacing(left);
        List<Integer> result = _character.getFallSprites(left);
        assertEquals(leftFacingSprites, result);
        _character.setFacing(right);
        result = _character.getFallSprites(right);
        assertEquals(leftFacingSprites, result);
    }

    /**
     * Test of getPunchSprites method, of class BasicCharacter.
     */
    @Test
    public void testGetPunchSprites() {
        _character = new BasicCharacterImpl();
        System.out.println("getPunchSprites");
        DirectionType left = DirectionType.LEFT;
        DirectionType right = DirectionType.RIGHT;
        List<Integer> leftFacingSprites = new ArrayList<>();
        leftFacingSprites.add(16);
        leftFacingSprites.add(17);
        List<Integer> rightFacingSprites = new ArrayList<>();
        rightFacingSprites.add(18);
        rightFacingSprites.add(19);
        _character.setPunch(leftFacingSprites, rightFacingSprites);
        _character.setFacing(left);
        List<Integer> result = _character.getPunchSprites(left);
        assertEquals(leftFacingSprites, result);
        _character.setFacing(right);
        result = _character.getPunchSprites(right);
        assertEquals(leftFacingSprites, result);
    }

    /**
     * Test of getWalkSprites method, of class BasicCharacter.
     */
    @Test
    public void testGetWalkSprites() {
        _character = new BasicCharacterImpl();
        System.out.println("getWalkSprites");
        DirectionType left = DirectionType.LEFT;
        DirectionType right = DirectionType.RIGHT;
        List<Integer> leftFacingSprites = new ArrayList<>();
        leftFacingSprites.add(20);
        leftFacingSprites.add(21);
        List<Integer> rightFacingSprites = new ArrayList<>();
        rightFacingSprites.add(22);
        rightFacingSprites.add(23);
        _character.setWalk(leftFacingSprites, rightFacingSprites);
        _character.setFacing(left);
        List<Integer> result = _character.getWalkSprites(left);
        assertEquals(leftFacingSprites, result);
        _character.setFacing(right);
        result = _character.getWalkSprites(right);
        assertEquals(leftFacingSprites, result);
    }

    /**
     * Test of getFacing method, of class BasicCharacter.
     */
    @Test
    public void testGetFacing() {
        System.out.println("getFacing");
        BasicCharacter instance = null;
        DirectionType expResult = null;
        DirectionType result = instance.getFacing();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFacing method, of class BasicCharacter.
     */
    @Test
    public void testSetFacing() {
        System.out.println("setFacing");
        DirectionType facing = null;
        BasicCharacter instance = null;
        instance.setFacing(facing);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBeDamaged method, of class BasicCharacter.
     */
    @Test
    public void testSetBeDamaged() {
        System.out.println("setBeDamaged");
        List<Integer> left = null;
        List<Integer> right = null;
        BasicCharacter instance = null;
        instance.setBeDamaged(left, right);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWalk method, of class BasicCharacter.
     */
    @Test
    public void testSetWalk() {
        System.out.println("setWalk");
        List<Integer> left = null;
        List<Integer> right = null;
        BasicCharacter instance = null;
        instance.setWalk(left, right);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdle method, of class BasicCharacter.
     */
    @Test
    public void testSetIdle() {
        System.out.println("setIdle");
        List<Integer> left = null;
        List<Integer> right = null;
        BasicCharacter instance = null;
        instance.setIdle(left, right);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPunch method, of class BasicCharacter.
     */
    @Test
    public void testSetPunch() {
        System.out.println("setPunch");
        List<Integer> left = null;
        List<Integer> right = null;
        BasicCharacter instance = null;
        instance.setPunch(left, right);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJump method, of class BasicCharacter.
     */
    @Test
    public void testSetJump() {
        System.out.println("setJump");
        List<Integer> left = null;
        List<Integer> right = null;
        BasicCharacter instance = null;
        instance.setJump(left, right);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFall method, of class BasicCharacter.
     */
    @Test
    public void testSetFall() {
        System.out.println("setFall");
        List<Integer> left = null;
        List<Integer> right = null;
        BasicCharacter instance = null;
        instance.setFall(left, right);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHandler method, of class BasicCharacter.
     */
    @Test
    public void testGetHandler() {
        System.out.println("getHandler");
        BasicCharacter instance = null;
        Handler expResult = null;
        Handler result = instance.getHandler();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxJump method, of class BasicCharacter.
     */
    @Test
    public void testGetMaxJump() {
        System.out.println("getMaxJump");
        BasicCharacter instance = null;
        int expResult = 0;
        int result = instance.getMaxJump();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxJump method, of class BasicCharacter.
     */
    @Test
    public void testSetMaxJump() {
        System.out.println("setMaxJump");
        int maxJump = 0;
        BasicCharacter instance = null;
        instance.setMaxJump(maxJump);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpeed method, of class BasicCharacter.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        BasicCharacter instance = null;
        int expResult = 0;
        int result = instance.getSpeed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpeed method, of class BasicCharacter.
     */
    @Test
    public void testSetSpeed() {
        System.out.println("setSpeed");
        int speed = 0;
        BasicCharacter instance = null;
        instance.setSpeed(speed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCharacterType method, of class BasicCharacter.
     */
    @Test
    public void testGetCharacterType() {
        System.out.println("getCharacterType");
        BasicCharacter instance = null;
        CharacterType expResult = null;
        CharacterType result = instance.getCharacterType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHealthBar method, of class BasicCharacter.
     */
    @Test
    public void testGetHealthBar() {
        System.out.println("getHealthBar");
        BasicCharacter instance = null;
        int expResult = 0;
        int result = instance.getHealthBar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHealthBar method, of class BasicCharacter.
     */
    @Test
    public void testSetHealthBar() {
        System.out.println("setHealthBar");
        int healthBar = 0;
        BasicCharacter instance = null;
        instance.setHealthBar(healthBar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStrength method, of class BasicCharacter.
     */
    @Test
    public void testGetStrength() {
        System.out.println("getStrength");
        BasicCharacter instance = null;
        int expResult = 0;
        int result = instance.getStrength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStrength method, of class BasicCharacter.
     */
    @Test
    public void testSetStrength() {
        System.out.println("setStrength");
        int strength = 0;
        BasicCharacter instance = null;
        instance.setStrength(strength);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxHealth method, of class BasicCharacter.
     */
    @Test
    public void testGetMaxHealth() {
        System.out.println("getMaxHealth");
        BasicCharacter instance = null;
        int expResult = 0;
        int result = instance.getMaxHealth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxHealth method, of class BasicCharacter.
     */
    @Test
    public void testSetMaxHealth() {
        System.out.println("setMaxHealth");
        int maxHealth = 0;
        BasicCharacter instance = null;
        instance.setMaxHealth(maxHealth);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takeDamage method, of class BasicCharacter.
     */
    @Test
    public void testTakeDamage() {
        System.out.println("takeDamage");
        int dam = 0;
        BasicCharacter instance = null;
        instance.takeDamage(dam);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of die method, of class BasicCharacter.
     */
    @Test
    public void testDie() {
        System.out.println("die");
        BasicCharacter instance = null;
        instance.die();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setxPosition method, of class BasicCharacter.
     */
    @Test
    public void testSetxPosition() {
        System.out.println("setxPosition");
        int _xPosition = 0;
        BasicCharacter instance = null;
        instance.setxPosition(_xPosition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setyPosition method, of class BasicCharacter.
     */
    @Test
    public void testSetyPosition() {
        System.out.println("setyPosition");
        int _yPosition = 0;
        BasicCharacter instance = null;
        instance.setyPosition(_yPosition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class BasicCharacter.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        BasicCharacter instance = null;
        Pair<Integer, Integer> expResult = null;
        Pair<Integer, Integer> result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDimension method, of class BasicCharacter.
     */
    @Test
    public void testGetDimension() {
        System.out.println("getDimension");
        BasicCharacter instance = null;
        Pair<Integer, Integer> expResult = null;
        Pair<Integer, Integer> result = instance.getDimension();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getxPosition method, of class BasicCharacter.
     */
    @Test
    public void testGetxPosition() {
        System.out.println("getxPosition");
        BasicCharacter instance = null;
        int expResult = 0;
        int result = instance.getxPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getyPosition method, of class BasicCharacter.
     */
    @Test
    public void testGetyPosition() {
        System.out.println("getyPosition");
        BasicCharacter instance = null;
        int expResult = 0;
        int result = instance.getyPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class BasicCharacterImpl extends BasicCharacter {

        public BasicCharacterImpl() {
            super(null, 0, 0, 0, 0, null, 0, 0, 0, 0);
        }
    }
    
}
