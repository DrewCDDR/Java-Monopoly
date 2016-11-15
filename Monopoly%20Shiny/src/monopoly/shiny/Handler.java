/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.shiny;

import Managers.MouseManager;
import UI.UIObject;
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
    
    public Game getGame(){
        return game;
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
    public void setAllObjectsBounds(Handler handler, String state, boolean hide){
        try{
            if(handler.getGameMouseManager().getUIManager() != null){
                if(handler.getGameMouseManager().getUIManager().getObjects() != null){
                    for (UIObject o : handler.getGameMouseManager().getUIManager().getObjects()) {
                        if(o != null){
                            if(o.getState().equals("")){
                                if (hide) {
                                    o.setX(0);
                                    o.setY(0);
                                    o.setWidth(0);
                                    o.setHeight(0);
                                    o.getBounds().x = 0;
                                    o.getBounds().y = 0;
                                    o.getBounds().height = 1;
                                    o.getBounds().width = 1;
                                }else{
                                    o.setX(1);
                                    o.setY(663);
                                    o.setWidth(80);
                                    o.setHeight(60);
                                    o.getBounds().x = (int) o.getX();
                                    o.getBounds().y = (int) o.getY();
                                    o.getBounds().height = o.getHeight();
                                    o.getBounds().width = o.getWidth();
                                }
                            }else if ((!(o.getState().equals(state)))) {
                                o.setX(0);
                                o.setY(0);
                                o.setWidth(0);
                                o.setHeight(0);
                                o.getBounds().x = 0;
                                o.getBounds().y = 0;
                                o.getBounds().height = 1;
                                o.getBounds().width = 1;
                            }

                        }
                    }
                }
            }
        }catch(Exception e){}
    }
}
