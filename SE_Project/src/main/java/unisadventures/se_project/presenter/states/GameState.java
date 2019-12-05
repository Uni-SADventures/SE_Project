package unisadventures.se_project.presenter.states;

import java.awt.Graphics;

import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.view.gfx.Assets;

public class GameState extends State {
	
	private PlayerCharacter player;
	
	public GameState(Game game){
		super(game);
		player = new PlayerCharacter(game, 100, 100,100,100,CharacterType.USER,6,1,6,10,"me");
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
                g.drawImage(Assets.scenario, (int) 0, (int) 0, null);
		player.render(g);
	}

}