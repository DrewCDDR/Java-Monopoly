//AGERGAR UN PTR DE LOS JUGADORES Y PONERLO ANTES DE LA FUNCION SORT!!!
package States;

import Managers.UIManager;
import Nodes.PlayerNode;
import UI.ClickListener;
import UI.UIImageButton;
import Visual.Assets;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import monopoly.shiny.Handler;

public class MenuState extends State{
    private boolean oneTime, hide, throwed;
    private int d1, d2, d3, d4, d5, d6;
    private int[] d; 
    private String state = "menu", pState = "";
    private UIManager a;
            
    public MenuState(Handler handler) {
        super(handler);
        oneTime = false;
        hide = true; 
        throwed = false;
        d = new int[6];
        //state = "menu";
        //pState = "";
        a = new UIManager(handler);
        handler.getGameMouseManager().setUIManager(a);
        addButtons();
    }
    
    public void addNumbers(){
        a.addObject(new UIImageButton(20, 356, 150, 150, Assets.two, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getGame().getGameState().setNumberOfPlayers(2);
                        pState = state;
                        state = "decideOrder";
                        oneTime = false;
                        a.removeAll();
                        addRoll(2);
                    }
                    
                }));
        a.addObject(new UIImageButton(212, 356, 150, 150, Assets.three, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getGame().getGameState().setNumberOfPlayers(3);
                        pState = state;
                        state = "decideOrder";
                        oneTime = false;
                        a.removeAll();
                        addRoll(3);
                    }
                    
                }));
        a.addObject(new UIImageButton(404, 356, 150, 150, Assets.four, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getGame().getGameState().setNumberOfPlayers(4);
                        pState = state;
                        state = "decideOrder";
                        oneTime = false;
                        a.removeAll();
                        addRoll(4);
                    }
                    
                }));
        a.addObject(new UIImageButton(596, 356, 150, 150,
                Assets.five, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getGame().getGameState().setNumberOfPlayers(5);
                        pState = state;
                        state = "decideOrder";
                        oneTime = false;
                        a.removeAll();
                        addRoll(5);
                    }
                    
                }));
        a.addObject(new UIImageButton(788, 356, 150, 150,
                Assets.six, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getGame().getGameState().setNumberOfPlayers(6);
                        pState = state;
                        state = "decideOrder";
                        oneTime = false;
                        a.removeAll();
                        addRoll(6);
                    }
                    
                }));
        a.addObject(new UIImageButton(1, handler.getGameHeight() -62, 80, 60,
                Assets.back, "", 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        
                        state = "menu";
                        if(state.equals("menu")){
                            //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                            hide = true;
                            
                            a.removeAll();
                            addButtons();   
                        }
                        
                        oneTime = false;
                    }
                    
                }));
    }
    public void addButtons(){
        a.addObject(new UIImageButton(handler.getGameWidth()/2 -190, handler.getGameHeight() -250, 380, 110,
                Assets.newGame, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        pState = "menu";
                        state = "info";
                        hide = false;
                        oneTime = false;
                        a.removeAll();
                        addNumbers();
                        //State.setState(handler.getGame().gameState);
                    }
                    
                }));
        a.addObject(new UIImageButton(handler.getGameWidth()/2 -75, handler.getGameHeight() -120, 150, 100,
                Assets.rules, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        pState = "menu";
                        state = "rules";
                        hide = false;
                        oneTime = false;
                        a.removeAll();
                    }
                    
                }));
    }
    public void addRoll(int n){
        a.addObject(new UIImageButton(30 , 306 -32, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d1 = Utils.Util.rand(2, 12);
                    }
                    
                }));
        
        switch(n){
            case 2:
            
                a.addObject(new UIImageButton(40, 356 -32, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d2 = Utils.Util.rand(2, 12);
                        sort(2);
                    }
                    
                }));
                break;
            case 3:
                
                a.addObject(new UIImageButton(40, 356 -32, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d2 = Utils.Util.rand(2, 12);
                    }
                    
                }));
                
                a.addObject(new UIImageButton(40, 406 -30, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d3 = Utils.Util.rand(2, 12);
                        sort(3);
                    }
                    
                }));
                break;
            case 4:
                
                a.addObject(new UIImageButton(40, 356 -32, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d2 = Utils.Util.rand(2, 12);
                    }
                    
                }));
                a.addObject(new UIImageButton(40, 406 -30, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d3 = Utils.Util.rand(2, 12);
                    }
                    
                }));
                a.addObject(new UIImageButton(40, 456 -28, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d4 = Utils.Util.rand(2, 12);
                        sort(4);
                    }
                    
                }));
                break;
            case 5:
                
                a.addObject(new UIImageButton(40, 356 -32, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d2 = Utils.Util.rand(2, 12);
                    }
                    
                }));
                a.addObject(new UIImageButton(40, 406 -30, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d3 = Utils.Util.rand(2, 12);
                    }
                    
                }));
                a.addObject(new UIImageButton(40, 456 -28, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d4 = Utils.Util.rand(2, 12);
                    }
                    
                }));
                a.addObject(new UIImageButton(40, 506 -26, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d5 = Utils.Util.rand(2, 12);
                        sort(5);
                    }
                    
                }));
                break;
            case 6:
                
                a.addObject(new UIImageButton(40, 356 -32, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d2 = Utils.Util.rand(2, 12);
                    }
                    
                }));
                a.addObject(new UIImageButton(40, 406 -30, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d3 = Utils.Util.rand(2, 12);
                    }
                    
                }));
                a.addObject(new UIImageButton(40, 456 -28, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d4 = Utils.Util.rand(2, 12);
                    }
                    
                }));
                a.addObject(new UIImageButton(40, 506 -26, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d5 = Utils.Util.rand(2, 12);
                    }
                    
                }));
                a.addObject(new UIImageButton(40, 556 -24, 50, 35, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d6 = Utils.Util.rand(2, 12);
                        sort(6);
                    }
                    
                }));
                break;
        }
        a.addObject(new UIImageButton(1, handler.getGameHeight() -62, 80, 60,
                Assets.back, "", 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        
                        state = "info";                                       
                        if(state.equals("info")){
                            hide = false;
                            a.removeAll();
                            addNumbers();
                        }
                        oneTime = false;
                    }
                    
                }));
    }

    
    private PlayerNode sort(int n){
        switch(n){
            case 2:
                d[0] = d1;
                d[1] = d2;
            break;
            case 3:
                d[0] = d1;
                d[1] = d2;
                d[2] = d3;
            break;
            case 4:
                d[0] = d1;
                d[1] = d2;
                d[2] = d3;
                d[3] = d4;
            case 5:
                d[0] = d1;
                d[1] = d2;
                d[2] = d3;
                d[3] = d4;
                d[4] = d5;
            case 6:
                d[0] = d1;
                d[1] = d2;
                d[2] = d3;
                d[3] = d4;
                d[4] = d5;
                d[5] = d6;
                break;
        }
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!(i == j)) {
                    if (i < j) {
                        temp = j;
                        j = i;
                        i = temp;
                    }
                }
            }
        }
        return organize(n);
    }
    private PlayerNode organize(int n){
        int[] pos = new int[n];
        int i = 0;
        PlayerNode ptr = new PlayerNode();
        while(i < n){
            if (d1 == d[i]) {
                pos[i] = 1;
                i++;
            }else if(d2 == d[i]){
                pos[i] = 2;
                i++;
            }else if(d3 == d[i]){
                pos[i] = 3;
                i++;
            }else if(d4 == d[i]){
                pos[i] = 4;
                i++;
            }else if (d5 == d[i]){
                pos[i] = 5;
                i++;
            }else if(d6 == d[i]){
                pos[i] = 6;
                i++;
            }else{
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            
            PlayerNode p = new PlayerNode(pos[j]);
            
            if (j == 0) {
                ptr = p;
            }
            p.add(ptr, p);
        }
        return ptr;
    }
    @Override
    public void update() {
        a.update();
    }

    @Override
    public void render(Graphics g) {
        if (!oneTime) {
            handler.setAllObjectsBounds(handler, state, hide);
            oneTime = true;
        }
        if(state.equals("menu")){
            
            //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            g.drawImage(Assets.menu, 0, 0, handler.getGameWidth(), handler.getGameHeight(), null);
            g.drawImage(Assets.menuTitle, handler.getGameWidth()/2 -300, handler.getGameHeight()/2 -280, 600, 300, null);
            
        }else if(state.equals("rules")){
            
        }else if(state.equals("info")){
            
            System.out.println(state);
            g.setColor(Color.black);
            g.setFont(new Font("Kabel-Light", Font.BOLD, 100));
            g.drawString("Click the number of ",0,103);
            g.drawString("players:", 0, 203);
        }else if (state.equals("decideOrder")){
            
            g.setColor(Color.black);
            g.setFont(new Font("Kabel-Light", Font.BOLD, 52));
            g.drawString("Deciding the order of the",0,53);
            g.drawString("players:",0,103);
            g.drawString("Color of each",701,53);
            g.drawString("player:",701,103);
            
            g.drawString("1:",0,306);
            g.drawString("2:",0,358); 
            
            switch(handler.getGame().getGameState().getNumberOfPlayers()){   
                case 3:
                    
                    g.drawString("3:",0,410); 
                    break;
                case 4:
                    
                    g.drawString("3:",0,410);
                    g.drawString("4:",0,462); 
                    break;
                case 5:
                    
                    g.drawString("3:",0,410);
                    g.drawString("4:",0,462);
                    g.drawString("5:",0,514); 
                    break;
                case 6:
                    
                    g.drawString("3:",0,410);
                    g.drawString("4:",0,462);
                    g.drawString("5:",0,514);
                    g.drawString("6:",0,566);
                    break;
            }
            
            
            
        }
        a.render(g);
    }
    
}
