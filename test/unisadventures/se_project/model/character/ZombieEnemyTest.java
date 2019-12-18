/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;
import unisadventures.se_project.presenter.launcher.*;
import unisadventures.se_project.presenter.states.*;
import unisadventures.se_project.util.CharacterType;

/**
 *
 * @author Emanuela Paolo
 */
public class ZombieEnemyTest {

    private ZombieEnemy enemy;
    private Handler handler;

    public ZombieEnemyTest() {
        Game game = new Game("test", 800, 800);
        game.start();
        handler = new Handler(game);
        enemy = new ZombieEnemy(handler, 500, 200, 16, 32, CharacterType.ENEMY, 1, 1, 1, 1);
    }

    @Test
    public void moveTest() {
        System.out.println("Zombie movement test");
        double expected = enemy.getPosition().getFirstElement() - 2;
        enemy.tick();
        double actual = enemy.getPosition().getFirstElement();
        Assertions.assertNotEquals(expected, actual, "Player not moving");

    }

    @Test
    public void leftHorizontalCollisionTest() {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            gamestate.getPlayer().setxPosition(200);
            enemy.setxPosition(gamestate.getPlayer().getxPosition() - enemy.getDimension().getFirstElement() - 1);
            enemy.setMovingLeft(false);
            System.out.println("player " + gamestate.getPlayer().getxPosition() + " enemy " + enemy.getxPosition());
            Assertions.assertFalse(enemy.leftHorizontalCollision());
            enemy.setxPosition(gamestate.getPlayer().getxPosition() - enemy.getDimension().getFirstElement());
            Assertions.assertTrue(enemy.leftHorizontalCollision());
        } else {
            Assertions.assertFalse(true);
        }

    }

    @Test
    public void rightHorizontalCollisionTest() {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            gamestate.getPlayer().setxPosition(200);
            enemy.setxPosition(gamestate.getPlayer().getxPosition() + gamestate.getPlayer().getDimension().getFirstElement() + 1);
            enemy.setMovingLeft(true);
            Assertions.assertFalse(enemy.rightHorizontalCollision());
            enemy.tick();
            Assertions.assertTrue(enemy.rightHorizontalCollision());
        } else {
            //Assertions.assertFalse(true);
        }

    }

    @Test
    public void verticalCollisionTest() {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            gamestate.getPlayer().setyPosition(200);
            enemy.setyPosition(gamestate.getPlayer().getyPosition() + gamestate.getPlayer().getDimension().getSecondElement() + 1);
            Assertions.assertFalse(enemy.checkVerticalCollision());
            enemy.setyPosition(gamestate.getPlayer().getyPosition() + gamestate.getPlayer().getDimension().getSecondElement());
            Assertions.assertTrue(enemy.checkVerticalCollision());
        } else {
            Assertions.assertFalse(true);
        }
    }
}
