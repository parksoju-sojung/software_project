/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author spark
 */
public class Deck {
    
    private ArrayList<Card> cards = new ArrayList<Card>();
    private final int numOfDeck = 2;
    
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
    
    ArrayList<Card> getCards() {
        return cards;
    }
    
    public Card draw() {
        Card c = cards.get(0);
        cards.remove(0);
        
        return c;
    }
}
