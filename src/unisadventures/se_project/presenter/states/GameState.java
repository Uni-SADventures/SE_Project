package unisadventures.se_project.presenter.states;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import unisadventures.se_project.model.basicObjects.Tile;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.presenter.world.World;

import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.model.character.ZombieEnemy;
import unisadventures.se_project.model.character.actionCommands.ActionManager;

import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.view.gfx.Assets;

/**
 * This class extends state and implements gamestate, the actual state were the
 * game is playable ad frametime can go on. It has every instance to be updated
 * each frame as parameter
 *
 * @author Emilio
 */


public class GameState extends State {

    private ActionManager _player;
    private ZombieEnemy _enemy;
  
    
    //GAME UI IMAGE IDS
    private int _uiCfu ;
    private int _uiHalfHeart ;
    private int _uiFullHeart ;
    private int _uiEmptyHeart ;
    //UI NUMBERS
    private int[] _uiNumbers ;
    

    public GameState(Handler handler ) {
        super(handler);
        
        
        
        
        PlayerCharacter player = new PlayerCharacter(handler, 140, 90, 100, 100, CharacterType.USER, 6, 1, 6, 170, "me");
        _player = new ActionManager(handler,player) ;
        
        _enemy = new ZombieEnemy(handler,3000,450, 64, 64, CharacterType.ENEMY, 6, 1, 6, 300);
        
        
        
        World w = null ;
        try {
            w =new World(handler,"resources/images/world1.txt");
            System.out.println(w);
        } catch (Exception ex) {
            System.exit(0);
        }
        handler.setWorld(w);
        
        
        handler.getGame().getCam().move(100, 0);
        handler.getCam().centerOnEntity(player);
        
        loadImages();

    }

    public PlayerCharacter getPlayer() {
        return (PlayerCharacter) _player.getCh();
    }

    @Override
    public void tick() {
        _handler.getWorld().tick();
        _player.tick();
        _enemy.tick();
        
        /*World.forEach(WorldObject el){
                    el.tick() ;
                } */

    }

    @Override
    public void displayView(Graphics g) {
        view.renderScenario(g);
        int xStart=(int)Math.max(0,_handler.getCam().getxOffset()/Tile.TILEWIDTH-1);
        int xEnd=(int)Math.min(_handler.getWorld().getWidth(),(_handler.getCam().getxOffset() + _handler.getWidth())/Tile.TILEWIDTH+1);
        int yStart=(int)Math.max(0,_handler.getCam().getyOffset()/Tile.TILEHEIGHT);
        int yEnd=(int)Math.min(_handler.getWorld().getHeight(),(_handler.getCam().getyOffset() + _handler.getHeight())/Tile.TILEHEIGHT+1);
        
        for(int y=yStart;y<yEnd;y++){
            
            for(int x=xStart;x<xEnd;x++){
                
                view.renderTile(g, _handler.getWorld().getTile(x,y).getTexture() ,(int)(x*Tile.TILEWIDTH - _handler.getCam().getxOffset()), (int)(y*Tile.TILEHEIGHT - _handler.getCam().getyOffset()   ));
            }
        }
        view.renderPlayer(g, _player.getCh().getPosition().getFirstElement(), _player.getCh().getPosition().getSecondElement());
  
        view.renderStuffMore(g, _enemy.getxPosition(), _enemy.getyPosition(),_enemy.getDimension().getFirstElement(),_enemy.getDimension().getSecondElement(), _enemy.getIdleSprites(DirectionType.LEFT).get(0));
        /*World.forEach(WorldObject el){
                    view.renderStuffMore(g, el.x, el.y, el.image);
                } */
        view.renderUi(g, _player.getCh().getHealthBar(), _player.getCh().getMaxHealth(), ((PlayerCharacter)_player.getCh()).getCfu(), ((PlayerCharacter)_player.getCh()).getLives());

    }
    @Override
    public void loadImages(){
        //TODO, WE LOAD HERE ALL MODELS GIVING PATH NAMES
            
        //loading all sprites for characters
        
            Assets.init();
        //PLAYER CHARACTER
            List temp = new LinkedList<>() ;
            Assets.storeImage("resources/images/char.png");
            int nowSeq = Assets.getActualSequenceNumber() ;
           
            temp.add(nowSeq);   
            _player.getCh().setIdle(temp , temp);
            _player.getCh().setBeDamaged(temp, temp);
            _player.getCh().setFall(temp, temp);
            _player.getCh().setJump(temp, temp);
            _player.getCh().setPunch(temp, temp);
            _player.getCh().setWalk(temp, temp);
            
        //ENEMY CHARACTER
            temp = new LinkedList<>() ;
            Assets.storeImage("resources/images/enemy_sprite.png",16,96,16,32);
            nowSeq = Assets.getActualSequenceNumber() ;
           
            temp.add(nowSeq);   
            _enemy.setIdle(temp , temp);
            _enemy.setBeDamaged(temp, temp);
            _enemy.setFall(temp, temp);
            _enemy.setJump(temp, temp);
            _enemy.setPunch(temp, temp);
            _enemy.setWalk(temp, temp);
            
         
        //SCENARIO (which id is inside world now)
            Assets.storeImage("resources/images/sfondo_unisa_pixel.jpg");
            nowSeq = Assets.getActualSequenceNumber() ;
            _handler.getWorld().setScenarioImage(nowSeq);

             
            
            //TILES
            //ROCK TILE 
            Assets.storeImage("resources/images/grass.png",0,0,60,60);
            nowSeq = Assets.getActualSequenceNumber() ;
            Tile.setRockIdImage(nowSeq);
       
            //SKY TILE
            Assets.storeImage("resources/images/background.png",0,0,1000,375);
            nowSeq = Assets.getActualSequenceNumber() ;
            Tile.setSkyIdImage(nowSeq);
            
            //LIMIT TILE
            Assets.storeImage("resources/images/background.png",0,375,1000,375);
            nowSeq = Assets.getActualSequenceNumber() ;
            Tile.setLimitIdImage(nowSeq);
            
            
            
            //UI OBJECTS
            //CFU
            Assets.storeImage("resources/images/objectstilesheet.png",160,0,32,32);
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiCfu = nowSeq ;
            
            //FULLHEART
            Assets.storeImage("resources/images/objectstilesheet.png",0,0,32,32);
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiFullHeart = nowSeq ;
            
            //HALFHEART
            Assets.storeImage("resources/images/objectstilesheet.png",32,0,32,32);
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiHalfHeart = nowSeq;
            
            //EMPTYHEART
            Assets.storeImage("resources/images/objectstilesheet.png",64,0,32,32);
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiEmptyHeart = nowSeq ;
            
            
            //NUMBERS
            _uiNumbers = new int[10] ;
            //0
            Assets.storeImage("resources/images/numbers/Number0.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiNumbers[0] = nowSeq ;
            
            //1
            Assets.storeImage("resources/images/numbers/Number1.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiNumbers[1] = nowSeq ;
            
            //2
            Assets.storeImage("resources/images/numbers/Number2.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiNumbers[2] = nowSeq ;
            
            //3
            Assets.storeImage("resources/images/numbers/Number3.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiNumbers[3] = nowSeq ;
            
            //4
            Assets.storeImage("resources/images/numbers/Number4.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiNumbers[4] = nowSeq ;
            
            //5
            Assets.storeImage("resources/images/numbers/Number5.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiNumbers[5] = nowSeq ;
            
            //6
            Assets.storeImage("resources/images/numbers/Number6.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiNumbers[6] = nowSeq ;
            
            //7
            Assets.storeImage("resources/images/numbers/Number7.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiNumbers[7] = nowSeq ;
            
            //8
            Assets.storeImage("resources/images/numbers/Number8.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiNumbers[8] = nowSeq ;
            
            //9
            Assets.storeImage("resources/images/numbers/Number9.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            _uiNumbers[9] = nowSeq ;
           
            
    }

    public int getUiCfu() {
        return _uiCfu;
    }

    public int getUiHalfHeart() {
        return _uiHalfHeart;
    }

    public int getUiFullHeart() {
        return _uiFullHeart;
    }

    public int getUiEmptyHeart() {
        return _uiEmptyHeart;
    }

    public int[] getUiNumbers() {
        return _uiNumbers;
    }

    
    
    
}
