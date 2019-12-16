/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.model.character.actionCommands.ActionManager;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.util.Pair;

/**
 *
 * @author Emilio
 */
public class PlayerCharacterTest {
    
    private final CharacterType _typeOfCharacter = CharacterType.USER;
    private int _healthBar;
    private int _strength;
    private int _maxHealth;
    private int _maxJump;
    private int _speed;
    private int _xPosition;
    private int _yPosition;
    private int _height;
    private int _width ;
    private String _username;
    private final Handler _handler;
    private final ActionManager _actions;
    
    public PlayerCharacterTest() {
        _healthBar= 20 ;
        _strength = 1 ;
        _maxHealth = 30 ;
        _maxJump = 2 ;
        _speed = 5; 
        _handler = null ;
        _xPosition = 0 ;
        _yPosition = 0 ;
        _height = 32 ;
        _width = 32 ;
        _actions = null ;
        _username = "john";
        
    }
    
   

    @Test
    public void testSomeMethod() {
       PlayerCharacter p = new PlayerCharacter(_handler,_xPosition,_yPosition,_height,_width,_typeOfCharacter,_healthBar,
            _strength,_maxHealth,_maxJump,_username); 
       int damage = 5 ;
       int expResult = _healthBar - damage;
       p.takeDamage(damage);
       assertEquals(p.getHealthBar(), expResult);
       
    }
    
}