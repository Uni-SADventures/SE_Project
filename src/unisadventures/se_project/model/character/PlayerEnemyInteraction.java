/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character;

import java.awt.Rectangle;
import java.util.LinkedList;

import unisadventures.se_project.model.World;
import unisadventures.se_project.model.basicObjects.Tile;
import unisadventures.se_project.presenter.states.GameState;
import unisadventures.se_project.presenter.states.State;

/**
 *
 * @author Paolo
 */
public class PlayerEnemyInteraction {

    private Player _player;
    private World _world;
    private LinkedList<BasicEnemy> _enemies;

    public PlayerEnemyInteraction(Player _player, World _world, LinkedList<BasicEnemy> _enemies) {
        this._player = _player;
        this._world = _world;
        this._enemies = _enemies;
    }

    public void tick() {
        //set boolean variables of player
        _enemies.forEach((e) -> e.tick());
        for (BasicEnemy enemy : _enemies) {
            if (horizontalCollision(enemy)) {
                if (leftHorizontalCollision(enemy)) {
                    _player.setLeftcollision(true);
                }
                if (rightHorizontalCollision(enemy)) {
                    _player.setRightcollision(true);
                }
                _player.takeDamage(enemy._strength);
            }
            if (checkVerticalCollision(enemy)) {
                _player.setVerticalcollision(true);
                enemy.setHealthBar(-1);
            }
        }

    }

    public boolean collisionWithTile(int x, int y) {
        return _world.getTile(x, y).isSolid();
    }

    public boolean rightHorizontalCollision(BasicEnemy enemy) {
        if (State.getState() instanceof GameState) {
            int px = _player.getxPosition();
            int py = _player.getyPosition();
            int pw = _player.getWidth();
            int ph = _player.getHeight();
            int ex = enemy.getxPosition();
            int ey = enemy.getyPosition();
            int ew = enemy.getWidth();
            int eh = enemy.getHeight();
            Rectangle rect = new Rectangle(px + pw - _player.getSpeed(), py, _player.getSpeed(), ph);

            if (((ex == px + pw) && ((py + ph <= ey + eh) && (py + ph >= ey))) || rect.intersects(new Rectangle(ex, ey, _player.getSpeed(), eh))) {
                if ((ex + ew - px) > (px - ex)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method check if there is a left horizontal collision between the
     * character and the enemy. A left collision is the collision between the
     * left part of the player and the right part of the enemy
     *
     * @return true if there is a horizontal collision, false otherwise
     */
    public boolean leftHorizontalCollision(BasicEnemy enemy) {
        if (State.getState() instanceof GameState) {

            int px = _player.getxPosition();
            int py = _player.getyPosition();
            int pw = _player.getWidth();
            int ph = _player.getHeight();
            int ex = enemy.getxPosition();
            int ey = enemy.getyPosition();
            int ew = enemy.getWidth();
            int eh = enemy.getHeight();
            Rectangle rect = new Rectangle(px, py, _player.getSpeed(), ph);
            if (((ex + ew) == px && ((py + ph) <= (ey + eh) && (py + ph) >= ey)) || rect.intersects(new Rectangle(ex + ew - _player.getSpeed(), ey, _player.getSpeed(), eh))) {
                if (((px + pw) - (ex + ew)) > (ex + ew - px)) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * This method check if there is a horizontal collision between the
     * character and the enemy.
     *
     * @return true if there is a horizontal collision, false otherwise
     */
    public boolean horizontalCollision(BasicEnemy enemy) {
        return leftHorizontalCollision(enemy) || rightHorizontalCollision(enemy);
    }

    /**
     * This method check if there is a vertical collision between the character
     * and the enemy.
     *
     * @return true if there is a vertical collision, false otherwise
     */
    public boolean checkVerticalCollision(BasicEnemy enemy) {
        if (State.getState() instanceof GameState) {
            int px = _player.getxPosition();
            int py = _player.getyPosition();
            int pw = _player.getWidth();
            int ph = _player.getHeight();
            int ex = enemy.getxPosition();
            int ey = enemy.getyPosition();
            int ew = enemy.getWidth();
            int eh = enemy.getHeight();
            Rectangle rect = new Rectangle(px, py, pw, ph);
            if (ey == (py + ph) && ((px >= ex && px <= ex + ew) || (px + pw >= ex && px + pw <= ex + ew)) || rect.intersects(new Rectangle(ex + 2, ey, ew - 4, 2))) {
                if ((ey + eh - py - ph) > (py + ph - ey)) {
                    return true;
                }
            }

        }
        return false;
    }

    public Player getPlayer() {
        return _player;
    }

    public void setPlayer(Player _player) {
        this._player = _player;
    }

    public World getWorld() {
        return _world;
    }

    public void setWorld(World _world) {
        this._world = _world;
    }

    public LinkedList<BasicEnemy> getEnemies() {
        return _enemies;
    }

    public void setEnemies(LinkedList<BasicEnemy> _enemies) {
        this._enemies = _enemies;
    }

}
