package unisadventures.se_project.model.character;

import unisadventures.se_project.model.WorldObject;
import java.util.*;
import unisadventures.se_project.util.DirectionType;
import unisadventures.se_project.util.Pair;

public abstract class BasicCharacter extends WorldObject implements CharacterInterface {

    private String name;
    private int healthBar;
    private int strenght;
    private int maxHealth;
    private double maxJump;
    private double initJump;
    private double speed;

    //all the sets of sprites
    private Pair<List<String>, List<String>> walk;
    private Pair<List<String>, List<String>> jump;
    private Pair<List<String>, List<String>> fall;
    private Pair<List<String>, List<String>> idle;
    private Pair<List<String>, List<String>> punch;
    private Pair<List<String>, List<String>> beDamaged;

    public BasicCharacter(double x, double y, double h, double w, String name, int healthBar, int strenght, int maxHealth, double maxJump) {
        super(x, y, h, w);
        this.name = name;
        this.healthBar = healthBar;
        this.strenght = strenght;
        this.maxHealth = maxHealth;
        this.maxJump = maxJump;
        this.initJump = -1;
        this.speed = 5;
    }

    public void setBeDamaged(List<String> left, List<String> right) {
        this.beDamaged = new Pair(left, right);
    }

    public void setWalk(List<String> left, List<String> right) {
        this.walk = new Pair(left, right);
    }

    public void setIdle(List<String> left, List<String> right) {
        this.idle = new Pair(left, right);
    }

    public void setPunch(List<String> left, List<String> right) {
        this.punch = new Pair(left, right);
    }

    public void setJump(List<String> left, List<String> right) {
        this.jump = new Pair(left, right);
    }

    public void setFall(List<String> left, List<String> right) {
        this.fall = new Pair(left, right);
    }

    public List<String> getBeDamagedSprites(DirectionType d) {
        if (d == DirectionType.LEFT) {
            return beDamaged.getFirstElement();
        } else if (d == DirectionType.RIGHT) {
            return beDamaged.getSecondElement();
        } else {
            return null;
        }
    }

    public List<String> getIdleSprites(DirectionType d) {
        if (d == DirectionType.LEFT) {
            return idle.getFirstElement();
        } else if (d == DirectionType.RIGHT) {
            return idle.getSecondElement();
        } else {
            return null;
        }
    }

    public List<String> getJumpSprites(DirectionType d) {
        if (d == DirectionType.LEFT) {
            return jump.getFirstElement();
        } else if (d == DirectionType.RIGHT) {
            return jump.getSecondElement();
        } else {
            return null;
        }
    }

    public List<String> getFallSprites(DirectionType d) {
        if (d == DirectionType.LEFT) {
            return fall.getFirstElement();
        } else if (d == DirectionType.RIGHT) {
            return fall.getSecondElement();
        } else {
            return null;
        }
    }

    public List<String> getPunchSprites(DirectionType d) {
        if (d == DirectionType.LEFT) {
            return punch.getFirstElement();
        } else if (d == DirectionType.RIGHT) {
            return punch.getSecondElement();
        } else {
            return null;
        }
    }

    public List<String> getWalkSprites(DirectionType d) {
        if (d == DirectionType.LEFT) {
            return walk.getFirstElement();
        } else if (d == DirectionType.RIGHT) {
            return walk.getSecondElement();
        } else {
            return null;
        }
    }

    public double getMaxJump() {
        return maxJump;
    }

    public void setMaxJump(double maxJump) {
        this.maxJump = maxJump;
    }

    public double getInitJump() {
        return initJump;
    }

    public void setInitJump(double initJump) {
        this.initJump = initJump;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthBar() {
        return healthBar;
    }

    public void setHealthBar(int healthBar) {
        this.healthBar = healthBar;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public void move(double W, DirectionType d) {
    /*    final double charCenterX = this.getBoundsInLocal().getWidth() / 2;
        final double charCenterY = this.getBoundsInLocal().getHeight() / 2;

        double absolX = charCenterX + this.getLayoutX();
        double absolY = charCenterY + this.getLayoutY();

        if (d == DirectionType.LEFT) {
            absolX -= speed;
        } else if (d == DirectionType.RIGHT) {
            absolX += speed;
        }

        if (absolX - charCenterX >= 0
                && absolX + charCenterX <= W) {
            this.relocate(absolX - charCenterX, absolY - charCenterY);
        }*/
    }

    @Override
    public boolean jump(double H) {
/*
        final double charCenterX = getBoundsInLocal().getWidth() / 2;
        final double charCenterY = getBoundsInLocal().getHeight() / 2;

        double absolX = charCenterX + getLayoutX();
        double absolY = charCenterY + getLayoutY() - 10;
        if (this.initJump == -1) {
            this.initJump = H - absolY;
        }

        if (absolY - charCenterY >= 0
                && absolY + charCenterY <= H
                && (H - absolY) - initJump < maxJump) {

            relocate(absolX - charCenterX, absolY - charCenterY);
            return true;
        }
*/
        return false;
    }

    @Override
    public void takeDamage(int dam) {
        if (this.healthBar > dam) {
            this.healthBar -= dam;
        } else {
            die();
        }
    }

    public void die() {
        //when health goes to 0 we have to manage how to put away a life when we have a menu
    }

    @Override
    public boolean fall(double H) {
/*
        double charCenterX = getBoundsInLocal().getWidth() / 2;
        double charCenterY = getBoundsInLocal().getHeight() / 2;

        double absolX = charCenterX + getLayoutX();
        double absolY = charCenterY + getLayoutY() + 10;

        if (absolY + charCenterY <= H - 100) {

            relocate(absolX - charCenterX, absolY - charCenterY);
            return true;
        } else {
            initJump = -1;
            return false;
        }
*/
    return false ;
    }

}
