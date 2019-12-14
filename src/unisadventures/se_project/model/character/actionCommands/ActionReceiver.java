/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import java.awt.Rectangle;
import unisadventures.se_project.model.character.EnemyCharacter;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.model.character.ZombieEnemy;
import unisadventures.se_project.presenter.states.GameState;
import unisadventures.se_project.presenter.states.State;

/**
 *
 * @author Paolo
 */
public class ActionReceiver {

    public ActionReceiver() {
    }

    public void playerHit(PlayerCharacter player) {

    }
    
    public void enemyHit(EnemyCharacter enemy){
        
    }

    public void enemyMove(EnemyCharacter enemy) {

        if (enemy instanceof ZombieEnemy) {
            zombieMove((ZombieEnemy) enemy);
        }else{
            
        }

    }

    private void zombieMove(ZombieEnemy enemy) {
        if (!enemy.isMoving()) {
            enemy.setIsMoving(true);
            enemy.setMovingLeft(true);
        }
        if (enemy.isMovingLeft() && enemy.isMoving()) {
            if (enemy.getxPosition() - enemy.getSpeed() < 0) {
                enemy.setMovingLeft(false);
                enemy.setxPosition(enemy.getxPosition() + enemy.getSpeed());
            } else {
                enemy.setxPosition(enemy.getxPosition() - enemy.getSpeed());
            }
        } else if (enemy.isMoving() && !enemy.isMovingLeft()) {
            if (enemy.getxPosition() + enemy.getSpeed() < enemy.getHandler().getGame().getWidth()) {
                enemy.setxPosition(enemy.getxPosition() + enemy.getSpeed());
            } else {
                enemy.setMovingLeft(true);
                enemy.setxPosition(enemy.getxPosition() - enemy.getSpeed());
            }
        }
    }

    public void enemyAttack(ZombieEnemy enemy) {
        if (State.getState() instanceof GameState) {
            GameState gstate = (GameState) State.getState();
            PlayerCharacter player = gstate.getPlayer();

            if (checkHorizontalCollision(enemy)) {
                player.setHealthBar(player.getHealthBar() - 1);

            }
        }
    }

    private boolean checkHorizontalCollision(ZombieEnemy enemy) {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            PlayerCharacter player = gamestate.getPlayer();
            int px = player.getPosition().getFirstElement();
            int pw = player.getDimension().getSecondElement();
            int ex = enemy.getPosition().getFirstElement();
            int ew = enemy.getDimension().getSecondElement();
            Rectangle rect = new Rectangle(px, player.getyPosition(), player.getDimension().getFirstElement(), pw);
            if (rect.intersects(new Rectangle(ex, enemy.getyPosition(), enemy.getDimension().getFirstElement(), ew))) {
                if (ex == px + pw || ex + ew == px) {
                    return true;
                }
            }
        }
        return false;
    }

}
