package unisadventures.se_project.view.gfx;

import java.awt.image.BufferedImage;
/**
 * This class is needed to keep track both of main world objects and window's weidth and height
 * @author Panzuti
 */
public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player, scenario,rock,sky,limit;

	public static void init(){
                player = ImageLoader.loadImage("resources/images/char.png");
       
                
                scenario = ImageLoader.loadImage("resources/images/scenario.jpg") ; 
                SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("resources/images/grass.png"));
                SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("resources/images/background.png"));

                rock=sheet.crop(0, 0, 60, 60);
                sky=sheet1.crop(0, 0, 1000, 375);
                limit=sheet1.crop(0,375,1000,375);
	}
/*	public static void changeImage(String path){
                SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(path));
		
		player = sheet.crop(0, 0, width, height);
        
        }*/
}
