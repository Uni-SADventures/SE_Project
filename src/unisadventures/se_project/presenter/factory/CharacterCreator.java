/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.factory;

import java.util.LinkedList;
import java.util.List;
import unisadventures.se_project.model.character.EnemyCharacter;
import unisadventures.se_project.model.character.PlayerCharacter;
import unisadventures.se_project.model.character.ZombieEnemy;
import unisadventures.se_project.presenter.factory.Creator;
import unisadventures.se_project.presenter.launcher.Handler;
import unisadventures.se_project.util.CharacterType;
import unisadventures.se_project.view.gfx.Assets;

/**
 *
 * @author Emilio
 */
public class CharacterCreator extends Creator{
    private LinkedList<Integer> playerIdleR, playerFallR,playerJumpR,playerPunchR,playerBeDamagedR,playerWalkR;
    private LinkedList<Integer> shapeIdleR, shapeFallR,shapeJumpR,shapePunchR,shapeBeDamagedR,shapeWalkR;
    private LinkedList<Integer> windIdleR, windFallR,windJumpR,windPunchR,windBeDamagedR,windWalkR;
    private LinkedList<Integer> refoundIdleR, refoundFallR,refoundJumpR,refoundPunchR,refoundBeDamagedR,refoundWalkR;
    
    
    private LinkedList<Integer> playerIdleL, playerFallL,playerJumpL,playerPunchL,playerBeDamagedL,playerWalkL;
    private LinkedList<Integer> shapeIdleL, shapeFallL,shapeJumpL,shapePunchL,shapeBeDamagedL,shapeWalkL;
    private LinkedList<Integer> windIdleL, windFallL,windJumpL,windPunchL,windBeDamagedL,windWalkL;
    private LinkedList<Integer> refoundIdleL, refoundFallL,refoundJumpL,refoundPunchL,refoundBeDamagedL,refoundWalkL;
    
    private Handler _handler ;
    
    public CharacterCreator(Handler handler){
            _handler = handler ;
        //PLAYER CHARACTER
            List temp = new LinkedList<Integer>() ;
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
           
            playerIdleL = (LinkedList<Integer>) temp;
            playerIdleR = (LinkedList<Integer>) temp;
            
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
            
            playerWalkL = (LinkedList<Integer>) temp2 ;
            playerWalkR = (LinkedList<Integer>) temp;
            playerFallL = (LinkedList<Integer>) temp2 ;
            playerFallR = (LinkedList<Integer>) temp;        
            playerJumpL = (LinkedList<Integer>) temp2 ;
            playerJumpR = (LinkedList<Integer>) temp;
            
           temp = new LinkedList<>() ;
            Assets.storeImage("resources/images/player_punch.png",48,36,16,28);
            nowSeq = Assets.getActualSequenceNumber() ;
           
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq);  
            
            Assets.storeImage("resources/images/character_sprite.png",48,4,16,28);
            nowSeq = Assets.getActualSequenceNumber() ;
            
            for(int i = 0; i <= 40 ; i++ )
                temp.add(nowSeq);  
            
            temp2 = new LinkedList<>() ;
            Assets.storeImage("resources/images/player_punch.png",0,36,16,28);
            nowSeq = Assets.getActualSequenceNumber() ;
           
            for(int i = 0; i <= 15 ; i++ )
                temp2.add(nowSeq);  
            
            Assets.storeImage("resources/images/character_sprite.png",0,36,16,28);
            nowSeq = Assets.getActualSequenceNumber() ;
            
            for(int i = 0; i <= 40 ; i++ )
                temp2.add(nowSeq);
 
            playerPunchL = (LinkedList<Integer>) temp2 ;
            playerPunchR = (LinkedList<Integer>) temp;
            
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
            
            playerBeDamagedL = (LinkedList<Integer>) temp2 ;
            playerBeDamagedR = (LinkedList<Integer>) temp;
           
            
            
       // "resources/images/enemy_Wind.png","resources/images/enemy_Shape.png"
            temp = new LinkedList<>() ;
            Assets.storeImage("resources/images/enemy_Refound.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            temp.add(nowSeq) ;
            refoundIdleR = (LinkedList<Integer>) temp;
            refoundFallR= (LinkedList<Integer>) temp;
            refoundJumpR= (LinkedList<Integer>) temp;
            refoundPunchR= (LinkedList<Integer>) temp;
            refoundBeDamagedR= (LinkedList<Integer>) temp;
            refoundWalkR= (LinkedList<Integer>) temp;
            refoundIdleL= (LinkedList<Integer>) temp;
            refoundFallL= (LinkedList<Integer>) temp;
            refoundJumpL= (LinkedList<Integer>) temp;
            refoundPunchL= (LinkedList<Integer>) temp;
            refoundBeDamagedL= (LinkedList<Integer>) temp;
            refoundWalkL= (LinkedList<Integer>) temp;
            
            temp = new LinkedList<>() ;
            Assets.storeImage("resources/images/enemy_Wind.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            temp.add(nowSeq) ;
            windIdleR = (LinkedList<Integer>) temp;
            windFallR= (LinkedList<Integer>) temp;
            windJumpR= (LinkedList<Integer>) temp;
            windPunchR= (LinkedList<Integer>) temp;
            windBeDamagedR= (LinkedList<Integer>) temp;
            windWalkR = (LinkedList<Integer>) temp;
            windIdleL= (LinkedList<Integer>) temp;
            windFallL= (LinkedList<Integer>) temp;
            windJumpL= (LinkedList<Integer>) temp;
            windPunchL= (LinkedList<Integer>) temp;
            windBeDamagedL= (LinkedList<Integer>) temp;
            windWalkL= (LinkedList<Integer>) temp;
              
            temp = new LinkedList<>() ;
            Assets.storeImage("resources/images/enemy_Shape.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            temp.add(nowSeq) ;
            shapeIdleR = (LinkedList<Integer>) temp;
            shapeFallR= (LinkedList<Integer>) temp;
            shapeJumpR= (LinkedList<Integer>) temp;
            shapePunchR= (LinkedList<Integer>) temp;
            shapeBeDamagedR= (LinkedList<Integer>) temp;
            shapeWalkR = (LinkedList<Integer>) temp;
            shapeIdleL= (LinkedList<Integer>) temp;
            shapeFallL= (LinkedList<Integer>) temp;
            shapeJumpL= (LinkedList<Integer>) temp;
            shapePunchL= (LinkedList<Integer>) temp;
            shapeBeDamagedL= (LinkedList<Integer>) temp;
            shapeWalkL= (LinkedList<Integer>) temp;
            
            
            
    }
    
    @Override
    public Object createElement(String whichOne,int x, int y) {
        if(whichOne.equals(CharacterType.SHAPE.toString())){
            ZombieEnemy product = new ZombieEnemy(_handler,x ,y, 64, 64, CharacterType.SHAPE, 6, 1, 6, 300) ;
            product.setIdle(shapeIdleL, shapeIdleR);
            product.setFall(shapeFallL, shapeFallR);
            product.setJump(shapeJumpL, shapeJumpR);
            product.setPunch(shapePunchL,shapePunchR);
            product.setWalk(shapeWalkL, shapeWalkR);
            product.setBeDamaged(shapeBeDamagedR, shapeBeDamagedR);
            return product ;
        } else if(whichOne.equals(CharacterType.REFOUND.toString())){
            ZombieEnemy product = new ZombieEnemy(_handler,x ,y, 64, 64, CharacterType.REFOUND, 6, 1, 6, 300) ;
            product.setIdle(refoundIdleL, refoundIdleR);
            product.setFall(refoundFallL, refoundFallR);
            product.setJump(refoundJumpL, refoundJumpR);
            product.setPunch(refoundPunchL,refoundPunchR);
            product.setWalk(refoundWalkL, refoundWalkR);
            product.setBeDamaged(refoundBeDamagedR, refoundBeDamagedR);
            return product ;
        } else if(whichOne.equals(CharacterType.WIND.toString())){
            ZombieEnemy product = new ZombieEnemy(_handler,x ,y, 64, 64, CharacterType.WIND, 6, 1, 6, 300) ;
            product.setIdle(windIdleL, windIdleR);
            product.setFall(windFallL, windFallR);
            product.setJump(windJumpL, windJumpR);
            product.setPunch(windPunchL,windPunchR);
            product.setWalk(windWalkL, windWalkR);
            product.setBeDamaged(windBeDamagedR, windBeDamagedR);
            return product ;
        } else if(whichOne.equals(CharacterType.USER.toString())){
            PlayerCharacter product = new PlayerCharacter(_handler, x,y, 64, 64, CharacterType.USER, 6, 300, 6, 170, "user");
            product.setIdle(playerIdleL, playerIdleR);
            product.setFall(playerFallL, playerFallR);
            product.setJump(playerJumpL, playerJumpR);
            product.setPunch(playerPunchL,playerPunchR);
            product.setWalk(playerWalkL, playerWalkR);
            product.setBeDamaged(playerBeDamagedR, playerBeDamagedR);
            return product ;
        }
        
        return null ;
    }
    
    public ZombieEnemy createShapeEnemy(int x, int y){
        return (ZombieEnemy) createElement(CharacterType.SHAPE.toString(), x, y) ;
    }
    public ZombieEnemy createWindEnemy(int x, int y){
        return (ZombieEnemy) createElement(CharacterType.WIND.toString(), x, y) ;
    }
    public ZombieEnemy createRefoundEnemy(int x, int y){
        return (ZombieEnemy) createElement(CharacterType.REFOUND.toString(), x, y) ;
    }
    public PlayerCharacter createPlayerCharacter(int x, int y){
        return (PlayerCharacter) createElement(CharacterType.USER.toString(), x, y) ;
    }
    
    public ZombieEnemy createRandomPr(int x, int y){
        int rand = (int) (Math.random() * 3) ;
            if(rand == 0)
                return createWindEnemy(x, y);
            else if(rand == 1)
                return createRefoundEnemy(x, y);
            else if(rand == 2)
                return createRefoundEnemy(x, y);
            return null ;
            
    }

    public void setPlayerIdleR(LinkedList<Integer> playerIdleR) {
        this.playerIdleR = playerIdleR;
    }

    public void setPlayerFallR(LinkedList<Integer> playerFallR) {
        this.playerFallR = playerFallR;
    }

    public void setPlayerJumpR(LinkedList<Integer> playerJumpR) {
        this.playerJumpR = playerJumpR;
    }

    public void setPlayerPunchR(LinkedList<Integer> playerPunchR) {
        this.playerPunchR = playerPunchR;
    }

    public void setPlayerBeDamagedR(LinkedList<Integer> playerBeDamagedR) {
        this.playerBeDamagedR = playerBeDamagedR;
    }

    public void setPlayerWalkR(LinkedList<Integer> playerWalkR) {
        this.playerWalkR = playerWalkR;
    }

    public void setShapeIdleR(LinkedList<Integer> shapeIdleR) {
        this.shapeIdleR = shapeIdleR;
    }

    public void setShapeFallR(LinkedList<Integer> shapeFallR) {
        this.shapeFallR = shapeFallR;
    }

    public void setShapeJumpR(LinkedList<Integer> shapeJumpR) {
        this.shapeJumpR = shapeJumpR;
    }

    public void setShapePunchR(LinkedList<Integer> shapePunchR) {
        this.shapePunchR = shapePunchR;
    }

    public void setShapeBeDamagedR(LinkedList<Integer> shapeBeDamagedR) {
        this.shapeBeDamagedR = shapeBeDamagedR;
    }

    public void setShapeWalkR(LinkedList<Integer> shapeWalkR) {
        this.shapeWalkR = shapeWalkR;
    }

    public void setWindIdleR(LinkedList<Integer> windIdleR) {
        this.windIdleR = windIdleR;
    }

    public void setWindFallR(LinkedList<Integer> windFallR) {
        this.windFallR = windFallR;
    }

    public void setWindJumpR(LinkedList<Integer> windJumpR) {
        this.windJumpR = windJumpR;
    }

    public void setWindPunchR(LinkedList<Integer> windPunchR) {
        this.windPunchR = windPunchR;
    }

    public void setWindBeDamagedR(LinkedList<Integer> windBeDamagedR) {
        this.windBeDamagedR = windBeDamagedR;
    }

    public void setWindWalkR(LinkedList<Integer> windWalkR) {
        this.windWalkR = windWalkR;
    }

    public void setRefoundIdleR(LinkedList<Integer> refoundIdleR) {
        this.refoundIdleR = refoundIdleR;
    }

    public void setRefoundFallR(LinkedList<Integer> refoundFallR) {
        this.refoundFallR = refoundFallR;
    }

    public void setRefoundJumpR(LinkedList<Integer> refoundJumpR) {
        this.refoundJumpR = refoundJumpR;
    }

    public void setRefoundPunchR(LinkedList<Integer> refoundPunchR) {
        this.refoundPunchR = refoundPunchR;
    }

    public void setRefoundBeDamagedR(LinkedList<Integer> refoundBeDamagedR) {
        this.refoundBeDamagedR = refoundBeDamagedR;
    }

    public void setRefoundWalkR(LinkedList<Integer> refoundWalkR) {
        this.refoundWalkR = refoundWalkR;
    }

    public void setPlayerIdleL(LinkedList<Integer> playerIdleL) {
        this.playerIdleL = playerIdleL;
    }

    public void setPlayerFallL(LinkedList<Integer> playerFallL) {
        this.playerFallL = playerFallL;
    }

    public void setPlayerJumpL(LinkedList<Integer> playerJumpL) {
        this.playerJumpL = playerJumpL;
    }

    public void setPlayerPunchL(LinkedList<Integer> playerPunchL) {
        this.playerPunchL = playerPunchL;
    }

    public void setPlayerBeDamagedL(LinkedList<Integer> playerBeDamagedL) {
        this.playerBeDamagedL = playerBeDamagedL;
    }

    public void setPlayerWalkL(LinkedList<Integer> playerWalkL) {
        this.playerWalkL = playerWalkL;
    }

    public void setShapeIdleL(LinkedList<Integer> shapeIdleL) {
        this.shapeIdleL = shapeIdleL;
    }

    public void setShapeFallL(LinkedList<Integer> shapeFallL) {
        this.shapeFallL = shapeFallL;
    }

    public void setShapeJumpL(LinkedList<Integer> shapeJumpL) {
        this.shapeJumpL = shapeJumpL;
    }

    public void setShapePunchL(LinkedList<Integer> shapePunchL) {
        this.shapePunchL = shapePunchL;
    }

    public void setShapeBeDamagedL(LinkedList<Integer> shapeBeDamagedL) {
        this.shapeBeDamagedL = shapeBeDamagedL;
    }

    public void setShapeWalkL(LinkedList<Integer> shapeWalkL) {
        this.shapeWalkL = shapeWalkL;
    }

    public void setWindIdleL(LinkedList<Integer> windIdleL) {
        this.windIdleL = windIdleL;
    }

    public void setWindFallL(LinkedList<Integer> windFallL) {
        this.windFallL = windFallL;
    }

    public void setWindJumpL(LinkedList<Integer> windJumpL) {
        this.windJumpL = windJumpL;
    }

    public void setWindPunchL(LinkedList<Integer> windPunchL) {
        this.windPunchL = windPunchL;
    }

    public void setWindBeDamagedL(LinkedList<Integer> windBeDamagedL) {
        this.windBeDamagedL = windBeDamagedL;
    }

    public void setWindWalkL(LinkedList<Integer> windWalkL) {
        this.windWalkL = windWalkL;
    }

    public void setRefoundIdleL(LinkedList<Integer> refoundIdleL) {
        this.refoundIdleL = refoundIdleL;
    }

    public void setRefoundFallL(LinkedList<Integer> refoundFallL) {
        this.refoundFallL = refoundFallL;
    }

    public void setRefoundJumpL(LinkedList<Integer> refoundJumpL) {
        this.refoundJumpL = refoundJumpL;
    }

    public void setRefoundPunchL(LinkedList<Integer> refoundPunchL) {
        this.refoundPunchL = refoundPunchL;
    }

    public void setRefoundBeDamagedL(LinkedList<Integer> refoundBeDamagedL) {
        this.refoundBeDamagedL = refoundBeDamagedL;
    }

    public void setRefoundWalkL(LinkedList<Integer> refoundWalkL) {
        this.refoundWalkL = refoundWalkL;
    }
    
    
}
