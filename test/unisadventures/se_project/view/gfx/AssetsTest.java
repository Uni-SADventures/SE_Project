/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.view.gfx;

import java.awt.image.BufferedImage;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 *
 * @author Paolo
 */
public class AssetsTest {

    private BufferedImage img;

    public AssetsTest() {
        img = ImageLoader.loadImage("resources/images/character_sprite.png").getSubimage(48, 0, 16, 32);

    }

    @Test
    /*This is the only way to do a test to compare two BufferedImage objects. 
    Run a nested for loop that iterates over every pixel and compare the RGB integer of that pixel*/
    public void testImage() {
        Assets.init();

        try {
            BufferedImage player = Assets.player;
            int width = player.getWidth();
            int height = player.getHeight();
            System.out.println("Testing 1,2,12");
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    Assertions.assertEquals(player.getRGB(x, y), img.getRGB(x, y));
                }
            }

        } catch (Exception e) {
            Assertions.fail("Assertequals failed");
        }

    }
}
