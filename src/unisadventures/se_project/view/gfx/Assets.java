package unisadventures.se_project.view.gfx;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is needed to keep track both of main world objects and window's
 * weidth and height
 *
 * @author Panzuti
 */
public class Assets {

   // private static final int width = 32, height = 32;

    //public static BufferedImage objects, tilesheet, player, scenario, ground, ground_1, grass, tree, enemy, CFU, full_heart, half_heart, empty_heart;
    //public static BufferedImage rock, sky, limit;
   // public static BufferedImage zero, one,two,three,four,five,six,seven,eight,nine;
    private static Map<Integer,BufferedImage>   _images;
    private static int _sequence ;
    private static BufferedImage _temporarySheet ;
    private static String _temporarySheetName ;
    /*@author Emanuela Paolo 
    this method loads the sprites of the player, enemy and the main objects and tiles.
     */
    public static void init() {
        
        _images = new HashMap<>();
        _sequence = 0 ;
    }    
        
    
    public static void storeImage(String path ){
        _sequence++ ;
        BufferedImage image = ImageLoader.loadImage(path);
        _images.put(_sequence, image) ;
        _temporarySheetName = null ;
        
    }
    
    public static void storeImage(String path, int initX, int initY, int finalX, int finalY) {
        _sequence++;
        if (_temporarySheetName == null || !_temporarySheetName.equals(path)) {
            _temporarySheetName = path;
            
            _temporarySheet = ImageLoader.loadImage(path);
        }
        BufferedImage image = _temporarySheet.getSubimage(initX, initY, finalX, finalY);
        _images.put(_sequence, image);

    }
    
    public static void storeImage(String path, int finalX, int finalY ){
         storeImage( path,0, 0, finalX, finalY ) ;
        
    }

    public static int getActualSequenceNumber() {
        return _sequence;
    }
    
    public static BufferedImage retrieveImage(int id){
        if(_images.containsKey(id))
            return _images.get(id) ;
        else
            return null ;
    }
    
    
    
    
    
    
    
}

