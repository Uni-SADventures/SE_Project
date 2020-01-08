/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.util.DirectionType;

/**
 *
 * @author Paolo
 */
public class MovementCommand extends BasicCommand {

    

    public MovementCommand() {
        super();
    }

    @Override
    public void execute(DirectionType type) {
        if (type == DirectionType.LEFT) {
            _count = _player.moveLeft(_count);
        } else if (type == DirectionType.RIGHT) {
            _count = _player.moveRight(_count);
        } else {
            _count = _player.idle(_count);
        }
        _count++;
    }
}
