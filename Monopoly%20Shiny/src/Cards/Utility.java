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
public class Utility extends Card {
    private boolean buyable;
    private int index,rent, price, mortage;
    private String name;
    
    public Utility(String type, int id) {
        super(type, id);
    }
    
    
    public int getIndex(){
        return index;
    }

    //
    public void setIndex(int index) {
        this.index = index;
    }

    public void setBuyable(boolean buyable) {
        this.buyable = buyable;
    }
    public boolean isBuyable(){
        return buyable;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMortage() {
        return mortage;
    }

    public void setMortage(int mortage) {
        this.mortage = mortage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
