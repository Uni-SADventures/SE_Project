
package unisadventures.se_project.model;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.model.basicObjects.Platform;
import unisadventures.se_project.util.LevelStateMessenger;
import unisadventures.se_project.util.Pair;


public class LevelManagerTest {
    private LevelManager testLevelManager;
            
    public LevelManagerTest() {
       Platform  platform1 = new Platform(0, 0 , 1, 1, "test1");
       Platform  platform2 = new Platform(2, 2 , 4, 4, "test2");
       ArrayList<WorldObject> worldObjects = new ArrayList<>();
       worldObjects.add(platform1);
       worldObjects.add(platform2);
       testLevelManager = new LevelManager(10, 9, "test", worldObjects);
        
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
     * Test of tick method, of class LevelManager.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        
        LevelManager instance = testLevelManager;
        LevelStateMessenger expResult = new LevelStateMessenger();
        
        expResult.levelDimensions = new Pair<Double, Double>(new Double(10), new Double(9));
        expResult.backgroundImageFile = "test";
        LevelStateMessenger.ObjectData platformOneData = expResult.new ObjectData();
        platformOneData.objectPosition = new Pair<Double, Double>(new Double(0), new Double(0));
        platformOneData.objectDimensions = new Pair<Double, Double>(new Double(1), new Double(1));
        platformOneData.spriteImageFile = "test1";
        LevelStateMessenger.ObjectData platformTwoData = expResult.new ObjectData();
        platformTwoData.objectPosition = new Pair<Double, Double>(new Double(2), new Double(2));
        platformTwoData.objectDimensions = new Pair<Double, Double>(new Double(4), new Double(4));
        platformTwoData.spriteImageFile = "test2";
        expResult.objectsData = new ArrayList<>();
        expResult.objectsData.add(platformOneData);
        expResult.objectsData.add(platformTwoData);
        
        LevelStateMessenger result = instance.tick();
        assertEquals(expResult, result);

    }
    
    
    
    
}