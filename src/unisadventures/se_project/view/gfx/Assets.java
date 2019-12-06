package unisadventures.se_project.view.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player, scenario, dirt, grass, stone, tree;

	public static void init(){
                player = ImageLoader.loadImage("resources/images/char.png");
       
                
                scenario = ImageLoader.loadImage("resources/images/scenario.jpg") ; 
		//SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res/textures/char.png"));
            
		//SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res/textures/sheet.png"));
		
		//player = sheet.crop(0, 0, width, height);
		//dirt = sheet.crop(width, 0, width, height);
		///grass = sheet.crop(width * 2, 0, width, height);
		//stone = sheet.crop(width * 3, 0, width, height);
		//tree = sheet.crop(0, height, width, height);
	}
	public static void changeImage(String path){
                SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(path));
		
		player = sheet.crop(0, 0, width, height);
        
        }
}
