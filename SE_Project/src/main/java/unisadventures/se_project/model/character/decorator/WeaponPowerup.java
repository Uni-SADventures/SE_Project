/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.decorator;

import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.model.character.MovementsInterface;



/**
 *
 * @author Emilio
 */
public abstract class WeaponPowerup implements MovementsInterface {
    private MovementsInterface _playerCharacter ;

    public WeaponPowerup(MovementsInterface ch) {
        this._playerCharacter = ch;
    }
    
    
    
    @Override
    public void move(double W, DirectionType d) {
        _playerCharacter.move(W,d) ;
    }

 
    @Override
    public boolean jump(double H) {
        return _playerCharacter.jump(H) ;
    }

    @Override
    public boolean fall(double H) {
        return _playerCharacter.fall(H) ;
    }

    @Override
    public void attack() {
        _playerCharacter.attack();
    }

    @Override
    public void takeDamage(int damage) {
        _playerCharacter.takeDamage(damage);
    }

    @Override
    public void grab() {
        _playerCharacter.grab();
    }
   
    
}
