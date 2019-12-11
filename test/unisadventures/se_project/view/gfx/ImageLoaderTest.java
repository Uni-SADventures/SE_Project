/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.view.gfx;

import java.awt.image.BufferedImage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.testng.annotations.Test;

/**
 *
 * @author Emilio
 */
public class ImageLoaderTest {

    public ImageLoaderTest() {
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
     * Test of loadImage method, of class ImageLoader.
     */
    @Test
    public void testLoadImage() {

        String path = "";
        BufferedImage expResult = null;
        BufferedImage result = ImageLoader.loadImage("resources/images/char.png");
        Assertions.assertNotEquals(expResult, result);
    }

}
