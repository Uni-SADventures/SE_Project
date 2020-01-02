/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.presenter.factory;

import unisadventures.se_project.presenter.launcher.Handler;

/**
 *
 * @author Emilio
 */
public abstract class Creator {
    
    public abstract Object createElement(String whichOne,int x, int y) ;
    
}
