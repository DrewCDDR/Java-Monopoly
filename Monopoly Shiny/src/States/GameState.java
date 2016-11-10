package States;

import Managers.UIManager;
import Visual.Assets;
import java.awt.Color;
import java.awt.Graphics;
import monopoly.shiny.Handler;

public class GameState extends State{
    private boolean oneTime = false, hide = true;
    private int nPlayers;
    private String state;
    private UIManager b;
    
    public GameState(Handler handler) {
        super(handler);
        state = "game";
        b = handler.getGameMouseManager().getUIManager();
        
    }

    @Override
    public void update() {
        b.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.map, 0, 0, 725, 725, null);
        if (!oneTime) {
            handler.setAllObjectsBounds(handler, state, hide);
            oneTime = true;
        }
        b.render(g);
    }
    
    public void setNumberOfPlayers(int n){
        nPlayers = n;
    }
    public int getNumberOfPlayers(){
        return nPlayers;
    }
    
}
