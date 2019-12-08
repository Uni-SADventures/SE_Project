
package unisadventures.se_project.util;

import java.util.ArrayList;


public class LevelStateMessenger {
   public Pair<Double, Double> levelDimensions;
   public String backgroundImageFile;
   public ArrayList<ObjectData> objectsData;
   
   public class ObjectData{
       public Pair<Double, Double> objectPosition;
       public Pair<Double, Double> objectDimensions;
       public String spriteImageFile;
   }
}
