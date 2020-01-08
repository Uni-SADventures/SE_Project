/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

/**
 *
 * @author Paolo
 */
public class BasicEnemyFactory extends EnemyFactory {

    public BasicEnemyFactory() {

    }

    public Enemy createEnemy() {
        return new BasicEnemy(300, 450, 64, 64);
    }

}
