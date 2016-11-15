package UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 *
 * @author cddr
 */
public abstract class UIObject {
    
    protected boolean overIn = false;
    protected int width, height;
    protected float x, y;
    protected Rectangle bounds;
    protected String state;

    public UIObject(float x, float y, int width, int height, String state) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.state = state;
        bounds = new Rectangle((int) x, (int) y, width, height);
    }
    
    public abstract void update();
    public abstract void render(Graphics g);
    public abstract void onClick();
    
    public void onMouseMove(MouseEvent e){
        if (bounds.contains(e.getX(), e.getY())) {
            overIn = true;
        }else{
            overIn = false;
        }
    }
    
    public void onMouseRelease(MouseEvent e){
        if (overIn) {
            onClick();
        }
    }
    
    //GETTERS n' SETTERS:
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isOverIn() {
        return overIn;
    }

    public void setOverIn(boolean overIn) {
        this.overIn = overIn;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
}
