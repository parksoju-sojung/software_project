/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;

/**
 *
 * @author spark
 */
public class Hand {
    
    private ArrayList<Card> cards = new ArrayList<Card>();
    
    ArrayList<Card> getCards() {
        return(cards);
    }
    
    void addCard(Card c) {
        cards.add(c);
    }
    
    Card getNthCard(int i) {
        return cards.get(i - 1);
    }
    
    int calcHand() {
        int reg = 0;
        int low = 0;
        for (int i = 0; i < cards.size(); i++) {
            reg += cards.get(i).getValue().getNumVal();
        }
       
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getValue().getStrVal().equals("Ace")) {
                low += 1;
            } else {
                low += cards.get(i).getValue().getNumVal();
            }
        }
        
        
        return (reg > 21) ? low : reg;
    }
    
    void clearHand() {
        cards.clear();
    }
    
}
