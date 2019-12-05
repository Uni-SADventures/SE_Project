package unisadventures.se_project.presenter.states;

import java.awt.Graphics;

import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.model.character.PlayerCharacter;

public class GameState extends State {
	
	private PlayerCharacter player;
	
	public GameState(Game game){
		super(game);
		player = new PlayerCharacter(game, 100, 100,100,100,"bro",6,1,6,10);
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}

}