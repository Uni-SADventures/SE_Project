package unisadventures.se_project.presenter.states;

import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.presenter.world.World;

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
    private World _world;

    public GameState(Handler handler /*, World world*/) {
        super(handler/*,world*/);
        player = new PlayerCharacter(handler, 140, 90, 100, 100, CharacterType.USER, 6, 1, 6, 170, "me");
        enemy = new ZombieEnemy(handler, 0, 100, 16, 32, CharacterType.ENEMY, 6, 1, 6, 300);
        
        
        try {
            _world =new World(handler,"resources/images/world1.txt");
            System.out.println(_world);
        } catch (Exception ex) {
            System.exit(0);
        }
        
        
        handler.setWorld(_world);

        handler.getGame().getCam().move(100, 0);
        handler.getCam().centerOnEntity(player);

    }

    public PlayerCharacter getPlayer() {
        return player;
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
        _world.render(g);
        view.renderPlayer(g, player.getPosition().getFirstElement(), player.getPosition().getSecondElement());
  
        view.renderStuffMore(g, enemy.getPosition().getFirstElement(), enemy.getPosition().getSecondElement(), Assets.ground_1);
        /*World.forEach(WorldObject el){
                    view.renderStuffMore(g, el.x, el.y, el.image);
                } */
        view.renderUi(g, player.getHealthBar(), player.getMaxHealth(), player.getCfu(), player.getLives());

    }

}
