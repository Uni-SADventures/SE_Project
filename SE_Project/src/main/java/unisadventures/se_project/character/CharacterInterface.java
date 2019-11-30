/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing2;

/**
 *
 * @author Francesco
 */
public interface CharacterInterface {
    void moveLeft(double dx);
    void moveRight(double dx);
    void jump();
    void attack();
    void takeDamage();
    void grab();
}
