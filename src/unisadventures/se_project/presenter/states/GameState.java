package unisadventures.se_project.presenter.states;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import unisadventures.se_project.model.basicObjects.CollectibleItem;
import unisadventures.se_project.model.basicObjects.Tile;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.model.GameLevel;
import unisadventures.se_project.model.character.EnemyCharacter;

import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.model.character.ZombieEnemy;
import unisadventures.se_project.model.character.actionCommands.ActionManager;
import unisadventures.se_project.presenter.launcher.Game;

import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.util.CollectibleType;
import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.util.Pair;
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
    private LinkedList<EnemyCharacter> _enemy;
    private LinkedList<CollectibleItem> _collectibles;
    private Handler handler;
    private ArrayList<Pair<String,String>> levelManager = new ArrayList();
    
    
    //GAME UI IMAGE IDS
    private int _uiCfu ;
    private int _uiHalfHeart ;
    private int _uiFullHeart ;
    private int _uiEmptyHeart ;
    //UI NUMBERS
    private int[] _uiNumbers ;
    private int countCFU;
    private int id;
    public boolean stateIsMenu;

    public GameState(Handler handler ,int id) {
        super(handler);
        this.handler = handler;
        this.id=id;
        _collectibles = new LinkedList<>() ;
        levelManager.add(new Pair("resources/images/level1World.txt","resources/images/level1Items.txt"));
        levelManager.add(new Pair("resources/images/level2World.txt","resources/images/level2Items.txt"));
        levelManager.add(new Pair("resources/images/level3World.txt","resources/images/level3Items.txt"));
        //REMEMBER THAT WHEN YOU CHANGE IMAGES YOU NEED TO PUT HEIGHT AND WIDTH ACCORDING TO 
        //THAT IMAGES' DIMENSIONS HERE AT THE 4TH AND 5TH ARGUMENT
        //RICORCA CHE SE VUOI CAMBIARE LE IMMAGINI DEVI METTERE ALTEZZA E LARGHEZZA COME
        //QUELLE DELLE IMMAGINI CHE VUOI USARE GIA' QUI AL 4o E 5o ARGOMENTO
        PlayerCharacter player = new PlayerCharacter(handler, 90, 90, 64, 64, CharacterType.USER, 6, 1, 6, 170, "me");
        _player = new ActionManager(handler,player) ;
         _enemy = new LinkedList<>();
        _enemy.add(new ZombieEnemy(handler, 300, 450, 64, 64, CharacterType.ENEMY, 6, 1, 6, 300));
        
        
        GameLevel level = null ;
        try {
            String path1=levelManager.get(id).getFirstElement();
            String path2=levelManager.get(id).getSecondElement();
            level =new GameLevel(path1,path2, handler.getDisplayWidth(), handler.getDisplayHeight());
        } catch (Exception ex) {
            System.exit(0);
        }
        handler.setLevel(level);
        
        for(int i=0;i<=level.getCollectiblePositions().size()-1;i++){
            _collectibles.add(i,new CollectibleItem(level.getCollectiblePositions().get(i).getFirstElement(),level.getCollectiblePositions().get(i).getSecondElement() , 32, 32, CollectibleType.CFU));
        }
        

        
        handler.getGame().getCam().move(100, 0);
        handler.getCam().centerOnEntity(player);
        
        loadImages();

    }

    public PlayerCharacter getPlayer() {
        return (PlayerCharacter) _player.getCh();
    }
    
    public ActionManager getPlayerActionManager() {
        return _player;
    }

    @Override
    public void tick() {
        
        if(getCountCFU()==3){
            State.setState(new LoadingState(handler,id));
        }
        _handler.getLevel().tick();
        _player.tick();
        _enemy.forEach((e)->e.tick());
        for(EnemyCharacter e: _enemy){
            if(e.getHealthBar() <= 0){
                _enemy.remove(e);
            }
        }
       

        /*World.forEach(WorldObject el){
                    el.tick() ;
                } */

    }

    @Override
    public void displayView(Graphics g) {
        view.renderScenario(g);
        int xStart=(int)Math.max(0,_handler.getCam().getxOffset()/Tile.TILEWIDTH-1);

        int xEnd=(int)Math.min(_handler.getLevel().getLevelWidth(),(_handler.getCam().getxOffset() + _handler.getDisplayWidth())/Tile.TILEWIDTH+1);
        int yStart=(int)Math.max(0,_handler.getCam().getyOffset()/Tile.TILEHEIGHT);
        int yEnd=(int)Math.min(_handler.getLevel().getLevelHeight(),(_handler.getCam().getyOffset() + _handler.getDisplayHeight())/Tile.TILEHEIGHT+1);

        
        for(int y=yStart;y<yEnd;y++){
            
            for(int x=xStart;x<xEnd;x++){
                

                view.renderTile(g, _handler.getLevel().getTile(x,y).getTexture() ,(int)(x*Tile.TILEWIDTH - _handler.getCam().getxOffset()), (int)(y*Tile.TILEHEIGHT - _handler.getCam().getyOffset()   ));

            }
        }
        view.renderPlayer(g, _player.getActualId(),_player.getCh().getPosition().getFirstElement(), _player.getCh().getPosition().getSecondElement());
  
        _enemy.forEach((e) -> view.renderStuffMore(g, e.getxPosition(), e.getyPosition(), e.getDimension().getFirstElement(), e.getDimension().getSecondElement(), e.getIdleSprites(DirectionType.LEFT).get(0)));
        
        for(CollectibleItem coll : _collectibles){
            view.renderStuffMore(g, coll.getxPosition(), coll.getyPosition(),coll.getWidth(),coll.getHeight(),coll.getNextImageFileName());
        }
        
        
        
        countCFU=view.renderUi(g, _player.getCh().getHealthBar(), _player.getCh().getMaxHealth(), ((PlayerCharacter)_player.getCh()).getCfu(), ((PlayerCharacter)_player.getCh()).getLives());

    }
    @Override
    public void loadImages(){
        //TODO, WE LOAD HERE ALL MODELS GIVING PATH NAMES
            
        //loading all sprites for characters
        
            Assets.init();
        //PLAYER CHARACTER
            List temp = new LinkedList<>() ;
            Assets.storeImage("resources/images/character_sprite.png",48,4,16,28);
            int nowSeq = Assets.getActualSequenceNumber() ;
           
            for(int i = 0; i <= 20 ; i++ )
                temp.add(nowSeq);  
            
            Assets.storeImage("resources/images/character_sprite.png",16,4,16,28);
            nowSeq = Assets.getActualSequenceNumber() ;
            
            for(int i = 0; i <= 20 ; i++ )
                temp.add(nowSeq);  
            
            Assets.storeImage("resources/images/character_sprite.png",16,36,16,28);
            nowSeq = Assets.getActualSequenceNumber() ;
            
            for(int i = 0; i <= 20 ; i++ )
                temp.add(nowSeq); 
           
            _player.getCh().setIdle(temp , temp);
            
            temp = new LinkedList<>() ;
            Assets.storeImage("resources/images/character_sprite.png",48,4,16,28);
            nowSeq = Assets.getActualSequenceNumber() ;
           
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq);  
            
            Assets.storeImage("resources/images/character_sprite.png",48,36,16,28);
            nowSeq = Assets.getActualSequenceNumber() ;
            
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq);  
            
            List temp2 = new LinkedList<>() ;
            Assets.storeImage("resources/images/character_sprite.png",0,4,16,28);
            nowSeq = Assets.getActualSequenceNumber() ;
           
            for(int i = 0; i <= 15 ; i++ )
                temp2.add(nowSeq);  
            
            Assets.storeImage("resources/images/character_sprite.png",0,36,16,28);
            nowSeq = Assets.getActualSequenceNumber() ;
            
            for(int i = 0; i <= 15 ; i++ )
                temp2.add(nowSeq);  
            
            _player.getCh().setWalk(temp2, temp);
            _player.getCh().setBeDamaged(temp2, temp);
            _player.getCh().setFall(temp2, temp);
            _player.getCh().setJump(temp2, temp);
            _player.getCh().setPunch(temp2, temp);
            temp = new LinkedList<>() ;
            Assets.storeImage("resources/images/character_damage_sprite.png",16,32,16,32);
            nowSeq = Assets.getActualSequenceNumber() ;
           
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq);  
            
            Assets.storeImage("resources/images/character_damage_sprite.png",32,32,16,32);
            nowSeq = Assets.getActualSequenceNumber() ;
            
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq);  
            
            temp2 = new LinkedList<>() ;
            Assets.storeImage("resources/images/character_damage_sprite.png",16,32,16,32);
            nowSeq = Assets.getActualSequenceNumber() ;
           
            for(int i = 0; i <= 15 ; i++ )
                temp2.add(nowSeq);  
            
            Assets.storeImage("resources/images/character_damage_sprite.png",32,32,16,32);
            nowSeq = Assets.getActualSequenceNumber() ;
            
            for(int i = 0; i <= 15 ; i++ )
                temp2.add(nowSeq);
            _player.getCh().setBeDamaged(temp2, temp);
            
            
        //ENEMY CHARACTER
            temp = new LinkedList<>() ;
            Assets.storeImage("resources/images/enemy_sprite.png",16,96,16,30);
            nowSeq = Assets.getActualSequenceNumber() ;
           
            temp.add(nowSeq);   
            for (EnemyCharacter enemy : _enemy) {
            enemy.setIdle(temp, temp);
            enemy.setFall(temp, temp);
            enemy.setJump(temp, temp);
            enemy.setPunch(temp, temp);
            enemy.setWalk(temp, temp);
            }
            
         
        //SCENARIO (which id is inside world now)
            Assets.storeImage("resources/images/sfondo_unisa_pixel.jpg");
            nowSeq = Assets.getActualSequenceNumber() ;
            _handler.getLevel().setScenarioImage(nowSeq);

             
            
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
           
            //COLLECTIBLES
            
            Assets.storeImage("resources/images/objectstilesheet.png",160,0,32,32);
            nowSeq = Assets.getActualSequenceNumber() ;
            temp = new LinkedList<>();
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq);  
            Assets.storeImage("resources/images/objectstilesheet.png",96,0,32,32);
            nowSeq = Assets.getActualSequenceNumber() ;
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq); 
            for(int i=0;i<=handler.getLevel().getCollectiblePositions().size()-1;i++){
                 _collectibles.get(i).setImageFileNameList(temp);
        }
  
            
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

    public LinkedList<CollectibleItem> getCollectibles() {
        return _collectibles;
    }

    @Override
    public int getCountCFU() {
        return countCFU;
    }

    public LinkedList<EnemyCharacter> getEnemies() {
        return _enemy;
    }

    
    
    

    
    
    
}
