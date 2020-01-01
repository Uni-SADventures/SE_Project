/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.view.display;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author Emilio
 */
public class AudioManager {
    private static final String gameLevel = "resources/music/game.wav" , playerDamage = "resources/music/game.wav", enemyDamage = "resources/music/game.wav",
            menu = "resources/music/menu.wav" ;
    private static AudioClip loop = null ;
    public static void gameLevelLoop() {
        if(loop != null )
            stopMusic() ;
        playLoop(gameLevel) ;

    }
    public static void gameMenuLoop() {
        if(loop != null )
            stopMusic() ;
        playLoop(menu) ;

    }
    public static void stopMusic(){
        loop.stop();
        System.out.println("ca");
        
    }
    private static void playLoop(String path){
        try {
            // gets the sound file that is passed in the constructor
            loop = Applet.newAudioClip(new File(path).toURI().toURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
        loop.loop();
 
        
    }
}
