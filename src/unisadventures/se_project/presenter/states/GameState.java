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
import unisadventures.se_project.presenter.factory.CharacterCreator;
import unisadventures.se_project.presenter.factory.CollectiblesCreator;
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
    private LinkedList<ActionManager> _enemy;
    private LinkedList<CollectibleItem> _collectibles;
    private ArrayList<Pair<String,String>> levelManager = new ArrayList();
    private CharacterCreator _chFactory ;
    private CollectiblesCreator _collFactory ;
    private int _pauseImageId ;
    
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
        this.id=id;
        _collectibles = new LinkedList<>() ;
        levelManager.add(new Pair("resources/levels/level1World.txt","resources/levels/level1Items.txt"));
        levelManager.add(new Pair("resources/levels/level2World.txt","resources/levels/level2Items.txt"));
        levelManager.add(new Pair("resources/levels/level3World.txt","resources/levels/level3Items.txt"));
        
        Assets.init();
        _chFactory = new CharacterCreator(_handler) ;
        _collFactory = new CollectiblesCreator() ;
        //REMEMBER THAT WHEN YOU CHANGE IMAGES YOU NEED TO PUT HEIGHT AND WIDTH ACCORDING TO 
        //THAT IMAGES' DIMENSIONS HERE AT THE 4TH AND 5TH ARGUMENT
        //RICORCA CHE SE VUOI CAMBIARE LE IMMAGINI DEVI METTERE ALTEZZA E LARGHEZZA COME
        //QUELLE DELLE IMMAGINI CHE VUOI USARE GIA' QUI AL 4o E 5o ARGOMENTO
        
        _player = new ActionManager(_handler,_chFactory.createPlayerCharacter(90, 90)) ;
         _enemy = new LinkedList<>();
         
        
        /*_enemy.add(new ZombieEnemy(handler, 300, 450, 64, 64, CharacterType.ENEMY, 6, 1, 6, 300));
        _enemy.add(new ZombieEnemy(handler, 600, 450, 64, 64, CharacterType.ENEMY, 6, 1, 6, 300));*/
        
        
        GameLevel level = null ;
        try {
            String path1=levelManager.get(id).getFirstElement();
            String path2=levelManager.get(id).getSecondElement();
            level =new GameLevel(path1,path2, _handler.getDisplayWidth(), _handler.getDisplayHeight());
        } catch (Exception ex) {
            System.exit(0);
        }
        _handler.setLevel(level);
        
        for(int j=0;j<level.getEnemiesPositions().size();j++)
            _enemy.add(j,new ActionManager(_handler, _chFactory.createRandomPr(level.getEnemiesPositions().get(j).getFirstElement(), level.getEnemiesPositions().get(j).getSecondElement())));
        
        
        for(int i=0;i<=level.getCollectiblePositions().size()-1;i++)
            _collectibles.add(i,_collFactory.createCfuCollectible(level.getCollectiblePositions().get(i).getFirstElement(), level.getCollectiblePositions().get(i).getSecondElement() )) ;
        
        for(int i=0;i<=level.getCoffeePositions().size()-1;i++)
            _collectibles.add(i,_collFactory.createCoffeeCollectible(level.getCoffeePositions().get(i).getFirstElement(), level.getCoffeePositions().get(i).getSecondElement() )) ;
        
        for(int i=0;i<=level.getJetpackPositions().size()-1;i++)
            _collectibles.add(i,_collFactory.createJetpackCollectible(level.getJetpackPositions().get(i).getFirstElement(), level.getJetpackPositions().get(i).getSecondElement() )) ;

        for(int i=0;i<=level.getHeartPositions().size()-1;i++)
            _collectibles.add(i,_collFactory.createHeartCollectible(level.getHeartPositions().get(i).getFirstElement(), level.getHeartPositions().get(i).getSecondElement() )) ;

        
        
        
        _handler.getGame().getCam().move(100, 0);
        _handler.getCam().centerOnEntity((PlayerCharacter) _player.getCh());
        
        loadImages();
        _handler.getKeyManager().esc = false ;
        
    }

    public PlayerCharacter getPlayer() {
        return (PlayerCharacter) _player.getCh();
    }
    
    public ActionManager getPlayerActionManager() {
        return _player;
    }

    @Override
    public void tick() {
        if( _handler.getKeyManager().esc)
            return ;
        
        if(_player.getCh().getHealthBar()<=0 || _player.getCh().getyPosition() >= _handler.getDisplayHeight()){
            State.setState(new GameOverState(_handler, id));
            
        }
        
        if(getCountCFU()==8){
            State.setState(new LoadingState(_handler,id));
        }
        _handler.getLevel().tick();
        _player.tick();
      
        LinkedList<ActionManager> oldEnemy= (LinkedList<ActionManager>) _enemy.clone();
        for(int i = 0 ; i < oldEnemy.size() ; i++ ){
            oldEnemy.get(i).tick();
        //    if(oldEnemy.get(i).checkVerticalCollision())
             //   oldEnemy.get(i).takeDamage(_player.getCh().getStrength()); TO FIX
            oldEnemy.get(i).attack();
            oldEnemy.get(i).movement();
            
            
        }

        for(ActionManager e: oldEnemy){
            if(e.getCh().getHealthBar() <= 0){
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
  
        
        
         for (int i=0;i<_enemy.size();i++) {
            view.renderStuffMore(g, _enemy.get(i).getCh().getxPosition(), _enemy.get(i).getCh().getyPosition(), _enemy.get(i).getCh().getDimension().getFirstElement(), _enemy.get(i).getCh().getDimension().getSecondElement(), _enemy.get(i).getActualId());
            }
        
        for(CollectibleItem coll : _collectibles){
            view.renderStuffMore(g, coll.getxPosition(), coll.getyPosition(),coll.getWidth(),coll.getHeight(),coll.getNextImageFileName());
        }
        
        
        
        countCFU=view.renderUi(g, _player.getCh().getHealthBar(), _player.getCh().getMaxHealth(), ((PlayerCharacter)_player.getCh()).getCfu(), ((PlayerCharacter)_player.getCh()).getLives());
        if(_handler.getKeyManager().esc)
            view.renderPause(g, _pauseImageId) ;
//  Rectangle r = HitCommand._hitArea ;
        //g.fill3DRect(r.x, r.y, r.width, r.height,true);
        
    }
    @Override
    public void loadImages(){
        //TODO, WE LOAD HERE ALL MODELS GIVING PATH NAMES
            
        //loading all sprites for characters
        
      
            
            List temp = new LinkedList<>() ;
         
        //SCENARIO (which id is inside world now)
            Assets.storeImage(_handler.getLevel().getPathScenarioImage());
            int nowSeq = Assets.getActualSequenceNumber() ;
            _handler.getLevel().setScenarioImage(nowSeq);

             
            
            //TILES
            //ROCK TILE 
            Assets.storeImage("resources/images/platforms.jpg");//,0,0,60,60);
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
           
            
            
            Assets.storeImage("resources/images/pause.gif");
            nowSeq = Assets.getActualSequenceNumber() ;
            _pauseImageId = nowSeq ;
  
            
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

    public LinkedList<ActionManager> getEnemies() {
        return _enemy;
    }

    /**
     *
     */
    
    


    
    
    
}
