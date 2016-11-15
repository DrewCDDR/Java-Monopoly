package Cards;

public class Station extends Card{
    
    private boolean buyable;
    private int index, rent, price, if2, if3, if4, mortage;
    private String name;
    
    public Station(String type, int id) {
        super(type, id);
    }
    
    //
    
    public void setBuyable(boolean buyable){
        this.buyable = buyable;
    }
    public boolean isBuyable(){
        return buyable;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public int getIf2() {
        return if2;
    }

    public void setIf2(int if2) {
        this.if2 = if2;
    }

    public int getIf3() {
        return if3;
    }

    public void setIf3(int if3) {
        this.if3 = if3;
    }

    public int getIf4() {
        return if4;
    }

    public void setIf4(int if4) {
        this.if4 = if4;
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
