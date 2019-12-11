/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.view.gfx;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import unisadventures.se_project.model.Handler;

/**
 *Ths class is used as support for states, it puts on screen whatever it's needed to be
 * there
 * @author Emilio
 */
public class StateGraphics {

    private Handler _handler;

    public StateGraphics(Handler handler/*,World w */) {
        _handler = handler;
    }

    /**
     * This method exists to render only the scenario
     * @param g graphics that are needed to draw with
     */
    public void renderScenario(Graphics g) {
        g.drawImage(Assets.scenario, (int) -_handler.getCam().getxOffset(), (int) -_handler.getCam().getyOffset(), null);
      

    }
    
    
    /**
     * This method exists to render only the main character
     * @param g graphics that are needed to draw with
     * @param x x position of user
     * @param y y position of user
     */
    public void renderPlayer(Graphics g, double x, double y) {
        g.drawImage(Assets.player, (int) (x- _handler.getCam().getxOffset()), (int) (y-_handler.getCam().getyOffset()), null);

    }
    
    /**
     * This method draws on screen whatever object we want to visualize, only position
     * and an image are needed to do so
     * @param g graphics that are needed to draw with
     * @param x x position of the object
     * @param y y position of the object
     * @param sprite image needed to represent our object
     */
    public void renderStuffMore(Graphics g, double x, double y, BufferedImage sprite){
        g.drawImage( sprite, (int) (x- _handler.getCam().getxOffset()), (int) (y-_handler.getCam().getyOffset()), null);
    }
    
    
    public void renderUi(Graphics g, int health, int maxHealth, int cfu, int lives){
       g.drawImage(Assets.CFU,50,10,null);
       int j=35;

        boolean odd = (health %2 == 0) ;
        
        int pixelIncrementer = 1 ;
        for(int i = 2 ; i <= maxHealth; i += 2){
            if(health > 1)
                 g.drawImage(Assets.full_heart, 55 + (j * pixelIncrementer), 10, null);
            else if(health == 1){
                g.drawImage(Assets.half_heart, 55 + (j * pixelIncrementer), 10, null);
            } else
                g.drawImage(Assets.empty_heart, 55 + (j * pixelIncrementer), 10, null);
            health -= 2 ;
            pixelIncrementer++ ;    
        }
        cfu=20;
        int[] cfuDigits = String.valueOf(cfu).chars().map(Character::getNumericValue).toArray();
        
        pixelIncrementer = 0;
        for (int i = 0; i < cfuDigits.length; i++) {
           
            if (cfuDigits[i] == 0) {
                g.drawImage(Assets.zero, 10+pixelIncrementer, 10, null);
            } else if (cfuDigits[i] == 1) {
                g.drawImage(Assets.one, 10+pixelIncrementer, 10, null);
            } else if (cfuDigits[i] == 2) {
                g.drawImage(Assets.two, 10+pixelIncrementer, 10, null);
            } else if (cfuDigits[i] == 3) {
                g.drawImage(Assets.three, 10+pixelIncrementer, 10, null);
            } else if (cfuDigits[i] == 4) {
                g.drawImage(Assets.four, 10+pixelIncrementer, 10, null);
            } else if (cfuDigits[i] == 5) {
                g.drawImage(Assets.five, 10+pixelIncrementer, 10, null);
            } else if (cfuDigits[i] == 6) {
                g.drawImage(Assets.six, 10+pixelIncrementer, 10, null);
            } else if (cfuDigits[i] == 7) {
                g.drawImage(Assets.seven, 10+pixelIncrementer, 10, null);
            } else if (cfuDigits[i] == 8) {
                g.drawImage(Assets.eight, 10+pixelIncrementer, 10, null);
            } else if (cfuDigits[i] == 9) {
                g.drawImage(Assets.nine, 10+pixelIncrementer, 10, null);
            }
               pixelIncrementer +=7;
        }
        lives=20;
        pixelIncrementer +=0;
        int[] livesDigits = String.valueOf(lives).chars().map(Character::getNumericValue).toArray();
        for (int i = 0; i < livesDigits.length; i++) {
           
            if (livesDigits[i] == 0) {
                g.drawImage(Assets.zero, 200+pixelIncrementer, 10, null);
            } else if (livesDigits[i] == 1) {
                g.drawImage(Assets.one, 200+pixelIncrementer, 10, null);
            } else if (livesDigits[i] == 2) {
                g.drawImage(Assets.two, 200+pixelIncrementer, 10, null);
            } else if (livesDigits[i] == 3) {
                g.drawImage(Assets.four, 200+pixelIncrementer, 10, null);
            } else if (livesDigits[i] == 5) {
                g.drawImage(Assets.five, 200+pixelIncrementer, 10, null);
            } else if (livesDigits[i] == 6) {
                g.drawImage(Assets.six, 200+pixelIncrementer, 10, null);
            } else if (livesDigits[i] == 7) {
                g.drawImage(Assets.seven, 200+pixelIncrementer, 10, null);
            } else if (livesDigits[i] == 8) {
                g.drawImage(Assets.eight, 200+pixelIncrementer, 10, null);
            } else if (livesDigits[i] == 9) {
                g.drawImage(Assets.nine, 200+pixelIncrementer, 10, null);
            }
               pixelIncrementer +=7;
        }
        
        g.drawImage(Assets.full_heart, 210+pixelIncrementer, 10, null);
            //g.setColor(Color.red);
            //g.drawString("10", 15 + (j * 2), 50);
        
        
        
        }
    
}
