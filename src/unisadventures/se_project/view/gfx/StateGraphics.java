/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.view.gfx;


import java.awt.Graphics;
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
     
        g.drawImage(Assets.retrieveImage(playerId), (int) (x- _handler.getCam().getxOffset()), (int) (y-_handler.getCam().getyOffset()), null);

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
    
    
    public void renderUi(Graphics g, int health, int maxHealth, int cfu, int lives){
        
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
        cfu=20;
        int[] cfuDigits = String.valueOf(cfu).chars().map(Character::getNumericValue).toArray();
        
        pixelIncrementer = 0;
        for (int i = 0; i < cfuDigits.length; i++) {
           
           switch (cfuDigits[i]) {
               case 0:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[0]), 10+pixelIncrementer, 10, null);
                   break;
               case 1:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[1]), 10+pixelIncrementer, 10, null);
                   break;
               case 2:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[2]), 10+pixelIncrementer, 10, null);
                   break;
               case 3:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[3]), 10+pixelIncrementer, 10, null);
                   break;
               case 4:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[4]), 10+pixelIncrementer, 10, null);
                   break;
               case 5:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[5]), 10+pixelIncrementer, 10, null);
                   break;
               case 6:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[6]), 10+pixelIncrementer, 10, null);
                   break;
               case 7:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[7]), 10+pixelIncrementer, 10, null);
                   break;
               case 8:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[8]), 10+pixelIncrementer, 10, null);
                   break;
               case 9:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[9]), 10+pixelIncrementer, 10, null);
                   break;
               default:
                   break;
           }
               pixelIncrementer +=7;
        }
        lives=20;
        pixelIncrementer +=0;
        int[] livesDigits = String.valueOf(lives).chars().map(Character::getNumericValue).toArray();
        for (int i = 0; i < livesDigits.length; i++) {
           
           switch (livesDigits[i]) {
               case 0:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[0]), 200+pixelIncrementer, 10, null);
                   break;
               case 1:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[1]), 200+pixelIncrementer, 10, null);
                   break;
               case 2:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[2]), 200+pixelIncrementer, 10, null);
                   break;
               case 3:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[3]), 200+pixelIncrementer, 10, null);
                   break;
               case 4:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[4]), 200+pixelIncrementer, 10, null);
                   break;
               case 5:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[5]), 200+pixelIncrementer, 10, null);
                   break;
               case 6:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[6]), 200+pixelIncrementer, 10, null);
                   break;
               case 7:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[7]), 200+pixelIncrementer, 10, null);
                   break;
               case 8:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[8]), 200+pixelIncrementer, 10, null);
                   break;
               case 9:
                   g.drawImage(Assets.retrieveImage(state.getUiNumbers()[9]), 200+pixelIncrementer, 10, null);
                   break;
               default:
                   break;
           }
               pixelIncrementer +=7;
        }
        
        g.drawImage(Assets.retrieveImage(state.getUiFullHeart()), 210+pixelIncrementer, 10, null);
            //g.setColor(Color.red);
            //g.drawString("10", 15 + (j * 2), 50);
        
        
        
        }
    
    public void renderTile(Graphics g,int imageId,int x,int y){
        g.drawImage( Assets.retrieveImage(imageId), x, y, TILEWIDTH, TILEHEIGHT, null);
    }
    
    public void renderMenuBackground(Graphics g, int backgroundId, int displayWidth, int displayHeight) {
        g.drawImage(Assets.retrieveImage(backgroundId), 0, 0, displayWidth, displayHeight, null);
    }
    
    public void renderMenuTitle(Graphics g, int titleId, int titleWidth, int titleHeight, int titleXPosition, int titleYPosition) {
        g.drawImage(Assets.retrieveImage(titleId), titleXPosition, titleYPosition, titleWidth, titleHeight, null);
    }
    
    public void renderText(Graphics g, String text, int textXPosition, int textYPosition) {
        g.drawString(text, textXPosition, textYPosition);
    }
}
