package unisadventures.se_project.presenter.states;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import unisadventures.se_project.model.basicObjects.CollectibleItem;
import unisadventures.se_project.model.basicObjects.Tile;
import unisadventures.se_project.model.World;
import unisadventures.se_project.model.basicObjects.LimitTile;
import unisadventures.se_project.model.basicObjects.RockTile;
import unisadventures.se_project.model.basicObjects.SkyTile;
import unisadventures.se_project.model.character.*;
import unisadventures.se_project.model.character.actionCommands.*;
import unisadventures.se_project.presenter.camera.GameCamera;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.util.*;
import unisadventures.se_project.view.gfx.Assets;
import unisadventures.se_project.view.gfx.StateGraphics;

/**
 * This class extends state and implements gamestate, the actual state were the
 * game is playable ad frametime can go on. It has every instance to be updated
 * each frame as parameter
 *
 * @author Emilio
 */
public class GameState extends State {

    private Game _game;
    private World _world;
    private LinkedList<BasicEnemy> _enemy;
    private ArrayList<Pair<String, String>> levelManager = new ArrayList();
    private StateGraphics _view;
    private GameCamera _gameCamera;
    private Player _player;
    private KeyboardInput _keyboardInput;
    private MovementCommand _movementCommand;
    private HitCommand2 _hitCommand;
    private VerticalCommand2 _verticalCommand;
    private GrabCommand _grabcommand;
    private IdleCommand _idlecommand;
    
    //GAME UI IMAGE IDS
    private int _uiCfu;
    private int _uiHalfHeart;
    private int _uiFullHeart;
    private int _uiEmptyHeart;
    //UI NUMBERS
    private int[] _uiNumbers;
    private int _countCFU;
    private int _id;
    public boolean stateIsMenu;

    public GameState(Game game, int id) {
        super(game);
        _game = game;
        _id = id;
        _player = Player.getPlayer();
        levelManager.add(new Pair("resources/images/level1World.txt", "resources/images/level1Items.txt"));
        levelManager.add(new Pair("resources/images/level2World.txt", "resources/images/level2Items.txt"));
        levelManager.add(new Pair("resources/images/level3World.txt", "resources/images/level3Items.txt"));
        _enemy = new LinkedList<>();
        _enemy.add(new ZombieEnemy(300, 450, 64, 64));
        _enemy.add(new ZombieEnemy(600, 450, 64, 64));
        _keyboardInput = new KeyboardInput(_game.getKeyManager());
        _movementCommand = new MovementCommand();
        _verticalCommand = new VerticalCommand2();
        _hitCommand = new HitCommand2();
        _grabcommand = new GrabCommand();
        _idlecommand = new IdleCommand();
        
        _world = null;
        try {
            String path1 = levelManager.get(id).getFirst();
            String path2 = levelManager.get(id).getSecond();
            _world = new World(path1, path2);
        } catch (Exception ex) {
            System.exit(0);
        }
        _view = new StateGraphics(this);
        _gameCamera.move(100, 0);
        _gameCamera.centerOnEntity(_player);

        loadImages();

    }

    public Player getPlayer() {
        return _player;
    }

    public void setPlayer(Player _player) {
        this._player = _player;
    }


    public Game getGame() {
        return _game;
    }

    public void setGame(Game _game) {
        this._game = _game;
    }

    public GameCamera getGameCamera() {
        return _gameCamera;
    }

    public void setGameCamera(GameCamera _gameCamera) {
        this._gameCamera = _gameCamera;
    }

    public LinkedList<BasicEnemy> getEnemy() {
        return _enemy;
    }

    public void setEnemy(LinkedList<BasicEnemy> _enemy) {
        this._enemy = _enemy;
    }

    public ArrayList<Pair<String, String>> getLevelManager() {
        return levelManager;
    }

    public void setLevelManager(ArrayList<Pair<String, String>> levelManager) {
        this.levelManager = levelManager;
    }

    public World getWorld() {
        return _world;
    }

    public void setWorld(World world) {
        _world = world;
    }

    public StateGraphics getView() {
        return _view;
    }

    public void setView(StateGraphics _view) {
        this._view = _view;
    }

    @Override
    public void tick() {

        if (getCountCFU() == 8) {
            State.setState(new LoadingState(_game, _id));
        }
        //_world.tick();
        _keyboardInput.tick(_movementCommand, _verticalCommand, _hitCommand, _grabcommand, _idlecommand);
        _enemy.forEach((e) -> e.tick());
        for (BasicEnemy e : _enemy) {
            if (e.getHealthBar() <= 0) {
                _enemy.remove(e);
            }
        }
        
        _gameCamera.centerOnEntity(_player);
        /*World.forEach(WorldObject el){
                    el.tick() ;
                } */
    }

    @Override
    public void displayView(Graphics g) {
        _view.renderScenario(g);
        int xStart = (int) Math.max(0, _gameCamera.getxOffset() / Tile.TILEWIDTH - 1);

        int xEnd = (int) Math.min(_world.getWidth(), (_gameCamera.getxOffset() + _game.getDisplay().getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, _gameCamera.getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(_world.getHeight(), (_gameCamera.getyOffset() + _game.getDisplay().getHeight()) / Tile.TILEHEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {

            for (int x = xStart; x < xEnd; x++) {

                _view.renderTile(g, _world.getTile(x, y).getTexture(), (int) (x * Tile.TILEWIDTH - _gameCamera.getxOffset()), (int) (y * Tile.TILEHEIGHT - _gameCamera.getyOffset()));

            }
        }
        _view.renderPlayer(g, _player.getActualId(), _player.getxPosition(), _player.getyPosition());

        _enemy.forEach((e) -> _view.renderStuffMore(g, e.getxPosition(), e.getyPosition(), e.getWidth(), e.getHeight(), e.getIdleSprites(DirectionType.LEFT).get(1)));

        for (int i = 0; i < _enemy.size(); i++) {
            _view.renderStuffMore(g, _enemy.get(i).getxPosition(), _enemy.get(i).getyPosition(), _enemy.get(i).getWidth(), _enemy.get(i).getHeight(), _enemy.get(i).getIdleSprites(DirectionType.LEFT).get(i));
        }

        for (CollectibleItem coll : _world.getCollectibles()) {
            _view.renderStuffMore(g, coll.getxPosition(), coll.getyPosition(), coll.getWidth(), coll.getHeight(), coll.getNextImageFileName());
        }

        _countCFU = _view.renderUi(g, _player.getHealthBar(), _player.getMaxHealth(), (_player).getCfu(), (_player).getLives());

    }

    @Override
    public void loadImages() {
        //TODO, WE LOAD HERE ALL MODELS GIVING PATH NAMES

        //loading all sprites for characters
        Assets assets = new Assets();
        //PLAYER CHARACTER
        List temp = new LinkedList<>();
        assets.storeImage("resources/images/character_sprite.png", 48, 4, 16, 28);
        int nowSeq = assets.getActualSequenceNumber();

        for (int i = 0; i <= 20; i++) {
            temp.add(nowSeq);
        }

        assets.storeImage("resources/images/character_sprite.png", 16, 4, 16, 28);
        nowSeq = assets.getActualSequenceNumber();

        for (int i = 0; i <= 20; i++) {
            temp.add(nowSeq);
        }

        assets.storeImage("resources/images/character_sprite.png", 16, 36, 16, 28);
        nowSeq = assets.getActualSequenceNumber();

        for (int i = 0; i <= 20; i++) {
            temp.add(nowSeq);
        }

        _player.setIdle(temp, temp);

        temp = new LinkedList<>();
        assets.storeImage("resources/images/character_sprite.png", 48, 4, 16, 28);
        nowSeq = assets.getActualSequenceNumber();

        for (int i = 0; i <= 15; i++) {
            temp.add(nowSeq);
        }

        assets.storeImage("resources/images/character_sprite.png", 48, 36, 16, 28);
        nowSeq = assets.getActualSequenceNumber();

        for (int i = 0; i <= 15; i++) {
            temp.add(nowSeq);
        }

        List temp2 = new LinkedList<>();
        assets.storeImage("resources/images/character_sprite.png", 0, 4, 16, 28);
        nowSeq = assets.getActualSequenceNumber();

        for (int i = 0; i <= 15; i++) {
            temp2.add(nowSeq);
        }

        assets.storeImage("resources/images/character_sprite.png", 0, 36, 16, 28);
        nowSeq = assets.getActualSequenceNumber();

        for (int i = 0; i <= 15; i++) {
            temp2.add(nowSeq);
        }

        _player.setWalk(temp2, temp);
        _player.setBeDamaged(temp2, temp);
        _player.setFall(temp2, temp);
        _player.setJump(temp2, temp);
        _player.setPunch(temp2, temp);
        temp = new LinkedList<>();
        assets.storeImage("resources/images/character_damage_sprite.png", 16, 32, 16, 32);
        nowSeq = assets.getActualSequenceNumber();

        for (int i = 0; i <= 15; i++) {
            temp.add(nowSeq);
        }

        assets.storeImage("resources/images/character_damage_sprite.png", 32, 32, 16, 32);
        nowSeq = assets.getActualSequenceNumber();

        for (int i = 0; i <= 15; i++) {
            temp.add(nowSeq);
        }

        temp2 = new LinkedList<>();
        assets.storeImage("resources/images/character_damage_sprite.png", 16, 32, 16, 32);
        nowSeq = assets.getActualSequenceNumber();

        for (int i = 0; i <= 15; i++) {
            temp2.add(nowSeq);
        }

        assets.storeImage("resources/images/character_damage_sprite.png", 32, 32, 16, 32);
        nowSeq = assets.getActualSequenceNumber();

        for (int i = 0; i <= 15; i++) {
            temp2.add(nowSeq);
        }
        _player.setBeDamaged(temp2, temp);

        //ENEMY CHARACTER
        temp = new LinkedList<>();
        assets.storeImage("resources/images/enemy_Wind.png");//16,96,16,30);
        nowSeq = assets.getActualSequenceNumber();

        temp.add(nowSeq);

        assets.storeImage("resources/images/enemy_Shape.png");//16,96,16,30);
        nowSeq = assets.getActualSequenceNumber();

        temp.add(nowSeq);

        for (int i = 0; i < _enemy.size(); i++) {
            _enemy.get(i).setIdle(temp, temp);
            _enemy.get(i).setFall(temp, temp);
            _enemy.get(i).setJump(temp, temp);
            _enemy.get(i).setPunch(temp, temp);
            _enemy.get(i).setWalk(temp, temp);
        }

        //SCENARIO (which id is inside world now)
        assets.storeImage(_world.getPathScenarioImage());
        nowSeq = assets.getActualSequenceNumber();
        _world.setScenarioImage(nowSeq);

        //TILES
        //ROCK TILE 
        assets.storeImage("resources/images/platforms.jpg");//,0,0,60,60);
        RockTile rockTile = new RockTile(assets.getActualSequenceNumber(),2,200,200);
        
        //SKY TILE
        assets.storeImage("resources/images/background.png", 0, 0, 1000, 375);
        SkyTile skyTile = new SkyTile(assets.getActualSequenceNumber(),3,200,200);

        //LIMIT TILE
        assets.storeImage("resources/images/background.png", 0, 375, 1000, 375);
        LimitTile limitTile = new LimitTile(assets.getActualSequenceNumber(),4,200,200);

        //UI OBJECTS
        //CFU
        assets.storeImage("resources/images/objectstilesheet.png", 160, 0, 32, 32);
        nowSeq = assets.getActualSequenceNumber();
        _uiCfu = nowSeq;

        //FULLHEART
        assets.storeImage("resources/images/objectstilesheet.png", 0, 0, 32, 32);
        nowSeq = assets.getActualSequenceNumber();
        _uiFullHeart = nowSeq;

        //HALFHEART
        assets.storeImage("resources/images/objectstilesheet.png", 32, 0, 32, 32);
        nowSeq = assets.getActualSequenceNumber();
        _uiHalfHeart = nowSeq;

        //EMPTYHEART
        assets.storeImage("resources/images/objectstilesheet.png", 64, 0, 32, 32);
        nowSeq = assets.getActualSequenceNumber();
        _uiEmptyHeart = nowSeq;

        //NUMBERS
        _uiNumbers = new int[10];
        //0
        assets.storeImage("resources/images/numbers/Number0.png");
        nowSeq = assets.getActualSequenceNumber();
        _uiNumbers[0] = nowSeq;

        //1
        assets.storeImage("resources/images/numbers/Number1.png");
        nowSeq = assets.getActualSequenceNumber();
        _uiNumbers[1] = nowSeq;

        //2
        assets.storeImage("resources/images/numbers/Number2.png");
        nowSeq = assets.getActualSequenceNumber();
        _uiNumbers[2] = nowSeq;

        //3
        assets.storeImage("resources/images/numbers/Number3.png");
        nowSeq = assets.getActualSequenceNumber();
        _uiNumbers[3] = nowSeq;

        //4
        assets.storeImage("resources/images/numbers/Number4.png");
        nowSeq = assets.getActualSequenceNumber();
        _uiNumbers[4] = nowSeq;

        //5
        assets.storeImage("resources/images/numbers/Number5.png");
        nowSeq = assets.getActualSequenceNumber();
        _uiNumbers[5] = nowSeq;

        //6
        assets.storeImage("resources/images/numbers/Number6.png");
        nowSeq = assets.getActualSequenceNumber();
        _uiNumbers[6] = nowSeq;

        //7
        assets.storeImage("resources/images/numbers/Number7.png");
        nowSeq = assets.getActualSequenceNumber();
        _uiNumbers[7] = nowSeq;

        //8
        assets.storeImage("resources/images/numbers/Number8.png");
        nowSeq = assets.getActualSequenceNumber();
        _uiNumbers[8] = nowSeq;

        //9
        assets.storeImage("resources/images/numbers/Number9.png");
        nowSeq = assets.getActualSequenceNumber();
        _uiNumbers[9] = nowSeq;

        //COLLECTIBLES
        assets.storeImage("resources/images/objectstilesheet.png", 160, 0, 32, 32);
        nowSeq = assets.getActualSequenceNumber();
        temp = new LinkedList<>();
        for (int i = 0; i <= 15; i++) {
            temp.add(nowSeq);
        }
        assets.storeImage("resources/images/objectstilesheet.png", 96, 0, 32, 32);
        nowSeq = assets.getActualSequenceNumber();
        for (int i = 0; i <= 15; i++) {
            temp.add(nowSeq);
        }
        for (int i = 0; i <= _world.getCollectibles().size() - 1; i++) {
            _world.getCollectibles().get(i).setImageFileNameList(temp);
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

    public int getId() {
        return _id;
    }

    @Override
    public int getCountCFU() {
        return _countCFU;
    }

    public LinkedList<BasicEnemy> getEnemies() {
        return _enemy;
    }

}
