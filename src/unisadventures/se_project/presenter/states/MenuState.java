package unisadventures.se_project.presenter.states;

import java.awt.Graphics;


import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.view.gfx.Assets;

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
    // Graphical constants
    
    private int _titleXPostiton;
    private int _titleUpperYPosition;
    private int _titleLowerYPosition;
    private int _titleActualYPosition;
    private int _titleWidth;
    private int _titleHeight;
    
    private int _playButtonXPosition;
    private int _playButtonYPosition;
    private int _playButtonWidth;
    private int _playButtonHeight;
    
    private int _quitButtonXPosition;
    private int _quitButtonYPosition;
    private int _quitButtonWidth;
    private int _quitButtonHeight;
                
    private int _playTextXPosition;
    private int _playTextYPosition;
                
    private int _quitTextXPosition;
    private int _quitTextYPosition;


    public MenuState(Handler handler){
            
        super(handler);
        
        _displayWidth = handler.getDisplayWidth();
        _displayHeight = _handler.getDisplayHeight();
        
        _titleXPostiton = 20;
        _titleUpperYPosition = 20;
        _titleLowerYPosition = 80;
        _titleWidth = _displayWidth - 40;
        _titleHeight = 80;
        
        _playButtonXPosition = (int) _displayWidth/2 - 55;
        _playButtonYPosition = (int) _displayHeight * 1/3;
        _playButtonWidth = 110;
        _playButtonHeight = 40;
        
        _quitButtonXPosition = (int) _displayWidth/2 - 55;
        _quitButtonYPosition = (int) _displayHeight * 1/3 + 80;
        _quitButtonWidth = 110;
        _quitButtonHeight = 40;
        
        _playTextXPosition = (int) _displayWidth/2 - 85;
        _playTextYPosition = (int) _displayHeight * 1/3 + 60;
        
        _quitTextXPosition = (int) _displayWidth/2 - 75;
        _quitTextYPosition = (int) _displayHeight * 1/3 + 140;
                
        _menu = new MainMenu();

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
        
                if (_titleIsMovingDown) {
                    _titleActualYPosition = _titleUpperYPosition + _framesCounter;
                } else {
                    _titleActualYPosition = _titleLowerYPosition - _framesCounter;
                }
        
                view.renderMenuBackground(g, _menu.getBackgroundImageId(), _displayWidth, _displayHeight);
                view.renderMenuTitle(g, _menu.getTitleImageId(), _titleXPostiton, _titleActualYPosition, _titleWidth, _titleHeight);
                
                view.renderButtons(g, "Play!", _playButtonXPosition, _playButtonYPosition, _playButtonWidth, _playButtonHeight);
                view.renderButtons(g, "Quit!", _quitButtonXPosition, _quitButtonYPosition, _quitButtonWidth, _quitButtonHeight);
                
                if (_blinkingTextIsVisible) {
                    view.renderText(g, "or press Enter", _playTextXPosition, _playTextYPosition);
                    view.renderText(g, "or press Esc", _quitTextXPosition, _quitTextYPosition);
                }
                
                
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
    
    public boolean playButtonPressed(int mouseXPosition, int mouseYPosition) {
        if ( (_playButtonXPosition <= mouseXPosition) && (mouseXPosition <= (_playButtonXPosition + _playButtonWidth))) {
            if ( (_playButtonYPosition <= mouseYPosition) && (mouseYPosition <= (_playButtonYPosition + _playButtonHeight))) {
                return true;
            }
        }
        return false;
    }
    
    public boolean quitButtonPressed(int mouseXPosition, int mouseYPosition) {
        if ( (_quitButtonXPosition <= mouseXPosition) && (mouseXPosition <= (_quitButtonXPosition + _quitButtonWidth))) {
            if ( (_quitButtonYPosition <= mouseYPosition) && (mouseYPosition <= (_quitButtonYPosition + _quitButtonHeight))) {
                return true;
            }
        }
        return false;
    }


	
	
}

	
	
