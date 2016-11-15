/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Cards.Card;
import Cards.Tax;

/**
 *
 * @author cddr
 */
public class TaxNode {
    public Card tax;
    public TaxNode link;
    

    public TaxNode(Tax tax) {
        this.tax = tax;
    }
    
    public void add(TaxNode this, TaxNode p){
        TaxNode q = this;
        while (q.link != null) {            
            q = q.link;
        }
        q.link = p;
        p.link = null;
    }
}
