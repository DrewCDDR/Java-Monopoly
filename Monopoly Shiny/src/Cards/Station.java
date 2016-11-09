package Cards;

public class Station extends Card{
    
    private boolean buyable;
    private int rent;
    
    public Station(String type, int id) {
        super(type, id);
    }
    
    public void setBuyable(boolean buyable){
        this.buyable = buyable;
    }
    public boolean isBuyable(){
        return buyable;
    }
}
