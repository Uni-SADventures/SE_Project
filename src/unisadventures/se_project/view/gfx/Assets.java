package unisadventures.se_project.view.gfx;

import java.awt.image.BufferedImage;
/**
 * This class is needed to keep track both of main world objects and window's weidth and height
 * @author Panzuti
 */
public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage objects, tilesheet, player, scenario, ground, ground_1, grass, tree, enemy, CFU, heart, heart_1, heart_2;

	public static void init(){
                player = ImageLoader.loadImage("resources/images/character_sprite.png");
                player = player.getSubimage(48,0,16,height);
                
                
                scenario = ImageLoader.loadImage("resources/images/scenario.jpg") ; 
               
                
                tilesheet = ImageLoader.loadImage("resources/images/tilesheet1.png");
                ground = tilesheet.getSubimage(0, 0, width, height);
                ground_1 = tilesheet.getSubimage(64, 0, width, height);
                grass = tilesheet.getSubimage(0, 176, width, 16);
                tree = tilesheet.getSubimage(64, 128, width*2, height*2);
                
                
                enemy = ImageLoader.loadImage("resources/images/enemy_sprite.png");
                enemy= enemy.getSubimage(16, 96, 16, height);
                
                
                objects=ImageLoader.loadImage("resources/images/objectstilesheet.png");
                CFU = objects.getSubimage(160, 0, width, height);
                heart = objects.getSubimage(0, 0, width, height);
                heart_1 = objects.getSubimage(32, 0, width, height);
                heart_2 = objects.getSubimage(64, 0, width, height);
                
                
		//SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res/textures/char.png"));
            
		//SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res/textures/sheet.png"));
		
		//player = sheet.crop(0, 0, width, height);
		//dirt = sheet.crop(width, 0, width, height);
		///grass = sheet.crop(width * 2, 0, width, height);
		//stone = sheet.crop(width * 3, 0, width, height);
		//tree = sheet.crop(0, height, width, height);
	}
/*	public static void changeImage(String path){
                SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(path));
		
		player = sheet.crop(0, 0, width, height);
        
        }*/
}
