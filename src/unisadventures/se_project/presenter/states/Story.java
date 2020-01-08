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
public class Story {
    public static final String BACKGROUND_IMAGE = "resources/images/Story_image.png";
    
    private int _backgroundImageId;

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
}
