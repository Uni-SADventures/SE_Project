/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.util.CharacterType;

/**
 *
 * @author Paolo
 */
public class ZombieEnemyTest {

    private ZombieEnemy enemy;
    private Game game;
    private PlayerCharacter player;

    public ZombieEnemyTest() {
        game = new Game("test", 300, 300);
        game.start();
        enemy = game.getGameState().getEnemy();
        player = game.getGameState().getPlayer();
    }

    @Test
    public void moveTest() {
        double expected = enemy.getxPosition();
        enemy.tick();
        double actual = enemy.getxPosition();
        Assertions.assertNotEquals(expected, actual, "Zombie not moving");
    }

    @Test
    public void attackTest() {
        System.out.println("player");
        System.out.println("x " + player.getxPosition());
        System.out.println("y " + player.getyPosition());
        System.out.println("width " + player.getWidth());
        System.out.println("height " + player.getHeight());
        System.out.println("enemy");
        enemy.setxPosition(player.getxPosition() + player.getWidth());
        enemy.setyPosition(enemy.getyPosition() + player.getHeight() - enemy.getHeight() );
        System.out.println("x " + enemy.getxPosition());
        System.out.println("y " + enemy.getyPosition());
        System.out.println("width " + enemy.getWidth());
        System.out.println("height " + enemy.getHeight());
        int expected, actual;
        //test when they meet
        expected = player.getHealthBar() - 1;
        enemy.attack();
        actual = player.getHealthBar();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getDamageTest() {
        int expected, actual;
        game.getGameState().getPlayer().setyPosition(180 - 32);
        enemy.getDamage();
        actual = enemy.getHealthBar();
        Assertions.assertEquals(-1, actual);
    }
}
