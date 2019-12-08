/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.view.gfx;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import unisadventures.se_project.presenter.launcher.Game;

/**
 *Ths class is used as support for states, it puts on screen whatever it's needed to be
 * there
 * @author Emilio
 */
public class StateGraphics {

    private Game _game;

    public StateGraphics(Game game/*,World w */) {
        _game = game;
    }

    /**
     * This method exists to render two thing: scenario and then the player character on screen
     * @param g graphics that are needed to draw with
     * @param x x position of user
     * @param y y position of user
     */
    public void render(Graphics g, double x, double y) {
        g.drawImage(Assets.scenario, (int) -_game.getCam().getxOffset(), (int) -_game.getCam().getyOffset(), null);
        g.drawImage(Assets.player, (int) (x- _game.getCam().getxOffset()), (int) (y-_game.getCam().getyOffset()), null);

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
        g.drawImage( sprite, (int) (x- _game.getCam().getxOffset()), (int) (y-_game.getCam().getyOffset()), null);
    }
}
