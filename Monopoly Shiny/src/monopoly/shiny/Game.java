package monopoly.shiny;

import Managers.MouseManager;
import States.GameState;
import States.MenuState;
import States.State;
import Visual.Window;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author demarchenac
 */
public class Game implements Runnable{
    private boolean running = false;
    private int width, height;
    private String title;
    private Window display;
    //Thread
    private Thread thread;
    //Visible
    private BufferStrategy bs;
    private Graphics g;
    //States
    public State menuState;
    public State gameState;
    //Managers
    private MouseManager mouseManager;
    //THE GOD BLESSED HANDLER.
    private Handler handler;
    
    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
    }
    
    
    @Override
    public void run() {
        init();
        
        int fps = 60, updates = 0;
        long now, timer = 0, lastTime = System.nanoTime();
        double delta = 0, timePerUpdate = 1000000000/fps;
        
        while(running){
            now = System.nanoTime();
            delta += (now-lastTime)/timePerUpdate;
            timer += now - lastTime;
            lastTime = now;
            
            if (delta >= 1) {
                update();
                render();
                updates++;
                delta--;
            }
            if (timer >= 1000000000) {
                //System.out.println("Updates and Frames: " + updates);
                updates = 0;
                timer = 0;
            }    
        }
        stop();
    }
    
    private void init(){
        display = new Window(title,width,height);
        handler = new Handler(this);
        
        menuState = new MenuState(handler);
        gameState = new GameState(handler);
        State.setState(menuState);
    }
    public synchronized void start(){
        if(running)return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running)return;
        running = false;
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    private void update(){
        /*
         keyManager.update();
        
        if (State.getState() != null) {
            State.getState().update();
        }
        */
    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
           display.getCanvas().createBufferStrategy(3);
           return;
        }
        g = bs.getDrawGraphics();
        //clear window
        g.clearRect(0, 0, width, height);
        //start STATE drawing 
        /*if (State.getState() != null) {
            State.getState().render(g);
        }*/ 
        //end STATE drawing
        bs.show();
        g.dispose();
    }
    
    public MouseManager getMouseManager(){
        return mouseManager;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
}
