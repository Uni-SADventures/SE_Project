package unisadventures.se_project.model.character;

import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.util.CharacterType;

/**
 * Extension of BasicCharacter class to represent a character which is the one beign used by
 * the player
 * @author Emilio
 */
public class PlayerCharacter extends BasicCharacter {


    private final String _username;
    private int _cfu ;
    private int _lives ;

    public PlayerCharacter(Game game, double xPosition, double yPosition, double height, double width, CharacterType type, int healthBar, int strength, int maxHealth, double maxJump, String username) {
        super(game,xPosition, yPosition, height, width, type, healthBar, strength, maxHealth, maxJump);
 
        _username = username ;
        _cfu = 0 ;
        _lives = 3 ;
        
    }

    public int getCfu() {
        return _cfu;
    }

    public void setCfu(int _cfu) {
        this._cfu = _cfu;
    }

    public int getLives() {
        return _lives;
    }

    public void setLives(int _lives) {
        this._lives = _lives;
    }
    
    
    
    

}
