/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.Model.character.decorator;


import unisadventures.se_project.Model.character.CharacterInterface;

/**
 *
 * @author Emilio
 */
public class WpuKnife extends WeaponPowerup {

    public WpuKnife(CharacterInterface ch) {
        super(ch) ;
    }
    
    @Override
    public void attack() {
        //I can override every method but now i totally need to change only
        //this one because I'm working on a Knife
    }
    
}
