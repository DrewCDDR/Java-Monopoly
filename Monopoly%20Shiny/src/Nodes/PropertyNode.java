/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Cards.Card;
import Cards.Property;

/**
 *
 * @author cddr
 */
public class PropertyNode {
    public PropertyNode link;
    public Card property;
    
    public PropertyNode(Property property) {
        this.property = property;
    }
    public void add(PropertyNode this, PropertyNode p){
        PropertyNode q = this;
        while (q.link != null) {            
            q = q.link;
        }
        q.link = p;
        p.link = null;
    }
    public void printProperty(PropertyNode this){
//        System.out.println("hallo");
        PropertyNode p = this;
        while (p != null) {  
//            System.out.println("hi");
            System.out.println("id:"+((Property)p.property).getIndex() +
                    "#NAME: "+((Property)p.property).getName() +
                    "#Price: " +((Property)p.property).getPropertyValue());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            p = p.link;
        }
    }
}
