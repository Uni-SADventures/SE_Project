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
public class EnemyFactory {
    
public EnemyFactory(){
    
}

public Enemy createEnemy(EnemyType type){
    switch(type){
        case BASIC:
            return new BasicEnemyFactory().createEnemy();
        case ZOMBIE:
            return new ZombieEnemyFactory().createEnemy();
    }
    return null;
}
}
