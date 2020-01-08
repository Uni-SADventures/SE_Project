/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.model.character.PlayerCharacter;


/**
 *This interface represent all basic movement methods to implement for every type of character
 * @author Francesco
 */
public interface MovementsInterface {
    void moveLeft();
    void moveRight();
    void jump();
    void fall() ;
    void attack();
    void idle();
    void takeDamage(int damage);
    void grab();
    void tick();
}
