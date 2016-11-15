package Cards;

public abstract class Card {
    
    protected int id;
    protected String type;

    public Card(String type, int id) {
        this.id = id;
        this.type = type;
    }  

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
