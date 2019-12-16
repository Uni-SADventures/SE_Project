/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.launcher;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.testng.Assert;
import unisadventures.se_project.model.FrameListener;

/**
 *
 * @author Emilio
 */
public class FrameClockTest {
    
    public FrameClockTest() {
    }
    
    

    /**
     * Test of run method, of class FrameClock.
     */
    @Test
    public void testRun() {
        FrameClock instance = new FrameClock();
        instance.start();
        Assertions.assertTrue(instance.isAlive());
        instance.stop();
    }

    /**
     * Test of registerObserver method, of class FrameClock.
     */
    @Test
    public void testRegisterObserver() {
       
        FrameListener o = null;
        FrameClock instance = new FrameClock();
        instance.registerObserver(o);
        assertEquals(instance.observerList.size(), 1);
        
    }

    /**
     * Test of unregisterObserver method, of class FrameClock.
     */
    @Test
    public void testUnregisterObserver() {
        FrameListener o = null;
        FrameClock instance = new FrameClock();
        instance.registerObserver(o);
        instance.unregisterObserver(o);
        assertEquals(instance.observerList.size(), 0);
        
    }

    
    
}
