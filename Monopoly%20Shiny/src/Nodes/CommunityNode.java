/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Cards.Card;
import Cards.CommunityChest;

/**
 *
 * @author cddr
 */
public class CommunityNode {
    public Card card;
    public CommunityNode link;
    
    public CommunityNode(CommunityChest card) {
        this.card = card;
    }
    public void add(CommunityNode this, CommunityNode p){
        CommunityNode q = this;
        while (q.link != null) {            
            q = q.link;
        }
        q.link = p;
        p.link = null;
    }
    public void printTitles(CommunityNode this){
        CommunityNode p = this;
        int c = 0;
        while (p != null) {            
            
            System.out.println("C #" +c +": " +((CommunityChest)p.card).title);
            p = p.link;
            c++;
        }
 
    }
}
