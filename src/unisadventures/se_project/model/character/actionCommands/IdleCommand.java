/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.model.basicObjects.Tile;
import unisadventures.se_project.util.DirectionType;

/**
 * This class implements an action command wich moves left and right the
 * character keeping track of the game camera
 *
 * @author Emilio
 */
public class IdleCommand extends BasicCommand {

    public IdleCommand() {
    }

    @Override
    public void execute(DirectionType type) {
        if(type == DirectionType.IDLE)
            _count++;
    }

}
