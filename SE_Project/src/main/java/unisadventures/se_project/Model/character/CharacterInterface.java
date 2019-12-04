/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.character;

import util.DirectionType;



/**
 *
 * @author Francesco
 */
public interface CharacterInterface {
    void move(double W, DirectionType D);
    boolean jump(double H);
    boolean fall(double H) ;
    void attack();
    void takeDamage(int damage);
    void grab();
}
