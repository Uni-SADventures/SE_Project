/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.states;

import java.awt.Graphics;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.view.gfx.Assets;

/**
 *
 * @author krist
 */
public class LoadingState extends State {

    public static final String BACKGROUND_IMAGE = "resources/images/loading_background.png";
    public static final String TITLE_IMAGE = "resources/images/menu_title.png";
    
    private int _backgroundImageId;
    private int _titleImageId;
    int _displayWidth;
    int _displayHeight;
    private int _id;

    public LoadingState(Game game, int id) {
        super(game);
        _id = id;
        _displayWidth = _game.getDisplay().getWidth();
        _displayHeight = _game.getDisplay().getHeight();

        loadImages();
    }

    @Override
    public void tick() {
        if (_game.getKeyManager().isEnter()) {
            System.out.println("id= " + _id);
            State.setState(new GameState(_game, _id + 1));
            System.out.println("Level "+ _id + State.getState().toString());
        }

    }

    @Override
    public void displayView(Graphics g) {
        g.drawImage(Assets.retrieveImage(_backgroundImageId), 0, 0, _displayWidth, _displayHeight, null);
        g.drawImage(Assets.retrieveImage(_titleImageId),  _displayWidth - 40, 80, 20, 20, null);
        g.drawString("Press Enter", (int) _displayWidth / 2 - 20, _displayHeight - 20);
    }

    @Override
    public void loadImages() {
        Assets.storeImage(BACKGROUND_IMAGE);
        _backgroundImageId = Assets.getActualSequenceNumber();
        //Assets.storeImage(Loading.TITLE_IMAGE);
        //_loading.setTitleImageId(Assets.getActualSequenceNumber());
    }

    @Override
    public int getCountCFU() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
