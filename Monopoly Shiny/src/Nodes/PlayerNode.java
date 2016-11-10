/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Visual.Assets;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author cddr
 */
public class PlayerNode {
    public boolean jailChance;
    public boolean communityJail;
    public int order;
    public int money;
    public Color color;
    public BufferedImage token;
    public PlayerNode dLink;
    public PlayerNode iLink;
    public PropertyNode pLink;
    
    public PlayerNode() {
    }
    
    public PlayerNode(int order) {
        this.order = order;
        token = Assets.tokens[order];
        money = 1500;  
        jailChance = false;
        communityJail = false;
        dLink = this;
        iLink = this;
    } 
    
    public void add(PlayerNode ptr, PlayerNode player){
        PlayerNode p = ptr;
        if (!(ptr.dLink == ptr)) {
            do{
                p = p.dLink;
            } while (p == ptr);
            p.iLink.dLink = player;
            player.dLink = p;
            p.iLink = player;
        }
    }
}
