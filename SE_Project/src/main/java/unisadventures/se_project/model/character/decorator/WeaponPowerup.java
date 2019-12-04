/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.character.decorator;

import model.character.CharacterInterface;
import util.DirectionType;



/**
 *
 * @author Emilio
 */
public abstract class WeaponPowerup implements CharacterInterface{
    private CharacterInterface ch ;

    public WeaponPowerup(CharacterInterface ch) {
        this.ch = ch;
    }
    
    
    
    @Override
    public void move(double W, DirectionType d) {
        ch.move(W,d) ;
    }

 
    @Override
    public boolean jump(double H) {
        return ch.jump(H) ;
    }

    @Override
    public boolean fall(double H) {
        return ch.fall(H) ;
    }

    @Override
    public void attack() {
        ch.attack();
    }

    @Override
    public void takeDamage(int damage) {
        ch.takeDamage(damage);
    }

    @Override
    public void grab() {
        ch.grab();
    }
   
    
}
