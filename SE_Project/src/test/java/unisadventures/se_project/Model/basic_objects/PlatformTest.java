/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.Model.basic_objects;

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
public class PlatformTest {
    
    private final double _xPosition;
    private final double _yPosition;
    private final double _height;
    private final double _width;
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
