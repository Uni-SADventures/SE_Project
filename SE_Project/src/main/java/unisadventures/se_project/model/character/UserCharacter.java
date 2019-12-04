/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.Model.character;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;

/**
 *
 * @author Emilio
 */
public class UserCharacter extends BasicCharacter {
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

    @Override
    public void attack() {
        AnimationTimer punch = new AnimationTimer(){
            private int start = -1 ;

            @Override
            public void handle(long now) {
                start++ ;
                if(start == 0)
                    setImage(new Image("https://imgur.com/gallery/XFdGg")) ;
                if(start == 3)
                    setImage(new Image("https://i.imgur.com/j2K6SvP.png")) ;
                if(start == 6)
                    setImage(new Image("https://i.imgur.com/I3IeSSm.jpg")) ;
                
                if(start == 9){
                    setImage(new Image("https://i.imgur.com/I3IeSSm.jpg")) ;
                    
                    //I have to see who or what I'm trying to punch, even to get if 
                    //there's one and,then, deal the damage
                }
                if(start == 12){
                    setImage(new Image("https://i.imgur.com/2NEzBZJ.png")) ;
                    this.stop() ;
                }
            }
        };
        
        punch.start();
    }

    @Override
    public void grab() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

}
