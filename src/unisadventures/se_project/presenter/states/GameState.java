package unisadventures.se_project.presenter.states;

import java.awt.Graphics;

import java.util.logging.Level;
import unisadventures.se_project.model.basicObjects.Tile;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.model.GameLevel;

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
    private GameLevel _level;

    public GameState(Handler handler /*, World world*/) {
        super(handler);
        try {
            _level =new GameLevel("resources/images/world1.txt");
            System.out.println(_level);
        } catch (Exception ex) {
            System.exit(0);
        }
        handler.setWorld(_level);

        player = new PlayerCharacter(handler, 140, 90, 100, 100, CharacterType.USER, 6, 1, 6, 170, "me");
        enemy = new ZombieEnemy(handler,3000,450, 64, 64, CharacterType.ENEMY, 6, 1, 6, 300);
        
        handler.getGame().getCam().move(100, 0);
        handler.getCam().centerOnEntity(player);

    }

    public PlayerCharacter getPlayer() {
        return player;
    }

    @Override
    public void tick() {
        _level.tick();
        player.tick();
        enemy.tick();
        
        /*World.forEach(WorldObject el){
                    el.tick() ;
                } */

    }

    @Override
    public void displayView(Graphics g) {
        view.renderScenario(g);
        int xStart=(int)Math.max(0,_handler.getCam().getxOffset()/Tile.TILEWIDTH-1);
        int xEnd=(int)Math.min(_level.getWidth(),(_handler.getCam().getxOffset() + _handler.getWidth())/Tile.TILEWIDTH+1);
        int yStart=(int)Math.max(0,_handler.getCam().getyOffset()/Tile.TILEHEIGHT);
        int yEnd=(int)Math.min(_level.getHeight(),(_handler.getCam().getyOffset() + _handler.getHeight())/Tile.TILEHEIGHT+1);
        
        for(int y=yStart;y<yEnd;y++){
            for(int x=xStart;x<xEnd;x++){
                
                view.renderTile(g, _level.getTile(x,y).getTexture() ,(int)(x*Tile.TILEWIDTH - _handler.getCam().getxOffset()), (int)(y*Tile.TILEHEIGHT - _handler.getCam().getyOffset()   ));
            }
        }
        view.renderPlayer(g, player.getPosition().getFirstElement(), player.getPosition().getSecondElement());
  
        view.renderStuffMore(g, enemy.getxPosition(), enemy.getyPosition(),enemy.getDimension().getFirstElement(),enemy.getDimension().getSecondElement(), Assets.enemy);
        /*World.forEach(WorldObject el){
                    view.renderStuffMore(g, el.x, el.y, el.image);
                } */
        view.renderUi(g, player.getHealthBar(), player.getMaxHealth(), player.getCfu(), player.getLives());

    }

}
