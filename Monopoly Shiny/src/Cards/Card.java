package Cards;

public abstract class Card {
    
    protected int id;
    protected String type;

    public Card(String type, int id) {
        this.id = id;
        this.type = type;
    }  
}
