
package BlackJack;

/**
 * This class models card that has suit and value
 * 
 * @author Sojung Park
 */
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
    
    /**
     * String version of the card for display
     * 
     * @return String value of the card for display purpose
     */
    @Override
    public String toString() {
        return(suit.getStrVal() + " " + value.getStrVal());
    }
    
}
