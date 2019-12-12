package unisadventures.se_project.model.basicObjects;

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
public class PlatformTest {
    
    private final int _xPosition;
    private final int _yPosition;
    private final int _height;
    private final int _width;
    private final String _imageFileName;
    private final Platform _instance;
    
    
    public PlatformTest() {
        _xPosition = 1;
        _yPosition = 2;
        _height = 3;
        _width = 4;
        _imageFileName = "test";
        _instance = new Platform(_xPosition, _yPosition, _height, _width, _imageFileName);
        
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

    @Test
    public void testGetImageFileName() {
        System.out.println("getImageFileName");
        String expResult = "test";
        String result = _instance.getImageFileName();
        assertEquals(expResult, result);
    }
    
}