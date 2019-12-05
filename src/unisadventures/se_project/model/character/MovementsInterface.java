/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import unisadventures.se_project.util.DirectionType;



/**
 *
 * @author Francesco
 */
public interface MovementsInterface {
    void move(double W, DirectionType D);
    boolean jump(double H);
    boolean fall(double H) ;
    void attack();
    void takeDamage(int damage);
    void grab();
}
