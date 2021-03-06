/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.states;

import java.awt.Graphics;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.presenter.audio.AudioManager;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.view.gfx.Assets;

/**
 *
 * @author krist
 */
public class LoadingState extends State {
    Loading _loading;
    int _displayWidth;
    int _displayHeight;
    private int _id;

    public LoadingState(Handler handler,int id){
            
        super(handler);
        _id=id;
        _loading = new Loading();
        _displayWidth = handler.getDisplayWidth();
        _displayHeight = handler.getDisplayHeight();
        
        loadImages();
         AudioManager.stopMusic();
        AudioManager.playLevelComplete();
    }

    @Override
    public void tick() {
        if(_id!=4){
        if(_handler.getKeyManager().enter){
            AudioManager.gameLevelLoop();
            State.setState(new GameState(_handler,_id+1));
        }
            }else if(_handler.getKeyManager().esc)
                System.exit(0);
    }
          

    @Override
    public void displayView(Graphics g) {
        view.renderLoadingBackground(g, _loading.getBackgroundImageId(), _displayWidth, _displayHeight);
        view.renderLoadingTitle(g, _loading.getTitleImageId(), _displayWidth - 40, 80, 20, 20);
        view.renderText(g, "", (int) _displayWidth/2 - 20, _displayHeight - 20);
    }

    @Override
    public void loadImages() {
        if(_id!=2 && _id!=4){
            Assets.storeImage(Loading.LOADING_IMAGE);
            _loading.setBackgroundImageId(Assets.getActualSequenceNumber());
        }else if(_id==2){
            Assets.storeImage(Loading.DEGREE_IMAGE);
            _loading.setBackgroundImageId(Assets.getActualSequenceNumber());     
        }else{
            Assets.storeImage(Loading.MASTER_DEGREE_IMAGE);
            _loading.setBackgroundImageId(Assets.getActualSequenceNumber());
        }
        //Assets.storeImage(Loading.TITLE_IMAGE);
        //_loading.setTitleImageId(Assets.getActualSequenceNumber());
    }

    @Override
    public int getCountCFU() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
