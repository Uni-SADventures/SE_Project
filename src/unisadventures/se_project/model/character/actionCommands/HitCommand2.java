/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.model.character.actionCommands;

import unisadventures.se_project.util.DirectionType;
import static unisadventures.se_project.util.DirectionType.*;

/**
 *
 * @author Paolo
 */
public class HitCommand2 extends BasicCommand{

    public HitCommand2(){
        super();
    }
    
    @Override
    public void execute(DirectionType type) {
        switch (type){
            case HIT:
                _player.attack(_count);
        }
    }
    
}
