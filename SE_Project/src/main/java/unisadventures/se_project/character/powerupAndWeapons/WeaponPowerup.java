/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.character.powerupAndWeapons;

import unisadventures.se_project.character.CharacterInterface;


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
    public void moveLeft(double W) {
        ch.moveLeft(W) ;
    }

    @Override
    public void moveRight(double W) {
        ch.moveRight(W);
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
