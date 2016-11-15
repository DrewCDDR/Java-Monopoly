/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Cards.Card;
import Cards.Station;

/**
 *
 * @author cddr
 */
public class StationNode {
    public Card station;
    public StationNode link;
    
    public StationNode(Station station) {
        this.station = station;
    }
    public void add(StationNode this, StationNode p){
        StationNode q = this;
        while (q.link != null) {            
            q = q.link;
        }
        q.link = p;
        p.link = null;
    }
}
