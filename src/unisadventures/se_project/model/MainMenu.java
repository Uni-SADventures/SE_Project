package unisadventures.se_project.model;

/**
 * Class to store information about the game main menu
 */
public class MainMenu {
    
    public static final String BACKGROUND_IMAGE = "resources/images/menu_background.png";
    public static final String TITLE_IMAGE = "resources/images/menu_title.png";
    
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
