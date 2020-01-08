/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.input;

import java.awt.event.KeyEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.testng.Assert;

/**
 *
 * @author Emilio
 */
public class KeyManagerTest {
    
    public KeyManagerTest() {
    }

    /**
     * Test of tick method, of class KeyManager.
     */
    @Test
    public void testTick() {
        KeyManager instance = new KeyManager();
        instance.tick();
        assertEquals(instance.up,false);
        assertEquals(instance.down,false);
        assertEquals(instance.left,false);
        assertEquals(instance.right,false);
        assertEquals(instance.hit,false);
        
    }

    
}
