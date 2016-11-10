/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Cards.Property;

/**
 *
 * @author cddr
 */
public class PropertyNode {
    public PropertyNode link;
    public Property property;
    
    public PropertyNode(Property property) {
        this.property = property;
    }
    
}
