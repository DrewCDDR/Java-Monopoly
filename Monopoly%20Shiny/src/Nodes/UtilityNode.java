package Nodes;


import Cards.Card;
import Cards.Utility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cddr
 */
public class UtilityNode {
    public Card card;
    public UtilityNode link;
    
    public UtilityNode(Utility card) {
        this.card = card;
    }
    public void add(UtilityNode this, UtilityNode p){
        UtilityNode q = this;
        while (q.link != null) {            
            q = q.link;
        }
        q.link = p;
        p.link = null;
    }
}
