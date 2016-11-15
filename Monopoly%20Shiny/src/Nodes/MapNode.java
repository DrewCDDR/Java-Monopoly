/*
 * ADD ALL MOVES IN ALL PLAYERS
 */
package Nodes;

import Cards.Card;
import java.awt.Graphics;

/**
 *
 * @author cddr
 */
public class MapNode {
    public boolean owned;
    public int id;
    public int x;
    public int y;
    public String name;
    public Card card;
    public PlayerNode p1;
    public PlayerNode p2;
    public PlayerNode p3;
    public PlayerNode p4;
    public PlayerNode p5;
    public PlayerNode p6;
    public PlayerNode owner;
    public MapNode dLink;
    public MapNode iLink;

    public MapNode(int id, String name, Card card) {
        this.id = id;
        this.name = name;
        this.card = card;
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;
        p5 = null;
        p6 = null;
        owned = false;
        this.dLink = this;
        this.iLink = this;
    }
    
    
    /*public void MapNode(int id, String name, Card card, PlayerNode p1, 
            PlayerNode p2, PlayerNode p3, PlayerNode p4, PlayerNode p5,
            PlayerNode p6){
        this.id = id;
        this.card = card;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.dLink = this;
        this.iLink = this;
    }*/
    
    public void goToPositive(MapNode this, PlayerNode player, int remaining, Graphics g){
        int timer = 0;
        String direction = "";
        MapNode p = this;
        while (remaining > 0) {  
            System.out.println("Timer: " +timer);
            System.out.println("Moves: " +remaining);
            System.out.println("=============================================");
            if (timer == 10000) {
                
                if (p.id == 1 || p.id < 11) {
                    direction = "left";
                }else if(p.id == 11 || p.id < 21){
                    direction = "up";
                }else if(p.id == 21 || p.id < 31){
                    direction = "right";
                }else if(p.id == 31 || p.id <= 40){
                    direction = "down";
                }
                
                if (p.p1 == player) {
                    p.dLink.p1 = player;
                    p1 = null;     
                }else if(p.p2 == player){
                    p.dLink.p2 = player;
                    p2 = null; 
                }else if(p.p3 == player){
                    p.dLink.p3 = player;
                    p3 = null;                
                }else if(p.p4 == player){
                    p.dLink.p4 = player;
                    p4 = null;                  
                }else if(p.p5 == player){                    
                    p.dLink.p5 = player;
                    p5 = null;                  
                }else if(p.p6 == player){
                    p.dLink.p6 = player;
                    p6 = null;
                                    
                }
                if ("left".equals(direction)) {
                    player.x -= 30;
                }else if("up".equals(direction)){
                    player.y -= 30;
                }else if("right".equals(direction)){
                    player.x += 30;
                }else if("down".equals(direction)){
                    player.y += 30;
                }
                g.drawImage(player.token, player.x, player.y, 25, 25, null);
                
                p = p.dLink;
                timer = 0;
                remaining--;
            }else{
                timer++;
            }
        }
    }
    public void goToNegative(MapNode this, PlayerNode player, int remaining){
        int timer = 0;
        MapNode p = this;
        while (remaining > 0) {            
            if (timer == 100) {
                if (p.p1 == player) {
                    p.iLink.p1 = player;
                    p1 = null;                  
                }else if(p.p2 == player){
                    p.iLink.p2 = player;
                    p2 = null;                  
                }else if(p.p3 == player){
                    p.iLink.p3 = player;
                    p3 = null;                
                }else if(p.p4 == player){
                    p.iLink.p4 = player;
                    p4 = null;                  
                }else if(p.p5 == player){                    
                    p.iLink.p5 = player;
                    p5 = null;                  
                }else if(p.p6 == player){
                    p.iLink.p6 = player;
                    p6 = null;
                                    
                }
                p = p.iLink;   
                timer = 0;
                remaining--;
            }else{
                timer++;
            }
        }
    }
    
    public void add(MapNode this, MapNode player){
        MapNode p = this;
        MapNode ult = this.iLink;
        ult.dLink = player;
        player.dLink = this;
        this.iLink = player;
        player.iLink = ult;
    }
    
    public void setOwner(MapNode this, int id, PlayerNode p){
        MapNode q = this;
        boolean stay = true;
        while(q != null && stay){
            if (q.id == id) {
                stay = false;
            }else{
              q = q.dLink;  
            }
        }
        if (!stay) {
            q.owner = p;
            q.owned = true;
        }
    }
    
}
    
        