package unisadventures.se_project.Model.character;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import unisadventures.se_project.util.DirectionType;

/**
 * Hold down an arrow key to have your hero move around the screen.
 * Hold down the shift key to have the hero run.
 */
public class testMovements extends Application {

    private static final double W = 600, H = 400;
    private static final String SCENARIO_IMAGE = "https://i.imgur.com/pj38qGl.jpg";
    private static final String HERO_IMAGE_LOC =
            "https://i.imgur.com/2NEzBZJ.png";

    private Image heroImage;
    private BasicCharacter hero;
    private EnemyCharacter enemy;
    boolean  goEast, goWest, jumping, hitting, falling = true;

    @Override
    public void start(Stage stage) throws Exception {
        heroImage = new Image(HERO_IMAGE_LOC);
        Image scenarioImage = new Image(SCENARIO_IMAGE);
        hero = new UserCharacter(heroImage,"test",3,3,3,120,"UserName");
        enemy = new EnemyCharacter(heroImage,"Test",3,3,3,200);
        Group dungeon = new Group(new ImageView(scenarioImage),hero,enemy);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("Uni-Sadventures");
        
        moveHeroTo(W / 2, H / 2);
        moveEnemyTo(W / 2,H / 2);
        Scene scene = new Scene(dungeon, W, H, Color.FORESTGREEN);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                  
                    case LEFT:  goWest  = true; break;
                    case RIGHT: goEast  = true; break;
                    case A:  goWest  = true; break;
                    case D: goEast  = true; break;
                    case F: hitting  = true; break;
                    case SPACE: if(!falling)
                        jumping = true; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {

                    case LEFT:
                        goWest = false;
                        break;
                    case RIGHT:
                        goEast = false;
                        break;
                    case A:
                        goWest = false;
                        break;
                    case D:
                        goEast = false;
                        break;
                    case F: hitting  = false; break;
                    case SPACE: {
                        jumping = false;
                        falling = true;
                        break;
                    }
                }
            }
        });

        stage.setScene(scene);
        stage.show();
        AnimationTimer enemyTimer= enemy.animationPattern(W,W);
        

        AnimationTimer timer = new AnimationTimer() {
            
            @Override
            public void handle(long now) {
                if (goEast) {
                    hero.move(W,DirectionType.RIGHT);
                }
                if (goWest) {
                    hero.move(W,DirectionType.LEFT);
                }
                if (jumping) {
                    jumping = hero.jump(H);
                    if (!jumping) {
                        falling = true;
                    }
                }
                
                double y = hero.getLayoutY()+ hero.getBoundsInLocal().getHeight() / 2;

     

                 if (!jumping && y <= H-100) {
                    falling = hero.fall(H);
                }
                if(hitting){
                    hero.attack();
                }
                
            checkInteractiveObject() ;
            }

            private void checkInteractiveObject() {
                 //controlla che nella posizione ci sia oggetto
                //lui capisce se è grab o potenziamento e se potenziamente gestisce
                //il decorator e rida tutto in hero
            }
        };
        timer.start();
        enemyTimer.start(); 
   }
/*
    private void moveHeroBy(int dx, int dy) {
        if (dx == 0 && dy == 0) return;

        final double cx = hero.getBoundsInLocal().getWidth()  / 2;
        final double cy = hero.getBoundsInLocal().getHeight() / 2;

        double x = cx + hero.getLayoutX() + dx;
        double y = cy + hero.getLayoutY() + dy;

        moveHeroTo(x, y);
    }*/

    private void moveHeroTo(double x, double y) {
        final double cx = hero.getBoundsInLocal().getWidth()  / 2;
        final double cy = hero.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
            x + cx <= W &&
            y - cy >= 0 &&
            y + cy <= H) {
            hero.relocate(x - cx, y - cy);
        }
    }
    private void moveEnemyTo(double x, double y) {
        final double cx = enemy.getBoundsInLocal().getWidth()  / 2;
        final double cy = enemy.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
            x + cx <= W &&
            y - cy >= 0 &&
            y + cy <= H) {
            enemy.relocate(x - cx, y - cy);
        }
    }
    
    public static void main(String[] args) { launch(args); }
}