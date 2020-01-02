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
                // _collectibles.get(i).setImageFileNameList(temp);
            
    
    }

    @Override
    public Object createElement(String whichOne, int x, int y) {
        if(whichOne.equals(CollectibleType.CFU.toString())){
            CollectibleItem product = new CollectibleItem(x,y, 32, 32, CollectibleType.CFU);
            product.setImageFileNameList(cfu);
            return (Object) product ;
        }
        return null ;
    }
    
    public CollectibleItem createCfuCollectible(int x, int y){
        return (CollectibleItem) createElement(CollectibleType.CFU.toString(),x,y) ;
    }
    
}
