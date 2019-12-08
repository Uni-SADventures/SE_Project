/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.decorator;

import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.model.character.MovementsInterface;



/**
 *USED PATTERN: DECORATOR
 * It decorates a character with a new powerup or weapon.
 * It keeeps track its relative playercharacter
 * @author Emilio
 */
public abstract class WeaponPowerup implements MovementsInterface {
    private MovementsInterface _playerCharacter ;

    public WeaponPowerup(MovementsInterface ch) {
        this._playerCharacter = ch;
    }
    
    
    
    //TODO
   
    
}
