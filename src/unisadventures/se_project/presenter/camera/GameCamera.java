/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.camera;

import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.model.basicObjects.Tile;

/**
 *This class does create a gamecamera as a support for game display. It does keep
 * state of x and y offset wich are determined by a character movements
 * It has as parameters its game instance and those x and y offsets
 * @author danielevalentino
 */


public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
        /**
         * Centers a camera on a character setting xOffset on his x position
         * @param p is the character passed
         */
	public void centerOnEntity(PlayerCharacter p){
		xOffset = (float) (p.getPosition().getFirstElement() - handler.getDisplayWidth() / 2 + p.getDimension().getFirstElement() / 2);
		//yOffset = (float) (p.getPosition().getSecondElement() - handler.getHeight() / 2 + p.getDimension().getSecondElement() / 2);
                checkBlankSpace();
        }
        
        public void checkBlankSpace(){
            if(xOffset<0){
                xOffset=0;
            }else if(xOffset>handler.getLevel().getLevelWidth()*Tile.TILEWIDTH-handler.getDisplayWidth()){
                xOffset=handler.getLevel().getLevelWidth()*Tile.TILEWIDTH-handler.getDisplayWidth();
            }
            if(yOffset<0){
                yOffset=0;
            }else if(yOffset>handler.getLevel().getLevelHeight()*Tile.TILEHEIGHT-handler.getDisplayHeight()){
                yOffset=handler.getLevel().getLevelHeight()*Tile.TILEHEIGHT-handler.getDisplayHeight();
            }
        }
        /**
         * Centers a camera on a character setting yOffset on his y position
         * To be used when a character lands on a platform higher than his initial position
         * or if while falling has reached an x value lower then its initial jump'
         * @param p is the character passed
         */
        public void centerOnEntityFloor(PlayerCharacter p){
		//xOffset = (float) (p.getPosition().getFirstElement() - game.getWidth() / 2 + p.getDimension().getFirstElement() / 2);
		yOffset = (float) (p.getPosition().getSecondElement() - handler.getDisplayHeight() / 2 + p.getDimension().getSecondElement() / 2);
                checkBlankSpace();
        }
	
        
        /**
         * It manually moves the camera
         * @param xAmt how much is needed to move it on x axis
         * @param yAmt how much is needed to move it on y axis
         */
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
                checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
