/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.model.character.EnemyCharacter;
import unisadventures.se_project.model.character.PlayerCharacter;

/**
 * Command interface needed for the Command design pattern.
 * @author Paolo
 */
public interface Command {
    public void execute(EnemyCharacter enemy);
    public void execute(PlayerCharacter player);
}
