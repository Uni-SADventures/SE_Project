package unisadventures.se_project.model.character;

import java.awt.Graphics;
import java.util.Timer;
import unisadventures.se_project.presenter.launcher.Game;
import unisadventures.se_project.util.Pair;
import unisadventures.se_project.view.gfx.Assets;

public class UserCharacter extends BasicCharacter {

    private Game game;

    public UserCharacter(Game game, double x, double y, double h, double w, String name, int healthBar, int strenght, int maxHealth, double maxJump) {
        super(x, y, h, w, name, healthBar, strenght, maxHealth, maxJump);
        this.game = game;
    }
    double fall = 0;
    int i = 0;

    @Override
     public void tick() {
        game.start();
        if(!game.getKeyManager().up && getJumping().getFirstElement() ){
            if(getJumping().getSecondElement() < 16)
               
                setFalling(new Pair(true,16-getJumping().getSecondElement()));
           
            setJumping(new Pair(false,0));
           // setFalling(new Pair(true,16-getJumping().getSecondElement()));
        //    if(getFalling().getSecondElement() == 16)
          //      setFalling(new Pair(false,0));
        }
         if (game.getKeyManager().up && !this.getJumping().getFirstElement()) {
            int timeElapsed = getJumping().getSecondElement() ;
            setJumping(new Pair(true,timeElapsed + 1));
            _yPosition -= this.getSpeed() + timeElapsed;
            System.out.println("time elapsed " + getJumping().getSecondElement() + " postion " + _yPosition);
       
           // System.out.println("speed " + this.getSpeed() - timeElapsed + " postion " + _yPosition);
        }
        if (this.getJumping().getFirstElement() && !this.getFalling().getFirstElement() ) {
            int timeElapsed = getJumping().getSecondElement() ;
            setJumping(new Pair(true,timeElapsed + 1));
            
            if (timeElapsed == 15) {
                _yPosition -= this.getSpeed();
                
               //setJumping(new Pair(false,0));
                setFalling(new Pair(true,0));
                return;
            } else if (timeElapsed < 15)
                 _yPosition -= this.getSpeed();
           // speed -= 1;
            System.out.println("time elapsed " + getJumping().getSecondElement()+ " postion " + _yPosition);
        }
        
        
        if (this.getFalling().getFirstElement()) {
            int timeElapsed = getFalling().getSecondElement() ;
            setFalling(new Pair(true,timeElapsed + 1));
            
            if (timeElapsed == 15) {
                _yPosition += this.getSpeed();
                
                
                setFalling(new Pair(false,16));
                //setJumping(new Pair(false,0));
                return;
            } else if(timeElapsed < 15)
                _yPosition += this.getSpeed();
            
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
        if (game.getKeyManager().left) {
            _xPosition -= 3;
        }
        if (game.getKeyManager().right) {
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
