package unisadventures.se_project.view.gfx;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * This class is mainly used as static class to buffer images from a path string
 * @author Panzuti
 */
public class ImageLoader {
        /**
         *
         * @param path is the string where the file should be
         * @return the initialized image
         */
	public static BufferedImage loadImage(String path){
		try {
			return ImageIO.read(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
