/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.model.character.EnemyCharacter;
import unisadventures.se_project.model.character.PlayerCharacter;

/**
 *
 * @author Paolo
 */
public class HitCommand2 implements Command {

    private ActionReceiver _action;

    public HitCommand2(ActionReceiver action) {
        _action = action;
    }

    @Override
    public void execute(EnemyCharacter enemy) {
        _action.enemyHit(enemy);
    }

    @Override
    public void execute(PlayerCharacter player) {
        _action.playerHit(player);
    }

}
