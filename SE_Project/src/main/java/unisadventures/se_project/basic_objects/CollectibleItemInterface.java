/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.basic_objects;

import  unisadventures.se_project.WorldObjectInterface;
import  unisadventures.se_project.util.CollectibleType;
/**
 *
 * @author arno
 */
public interface CollectibleItemInterface extends WorldObjectInterface {
    
    public String getNextImageFileName();
    public CollectibleType getCollectibleType();
   
    
}
