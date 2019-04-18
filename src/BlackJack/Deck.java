
package BlackJack;

import java.util.ArrayList;
import java.util.Collections;

/**
 *This class models deck of the card. It contains list of cards and able to draw
 * from the card. You can set how many regular sets of 52-card you would like in
 * the deck
 * 
 * @author Sojung Park
 */
public class Deck {
    
    private ArrayList<Card> cards = new ArrayList<Card>();
    private final int numOfDeck = 2;
    
    //create deck with designated number of sets and shuffle
    public Deck() {
        for(int i = 0; i < numOfDeck; i++) {
            for(Suit s : Suit.values()) {
                for(Value v: Value.values()) {
                    cards.add(new Card(s, v));
                }
            }
        }
        
        Collections.shuffle(cards);
    }
    
    /**
     * retrieve list of cards in deck
     * 
     * @return cards in deck
     */
    ArrayList<Card> getCards() {
        return cards;
    }
    
    /**
     * set cards as given list of cards
     * 
     * @param c list of cards
     */
    void setCards(ArrayList<Card> c) {
        cards = c;
    }
    
    /**
     * Retrieve first card from the deck. delete first card in the list.
     * @return first card 
     */
    public Card draw() {
        Card c = cards.get(0);
        cards.remove(0);
            
        return c;
    }
}
