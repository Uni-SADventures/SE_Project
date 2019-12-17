package unisadventures.se_project.presenter.states;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import unisadventures.se_project.model.MainMenu;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.view.gfx.Assets;
import unisadventures.se_project.view.gfx.ButtonManager;
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
        _view.renderText(g, "or press enter", (int) _displayWidth/2 - 25, _displayHeight - 20);
        
        ActionListener listener = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _handler.getGame().pressPlayButton();
            }			
            
        };
        ButtonManager.addButton(_displayWidth/2 - 5, _displayHeight/2 - 15, 10, 30, "Play!", listener);
        
    }

    @Override
    public void loadImages() {
        Assets.storeImage(MainMenu.BACKGROUND_IMAGE);
        _menu.setBackgroundImageId(Assets.getActualSequenceNumber());
        Assets.storeImage(MainMenu.TITLE_IMAGE);
        _menu.setTitleImageId(Assets.getActualSequenceNumber());
    }

	
	
}
