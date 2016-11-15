package Managers;

import UI.UIObject;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import monopoly.shiny.Handler;

/**
 *
 * @author cddr
 */
public class UIManager {
    
    private Handler handler;
    private ArrayList<UIObject> objects;

    public UIManager(Handler handler) {
        this.handler = handler;
        objects = new ArrayList <UIObject>();
    }
    
    
    public void update(){
        for (UIObject o : objects) {
            o.update();
        }
    }
    
    public void render(Graphics g){
        try{
            for (UIObject o : objects) {
                o.render(g);
            }
        }catch(Exception e){}
    }
    
    public void onMouseMove(MouseEvent e){
        int l = objects.size();
        for (int i = 0; i < l; i++) {
            objects.get(i).onMouseMove(e);
        }  
    }
    
    public void onMouseRelease(MouseEvent e){
        try{    
            for (UIObject o : objects) {
                o.onMouseRelease(e);
            }
        }catch(Exception z){}
    }
    
    public void addObject(UIObject o){
        objects.add(o);
    }
    
    public void removeObject(UIObject o){
        objects.remove(o);
    }
    
    public void remove(int i){
        objects.remove(i);
    }
    
    public void removeAll(){
        int l = objects.size() -1;
        for (int i = 0; i < l; i++) {
            objects.remove(0);
        }
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }
}
