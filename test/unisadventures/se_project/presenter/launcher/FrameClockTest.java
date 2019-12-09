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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import unisadventures.se_project.model.FrameListener;

/**
 *
 * @author Emilio
 */
public class FrameClockTest {
    
    public FrameClockTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of run method, of class FrameClock.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        FrameClock instance = new FrameClock();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerObserver method, of class FrameClock.
     */
    @Test
    public void testRegisterObserver() {
        System.out.println("registerObserver");
        FrameListener o = null;
        FrameClock instance = new FrameClock();
        instance.registerObserver(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unregisterObserver method, of class FrameClock.
     */
    @Test
    public void testUnregisterObserver() {
        System.out.println("unregisterObserver");
        FrameListener o = null;
        FrameClock instance = new FrameClock();
        instance.unregisterObserver(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyObservers method, of class FrameClock.
     */
    @Test
    public void testNotifyObservers() {
        System.out.println("notifyObservers");
        FrameClock instance = new FrameClock();
        instance.notifyObservers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
