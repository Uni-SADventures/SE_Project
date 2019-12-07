/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.model.character.BasicCharacter;
import unisadventures.se_project.presenter.launcher.Game;

/**
 *
 * @author Emilio
 */
public abstract class ActionCommand {
    protected BasicCharacter _ch ;
    protected Game _game ;
    protected int _count ;
    public ActionCommand(Game game, BasicCharacter ch) {
        _game = game ;
        _ch = ch;
        _count = 0;
    }

    public int getCount() {
        return _count;
    }
    
    
    
    public void resetCounter(){
        _count = 0 ;
    }
    
    
}
