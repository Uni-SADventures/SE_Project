/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.factory;

import java.util.LinkedList;
import java.util.List;
import unisadventures.se_project.model.basicObjects.CollectibleItem;
import unisadventures.se_project.util.CollectibleType;
import unisadventures.se_project.view.gfx.Assets;

/**
 *
 * @author Emilio
 */
public class CollectiblesCreator extends Creator{
    
    LinkedList<Integer> cfu ;
    LinkedList<Integer>coffee ;
    LinkedList<Integer>jetpack ;
    LinkedList<Integer>heart ;
    //IT CAN BE EXPANDED IF WE WANT MORE AND MORE COLLECTIBLES
    public CollectiblesCreator() {
        //COLLECTIBLES
            Assets.storeImage("resources/images/objectstilesheet.png",160,0,32,32);
            int nowSeq = Assets.getActualSequenceNumber() ;
            List<Integer> temp = new LinkedList<>();
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq);  
            Assets.storeImage("resources/images/objectstilesheet.png",96,0,32,32);
            nowSeq = Assets.getActualSequenceNumber() ;
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq); 
            
            cfu = (LinkedList<Integer>) temp ;
                
            Assets.storeImage("resources/images/coffee.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            temp = new LinkedList<>();
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq);  
            Assets.storeImage("resources/images/coffee.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq); 
            
            coffee = (LinkedList<Integer>) temp ;
            
            Assets.storeImage("resources/images/jetpack.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            temp = new LinkedList<>();
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq);  
            Assets.storeImage("resources/images/jetpack.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq); 
            
            jetpack = (LinkedList<Integer>) temp ;
            
            Assets.storeImage("resources/images/heart.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            temp = new LinkedList<>();
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq);  
            Assets.storeImage("resources/images/heart.png");
            nowSeq = Assets.getActualSequenceNumber() ;
            for(int i = 0; i <= 15 ; i++ )
                temp.add(nowSeq); 
            
            heart = (LinkedList<Integer>) temp ;
               
            
    
    }

    @Override
    public Object createElement(String whichOne, int x, int y) {
        if(whichOne.equals(CollectibleType.CFU.toString())){
            CollectibleItem product = new CollectibleItem(x,y, 32, 32, CollectibleType.CFU);
            product.setImageFileNameList(cfu);
            return (Object) product ;
        }
        else if(whichOne.equals(CollectibleType.COFFEE.toString())){
            CollectibleItem product = new CollectibleItem(x,y, 32, 32, CollectibleType.COFFEE);
            product.setImageFileNameList(coffee);
            return (Object) product ;
        }
        else if(whichOne.equals(CollectibleType.JETPACK.toString())){
            CollectibleItem product = new CollectibleItem(x,y, 32, 32, CollectibleType.JETPACK);
            product.setImageFileNameList(jetpack);
            return (Object) product ;
        }
        else if(whichOne.equals(CollectibleType.HEART.toString())){
            CollectibleItem product = new CollectibleItem(x,y, 32, 32, CollectibleType.HEART);
            product.setImageFileNameList(heart);
            return (Object) product ;
        }
        return null ;
    }
    
    public CollectibleItem createCfuCollectible(int x, int y){
        return (CollectibleItem) createElement(CollectibleType.CFU.toString(),x,y) ;
    }
    
     public CollectibleItem createCoffeeCollectible(int x, int y){
        return (CollectibleItem) createElement(CollectibleType.COFFEE.toString(),x,y) ;
    }
    public CollectibleItem createJetpackCollectible(int x, int y){
        return (CollectibleItem) createElement(CollectibleType.JETPACK.toString(),x,y) ;
    }
    public CollectibleItem createHeartCollectible(int x, int y){
        return (CollectibleItem) createElement(CollectibleType.HEART.toString(),x,y) ;
    }
    
}
