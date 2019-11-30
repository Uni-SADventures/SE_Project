/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing2;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.*;
import javafx.scene.image.*;


/**
 *
 * @author Francesco
 */
public class Character extends ImageView implements CharacterInterface  {
    private String name;
    private int healthBar;
    private int strenght;
    private int maxHealth;

    public Character(Image sprite,String name, int healthBar, int strenght, int maxHealth) {
        super(sprite);
        this.name = name;
        this.healthBar = healthBar;
        this.strenght = strenght;
        this.maxHealth = maxHealth;
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

        double x = cx + this.getLayoutX() - 1;
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

        double x = cx + this.getLayoutX() + 1;
        double y = cy + this.getLayoutY();

        if (x - cx >= 0 &&
            x + cx <= W ) {
            this.relocate(x - cx, y - cy);
        }
    }

    @Override
    public void jump() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void takeDamage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void grab() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}