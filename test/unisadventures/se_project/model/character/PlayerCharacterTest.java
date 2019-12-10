/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Emilio
 */
public class PlayerCharacterTest {
    
    public PlayerCharacterTest() {
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

    @Test
    public void testSomeMethod() {
        
        System.out.println("player tick");
        PlayerCharacter instance = null;
        
        //  I should just check that idle is being executed
        
        try{
            instance.tick();
        
        } catch(Exception e ){
            //Assertions.assertEquals() ;
        }//
        
        
        //we need to check every basicMethod
        
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
