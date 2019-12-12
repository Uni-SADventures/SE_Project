/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.util.CharacterType;

/**
 *
 * @author Paolo
 */
public class ZombieEnemyTest {

    private ZombieEnemy enemy;
    private Game game;

    public ZombieEnemyTest() {
        Game game = new Game("test", 300, 300);
        Handler handler= new Handler(game);
        enemy = new ZombieEnemy(handler, 100, 200, 16, 32, CharacterType.ENEMY, 1, 1, 1, 1);
    }

    @Test
    public void moveTest() {
        System.out.println("Zombie movement test");
        double expected = enemy.getPosition().getFirstElement();
        enemy.tick();
        double actual = enemy.getPosition().getFirstElement();
        Assertions.assertNotEquals(expected, actual, "Player not moving");
    }

}
