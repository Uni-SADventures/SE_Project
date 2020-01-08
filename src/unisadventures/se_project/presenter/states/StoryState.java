/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.states;

import java.awt.Graphics;
import unisadventures.se_project.model.Loading;
import unisadventures.se_project.model.Story;
import unisadventures.se_project.presenter.audio.AudioManager;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.view.gfx.Assets;

/**
 *
 * @author krist
 */
public class StoryState extends State{
    Story _story;
    int _displayWidth;
    int _displayHeight;
    private int _id;

    public StoryState (Handler handler,int id){
            
        super(handler);
        _id=id;
        _story = new Story();
        _displayWidth = handler.getDisplayWidth();
        _displayHeight = handler.getDisplayHeight();
        loadImages();
        AudioManager.stopMusic();
        AudioManager.playLevelComplete();
    }

    @Override
    public void tick() {
        if(_handler.getKeyManager().up){
            AudioManager.stopMusic();
            AudioManager.gameLevelLoop();
            State.setState(new GameState(_handler,_id));
            
        }
	
    }

    @Override
    public void displayView(Graphics g) {
        view.renderStoryBackground(g, _story.getBackgroundImageId(), _displayWidth, _displayHeight);
        view.renderText(g, "Press W To Start", (int) _displayWidth/2 - 20, _displayHeight - 20);
    }

    @Override
    public void loadImages() {
        Assets.storeImage(Story.BACKGROUND_IMAGE);
        _story.setBackgroundImageId(Assets.getActualSequenceNumber());
        //Assets.storeImage(Loading.TITLE_IMAGE);
        //_story.setTitleImageId(Assets.getActualSequenceNumber());
    }

    @Override
    public int getCountCFU() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
