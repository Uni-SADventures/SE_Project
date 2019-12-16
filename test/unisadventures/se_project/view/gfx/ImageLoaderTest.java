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
    

    /**
     * Test of loadImage method, of class ImageLoader.
     */
    @Test
    public void testLoadImage() {
        ImageLoader l = new ImageLoader();
        BufferedImage b = l.loadImage("resources/images/sfondo_unisa_pixel.jpg") ;
        assertNotNull(b) ;
    }
    
}
