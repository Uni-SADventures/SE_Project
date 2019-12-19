/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.camera;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.presenter.launcher.Handler;

/**
 *
 * @author Emilio
 */
public class GameCameraTest {
    
    private Handler _handler;
    private float _xOffset, _yOffset;
    
    public GameCameraTest() {
        _handler = null ;
        _xOffset = 0 ;
        _yOffset = 0 ;
    }
    

    /**
     * Test of move method, of class GameCamera.
     */
    @Test
    public void testCreation() {
        GameCamera inst = new GameCamera(_handler, _xOffset, _yOffset);
        assertNotNull(inst) ;
    
    }

    
}
