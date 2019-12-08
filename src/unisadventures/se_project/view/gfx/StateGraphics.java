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
 *
 * @author Emilio
 */
public class StateGraphics {

    private Game _game;

    public StateGraphics(Game game/*,World w */) {
        _game = game;
    }

    public void render(Graphics g, double x, double y) {
        g.drawImage(Assets.scenario, (int) -_game.getCam().getxOffset(), (int) -_game.getCam().getyOffset(), null);
        g.drawImage(Assets.player, (int) (x- _game.getCam().getxOffset()), (int) (y-_game.getCam().getyOffset()), null);

    }
    
    public void renderStuffMore(Graphics g, double x, double y, BufferedImage sprite){
        g.drawImage( sprite, (int) (x- _game.getCam().getxOffset()), (int) (y-_game.getCam().getyOffset()), null);
    }
}
