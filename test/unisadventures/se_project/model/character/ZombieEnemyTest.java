/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeMethod;
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
        enemy = new ZombieEnemy(handler, 500, 100, 64, 64, CharacterType.ENEMY, 1, 1, 1, 1);
    }

    @Test
    public void movementTest() {
        enemy.setxPosition(600);
        double expected = enemy.getPosition().getFirstElement() - 1;
        enemy.setIsMoving(true);
        enemy.setMovingLeft(true);
        enemy.movement();
        double actual = enemy.getPosition().getFirstElement();
        Assertions.assertEquals(expected, actual, "Player not moving left");

        expected = enemy.getPosition().getFirstElement() + 1;
        enemy.setMovingLeft(false);
        enemy.movement();
        actual = enemy.getPosition().getFirstElement();

        Assertions.assertEquals(expected, actual, "Player not moving right");
    }

    @BeforeMethod
    public void init() {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            gamestate.getPlayer().setxPosition(200);
            gamestate.getPlayer().setyPosition(200);
            enemy.setyPosition(200);
        }
    }

    @Test
    public void leftHorizontalCollisionTest() {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            enemy.setxPosition(gamestate.getPlayer().getxPosition() - enemy.getDimension().getFirstElement() - 1);
            enemy.setMovingLeft(false);
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
            enemy.setxPosition(gamestate.getPlayer().getxPosition() + gamestate.getPlayer().getDimension().getFirstElement() + 1);
            enemy.setMovingLeft(true);
            Assertions.assertFalse(enemy.rightHorizontalCollision());
            enemy.setxPosition(gamestate.getPlayer().getxPosition() + gamestate.getPlayer().getDimension().getFirstElement());
            Assertions.assertTrue(enemy.rightHorizontalCollision());
        } else {
            Assertions.assertFalse(true);
        }

    }

    @Test
    public void verticalCollisionTest() {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            enemy.setyPosition(gamestate.getPlayer().getxPosition() + gamestate.getPlayer().getDimension().getFirstElement() + 1);
            Assertions.assertFalse(enemy.checkVerticalCollision());
            enemy.setyPosition(gamestate.getPlayer().getxPosition() + gamestate.getPlayer().getDimension().getFirstElement());
            Assertions.assertTrue(enemy.checkVerticalCollision());
        } else {
            Assertions.assertFalse(true);
        }
    }

    @Test
    public void attackTest() {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            enemy.setxPosition(gamestate.getPlayer().getxPosition() + gamestate.getPlayer().getDimension().getFirstElement() + 1);
            enemy.attack();
            Assertions.assertEquals(gamestate.getPlayer().getHealthBar(), 6);
            enemy.setxPosition(gamestate.getPlayer().getxPosition() + gamestate.getPlayer().getDimension().getFirstElement());
            enemy.attack();
            Assertions.assertNotEquals(gamestate.getPlayer().getHealthBar(), 6);
        } else {
            Assertions.assertFalse(true);
        }
    }

    @Test
    public void getDamagedTest() {
        if (State.getState() instanceof GameState) {
            GameState gamestate = (GameState) State.getState();
            enemy.setxPosition(gamestate.getPlayer().getxPosition());
            enemy.setyPosition(gamestate.getPlayer().getyPosition() + gamestate.getPlayer().getDimension().getSecondElement() + 1);
            enemy.getDamage();
            Assertions.assertNotEquals(enemy.getHealthBar(),-1);
            enemy.setyPosition(gamestate.getPlayer().getyPosition() + gamestate.getPlayer().getDimension().getSecondElement());
            enemy.getDamage();
            Assertions.assertEquals(enemy.getHealthBar(),-1);
        } else {
            Assertions.assertFalse(true);
        }
    }
}
