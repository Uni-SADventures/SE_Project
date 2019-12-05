package unisadventures.se_project.model.character;

import java.awt.Graphics;
import java.util.Timer;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.util.Pair;
import unisadventures.se_project.view.gfx.Assets;

public class PlayerCharacter extends BasicCharacter {

    private Game _game;

    public PlayerCharacter(Game game, double xPosition, double yPosition, double height, double width, CharacterType type, int healthBar, int strength, int maxHealth, double maxJump) {
        super(xPosition, yPosition, height, width, type, healthBar, strength, maxHealth, maxJump);
        _game = game;
    }
    double fall = 0;
    int i = 0;

    @Override
     public void tick() {
        _game.start();
        if(!_game.getKeyManager().up && getJumping().getFirstElement() ){
            if(getJumping().getSecondElement() < 16)
               
                setFalling(new Pair(true,16-getJumping().getSecondElement()));
           
            setJumping(new Pair(false,0));
           // setFalling(new Pair(true,16-getJumping().getSecondElement()));
        //    if(getFalling().getSecondElement() == 16)
          //      setFalling(new Pair(false,0));
        }
         if (_game.getKeyManager().up && !getJumping().getFirstElement()) {
            int timeElapsed = getJumping().getSecondElement() ;
            setJumping(new Pair(true,timeElapsed + 1));
            _yPosition -= getSpeed() + timeElapsed;
            System.out.println("time elapsed " + getJumping().getSecondElement() + " postion " + _yPosition);
       
           // System.out.println("speed " + getSpeed() - timeElapsed + " postion " + _yPosition);
        }
        if (getJumping().getFirstElement() && !getFalling().getFirstElement() ) {
            int timeElapsed = getJumping().getSecondElement() ;
            setJumping(new Pair(true,timeElapsed + 1));
            
            if (timeElapsed == 15) {
                _yPosition -= getSpeed();
                
               //setJumping(new Pair(false,0));
                setFalling(new Pair(true,0));
                return;
            } else if (timeElapsed < 15)
                 _yPosition -= getSpeed();
           // speed -= 1;
            System.out.println("time elapsed " + getJumping().getSecondElement()+ " postion " + _yPosition);
        }
        
        
        if (getFalling().getFirstElement()) {
            int timeElapsed = getFalling().getSecondElement() ;
            setFalling(new Pair(true,timeElapsed + 1));
            
            if (timeElapsed == 15) {
                _yPosition += getSpeed();
                
                
                setFalling(new Pair(false,16));
                //setJumping(new Pair(false,0));
                return;
            } else if(timeElapsed < 15)
                _yPosition += getSpeed();
            
           // speed -= 1;
            System.out.println("time elapsed " + getFalling().getSecondElement()+ " postion " + _yPosition);
        }
       /* if (game.getKeyManager().up && fall == 0) {
            double current = _yPosition;
            _yPosition -= 30;
            fall = (current - _yPosition);

        }
        if (!game.getKeyManager().up && fall != 0) {
            for (i = 0; i < fall; i++) {
                _yPosition += 1;
            }

            fall = 0;
        }*/
        if (_game.getKeyManager().left) {
            _xPosition -= 3;
        }
        if (_game.getKeyManager().right) {
            _xPosition += 3;
        }
    }
     
    

    /*public void grab(InteractiveElement e) {
        //da fare quando avremo oggetto
        if (e.type == "weapon" || e.type == "powerup" )
            getPowered();
        else if(e.type == "cfu")
            cfu += e.value ; 
    }*/
    private void getPowered() {

    }

    @Override
    public void attack() {
      /*  AnimationTimer punch = new AnimationTimer() {
            private int start = -1;

            @Override
            public void handle(long now) {
                start++;
                if (start == 0) {
                    setImage(new Image("https://imgur.com/gallery/XFdGg"));
                }
                if (start == 3) {
                    setImage(new Image("https://i.imgur.com/j2K6SvP.png"));
                }
                if (start == 6) {
                    setImage(new Image("https://i.imgur.com/I3IeSSm.jpg"));
                }

                if (start == 9) {
                    setImage(new Image("https://i.imgur.com/I3IeSSm.jpg"));

                    //I have to see who or what I'm trying to punch, even to get if 
                    //there's one and,then, deal the damage
                }
                if (start == 12) {
                    setImage(new Image("https://i.imgur.com/2NEzBZJ.png"));
                    this.stop();
                }
            }
        };

        punch.start();
*/
    }

    @Override
    public void grab() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
