/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.model.character.Player;
import unisadventures.se_project.presenter.input.KeyManager;
import unisadventures.se_project.util.DirectionType;

/**
 *
 * @author Paolo
 */
public class KeyboardInput {

    private KeyManager _keyManager;
    private BasicCommand _command;

    public KeyboardInput(KeyManager keyManager) {
        _keyManager = keyManager;
    }

    public KeyManager getKeyManager() {
        return _keyManager;
    }

    public void setKeyManager(KeyManager _keyManager) {
        this._keyManager = _keyManager;
    }

    public Command getCommand() {
        return _command;
    }

    public void setCommand(BasicCommand _command) {
        this._command = _command;
    }

    /**
     * This method interprets user inputs if the character is user's one and if
     * not it checks what should a character do, for example if there is a floor
     * under their feet
     */
    /*public void stick() {

        //_handler.getCam().centerOnEntity((PlayerCharacter)_ch);
        if (_ch instanceof PlayerCharacter) {
            if (!_jumping) {
                fall();
            }
            _handler.getCam().centerOnEntity((PlayerCharacter) _ch);
            if (_handler.getKeyManager().left) {

                moveLeft();
                _ch.setFacing(DirectionType.LEFT);
            } else if (_handler.getKeyManager().right) {
                moveRight();
                _ch.setFacing(DirectionType.RIGHT);
            } else {
                _walking = false;
            }

            if (_handler.getKeyManager().up && !_falling) {
                jump();
            } else if (!_handler.getKeyManager().up) {
                _jumping = false;
            }
            //   else if(!_hanlder.checkFloor(_ch.getPosition().getFirstElement(),_ch.getPosition().getSecondElement()))
            //    _jumpFall.fall();

            if (_handler.getKeyManager().hit) {
                attack();
            } else {
                _hitting = false;
            }
            grab();
        } else {
            if (!_jumping) {
                fall();
            }

        }

        if (!_walking && !_jumping && !_falling && !_hitting && !_beingDamaged) {
            idle();
        }

        if (_beingDamaged) {
            _beingDamaged = _beDamaged.takeDamage(_incomingDamage);
            if (_beingDamaged) {
                if (_ch.getFacing().LEFT == DirectionType.LEFT) {
                    _movement.moveRight();
                } else {
                    _movement.moveLeft();
                }
            } else {
                _incomingDamage = 0;
            }
        }

        //CHECKING IF THERE IS SOME COLLECTIBLE
    }
*/
    public void tick(MovementCommand move, VerticalCommand2 vertical, HitCommand2 hit, GrabCommand grab, IdleCommand idle) {
        _command = move;
        if (_keyManager.isLeft()) {
            _command.execute(DirectionType.LEFT);
            
        } else if (_keyManager.isRight()) {
            _command.execute(DirectionType.RIGHT);
        } else {
            _command.execute(DirectionType.IDLE);
        }
        _command = vertical;
        if (_keyManager.isUp()) {
            _command.execute(DirectionType.JUMP);
        } else {
            _command.execute(DirectionType.FALL);
        }
        _command = hit;
        if (_keyManager.isHit()) {
            _command.execute(DirectionType.HIT);
        }
        grab.execute(DirectionType.GRAB);
        idle.execute(DirectionType.IDLE);
        
    }

}
