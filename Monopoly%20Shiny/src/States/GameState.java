package States;

import Managers.UIManager;
import Nodes.MapNode;
import Nodes.PlayerNode;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIObject;
import Visual.Assets;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import monopoly.shiny.Handler;

public class GameState extends State{
    private boolean oneTime = false, hide = true, winner = false, setPtr = false,
        stop = false, doble = false, triple = false, move = false;;
    private int nPlayers, dice1, dice2, magnitude, timer = 0;
    private String state;
    private UIManager b;
    private PlayerNode playersPtr, p;
    private MapNode mapPtr;
    
    public GameState(Handler handler) {
        super(handler);
        state = "game";
        b = handler.getGameMouseManager().getUIManager();
        
    }

    public void addGameButtons(){
        state = "game";
        b.addObject(new UIImageButton(726, 675, 50, 50, Assets.roll, state,
        new ClickListener() {
            @Override
            public void onClick() {
                stop = true;
                dice1 = 6; dice2 = 1;
                if (!triple) {
                    magnitude = dice1 + dice2;
                }
                
                if (dice1 == dice2) {
                    if (doble) {
                        if (!triple) {
                            triple = true;
                        }else{
                            triple = false;
                        }
                    }else{
                        doble = true;
                    }
                }
                state = ".";
                b.remove(0);
                b.remove(0);
                move = true;
            }
        }
        ));
    }
    public void addButtons_rolled(){
        b.addObject(new UIImageButton(1078, 675, 120, 50, Assets.nextTurn, state,
                new ClickListener() {
            @Override
            public void onClick() {
                if (!p.inJail) {
                    if (!doble) {
                        p = p.dLink;
                        doble = false;
                    }else{
                        if (!triple) {

                        }else{
                            
                            doble = false;
                            p.inJail = true;
                            p.jailTurns = 3;
                            p = p.dLink;
                        }
                    }
                }else{
                    triple = false;
                    if (doble) {
                        p.inJail = false;
                        p.jailTurns = 0;
                    }else{
                        p.jailTurns -= 1;
                        p = p.dLink;                       
                    }
                }
                    
                
                    
                    state = "game";
                    b.removeAll();
                    addGameButtons();
                    move = false;
                    stop = false;
                    state = ".";
                    
            }
        }));
    }
    public void movePlayer(Graphics g){
        String direction = "";
        if(magnitude > 0){
            if (timer == 20) {
                int tempo = 100;

                if (p.currentPosition.id == 1 || p.currentPosition.id < 11) {
                    direction = "left";
                }else if(p.currentPosition.id == 11 || p.currentPosition.id < 21){
                    direction = "up";
                }else if(p.currentPosition.id == 21 || p.currentPosition.id < 31){
                    direction = "right";
                }else if(p.currentPosition.id == 31 || p.currentPosition.id <= 40){
                    direction = "down";
                }

                assingPlayerToNode(p);                        

                if ("left".equals(direction)) {
                    p.x -= 60;
                }else if("up".equals(direction)){
                    p.y -= 60;
                }else if("right".equals(direction)){
                    p.x += 60;
                }else if("down".equals(direction)){
                    p.y += 60;
                }

                magnitude -=1;
                p.currentPosition = p.currentPosition.dLink;
                timer = 0;
                while (tempo > 0) {                            
                    g.drawImage(p.token, p.x, p.y, 25, 25, null);
                    tempo--;
                }
                if (p.currentPosition.id == 1) {
                    setPlayerCoodinatesOnGo(p);
                }else if(p.currentPosition.id == 11){
                    if (!p.inJail) {
                        setPlayerCoordinatesOnInJail_NotCaught(p);
                    }else{
                        setPlayerCoordinatesOnInJail_Caught(p);
                    }
                }else if(p.currentPosition.id == 21){
                    setPlayerCoordinatesOnFreeParking(p);
                }else if(p.currentPosition.id == 31){
                    setPlayerCoordinatesOnGoToJail(p);
                    if (magnitude == 0) {
                        magnitude = 20;
                        p.collect200 = false;
                        p.inJail = true;
                        p.jailTurns = 3;
                    }
                }
            }else{
                timer++;
            }
        }else{
            move = false;
        }
    }
    public void setPlayersOnGo(PlayerNode p){
        mapPtr.p1 = p;
        p.currentPosition = mapPtr;
        mapPtr.p2 = p.dLink;
        p.dLink.currentPosition = mapPtr;
        
        switch(nPlayers){
            case 3:
                mapPtr.p3 = p.dLink.dLink;
                p.dLink.dLink.currentPosition = mapPtr;
                break;
            case 4:
                mapPtr.p3 = p.dLink.dLink;
                p.dLink.dLink.currentPosition = mapPtr;
                mapPtr.p4 = p.dLink.dLink.dLink;
                p.dLink.dLink.dLink.currentPosition = mapPtr;
                break;
            case 5:
                mapPtr.p3 = p.dLink.dLink;
                p.dLink.dLink.currentPosition = mapPtr;
                mapPtr.p4 = p.dLink.dLink.dLink;
                p.dLink.dLink.dLink.currentPosition = mapPtr;
                mapPtr.p5 = p.dLink.dLink.dLink.dLink;
                p.dLink.dLink.dLink.dLink.currentPosition = mapPtr;
                break;
            case 6: 
                mapPtr.p3 = p.dLink.dLink;
                p.dLink.dLink.currentPosition = mapPtr;
                mapPtr.p4 = p.dLink.dLink.dLink;
                p.dLink.dLink.dLink.currentPosition = mapPtr;
                mapPtr.p5 = p.dLink.dLink.dLink.dLink;
                p.dLink.dLink.dLink.dLink.currentPosition = mapPtr;
                mapPtr.p6 = p.dLink.dLink.dLink.dLink.dLink;
                p.dLink.dLink.dLink.dLink.dLink.currentPosition = mapPtr;
                break;
        }
    }
    public void setPlayersCoordinatesOnGo(PlayerNode p){
        p.x = 660;
        p.y=  660;
        p.dLink.x = 665;
        p.dLink.y= 660;
        switch(nPlayers){
            case 3:
                p.dLink.dLink.x = 670;
                p.dLink.dLink.y= 660;
                break;
            case 4:
                p.dLink.dLink.x = 670;
                p.dLink.dLink.y= 660;
                p.dLink.dLink.dLink.x = 660;
                p.dLink.dLink.dLink.y= 670;
                break;
            case 5:
                p.dLink.dLink.x = 670;
                p.dLink.dLink.y= 660;
                p.dLink.dLink.dLink.x = 660;
                p.dLink.dLink.dLink.y= 670;
                p.dLink.dLink.dLink.dLink.x = 665;
                p.dLink.dLink.dLink.dLink.y= 670;
                break;
            case 6: 
                p.dLink.dLink.x = 670;
                p.dLink.dLink.y= 660;
                p.dLink.dLink.dLink.x = 660;
                p.dLink.dLink.dLink.y= 670;
                p.dLink.dLink.dLink.dLink.x = 665;
                p.dLink.dLink.dLink.dLink.y= 670;
                p.dLink.dLink.dLink.dLink.dLink.x = 670;
                p.dLink.dLink.dLink.dLink.dLink.y= 670;
                break;
        }
    }
    public void setPlayerCoodinatesOnGo(PlayerNode p){
        switch(p.order){
            case 1:
                p.x = 660;
                p.y = 660;
                break;
            case 2:
                p.x = 665;
                p.y = 660;
                break;
            case 3:
                p.x = 670;
                p.y = 660;
                break;
            case 4:
                p.x = 660;
                p.y = 670;
                break;
            case 5:
                p.x = 665;
                p.y = 670;
                break;
            case 6:
                p.x = 670;
                p.y = 670;
                break;
                
        }
    }
    public void setPlayerCoordinatesOnInJail_NotCaught(PlayerNode p){
        switch(p.order){
            case 1:
                p.x = 0;
                p.y = 630;
                break;
            case 2:
                p.x = 0;
                p.y = 635;
                break;
            case 3:
                p.x = 0;
                p.y = 640;
                break;
            case 4:
                p.x = 0;
                p.y = 645;
                break;
            case 5:
                p.x = 0;
                p.y = 650;
                break;
            case 6:
                p.x = 0;
                p.y = 655;
                break;
                
        }
    }    
    public void setPlayerCoordinatesOnInJail_Caught(PlayerNode p){
        switch(p.order){
            case 1:
                p.x = 45;
                p.y = 650;
                break;
            case 2:
                p.x = 45;
                p.y = 655;
                break;
            case 3:
                p.x = 45;
                p.y = 660;
                break;
            case 4:
                p.x = 55;
                p.y = 650;
                break;
            case 5:
                p.x = 55;
                p.y = 655;
                break;
            case 6:
                p.x = 55;
                p.y = 660;
                break;
                
        }
        
    }
    public void setPlayerCoordinatesOnFreeParking(PlayerNode p){
        switch(p.order){
            case 1:
                p.x = 50;
                p.y = 5;
                break;
            case 2:
                p.x = 45;
                p.y = 5;
                break;
            case 3:
                p.x = 40;
                p.y = 5;
                break;
            case 4:
                p.x = 50;
                p.y = 15;
                break;
            case 5:
                p.x = 45;
                p.y = 15;
                break;
            case 6:
                p.x = 40;
                p.y = 15;
                break;
                
        }
        
    }
    public void setPlayerCoordinatesOnGoToJail(PlayerNode p){
        switch(p.order){
            case 1:
                p.x = 660;
                p.y = 40;
                break;
            case 2:
                p.x = 665;
                p.y = 40;
                break;
            case 3:
                p.x = 670;
                p.y = 40;
                break;
            case 4:
                p.x = 660;
                p.y = 50;
                break;
            case 5:
                p.x = 665;
                p.y = 50;
                break;
            case 6:
                p.x = 670;
                p.y = 50;
                break;
                
        }
        
    }
    
    public void renderGeneralInfo(Graphics g){
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(p.name +" turn:", 752, 50);
        g.drawImage(p.token, 910, 19, 50,50,null);
        g.drawString("Dices: " +dice1 +" | " +dice2, 1072, 50);
        g.drawString("Position: " +p.currentPosition.name, 752, 100);
        if (doble) {
            if (triple) {
                g.drawString("triple!", 1082, 100);
            }else{
                g.drawString("double!", 1082, 100);
            }
        }
        if (p.inJail) {
            g.drawString("You're in Jail, you can't move    Turns left: " +p.jailTurns, 752, 150);
        }
        
    }
    public void renderPlayers(Graphics g){
        switch(nPlayers){
            case 3:
                g.drawImage(p.dLink.dLink.token, p.dLink.dLink.x, p.dLink.dLink.y, 25,25,null);
                break;
            case 4:
                g.drawImage(p.dLink.dLink.dLink.token, p.dLink.dLink.dLink.x,
                        p.dLink.dLink.dLink.y, 25,25,null);
                g.drawImage(p.dLink.dLink.token, p.dLink.dLink.x, p.dLink.dLink.y, 25,25,null);
                break;
            case 5:
                g.drawImage(p.dLink.dLink.dLink.dLink.token, p.dLink.dLink.dLink.dLink.x,
                        p.dLink.dLink.dLink.dLink.y, 25,25,null);
                g.drawImage(p.dLink.dLink.dLink.token, p.dLink.dLink.dLink.x,
                        p.dLink.dLink.dLink.y, 25,25,null);
                g.drawImage(p.dLink.dLink.token, p.dLink.dLink.x, p.dLink.dLink.y, 25,25,null);
                break;
            case 6:
                g.drawImage(p.dLink.dLink.dLink.dLink.dLink.token, p.dLink.dLink.dLink.dLink.dLink.x,
                        p.dLink.dLink.dLink.dLink.dLink.y, 25,25,null);
                g.drawImage(p.dLink.dLink.dLink.dLink.token, p.dLink.dLink.dLink.dLink.x,
                        p.dLink.dLink.dLink.dLink.y, 25,25,null);
                g.drawImage(p.dLink.dLink.dLink.token, p.dLink.dLink.dLink.x,
                        p.dLink.dLink.dLink.y, 25,25,null);
                g.drawImage(p.dLink.dLink.token, p.dLink.dLink.x, p.dLink.dLink.y, 25,25,null);
                break;
            
        }
        g.drawImage(p.dLink.token, p.dLink.x, p.dLink.y, 25,25,null);
        g.drawImage(p.token, p.x, p.y, 25,25,null);
    }
    public void assingPlayerToNode(PlayerNode p){
        if (p.order == playersPtr.order) {
            p.currentPosition.dLink.p1 = p;
            p.currentPosition.p1 = null;     
        }else if(p.order == playersPtr.dLink.order){
            p.currentPosition.dLink.p2 = p;
            p.currentPosition.p2 = null; 
        }
        switch(nPlayers){
            case 3:
            if(p.order == playersPtr.dLink.dLink.order){
                p.currentPosition.dLink.p3 = p;
                p.currentPosition.p3 = null;                 
            }
                break;
            case 4:
            if(p.order == playersPtr.dLink.dLink.order){
                p.currentPosition.dLink.p3 = p;
                p.currentPosition.p3 = null;                 
            }else if(p.order == playersPtr.dLink.dLink.dLink.order){
                p.currentPosition.dLink.p4 = p;
                p.currentPosition.p4 = null; 
            }
                break;
            case 5:
            if(p.order == playersPtr.dLink.dLink.order){
                p.currentPosition.dLink.p3 = p;
                p.currentPosition.p3 = null;                 
            }else if(p.order == playersPtr.dLink.dLink.dLink.order){
                p.currentPosition.dLink.p4 = p;
                p.currentPosition.p4 = null;                   
            }else if(p.order == playersPtr.dLink.dLink.dLink.dLink.order){                    
                p.currentPosition.dLink.p5 = p;
                p.currentPosition.p5 = null;
            }
            break;
            case 6: 
            if(p.order == playersPtr.dLink.dLink.order){
                p.currentPosition.dLink.p3 = p;
                p.currentPosition.p3 = null;                 
            }else if(p.order == playersPtr.dLink.dLink.dLink.order){
                p.currentPosition.dLink.p4 = p;
                p.currentPosition.p4 = null;                   
            }else if(p.order == playersPtr.dLink.dLink.dLink.dLink.order){                    
                p.currentPosition.dLink.p5 = p;
                p.currentPosition.p5 = null;                   
            }else if(p.order == playersPtr.dLink.dLink.dLink.dLink.dLink.order){
                p.currentPosition.dLink.p6 = p;
                p.currentPosition.p6 = null;
            }
            break;
        }
    }
    
    
    @Override
    public void update() {
        b.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.map, 0, 0, 725, 725, null);
        if (!oneTime) {
            addGameButtons();
            handler.setAllObjectsBounds(handler, state, hide);
            oneTime = true;
        }
        if (!setPtr) {
            p = playersPtr;
            setPtr = true;
            setPlayersOnGo(p);
            setPlayersCoordinatesOnGo(p);
            /*do {
                setPlayerCoordinatesOnGoToJail(p);
                p = p.dLink;
            } while (p != playersPtr);*/
            
        }
        if (!stop) {
            dice1 = Utils.Util.rand(1, 6);
            dice2 = Utils.Util.rand(1, 6);
        }else{
            if (move) {
                if (p.inJail) {
                    magnitude  = 0;
                }
                movePlayer(g);
            }else{
                if (state.equals(".")) {
                    state = "rolled";
                    addButtons_rolled();
                }
                if ((p.currentPosition.card.getType().equals("Property" )) ||
                        (p.currentPosition.card.getType().equals("Station")) ||
                        (p.currentPosition.card.getType().equals("Utilty"))) {
                    g.setColor(Color.white);
                    g.fillRect(752, 200, 250, 300);
                    g.setColor(Color.black);
                    if (state.equals("rolled")) {
                        
                    }
                }else{
                    if (state.equals("rolled")) {
                        
                    }
                }
            }
        }
        renderGeneralInfo(g);
        g.setColor(Color.red);
        renderPlayers(g);

        
        

        
        
        
        b.render(g);
        
    }
    
    public void setNumberOfPlayers(int n){
        nPlayers = n;
    }
    public int getNumberOfPlayers(){
        return nPlayers;
    }
    
    public void setPlayers(PlayerNode ptr){
        this.playersPtr = ptr;
    }
    public PlayerNode getPlayers(PlayerNode ptr){
        return ptr;
    }

    public MapNode getMapPtr() {
        return mapPtr;
    }

    public void setMapPtr(MapNode mapPtr) {
        this.mapPtr = mapPtr;
    }
}
