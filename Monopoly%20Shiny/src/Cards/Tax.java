/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

/**
 *
 * @author cddr
 */
public class Tax extends Card{
    private int index;
    private String name;
    
    public Tax(String type, int id) {
        super(type, id);
    }

    
    //GETTERS n' SETTERS:
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
