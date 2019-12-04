/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import java.awt.Graphics;
import unisadventures.se_project.util.DirectionType;

/**
 *
 * @author Francesco
 */
public class EnemyCharacter extends BasicCharacter {
    
    public EnemyCharacter(double x, double y, double h, double w, String name, int healthBar, int strenght, int maxHealth, double maxJump) {
        super(x,y,h,w,name, healthBar, strenght, maxHealth, maxJump);
    }
  /*  
    public AnimationTimer animationPattern(double R,double L){
       AnimationTimer enemyTimer = new AnimationTimer() {
            private int start = -1 ;
                    @Override
                    public void handle(long now) {
                      start++;
                      if(start <= 20)
                      move(R,DirectionType.RIGHT);
                      if(start>20 && start<40)
                         move(L,DirectionType.LEFT);
                      if(start>60)
                          start=-1;
                    }
       };    
        return enemyTimer;
         
        
       
    }
*/
    @Override
    public void attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void grab() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
