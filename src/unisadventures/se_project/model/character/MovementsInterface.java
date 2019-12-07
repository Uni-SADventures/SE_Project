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
    void moveLeft();
    void jump();
    void fall() ;
    void attack();
    void takeDamage(int damage);
    PlayerCharacter getPowered(PlayerCharacter p); 
    void grab();
}
