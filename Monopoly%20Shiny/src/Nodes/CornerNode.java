/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Cards.Card;
import Cards.Corner;

/**
 *
 * @author cddr
 */
public class CornerNode {
    public Card corner;
    public CornerNode link;

    public CornerNode(Corner corner) {
        this.corner = corner;
    }
    
    
    public void add(CornerNode this, CornerNode p){
        CornerNode q = this;
        while (q.link != null) {            
            q = q.link;
        }
        q.link = p;
        p.link = null;
    }
    
    public void printTitles(CornerNode this){
        CornerNode p = this;
        int c = 0;
        while (p != null) {            
            
            System.out.println("C #" +c +": INDEX = " +((Corner)p.corner).getIndex() +", NAME = "+((Corner)p.corner).getName());
            p = p.link;
            c++;
        }
 
    }
}
