/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.camera;

import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.presenter.launcher.Game;

/**
 *
 * @author danielevalentino
 */


public class GameCamera {
	
	private Game game;
	private float xOffset, yOffset;
	
	public GameCamera(Game game, float xOffset, float yOffset){
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void centerOnEntity(PlayerCharacter p){
		xOffset = (float) (p.getPosition().getFirstElement() - game.getWidth() / 2 + p.getDimension().getFirstElement() / 2);
		//yOffset = (float) (p.getPosition().getSecondElement() - game.getHeight() / 2 + p.getDimension().getSecondElement() / 2);
	}
        
        public void centerOnEntityFloor(PlayerCharacter p){
		//xOffset = (float) (p.getPosition().getFirstElement() - game.getWidth() / 2 + p.getDimension().getFirstElement() / 2);
		yOffset = (float) (p.getPosition().getSecondElement() - game.getHeight() / 2 + p.getDimension().getSecondElement() / 2);
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
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
