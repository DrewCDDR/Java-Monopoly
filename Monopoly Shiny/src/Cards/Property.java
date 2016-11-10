/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

import java.awt.Color;

/**
 *
 * @author demarchenac
 */
public class Property extends Card{
    
    private boolean buyable = true;
    private boolean hotel = false;
    private int inHouses = 0;
    private int oneHouseValue;
    private int twoHouseValue;
    private int threeHouseValue;
    private int fourHouseValue;
    private int hotelValue;
    private int rent;
    private int propertyValue;
    private String colorName;
    private Color color;

    public Property(String type, int id) {
        super(type, id);
    }
    
    public void calculateRent(){
        if (!(inHouses == 0)) {
            switch(inHouses){
                case 1:
                    rent = oneHouseValue;
                    break;
                case 2:
                    rent = twoHouseValue;
                    break;
                case 3:
                    rent = threeHouseValue;
                    break;
                case 4:
                    rent = fourHouseValue;
                    break;
            }
        }else{
            if (hotel) {
                rent = hotelValue;
            }
        }
    }
    
    public void setInHouses(int inHouses){
        this.inHouses = inHouses;
    }
    public int getInHouses(){
        return inHouses;
    }
    public int getRent(){
            return rent;
    }
    public int getPropertyValue(){
        return propertyValue;
    }
    public void setBuyable(boolean buyable){
        this.buyable = buyable;
    }
    public boolean isBuyable(){
        return buyable;
    }
}
