/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.states;

/**
 *
 * @author krist
 */
public class GameOver {
     
    public static final String BACKGROUND_IMAGE = "resources/images/game_over.png";
   
    
    private int _backgroundImageId;
    private int _titleImageId;

    /**
     * @return the _backgroundImageId
     */
    public int getBackgroundImageId() {
        return _backgroundImageId;
    }

    /**
     * @param _backgroundImageId the _backgroundImageId to set
     */
    public void setBackgroundImageId(int _backgroundImageId) {
        this._backgroundImageId = _backgroundImageId;
    }

    /**
     * @return the _titleImageId
     */
    public int getTitleImageId() {
        return _titleImageId;
    }

    /**
     * @param _titleImageId the _titleImageId to set
     */
    public void setTitleImageId(int _titleImageId) {
        this._titleImageId = _titleImageId;
    }
    
}

    


