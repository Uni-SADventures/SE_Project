/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.util.Pair;

/**
 *
 * @author mathieu
 */
public class WorldObjectTest {
    
    LevelManager _manager;
    private final double _xPosition;
    private final double _yPosition;
    private final double _width;
    private final double _height;
    private final WorldObjectImpl _instance;
    
    public WorldObjectTest() {
        _manager = new LevelManager(20, 10, "LevelManagerBackground");
        _xPosition = 1;
        _yPosition = 2;
        _width = 3;
        _height = 4;
        _instance = new WorldObjectImpl(_manager, _xPosition, _yPosition, _width, _height);
    }
    
    /**
     * Test of getPosition method, of class WorldObject.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Pair<Double, Double> expResult = new Pair<>(1.0, 2.0);
        Pair<Double, Double> result = _instance.getPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDimensions method, of class WorldObject.
     */
    @Test
    public void testGetDimensions() {
        System.out.println("getDimensions");
        Pair<Double, Double> expResult = new Pair<>(3.0, 4.0);
        Pair<Double, Double> result = _instance.getDimensions();
        assertEquals(expResult, result);
    }

    public class WorldObjectImpl extends WorldObject {

        public WorldObjectImpl(LevelManager manager, double xPosition, double yPosition, double width, double height) {
            super(manager, xPosition, yPosition, width, height);
        }

        public String tick() {
            return "";
        }

        public void takeDamage(int damage) {
        }
    }
    
}
