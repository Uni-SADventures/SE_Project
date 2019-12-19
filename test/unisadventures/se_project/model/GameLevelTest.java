
package unisadventures.se_project.model;

import java.io.IOException;
import org.testng.annotations.Test;
import unisadventures.se_project.model.basicObjects.Tile;

import org.testng.annotations.Test;
import unisadventures.se_project.model.basicObjects.Tile;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author Emilio
 */
public class GameLevelTest {
    private String _path, _path1;
    private int _width, _height ;
    public GameLevelTest() {
       _path = "resources/images/world1.txt";
       _path1 = "resources/images/world2.txt";
       _width = 600 ;
       _height = 600 ;
    }
    
   

    /**
     * Test of hit method, of class HitCommand.
     */
    @Test
    public void testCreationAndGetTile() throws IOException {
        GameLevel level = new GameLevel(_path,_path1,_width,_height) ;
        assertNotNull(level) ;
        
        
    }
    
}
