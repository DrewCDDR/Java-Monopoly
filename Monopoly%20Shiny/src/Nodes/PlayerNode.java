/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Cards.Chance;
import Cards.CommunityChest;
import Visual.Assets;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author cddr
 */
public class PlayerNode {
    public Chance chanceFree;
    public CommunityChest communityFree;
    public boolean inJail;
    public boolean collect200;
    public int cratedNumber, order, jailTurns;
    public int money;
    public int x;
    public int y;
    public String name;
    public Color color;
    public BufferedImage token;
    public PlayerNode dLink;
    public PlayerNode iLink;
    public PropertyNode pLink;
    public MapNode currentPosition;
    
    public void emptyPlayerNode(int createdNumber) {
        this.cratedNumber = createdNumber;
        this.dLink = this;
        this.iLink = this;
    }
    
    public PlayerNode(int order) {
        this.order = order;
        this.name = "Player " +order;
        this.token = Assets.tokens[order -1];
        this.money = 1500;  
        this.chanceFree = null;
        this.communityFree = null;
        this.dLink = this;
        this.iLink = this;
        this.inJail = false;
        this.collect200 = true;
        this.jailTurns = 0;
    } 
    
    public void add(PlayerNode this, PlayerNode player){
        PlayerNode p = this;
        PlayerNode ult = this.iLink;
        ult.dLink = player;
        player.dLink = this;
        this.iLink = player;
        player.iLink = ult;
    }
    public PlayerNode getPlayerNumber(PlayerNode this ,int number){
        PlayerNode p = this;
        boolean getOut = false;
        do {
            if (p.order == number) {
                getOut = true;
            }else{
                p = p.dLink;
            }
        } while ((p == this)&& !(getOut));
        return p;
    }

    
    //
    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }
    
    
}
