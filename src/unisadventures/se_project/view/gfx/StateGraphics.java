/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.view.gfx;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import static unisadventures.se_project.model.basicObjects.Tile.TILEHEIGHT;
import static unisadventures.se_project.model.basicObjects.Tile.TILEWIDTH;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.presenter.states.GameState;
import unisadventures.se_project.presenter.states.State;

/**
 *Ths class is used as support for states, it puts on screen whatever it's needed to be
 * there
 * @author Emilio
 */
public class StateGraphics {

    private Handler _handler;
    public StateGraphics(Handler handler/*,World w */) {
        _handler = handler;
    }

    /**
     * This method exists to render only the scenario
     * @param g graphics that are needed to draw with
     */
    public void renderScenario(Graphics g) {
        int scenarioId = _handler.getLevel().getScenarioImage() ;
        g.drawImage( Assets.retrieveImage(scenarioId), (int) (-_handler.getCam().getxOffset()/18), (int) (0-_handler.getCam().getyOffset()/18),1200,600, null);
      

    }
    
    
    /**
     * This method exists to render only the main character
     * @param g graphics that are needed to draw with
     * @param x x position of user
     * @param y y position of user
     */
    public void renderPlayer(Graphics g, int playerId ,double x, double y) {
     
        g.drawImage(Assets.retrieveImage(playerId), (int) (x- _handler.getCam().getxOffset()), (int) (y-_handler.getCam().getyOffset()),64,64,null);

    }
    
    /**
     * This method draws on screen whatever object we want to visualize, only position
     * and an image are needed to do so
     * @param g graphics that are needed to draw with
     * @param x x position of the object
     * @param y y position of the object
     * @param sprite image needed to represent our object
     */
    public void renderStuffMore(Graphics g, double x, double y, int width,int height, int imageId){
        g.drawImage( Assets.retrieveImage(imageId), (int) (x- _handler.getCam().getxOffset()), (int) (y-_handler.getCam().getyOffset()),width,height, null);
    }
    
    
    public int renderUi(Graphics g, int health, int maxHealth, int cfu, int lives){
        
       GameState state = (GameState)State.getState() ; 
       
       g.drawImage(Assets.retrieveImage(state.getUiCfu()),50,10,null);
       int j=35;
       

        boolean odd = (health %2 == 0) ;
        
        int pixelIncrementer = 1 ;
        for(int i = 2 ; i <= maxHealth; i += 2){
            if(health > 1)
                 g.drawImage(Assets.retrieveImage(state.getUiFullHeart()), 55 + (j * pixelIncrementer), 10, null);
            else if(health == 1){
                g.drawImage(Assets.retrieveImage(state.getUiHalfHeart()), 55 + (j * pixelIncrementer), 10, null);
            } else
                g.drawImage(Assets.retrieveImage(state.getUiEmptyHeart()), 55 + (j * pixelIncrementer), 10, null);
            health -= 2 ;
            pixelIncrementer++ ;    
        }
        
        int[] cfuDigits = String.valueOf(cfu).chars().map(Character::getNumericValue).toArray();
        
        pixelIncrementer = 0;
        for (int i = 0; i < cfuDigits.length; i++) {
           
           switch (cfuDigits[i]) {
               case 0:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[0]), 15+pixelIncrementer, 20,16,16, null);
                   break;
               case 1:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[1]), 15+pixelIncrementer, 20,16,16, null);
                   break;
               case 2:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[2]), 15+pixelIncrementer, 20,16,16, null);
                   break;
               case 3:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[3]), 15+pixelIncrementer, 20,16,16, null);
                   break;
               case 4:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[4]), 15+pixelIncrementer, 20,16,16, null);
                   break;
               case 5:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[5]), 15+pixelIncrementer, 20,16,16, null);
                   break;
               case 6:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[6]), 15+pixelIncrementer, 20,16,16, null);
                   break;
               case 7:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[7]), 15+pixelIncrementer, 20,16,16, null);
                   break;
               case 8:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[8]), 15+pixelIncrementer, 20,16,16, null);
                   break;
               case 9:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[9]), 15+pixelIncrementer, 20,16,16, null);
                   break;
               default:
                   break;
           }
               pixelIncrementer +=15;
        }
        
        pixelIncrementer +=0;
        int[] livesDigits = String.valueOf(lives).chars().map(Character::getNumericValue).toArray();
        for (int i = 0; i < livesDigits.length; i++) {
           
           switch (livesDigits[i]) {
               case 0:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[0]), 190+pixelIncrementer, 20,16,16, null);
                   break;
               case 1:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[1]), 190+pixelIncrementer, 20,16,16, null);
                   break;
               case 2:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[2]), 190+pixelIncrementer, 20,16,16, null);
                   break;
               case 3:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[3]), 190+pixelIncrementer, 20,16,16, null);
                   break;
               case 4:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[4]), 190+pixelIncrementer, 20,16,16, null);
                   break;
               case 5:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[5]), 190+pixelIncrementer, 20,16,16, null);
                   break;
               case 6:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[6]), 190+pixelIncrementer, 20,16,16, null);
                   break;
               case 7:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[7]), 190+pixelIncrementer, 20,16,16, null);
                   break;
               case 8:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[8]), 190+pixelIncrementer, 20,16,16, null);
                   break;
               case 9:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[9]), 190+pixelIncrementer, 20,16,16, null);
                   break;
               default:
                   break;
           }
               pixelIncrementer +=7;
        }
        
        g.drawImage(Assets.retrieveImage(state.getUiFullHeart()), 210+pixelIncrementer, 10, null);
            //g.setColor(Color.red);
            //g.drawString("10", 15 + (j * 2), 50);
        
        
         return cfu;
        }
    
    public void renderTile(Graphics g,int imageId,int x,int y){
        g.drawImage( Assets.retrieveImage(imageId), x, y, TILEWIDTH, TILEHEIGHT, null);
    }
    
    public void renderMenuBackground(Graphics g, int backgroundId, int displayWidth, int displayHeight) {
        g.drawImage(Assets.retrieveImage(backgroundId), 0, 0, displayWidth, displayHeight, null);
    }
    
    public void renderMenuTitle(Graphics g, int titleId, int titleXPosition, int titleYPosition, int titleWidth, int titleHeight) {
        g.drawImage(Assets.retrieveImage(titleId), titleXPosition, titleYPosition, titleWidth, titleHeight, null);
    }
    public void renderButtons(Graphics g,int displayWidth, int displayHeight){  
     Rectangle playButton= new Rectangle(displayWidth/2-80,displayHeight/2,150,75);
     
     int precX=displayWidth/2-80;
     int precY=displayHeight/2;
     Rectangle quitButton= new Rectangle(precX,precY+80,150,75);
     Graphics2D g2d=(Graphics2D) g;
    //Rectangle quitButton= new Rectangle(displayWidth/2 + 120,150,100,50);
     Font fnt1=new Font("arial",Font.BOLD,30);
     g.setFont(fnt1);
     g.setColor(Color.black);
     g.drawString("Play", playButton.x+40, playButton.y+50);
     g2d.draw(playButton);
     g.drawString("Quit", quitButton.x+40, quitButton.y+50);
     g2d.draw(quitButton);
    }
    
    public void renderText(Graphics g, String text, int textXPosition, int textYPosition) {
        g.drawString(text, textXPosition, textYPosition);
    }

    public void renderLoadingBackground(Graphics g, int backgroundId, int displayWidth, int displayHeight) {
        g.drawImage(Assets.retrieveImage(backgroundId), 0, 0, displayWidth, displayHeight, null);
    }

    public void renderLoadingTitle(Graphics g, int titleId, int titleWidth, int titleHeight, int titleXPosition, int titleYPosition) {
        g.drawImage(Assets.retrieveImage(titleId), titleXPosition, titleYPosition, titleWidth, titleHeight, null);
    }

}
