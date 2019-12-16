package unisadventures.se_project.model.basicObjects;

import java.util.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mathieu
 */
public class DestructibleObjectTest {
    
    private final int _xPosition;
    private final int _yPosition;
    private final int _height;
    private final int _width;
    private final LinkedList<Integer> _imageFileNameList;
    
    public DestructibleObjectTest() {
        _xPosition = 1;
        _yPosition = 2;
        _height = 3;
        _width = 4;
        _imageFileNameList = new LinkedList<>();
        _imageFileNameList.add(1);
        _imageFileNameList.add(2);
        _imageFileNameList.add(3);
    }
    
    

    /**
     * Test of getIntactImageFileName method, of class DestructibleObject.
     */
    @Test
    public void testGetIntactImageFileName() {
        System.out.println("getIntactImageFileName");
        DestructibleObject instance = new DestructibleObject(_xPosition, _yPosition, _height, _width);
        instance.setImageFileNameList(_imageFileNameList);
        int expResult = 1;
        int result = instance.getIntactImageFileName();
        assertEquals(expResult, result);
        instance.getNextDestructionImageFileName();
        result = instance.getIntactImageFileName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNextDestructionImageFileName method, of class DestructibleObject.
     */
    @Test
    public void testGetNextDestructionImageFileName() {
        System.out.println("getNextDestructionImageFileName");
        DestructibleObject instance = new DestructibleObject(_xPosition, _yPosition, _height, _width);
        instance.setImageFileNameList(_imageFileNameList);
        int expResult1 = 1;
        int expResult2 = 2;
        int expResult3 = 3;
        int result = instance.getNextDestructionImageFileName();
        assertEquals(expResult1, result);
        instance.takeDamage(1);
        result = instance.getNextDestructionImageFileName();
        assertEquals(expResult2, result);
        instance.takeDamage(1);
        result = instance.getNextDestructionImageFileName();
        assertEquals(expResult3, result);
        instance.takeDamage(1);
        result = instance.getNextDestructionImageFileName();
        assertEquals(expResult3, result);
    }

}