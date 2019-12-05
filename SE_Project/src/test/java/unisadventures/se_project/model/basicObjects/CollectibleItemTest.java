package unisadventures.se_project.model.basicObjects;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.util.CollectibleType;

/**
 *
 * @author mathieu
 */
public class CollectibleItemTest {
    
    private final double _xPosition;
    private final double _yPosition;
    private final double _height;
    private final double _width;
    private final ArrayList<String> _imageFileNameList;
    private final CollectibleType _type;
    
    public CollectibleItemTest() {
        _xPosition = 1;
        _yPosition = 2;
        _height = 3;
        _width = 4;
        _type = CollectibleType.CREDIT;
        _imageFileNameList = new ArrayList<>();
        _imageFileNameList.add("firstFrame");
        _imageFileNameList.add("secondFrame");
        _imageFileNameList.add("thirdFrame");
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
        CollectibleItem instance = new CollectibleItem(_xPosition, _yPosition, _height, _width, _imageFileNameList, _type);
        String expResult1 = "firstFrame";
        String expResult2 = "secondFrame";
        String expResult3 = "thirdFrame";
        String expResult4 = "firstFrame";
        String result = instance.getNextImageFileName();
        assertEquals(expResult1, result);
        result = instance.getNextImageFileName();
        assertEquals(expResult2, result);
        result = instance.getNextImageFileName();
        assertEquals(expResult3, result);
        result = instance.getNextImageFileName();
        assertEquals(expResult4, result);
    }

    /**
     * Test of getCollectibleType method, of class CollectibleItem.
     */
    @Test
    public void testGetCollectibleType() {
        System.out.println("getCollectibleType");
        CollectibleItem instance = new CollectibleItem(_xPosition, _yPosition, _height, _width, _imageFileNameList, _type);
        CollectibleType expResult = CollectibleType.CREDIT;
        CollectibleType result = instance.getCollectibleType();
        assertEquals(expResult, result);
    }
    
}