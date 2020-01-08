package unisadventures.se_project.presenter.states;

import java.awt.Graphics;
import unisadventures.se_project.presenter.launcher.Game;
/**
 * This class extends state and implements gamestate, the actual state were the
 * game is not playable and frametime can't go on. That's the case when the menu
 * has been invoked It has every instance to be updated each frame as parameter
 *
 * @author Emilio
 */
import unisadventures.se_project.view.gfx.Assets;

public class MenuState extends State {
    
    public static final String BACKGROUND_IMAGE = "resources/images/menu_background.jpg";
    public static final String TITLE_IMAGE = "resources/images/menu_title.png";
    
    private int _backgroundImageId;
    private int _titleImageId;
    int _displayWidth;
    int _displayHeight;

    public MenuState(Game game) {

        super(game);
        _displayWidth = game.getDisplay().getWidth();
        _displayHeight = game.getDisplay().getHeight();

        loadImages();
    }

    @Override
    public void tick() {
        if (_game.getKeyManager().isUp()) {
            State.setState(new GameState(_game, 1));
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
        Assets.storeImage(TITLE_IMAGE);
        _titleImageId = Assets.getActualSequenceNumber();
    }

    @Override
    public int getCountCFU() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
