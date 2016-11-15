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
    private boolean oneTime, hide, throwed, arranged, done, show;
    private int d1, d2, d3, d4, d5, d6;
    private String state = "menu", pState = "";
    private UIManager a;
    private PlayerNode ptr;
            
    public MenuState(Handler handler) {
        super(handler);
        oneTime = false;
        hide = true; 
        throwed = false;
        done = false;
        show = false;
        //state = "menu";
        //pState = "";
        a = new UIManager(handler);
        handler.getGameMouseManager().setUIManager(a);
        addButtons();
    }
    
    //Buttons creator per state:
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
                        addRoll();
                    }
                    
                }));
        a.addObject(new UIImageButton(242, 356, 150, 150, Assets.three, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getGame().getGameState().setNumberOfPlayers(3);
                        pState = state;
                        state = "decideOrder";
                        oneTime = false;
                        a.removeAll();
                        addRoll();
                    }
                    
                }));
        a.addObject(new UIImageButton(464, 356, 150, 150, Assets.four, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getGame().getGameState().setNumberOfPlayers(4);
                        pState = state;
                        state = "decideOrder";
                        oneTime = false;
                        a.removeAll();
                        addRoll();
                    }
                    
                }));
        a.addObject(new UIImageButton(686, 356, 150, 150,
                Assets.five, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getGame().getGameState().setNumberOfPlayers(5);
                        pState = state;
                        state = "decideOrder";
                        oneTime = false;
                        a.removeAll();
                        addRoll();
                    }
                    
                }));
        a.addObject(new UIImageButton(908, 356, 150, 150,
                Assets.six, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getGame().getGameState().setNumberOfPlayers(6);
                        pState = state;
                        state = "decideOrder";
                        oneTime = false;
                        a.removeAll();
                        addRoll();
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
    public void addRoll(){
        a.addObject(new UIImageButton(220 , handler.getGameHeight() -82, 100, 70, Assets.roll, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        d1 = Utils.Util.rand(2, 12);
                        d2 = Utils.Util.rand(2, 12);
                        d3 = Utils.Util.rand(2, 12);
                        d4 = Utils.Util.rand(2, 12);
                        d5 = Utils.Util.rand(2, 12);
                        d6 = Utils.Util.rand(2, 12);
                        show = true;
                    }
                    
                }));
  
        a.addObject(new UIImageButton(550, handler.getGameHeight() -82, 250, 80, Assets.arrange, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        
                        ptr = sort(handler.getGame().getGameState().getNumberOfPlayers());
                        arranged = true;
                    }
                    
                }));
        
        a.addObject(new UIImageButton(1020, handler.getGameHeight() -82, 150, 70, Assets.start, state, 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        
                        handler.getGame().getGameState().setPlayers(ptr);
                        a.removeAll();
                        State.setState(handler.getGame().getGameState());
                    }
                    
                }));
        
        a.addObject(new UIImageButton(1, handler.getGameHeight() -62, 80, 60, Assets.back, "", 
                new ClickListener(){
                    @Override
                    public void onClick() {
                        
                        state = "info";     
                        arranged = false;
                        if(state.equals("info")){
                            hide = false;
                            a.removeAll();
                            addNumbers();
                        }
                        oneTime = false;
                    }
                    
                }));
    }

    //Creation of the players list:
    private PlayerNode sort(int n){
        
        int[] d = new int[n];
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
                break;
            case 5:
                
                d[0] = d1;
                d[1] = d2;
                d[2] = d3;
                d[3] = d4;
                d[4] = d5;
                break;
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
//                if (!(d[i] == d[j])) {
                    if (d[i] > d[j]) {
                        temp = d[j];
                        d[j] = d[i];
                        d[i] = temp;
                    }
//                }
            }
        }
        /*for (int i = 0; i < n; i++) {
            System.out.println("V[" +i +"]: " +d[i]);
        }*/
        return organize(d, n);
    }
    private PlayerNode organize(int[] v, int n){
       giveMeAnOrder(v, n);       
        for (int k = 0; k < n; k++) {            
            PlayerNode p = new PlayerNode(k +1);
            if (k == 0) {
                ptr = p;
            }
            ptr.add(p);
        }
//        System.out.println("AAAA");
        return ptr;
    }
    private int[]  giveMeAnOrder(int[] v, int n){
        for (int i = 0; i < n; i++) {
            switch(i){
                case 0:
                    d1 = v[i];
                    break;
                case 1:
                    d2 = v[i];
                    break;
                case 2:
                    d3 = v[i];
                    break;
                case 3:
                    d4 = v[i];
                    break;
                case 4:
                    d5 = v[i];
                    break;
                case 5:
                    d6 = v[i];
                    break;
            }
        }
        return v;        
    }
    
    //functions that writes in the render to display in canvas per state:
    private void displayInfo(Graphics g){
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 100));
        g.drawString("Click the number of ",0,103);
        g.drawString("players:", 0, 203);
    }
    private void displayDecideOrder(Graphics g){
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 52));
        g.drawString("Deciding the order",0,53);
        g.drawString("of the players:",0,103);
        g.drawString("Token of each player:",701,53);
//        g.drawString("player:",501,103);

        g.drawString("Player 1: Dice:",0,306);
        g.drawString("Player 2: Dice:",0,358); 

        switch(handler.getGame().getGameState().getNumberOfPlayers()){   
            case 3:

                g.drawString("Player 3: Dice:",0,410); 
                break;
            case 4:

                g.drawString("Player 3: Dice:",0,410);
                g.drawString("Player 4: Dice:",0,462); 
                break;
            case 5:

                g.drawString("Player 3: Dice:",0,410);
                g.drawString("Player 4: Dice:",0,462);
                g.drawString("Player 5: Dice:",0,514); 
                break;
            case 6:

                g.drawString("Player 3: Dice:",0,410);
                g.drawString("Player 4: Dice:",0,462);
                g.drawString("Player 5: Dice:",0,514);
                g.drawString("Player 6: Dice:",0,566);
                break;
        }
    }
    private void displayDecideOrder_Show(Graphics g){
        g.drawString("" +d1,340,306);
        g.drawString("" +d2,340,358); 

        switch(handler.getGame().getGameState().getNumberOfPlayers()){   
            case 3:

                g.drawString("" +d3 ,340,410); 
            break;
            case 4:

                g.drawString("" +d3,340,410);
                g.drawString("" +d4,340,462); 
            break;
            case 5:

                g.drawString("" +d3,340,410);
                g.drawString("" +d4,340,462);
                g.drawString("" +d5,340,514); 
            break;
            case 6:

                g.drawString("" +d3,340,410);
                g.drawString("" +d4,340,462);
                g.drawString("" +d5,340,514);
                g.drawString("" +d6,340,566);
            break;
        }
    }
    private void displayDecideOrder_Arranged(Graphics g){
        
        g.drawString("Player 1 token: ", 702, 300);
        g.drawImage(Assets.tokens[0], 1050, 265, 40, 40, null);
        g.drawString("Player 2 token: ", 702, 350);
        g.drawImage(Assets.tokens[1], 1050, 315, 40, 40, null);
        
        switch(handler.getGame().getGameState().getNumberOfPlayers()){
            case 3:
                    g.drawString("Player 3 token: ", 702, 400);
                    g.drawImage(Assets.tokens[2], 1050, 365, 40, 40, null);
                break;
            case 4:
                    g.drawString("Player 3 token: ", 702, 400);
                    g.drawImage(Assets.tokens[2], 1050, 365, 40, 40, null);
                    g.drawString("Player 4 token: ", 502, 450);
                    g.drawImage(Assets.tokens[3], 1050, 415, 40, 40, null);
                break;
            case 5:
                    g.drawString("Player 3 token: ", 702, 400);
                    g.drawImage(Assets.tokens[2], 1050, 365, 40, 40, null);
                    g.drawString("Player 4 token: ", 702, 450);
                    g.drawImage(Assets.tokens[3], 1050, 415, 40, 40, null);
                    g.drawString("Player 5 token: ", 702, 500);
                    g.drawImage(Assets.tokens[4], 1050, 465, 40, 40, null);
                break;
            case 6:
                    g.drawString("Player 3 token: ", 702, 400);
                    g.drawImage(Assets.tokens[2], 1050, 365, 40, 40, null);
                    g.drawString("Player 4 token: ", 702, 450);
                    g.drawImage(Assets.tokens[3], 1050, 415, 40, 40, null);
                    g.drawString("Player 5 token: ", 702, 500);
                    g.drawImage(Assets.tokens[4], 1050, 465, 40, 40, null);
                    g.drawString("Player 6 token: ", 702, 550);
                    g.drawImage(Assets.tokens[5], 1050, 515, 40, 40, null);
                break;
        }
    }
           
    @Override
    public void update() {
        a.update();
    }

    @Override
    public void render(Graphics g) {
//        g.setColor(Color.);
        if (!oneTime) {
            handler.setAllObjectsBounds(handler, state, hide);
            oneTime = true;
        }
        if(state.equals("menu")){
            
            g.drawImage(Assets.menu, 0, 0, handler.getGameWidth(), handler.getGameHeight(), null);
            g.drawImage(Assets.menuTitle, handler.getGameWidth()/2 -300, handler.getGameHeight()/2 -280, 600, 300, null);
        }else if(state.equals("rules")){
            
        }else if(state.equals("info")){
            
            displayInfo(g);
        }else if (state.equals("decideOrder")){
            
            displayDecideOrder(g);
            displayDecideOrder_Arranged(g);
            
            if (show) {
                displayDecideOrder_Show(g);                               
            }                        
        }
        a.render(g);
    }    
}
