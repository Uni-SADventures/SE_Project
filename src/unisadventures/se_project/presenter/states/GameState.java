package unisadventures.se_project.presenter.states;

import java.awt.Graphics;

import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.model.LevelManager;
import unisadventures.se_project.model.character.PlayerCharacter;

import unisadventures.se_project.util.CharacterType;



/**
 * This class extends state and implements gamestate, the actual state were the game is
 * playable ad frametime can go on.
 * It has every instance to be updated each frame as parameter
 * @author Emilio
 */

public class GameState extends State {

	private PlayerCharacter player;
	//private World _world; //TODO
        
        
	public GameState(Game game, LevelManager manager /*, World world*/){
		super(game/*,world*/);
		player = new PlayerCharacter(manager, game, game.getWidth()/2, 180,100,100,CharacterType.USER,6,1,6,300,"me");
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
                view.renderScenario(g);
                view.renderPlayer(g, player.getPosition().getFirstElement(), player.getPosition().getSecondElement());
		/*World.forEach(WorldObject el){
                    view.renderStuffMore(g, el.x, el.y, el.image);
                } */
               view.renderUi(g, player.getHealthBar(), player.getMaxHealth(), player.getCfu(), player.getLives());
                
                 
	}

}