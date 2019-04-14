
package BlackJack;


public class Card 
{
    private final Suit suit;
    private final Value value;
    
    public Card(Suit s, Value v) {
        this.value = v;
        this.suit = s;
    }
    
    public Value getValue() {
            return this.value;
    }

    public Suit getSuit() {
            return this.suit;
    }
    
    
    @Override
    public String toString() {
        return(suit.getStrVal() + " " + value.getStrVal());
    }
    
}
