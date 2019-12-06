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
		player = new PlayerCharacter(game, game.getWidth()/2, 180,100,100,CharacterType.USER,6,1,6,300,"me");
               // player.setSpeed(10);
                game.getCam().move(100, 0);
                game.getCam().centerOnEntity(player);
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
        
        public void render(Graphics g,int x, int y) {
                g.drawImage(Assets.scenario, (int) -game.getCam().getxOffset(), (int) -game.getCam().getyOffset(), null);
		player.render(g);
                 
	}

}