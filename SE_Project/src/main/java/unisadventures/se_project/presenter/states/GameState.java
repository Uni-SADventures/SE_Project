package presenter.states;

import java.awt.Graphics;

import presenter.launcher.Game;
import model.character.UserCharacter;

public class GameState extends State {
	
	private UserCharacter player;
	
	public GameState(Game game){
		super(game);
		player = new UserCharacter(game, 100, 100,100,100,"bro",6,1,6,10);
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