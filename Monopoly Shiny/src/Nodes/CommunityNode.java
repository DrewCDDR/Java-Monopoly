/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Cards.CommunityChest;

/**
 *
 * @author cddr
 */
public class CommunityNode {
    public CommunityChest card;
    public CommunityNode link;
    
    public CommunityNode(CommunityChest card) {
        this.card = card;
    }
    
}
