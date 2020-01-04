/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.view.display;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Emilio
 */
public class AudioManager {
    private static final String gameLevelName = "resources/music/game.wav" ,
            playerDamageName = "resources/music/playerDamage.wav", 
            playerHitName = "resources/music/playerHit.wav",
            menuName = "resources/music/menu.wav",
            coinGrabName = "resources/music/coin.wav",
            gameOverName = "resources/music/gameOver.wav",
            levelCompleteName = "resources/music/levelComplete.wav" ,
            coffeeSipName = "resources/music/coffee.wav" ,
            jetpackName = "resources/music/jetpack.wav" ,
            heartTakenName = "resources/music/heart.wav" ;
    
    private static AudioClip  gameLevel ,playerDamage, playerHit,menu,coinGrab,gameOver,levelComplete, coffeeSip, jetpack, heartTaken;
            
    
    private static AudioClip loop = null ;
    
    public static void loadAudio(){
        try {
            gameLevel = Applet.newAudioClip(new File(gameLevelName).toURI().toURL()) ;
            playerDamage = Applet.newAudioClip(new File(playerDamageName).toURI().toURL()) ;
            playerHit = Applet.newAudioClip(new File(playerHitName).toURI().toURL()) ;
            menu = Applet.newAudioClip(new File(menuName).toURI().toURL()) ;
            coinGrab = Applet.newAudioClip(new File(coinGrabName).toURI().toURL()) ;
            gameOver = Applet.newAudioClip(new File(gameOverName).toURI().toURL()) ;
            levelComplete = Applet.newAudioClip(new File(levelCompleteName).toURI().toURL()) ;
            coffeeSip = Applet.newAudioClip(new File(coffeeSipName).toURI().toURL()) ;
            jetpack = Applet.newAudioClip(new File(jetpackName).toURI().toURL()) ;
            heartTaken = Applet.newAudioClip(new File(heartTakenName).toURI().toURL()) ;
        } catch (MalformedURLException ex) {
            Logger.getLogger(AudioManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void gameLevelLoop() {
        stopMusic() ;
        loop = gameLevel ;
        gameLevel.loop();

    }
    public static void gameMenuLoop() {
        stopMusic() ;
        loop = menu ;
        menu.loop();

    }
    public static void stopMusic(){
        if(loop != null ){
            loop.stop();
            loop = null ;
        }
        
    }
   
    
    
    public static void playPlayerDamage(){
        playerDamage.play();
    }
    
    public static void playPlayerHit(){
        playerHit.play();
    }
    
    public static void playCoinGrab(){
        coinGrab.play();
    }
    
    public static void playGameOver(){
        gameOver.play();
    }
    
    public static void playLevelComplete(){
        levelComplete.play();
    }
    
    public static void playCoffeeSip(){
        coffeeSip.play();
    }
    
    public static void playJetpack(){
        jetpack.play();
    }
    public static void playHeartTaken(){
        heartTaken.play();
    }
    
}
