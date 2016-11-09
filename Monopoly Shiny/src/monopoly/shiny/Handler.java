/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.shiny;

import Managers.MouseManager;
import javax.net.ssl.KeyManager;

/**
 *
 * @author demarchenac
 */
public class Handler {
    
    private Game game;
    
    public Handler(Game game) {
        this.game = game;
    }
    
    public int getGameWidth(){
        return game.getWidth();
    }
    
    public int getGameHeight(){
        return game.getHeight();
    }
    
    public MouseManager getGameMouseManager(){
        return game.getMouseManager();
    }   
}
