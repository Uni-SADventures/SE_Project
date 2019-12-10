package unisadventures.se_project.presenter.states;

import java.awt.Graphics;

import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.model.character.ZombieEnemy;

import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.view.gfx.Assets;

/**
 * This class extends state and implements gamestate, the actual state were the
 * game is playable ad frametime can go on. It has every instance to be updated
 * each frame as parameter
 *
 * @author Emilio
 */
public class GameState extends State {

    private PlayerCharacter player;
    private ZombieEnemy enemy;
    //private World _world; //TODO

    public GameState(Game game /*, World world*/) {
        super(game/*,world*/);
        player = new PlayerCharacter(game, game.getWidth() / 2, 180, 100, 100, CharacterType.USER, 6, 1, 6, 300, "me");
        enemy = new ZombieEnemy(game, 0, 100, 16, 32, CharacterType.ENEMY, 6, 1, 6, 300);
        //_world = world ;
        game.getCam().move(100, 0);
        game.getCam().centerOnEntity(player);

    }

    @Override
    public void tick() {
        player.tick();
        enemy.tick();
        
        /*World.forEach(WorldObject el){
                    el.tick() ;
                } */

    }

    @Override
    public void displayView(Graphics g) {
        view.renderScenario(g);
        view.renderPlayer(g, player.getPosition().getFirstElement(), player.getPosition().getSecondElement());
  
        view.renderStuffMore(g, enemy.getPosition().getFirstElement(), enemy.getPosition().getSecondElement(), Assets.ground_1);
        /*World.forEach(WorldObject el){
                    view.renderStuffMore(g, el.x, el.y, el.image);
                } */
        view.renderUi(g, player.getHealthBar(), player.getMaxHealth(), player.getCfu(), player.getLives());

    }

}
