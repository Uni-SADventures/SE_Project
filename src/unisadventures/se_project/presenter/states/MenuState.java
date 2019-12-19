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
    
    private MainMenu _menu;
    private int _displayWidth;
    private int _displayHeight;
    
    // Graphical management variables
    private int _framesCounter;
    private boolean _blinkingTextIsVisible;
    private boolean _titleIsMovingDown;


    public MenuState(Handler handler){
            
        super(handler);
        _menu = new MainMenu();
        _displayWidth = handler.getDisplayWidth();
        _displayHeight = _handler.getDisplayHeight();

        
        _framesCounter = 0;
        _blinkingTextIsVisible = true;
        _titleIsMovingDown = true;
                
        loadImages();
    }

    @Override
    public void tick() {

        
        _framesCounter ++;
        
        if (_framesCounter == 60) {
            _framesCounter = 0;
            _blinkingTextIsVisible = !_blinkingTextIsVisible;  // Blinking text visibility toggled
            _titleIsMovingDown = !_titleIsMovingDown;  // Title direction flipped
        }

	
    }

    @Override
    public void displayView(Graphics g) {
        
                int titleXPostiton = 20;
                int titleUpperYPosition = 20;
                int titleLowerYPosition = 80;
                int titleActualYPosition;
                int titleWidth = _displayWidth - 40;
                int titleHeight = 80;
                
                int blinkingTextXPoxition = (int) _displayWidth/2 - 55;
                int blinkingTextYPoxition = (int) _displayHeight * 2/3;
        
                if (_titleIsMovingDown) {
                    titleActualYPosition = titleUpperYPosition + _framesCounter;
                } else {
                    titleActualYPosition = titleLowerYPosition - _framesCounter;
                }
        
                _view.renderMenuBackground(g, _menu.getBackgroundImageId(), _displayWidth, _displayHeight);
                _view.renderMenuTitle(g, _menu.getTitleImageId(), titleXPostiton, titleActualYPosition, titleWidth, titleHeight);
                
                if (_blinkingTextIsVisible) {
                    _view.renderText(g, "Press Enter to play!", blinkingTextXPoxition, blinkingTextYPoxition);
                }

                // Button implementation is bugged
                /*ActionListener listener = new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        System.out.println("Debug");
                        _handler.getGame().pressPlayButton();
                    }			

                };
                ButtonManager.addButton(_displayWidth/2 - 50, _displayHeight/2 - 150, 100, 300, "Play!", listener);*/
        
    }

    @Override
    public void loadImages() {
        Assets.storeImage(MainMenu.BACKGROUND_IMAGE);
        _menu.setBackgroundImageId(Assets.getActualSequenceNumber());
        Assets.storeImage(MainMenu.TITLE_IMAGE);
        _menu.setTitleImageId(Assets.getActualSequenceNumber());

    }

    @Override
    public int getCountCFU() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


	
	
}

	
	
