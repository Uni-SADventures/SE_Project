package unisadventures.se_project.model.basicObjects;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.util.CollectibleType;

/**
 *
 * @author mathieu
 */
public class CollectibleItemTest {
    private LinkedList<Integer> _imageFileNameList;
    private final int _xPosition;
    private final int _yPosition;
    private final int _height;
    private final int _width;
    
    private final CollectibleType _type;
    
    public CollectibleItemTest() {
        _xPosition = 1;
        _yPosition = 2;
        _height = 3;
        _width = 4;
        _type = CollectibleType.CREDIT;
        _imageFileNameList = new LinkedList<>();
        _imageFileNameList.add(1);
        _imageFileNameList.add(2);
        _imageFileNameList.add(3);
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
     * Test of getNextImageFileName method, of class CollectibleItem.
     */
    @Test
    public void testGetNextImageFileName() {
        System.out.println("getNextImageFileName");
        CollectibleItem instance = new CollectibleItem(_xPosition, _yPosition, _height, _width, _type);
        instance.setImageFileNameList(_imageFileNameList);
        int expResult1 = 1;
        int expResult2 = 2;
        int expResult3 = 3;
        int expResult4 = 1;
        int result = instance.getNextImageFileName();
        assertEquals(expResult1, result);
        result = instance.getNextImageFileName();
        assertEquals(expResult2, result);
        result = instance.getNextImageFileName();
        assertEquals(expResult3, result);
        result = instance.getNextImageFileName();
        assertEquals(expResult4, result);
        //let's test counter
        instance.resetCounter();
        Assertions.assertEquals(instance.getNextImageFileName(), expResult1);
    }

    /**
     * Test of getCollectibleType method, of class CollectibleItem.
     */
    @Test
    public void testGetCollectibleType() {
        System.out.println("getCollectibleType");
        CollectibleItem instance = new CollectibleItem(_xPosition, _yPosition, _height, _width, _type);
        CollectibleType expResult = CollectibleType.CREDIT;
        CollectibleType result = instance.getCollectibleType();
        assertEquals(expResult, result);
        Assertions.assertNotEquals(instance, null, "collectible object's constructor doesn't work");
    }
    
}