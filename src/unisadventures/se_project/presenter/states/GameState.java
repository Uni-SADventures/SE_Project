package unisadventures.se_project.presenter.states;

import java.awt.Graphics;

import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.model.character.PlayerCharacter;

import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.view.gfx.Assets;
import unisadventures.se_project.view.gfx.StateGraphics;

public class GameState extends State {

	private PlayerCharacter player;
	//private World _world; //TODO
        
        
	public GameState(Game game /*, World world*/){
		super(game/*,world*/);
		player = new PlayerCharacter(game, game.getWidth()/2, 180,100,100,CharacterType.USER,6,1,6,300,"me");
                //_world = world ;
                game.getCam().move(100, 0);
                game.getCam().centerOnEntity(player);
                
                
	}
	
	@Override
	public void tick() {
		player.tick();
                /*World.forEach(WorldObject el){
                    el.tick() ;
                } */
              
	}

	
        
        @Override
        public void displayView(Graphics g) {
                view.render(g, player.getPosition().getFirstElement(), player.getPosition().getSecondElement());
		/*World.forEach(WorldObject el){
                    view.renderStuffMore(g, el.x, el.y, el.image);
                } */
                 
	}

}