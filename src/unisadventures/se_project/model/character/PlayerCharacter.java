package unisadventures.se_project.model.character;

import java.awt.Graphics;
import java.util.Timer;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.util.Pair;
import unisadventures.se_project.view.gfx.Assets;
import unisadventures.se_project.model.character.*;
import unisadventures.se_project.model.character.actionCommands.MoveCommand;


public class PlayerCharacter extends BasicCharacter {


    private String _username;

    public PlayerCharacter(Game game, double xPosition, double yPosition, double height, double width, CharacterType type, int healthBar, int strength, int maxHealth, double maxJump, String username) {
        super(game,xPosition, yPosition, height, width, type, healthBar, strength, maxHealth, maxJump);
 
        _username = username ;
        
    }
    double fall = 0;
    int i = 0;

}
