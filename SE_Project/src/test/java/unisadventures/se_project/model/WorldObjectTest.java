package unisadventures.se_project.model;

import java.awt.Graphics;
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
    
    private final double _xPosition;
    private final double _yPosition;
    
    private final double _width;
    private final double _height;
    private final WorldObjectImpl _instance;
    
    public WorldObjectTest() {
        _xPosition = 1;
        _yPosition = 2;
        _width = 3;
        _height = 4;
        _instance = new WorldObjectImpl(_xPosition, _yPosition, _width, _height);
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
     * Test of getPosition method, of class WorldObject.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Pair<Double, Double> expResult = new Pair<>(1.0, 2.0);
        Pair<Double, Double> result = _instance.getPosition();
        assertEquals(expResult.getFirstElement(), result.getFirstElement());
        assertEquals(expResult.getSecondElement(), result.getSecondElement());
    }

    /**
     * Test of getDimension method, of class WorldObject.
     */
    @Test
    public void testGetDimension() {
        System.out.println("getDimension");
        Pair<Double, Double> expResult = new Pair<>(3.0, 4.0);
        Pair<Double, Double> result = _instance.getDimension();
        assertEquals(expResult.getFirstElement(), result.getFirstElement());
        assertEquals(expResult.getSecondElement(), result.getSecondElement());
    }

    public class WorldObjectImpl extends WorldObject {

        public WorldObjectImpl(double xPosition, double yPosition, double width, double height) {
            super(xPosition, yPosition, width, height);
        }

        @Override
        public void tick() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void render(Graphics g) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}