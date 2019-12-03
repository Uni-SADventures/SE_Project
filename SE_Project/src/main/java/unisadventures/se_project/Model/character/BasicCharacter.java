/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.Model.character;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.*;
import javafx.scene.image.*;
import unisadventures.se_project.util.DirectionType;


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
    private double speed ;
    public BasicCharacter(Image sprite,String name, int healthBar, int strenght, int maxHealth, double maxJump) {
        super(sprite);
        this.name = name;
        this.healthBar = healthBar;
        this.strenght = strenght;
        this.maxHealth = maxHealth;
        this.maxJump = maxJump;
        initJump = -1 ;
        speed = 5 ;
    }

    public double getMaxJump() {
        return maxJump;
    }

    public void setMaxJump(double maxJump) {
        this.maxJump = maxJump;
    }

    public double getInitJump() {
        return initJump;
    }

    public void setInitJump(double initJump) {
        this.initJump = initJump;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
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
    public void move(double W,DirectionType d) {
        final double charCenterX = this.getBoundsInLocal().getWidth()  / 2;
        final double charCenterY = this.getBoundsInLocal().getHeight() / 2;

        double absolX = charCenterX + this.getLayoutX();
        double absolY = charCenterY + this.getLayoutY();
        
        if(d == DirectionType.LEFT)
            absolX -= speed ;
        else if (d == DirectionType.RIGHT)
            absolX += speed ;
        
        if (absolX - charCenterX >= 0 &&
            absolX + charCenterX <= W ) {
            this.relocate(absolX - charCenterX, absolY - charCenterY);
        }
    }


    @Override
    public boolean jump(double H) {

        final double charCenterX = getBoundsInLocal().getWidth() / 2;
        final double charCenterY = getBoundsInLocal().getHeight() / 2;

        double absolX = charCenterX + getLayoutX();
        double absolY = charCenterY + getLayoutY() - 10;
        if (this.initJump == -1) {
            this.initJump = H - absolY;
        }

        if (absolY - charCenterY >= 0
                && absolY + charCenterY <= H
                && (H-absolY)-initJump < maxJump ) {
            
            relocate(absolX - charCenterX, absolY - charCenterY);
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

        double charCenterX = getBoundsInLocal().getWidth() / 2;
        double charCenterY = getBoundsInLocal().getHeight() / 2;

        double absolX = charCenterX + getLayoutX();
        double absolY = charCenterY + getLayoutY() + 10;

        if (absolY + charCenterY <= H-100) {
           
            relocate(absolX - charCenterX, absolY - charCenterY);
            return true;
        } else {
            initJump = -1;
            return false ;
        }

    }

    

}