/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.launcher;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.presenter.camera.GameCamera;
import unisadventures.se_project.presenter.input.KeyManager;
import unisadventures.se_project.view.display.Display;

/**
 *
 * @author Emilio
 */
public class GameTest {
    
    private String _title ;
    private int _width,_height ;
    
    public GameTest() {
        _title = "test" ;
        _width = 400 ;
        _height = 400 ;
        
    }
    
    
    @Test
    public void testCreation() {
        Game g = new Game(_title,_width,_height) ;
    }

}
