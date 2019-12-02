/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.Model.character;

/**
 *
 * @author Emilio
 */
public class bootlegConcreteStageElement {
    private int posX ;
    private int posY ;
    private int dimX ;
    private int dimY ;

    public bootlegConcreteStageElement(int posX, int posY, int dimX, int dimY) {
        this.posX = posX;
        this.posY = posY;
        this.dimX = dimX;
        this.dimY = dimY;
    }
    
    private int[] getPosition(){
        int a[] = new int[2] ;
        a[0] = this.posX ;
        a[1] = this.posY ;
        
        return a ;
    }
    
    private void setPosition(int posX,int posY){
        if(posX != -1 )
            this.posX = posX ;
        if(posY != -1 )
            this.posY = posY ;
        
    }
    
    private int[] getDimension(){
        int a[] = new int[2] ;
        a[0] = this.dimX ;
        a[1] = this.dimY ;
        
        return a ;
    }
}
