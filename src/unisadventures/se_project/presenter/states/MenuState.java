package unisadventures.se_project.presenter.states;

import java.awt.Graphics;
import unisadventures.se_project.model.MainMenu;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.view.gfx.Assets;
/**
 * This class extends state and implements gamestate, the actual state were the game is not
 * playable and frametime can't go on. That's the case when the menu has been invoked
 * It has every instance to be updated each frame as parameter
 * @author Emilio
 */

public class MenuState extends State {
    
    MainMenu _menu;
    int _displayWidth;
    int _displayHeight;

    public MenuState(Handler handler){
            
        super(handler);
        _menu = new MainMenu();
        _displayWidth = handler.getDisplayWidth();
        _displayHeight = _handler.getDisplayHeight();
                
        loadImages();
    }

    @Override
    public void tick() {
	
    }

    @Override
    public void displayView(Graphics g) {
        _view.renderMenuBackground(g, _menu.getBackgroundImageId(), _displayWidth, _displayHeight);
        _view.renderMenuTitle(g, _menu.getTitleImageId(), _displayWidth - 40, 80, 20, 20);
        _view.renderText(g, "Press Enter", (int) _displayWidth/2 - 20, _displayHeight - 20);
    }

    @Override
    public void loadImages() {
        Assets.storeImage(MainMenu.BACKGROUND_IMAGE);
        _menu.setBackgroundImageId(Assets.getActualSequenceNumber());
        Assets.storeImage(MainMenu.TITLE_IMAGE);
        _menu.setTitleImageId(Assets.getActualSequenceNumber());
    }

	
	
}
