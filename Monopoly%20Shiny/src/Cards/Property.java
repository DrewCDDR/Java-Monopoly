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
    
    private boolean buyable;
    private boolean hotel;
    private int index;
    private int inHouses = 0;
    private int oneHouseValue;
    private int twoHouseValue;
    private int threeHouseValue;
    private int fourHouseValue;
    private int hotelValue;
    private int hotelCost;
    private int houseCost;
    private int rent;
    private int propertyValue;
    private int mortage;
    private String name;
    private String colorName;
    private Color color;

    public Property(String type, int id) {
        super(type, id);
        buyable = true;
        hotel = false;
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
    
    // THE DARK SIDE OF THE CODE//// GETTERS n' SETTERS:

    public int getMortage() {
        return mortage;
    }
    public void setMortage(int mortage) {
        this.mortage = mortage;
    } 
    public int getHotelCost() {
        return hotelCost;
    }
    public void setHotelCost(int hotelCost) {
        this.hotelCost = hotelCost;
    }
    public int getHouseCost() {
        return houseCost;
    }
    public void setHouseCost(int houseCost) {
        this.houseCost = houseCost;
    } 
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
    public boolean isHotel() {
        return hotel;
    }
    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }
    public int getOneHouseValue() {
        return oneHouseValue;
    }
    public void setOneHouseValue(int oneHouseValue) {
        this.oneHouseValue = oneHouseValue;
    }
    public int getTwoHouseValue() {
        return twoHouseValue;
    }
    public void setTwoHouseValue(int twoHouseValue) {
        this.twoHouseValue = twoHouseValue;
    }
    public int getThreeHouseValue() {
        return threeHouseValue;
    }
    public void setThreeHouseValue(int threeHouseValue) {
        this.threeHouseValue = threeHouseValue;
    }
    public int getFourHouseValue() {
        return fourHouseValue;
    }
    public void setFourHouseValue(int fourHouseValue) {
        this.fourHouseValue = fourHouseValue;
    }
    public int getHotelValue() {
        return hotelValue;
    }
    public void setHotelValue(int hotelValue) {
        this.hotelValue = hotelValue;
    }
    public String getColorName() {
        return colorName;
    }
    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }    
    public void setInHouses(int inHouses){
        this.inHouses = inHouses;
    }
    public int getInHouses(){
        return inHouses;
    }
    public void setRent(int rent){
        this.rent = rent;
    }
    public int getRent(){
            return rent;
    }
    public void setPropertyValue(int propertyValue){
        this.propertyValue = propertyValue;
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
