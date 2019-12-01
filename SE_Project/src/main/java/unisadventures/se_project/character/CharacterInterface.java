/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.character;

/**
 *
 * @author Francesco
 */
public interface CharacterInterface {
    void moveLeft(double W);
    void moveRight(double W);
    boolean jump(double H);
    boolean fall(double H) ;
    void attack();
    void takeDamage();
    void grab();
}
