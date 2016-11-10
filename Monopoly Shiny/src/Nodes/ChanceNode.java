/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Cards.Chance;

/**
 *
 * @author cddr
 */
public class ChanceNode {
    public Chance card;
    public ChanceNode link;
    
    public ChanceNode(Chance card) {
        this.card = card;
    }
    
}
