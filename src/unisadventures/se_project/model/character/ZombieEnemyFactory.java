/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import unisadventures.se_project.util.EnemyType;

/**
 *
 * @author Paolo
 */
public class ZombieEnemyFactory extends EnemyFactory{

    public ZombieEnemyFactory(){
        super();
    }
    
    public Enemy createEnemy() {
        return new ZombieEnemy(300,450,64,64);
    }
    
}
