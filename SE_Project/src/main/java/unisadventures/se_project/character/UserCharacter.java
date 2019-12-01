/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.character;

import javafx.scene.image.Image;

/**
 *
 * @author Emilio
 */
public class UserCharacter extends Character {
    private int cfu = 0 ;
    //mettere tutti i collezionabili qui
    private String username ;
    private boolean powered ;
    public UserCharacter(Image sprite, String name, int healthBar, int strenght, int maxHealth, double maxJump, String username) {
        super(sprite, name, healthBar, strenght, maxHealth, maxJump);
        this.username = username ;
        this.powered = false ;
    }
    
    
    
    /*public void grab(InteractiveElement e) {
        //da fare quando avremo oggetto
        if (e.type == "weapon" || e.type == "powerup" )
            getPowered();
        else if(e.type == "cfu")
            cfu += e.value ; 
    }*/

    private void getPowered() {
      
    }
    
    
    
    

}
