/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.character;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.*;
import javafx.scene.image.*;


/**
 *
 * @author Francesco
 */
public abstract class BasicCharacter extends ImageView implements CharacterInterface  {
    private String name;
    private int healthBar;
    private int strenght;
    private int maxHealth;
    private double maxJump ;
    private double initJump ;
    public BasicCharacter(Image sprite,String name, int healthBar, int strenght, int maxHealth, double maxJump) {
        super(sprite);
        this.name = name;
        this.healthBar = healthBar;
        this.strenght = strenght;
        this.maxHealth = maxHealth;
        this.maxJump = maxJump;
        initJump = -1 ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthBar() {
        return healthBar;
    }

    public void setHealthBar(int healthBar) {
        this.healthBar = healthBar;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

 
    
    @Override
    public void moveLeft(double W) {
       final double cx = this.getBoundsInLocal().getWidth()  / 2;
        final double cy = this.getBoundsInLocal().getHeight() / 2;

        double x = cx + this.getLayoutX() - 5;
        double y = cy + this.getLayoutY();

        if (x - cx >= 0 &&
            x + cx <= W ) {
            this.relocate(x - cx, y - cy);
        }
    }

    @Override
    public void moveRight(double W) {
      
        final double cx = this.getBoundsInLocal().getWidth()  / 2;
        final double cy = this.getBoundsInLocal().getHeight() / 2;

        double x = cx + this.getLayoutX() + 5;
        double y = cy + this.getLayoutY();

        if (x - cx >= 0 &&
            x + cx <= W ) {
            this.relocate(x - cx, y - cy);
        }
    }

    @Override
    public boolean jump(double H) {

        final double cx = getBoundsInLocal().getWidth() / 2;
        final double cy = getBoundsInLocal().getHeight() / 2;

        double x = cx + getLayoutX();
        double y = cy + getLayoutY() - 10;
        if (this.initJump == -1) {
            this.initJump = H - y;
        }

        if (y - cy >= 0
                && y + cy <= H
                && (H-y)-initJump < maxJump ) {
            
            relocate(x - cx, y - cy);
            return true;
        }
        
        
        return false;
    }

    @Override
    public void takeDamage(int dam) {
        if(this.healthBar > dam)
            this.healthBar -= dam;
        else
            die() ;
    }
    
    public void die() {
    //when health goes to 0 we have to manage how to put away a life when we have a menu
    }
  
    @Override
    public boolean fall(double H) {

        double cx = getBoundsInLocal().getWidth() / 2;
        double cy = getBoundsInLocal().getHeight() / 2;

        double x = cx + getLayoutX();
        double y = cy + getLayoutY() + 10;

        if (y + cy <= H-100) {
           
            relocate(x - cx, y - cy);
            return true;
        } else {
            initJump = -1;
            return false ;
        }

    }

    

}