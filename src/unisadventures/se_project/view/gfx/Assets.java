package unisadventures.se_project.view.gfx;

import java.awt.image.BufferedImage;

/**
 * This class is needed to keep track both of main world objects and window's
 * weidth and height
 *
 * @author Panzuti
 */
public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage objects, tilesheet, player, scenario, ground, ground_1, grass, tree, enemy, CFU, full_heart, half_heart, empty_heart;
    public static BufferedImage rock, sky, limit;
    public static BufferedImage zero, one,two,three,four,five,six,seven,eight,nine;
    /*@author Emanuela Paolo 
    this method loads the sprites of the player, enemy and the main objects and tiles.
     */
    public static void init() {
        //load player,scenario and enemy
        player = ImageLoader.loadImage("resources/images/char.png");
        //     player = ImageLoader.loadImage("resources/images/character_sprite.png").getSubimage(48, 0, 16, height);
        scenario = ImageLoader.loadImage("resources/images/scenario.jpg");
        enemy = ImageLoader.loadImage("resources/images/enemy_sprite.png").getSubimage(16, 96, 16, height);

        //load tiles 
        tilesheet = ImageLoader.loadImage("resources/images/tilesheet1.png");
        ground = tilesheet.getSubimage(0, 0, width, height);
        ground_1 = tilesheet.getSubimage(64, 0, width, height);
        grass = tilesheet.getSubimage(0, 176, width, width / 2);
        tree = tilesheet.getSubimage(64, 128, width * 2, height * 2);

        //load objects
        objects = ImageLoader.loadImage("resources/images/objectstilesheet.png");
        CFU = objects.getSubimage(160, 0, width, height);
        full_heart = objects.getSubimage(0, 0, width, height);
        half_heart = objects.getSubimage(32, 0, width, height);
        empty_heart = objects.getSubimage(64, 0, width, height);
        zero = ImageLoader.loadImage("resources/images/numbers/Number0.png");
        one = ImageLoader.loadImage("resources/images/numbers/Number1.png");
        two = ImageLoader.loadImage("resources/images/numbers/Number2.png");
        three = ImageLoader.loadImage("resources/images/numbers/Number3.png");
        four = ImageLoader.loadImage("resources/images/numbers/Number4.png");
        five = ImageLoader.loadImage("resources/images/numbers/Number5.png");
        six = ImageLoader.loadImage("resources/images/numbers/Number6.png");
        seven = ImageLoader.loadImage("resources/images/numbers/Number7.png");
        eight = ImageLoader.loadImage("resources/images/numbers/Number8.png");
        nine = ImageLoader.loadImage("resources/images/numbers/Number9.png");

        //temp
        //to be correctly ordered
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("resources/images/grass.png"));
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("resources/images/background.png"));

        rock = sheet.crop(0, 0, 60, 60);
        sky = sheet1.crop(0, 0, 1000, 375);
        limit = sheet1.crop(0, 375, 1000, 375);

    }
}
