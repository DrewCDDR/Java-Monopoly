/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Cards.Card;

/**
 *
 * @author cddr
 */
public class MapNode {
    public int id;
    String name;
    public Card card;
    public PlayerNode p1;
    public PlayerNode p2;
    public PlayerNode p3;
    public PlayerNode p4;
    public PlayerNode p5;
    public PlayerNode p6;
    public MapNode dlink;
    public MapNode iLink;
    
    public void MapNode(){
        
    }
    
    public void MapNode(int id, String name, Card card){
        this.id = id;
        this.name = name;
        this.card = card;
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;
        p5 = null;
        p6 = null;
    }
    public void MapNode(int id, String name, Card card, PlayerNode p1, 
            PlayerNode p2, PlayerNode p3, PlayerNode p4, PlayerNode p5,
            PlayerNode p6){
        this.id = id;
        this.name = name;
        this.card = card;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
    }
}
    
        