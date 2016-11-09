package States;

import Visual.Assets;
import java.awt.Graphics;
import monopoly.shiny.Handler;

public class MenuState extends State{

    public MenuState(Handler handler) {
        super(handler);
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.menu, 0, 0, handler.getGameWidth(), handler.getGameHeight(), null);
    }
    
}
