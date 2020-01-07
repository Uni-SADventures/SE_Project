/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.view.display;

import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



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
    
    private static AudioInputStream  gameLevel ,playerDamage, playerHit,menu,coinGrab,gameOver,levelComplete, coffeeSip, jetpack, heartTaken;
            
    
    private static Clip loop = null ;
    
    public static void loadAudio(){
        try {
            gameLevel = AudioSystem.getAudioInputStream(new File(gameLevelName).toURI().toURL()) ;
            playerDamage = AudioSystem.getAudioInputStream(new File(playerDamageName).toURI().toURL()) ;
            playerHit = AudioSystem.getAudioInputStream(new File(playerHitName).toURI().toURL()) ;
            menu = AudioSystem.getAudioInputStream(new File(menuName).toURI().toURL()) ;
            coinGrab = AudioSystem.getAudioInputStream(new File(coinGrabName).toURI().toURL()) ;
            gameOver = AudioSystem.getAudioInputStream(new File(gameOverName).toURI().toURL()) ;
            levelComplete = AudioSystem.getAudioInputStream(new File(levelCompleteName).toURI().toURL()) ;
            coffeeSip = AudioSystem.getAudioInputStream(new File(coffeeSipName).toURI().toURL()) ;
            jetpack = AudioSystem.getAudioInputStream(new File(jetpackName).toURI().toURL()) ;
            heartTaken = AudioSystem.getAudioInputStream(new File(heartTakenName).toURI().toURL()) ;
        } catch (Exception ex) {
            System.out.println("Audio problem: "+ ex.getMessage());
        }
    }
    
    private static AudioInputStream playAudio(AudioInputStream audioIn, String audio) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            return AudioSystem.getAudioInputStream(new File(audio).toURI().toURL()) ;
        } catch (Exception e) {
            System.out.println("Audio problem: "+ e.getMessage());
            return null ;
        }
    }
    
    private static AudioInputStream loopAudio(AudioInputStream audioIn, String audio) {
        try {
            loop = AudioSystem.getClip();
            loop.open(audioIn);
            loop.loop(0);
            return AudioSystem.getAudioInputStream(new File(audio).toURI().toURL()) ;
        } catch (Exception e) {
            System.out.println("Audio problem: "+ e.getMessage());
            return null ;
        }
    }
    
    public static void stopMusic(){
        if(loop != null){
            loop.stop();
            loop = null ;
        }
            
    }   
    
    
    public static void gameLevelLoop() {
        stopMusic();
        gameLevel = loopAudio(gameLevel, gameLevelName ) ;
    }
    
    public static void gameMenuLoop() {
        stopMusic() ;
        menu = loopAudio(menu, menuName ) ;
    }
    
  
    
    
    public static void playPlayerDamage(){
        playerDamage = playAudio(playerDamage,playerDamageName);
    }
    
    public static void playPlayerHit(){
        playerHit = playAudio(playerHit,playerHitName);
    }
    
    public static void playCoinGrab(){
        coinGrab = playAudio(coinGrab, coinGrabName);
    }
    
    public static void playGameOver(){
        gameOver = playAudio(gameOver, gameOverName);
    }
    
    public static void playLevelComplete(){
        levelComplete = playAudio(levelComplete,levelCompleteName);
    }
    
    public static void playCoffeeSip(){
        coffeeSip = playAudio(coffeeSip,coffeeSipName );
    }
    
    public static void playJetpack(){
        jetpack = playAudio(jetpack, jetpackName);
    }
    public static void playHeartTaken(){
        heartTaken = playAudio(heartTaken, heartTakenName);
    }
    
}
