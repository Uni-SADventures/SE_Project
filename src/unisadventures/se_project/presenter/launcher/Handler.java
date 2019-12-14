/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.launcher;

import unisadventures.se_project.model.GameLevel;
import unisadventures.se_project.presenter.camera.GameCamera;
import unisadventures.se_project.presenter.input.KeyManager;

/**
 *
 * @author krist
 */
public class Handler {
     
    private Game game;
    private GameLevel world;
    
    public Handler(Game game) {
        this.game=game;
    }
    
    public GameCamera getCam(){
        return game.getCam();
    }
    
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    
    public int getDisplayWidth(){
        return game.getDisplayWidth();
    }

    public int getDisplayHeight(){
        return game.getDisplayHeight();
    }
    
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    // World -> GameLevel
    public GameLevel getLevel() {
        return world;
    }

    public void setLevel(GameLevel world) {
        this.world = world;
    }
    
    
    
}
