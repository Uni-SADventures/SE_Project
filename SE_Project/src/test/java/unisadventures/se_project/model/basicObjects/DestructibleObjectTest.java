package unisadventures.se_project.model.basicObjects;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mathieu
 */
public class DestructibleObjectTest {
    
    private final double _xPosition;
    private final double _yPosition;
    private final double _height;
    private final double _width;
    private final ArrayList<String> _imageFileNameList;
    
    public DestructibleObjectTest() {
        _xPosition = 1;
        _yPosition = 2;
        _height = 3;
        _width = 4;
        _imageFileNameList = new ArrayList<>();
        _imageFileNameList.add("IntactObject");
        _imageFileNameList.add("firstFrameDestruction");
        _imageFileNameList.add("secondFrameDestruction");
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
     * Test of getIntactImageFileName method, of class DestructibleObject.
     */
    @Test
    public void testGetIntactImageFileName() {
        System.out.println("getIntactImageFileName");
        DestructibleObject instance = new DestructibleObject(_xPosition, _yPosition, _height, _width, _imageFileNameList);
        String expResult = "IntactObject";
        String result = instance.getIntactImageFileName();
        assertEquals(expResult, result);
        result = instance.getIntactImageFileName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNextDestructionImageFileName method, of class DestructibleObject.
     */
    @Test
    public void testGetNextDestructionImageFileName() {
        System.out.println("getNextDestructionImageFileName");
        DestructibleObject instance = new DestructibleObject(_xPosition, _yPosition, _height, _width, _imageFileNameList);;
        String expResult1 = "firstFrameDestruction";
        String expResult2 = "secondFrameDestruction";
        String expResult3 = null;
        String result = instance.getNextDestructionImageFileName();
        assertEquals(expResult1, result);
        result = instance.getNextDestructionImageFileName();
        assertEquals(expResult2, result);
        result = instance.getNextDestructionImageFileName();
        assertEquals(expResult3, result);
        result = instance.getNextDestructionImageFileName();
        assertEquals(expResult3, result);
    }

}