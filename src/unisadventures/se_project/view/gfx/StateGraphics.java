/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.view.gfx;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import unisadventures.se_project.model.Handler;
import unisadventures.se_project.model.character.actionCommands.ActionCommand;
import unisadventures.se_project.presenter.launcher.Game;

/**
 *Ths class is used as support for states, it puts on screen whatever it's needed to be
 * there
 * @author Emilio
 */
public class StateGraphics {

    private Handler _handler;
    protected Rectangle bounds;

    public StateGraphics(Handler handler/*,World w */) {
        _handler = handler;
    }

    /**
     * This method exists to render only the scenario
     * @param g graphics that are needed to draw with
     * @param x x position of user
     * @param y y position of user
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
        //g.setColor(Color.red);
        //g.fillRect((int) (x + bounds.x - _handler.getCam().getxOffset()), (int) (y + bounds.y - _handler.getCam().getyOffset()), bounds.width,bounds.height);
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
       // for(){
       // }
       // g.drawImage(Assets.scenario, (int) -_game.getCam().getxOffset(), (int) -_game.getCam().getyOffset(), null);
    }
}
