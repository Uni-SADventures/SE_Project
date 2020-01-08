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
public class VerticalCommand2 extends BasicCommand {

    public VerticalCommand2() {
        super();
    }

    @Override
    public void execute(DirectionType type) {
        switch (type) {
            case JUMP:
                _player.jump(_count);

            case FALL:
                _player.fall(_count);

            default:
                return;
        }
    }

}
