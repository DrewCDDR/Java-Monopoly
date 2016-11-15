/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Cards.Card;
import Cards.Chance;

/**
 *
 * @author cddr
 */
public class ChanceNode {
    public Card card;
    public ChanceNode link;
    
    public ChanceNode(Chance card) {
        this.card = card;
    }
    public void add(ChanceNode this, ChanceNode p){
        ChanceNode q = this;
        while (q.link != null) {            
            q = q.link;
        }
        q.link = p;
        p.link = null;
    }
    public void printTitles(ChanceNode this){
        ChanceNode p = this;
        int c = 0;
        while (p != null) {            
            
            System.out.println("C #" +c +": " +((Chance)p.card).title);
            p = p.link;
            c++;
        }
 
    }
}
