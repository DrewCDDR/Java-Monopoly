package UI;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author cddr
 */
public class UIImageButton extends UIObject{
    
    private Image[] images;
    private ClickListener clicker;
    
    public UIImageButton(float x, float y, int width, int height,
            Image[] images, String state, ClickListener clicker) {
        
        super(x, y, width, height, state);
        this.images = images;
        this.clicker = clicker;
        this.state = state;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics g) {
        if (overIn) {
            g.drawImage(images[1], (int) x, (int) y, width, height, null);
            g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }else{
            g.drawImage(images[0], (int) x, (int) y, width, height, null);
        }
        //g.setColor(Color.cyan);
        //g.drawRect(1, 1, bounds.width, bounds.height);
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
