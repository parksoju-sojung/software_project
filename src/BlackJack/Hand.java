
package BlackJack;

import java.util.ArrayList;

/**
 *This class models card hand of a player. It has list of cards and you can add
 * card to the hand and get Nth card from the hand, and calculate the BlackJack
 * value of the hand and drop all the cards in the hand
 * 
 * @author Sojung Park
 */
public class Hand {
    
    private ArrayList<Card> cards = new ArrayList<Card>();
    
    /**
     * retrieve ArrayList of cards
     * 
     * @return list of cards
     */
    ArrayList<Card> getCards() {
        return(cards);
    }
    
    /**
     * add given card in the hand
     * 
     * @param c given card
     */
    void addCard(Card c) {
        cards.add(c);
    }
    
    /**
     * retrieve Nth card in the hand
     * 
     * @param i location of the desired card
     * @return Nth card
     */
    Card getNthCard(int i) {
        return cards.get(i - 1);
    }
    
    /**
     * calculate blackjack value of the hand
     * 
     * @return the value of the hand
     */
    int calcHand() {
        int reg = 0;
        int low = 0;
        
        //calculate value for the hand (treat A as 11)
        for (int i = 0; i < cards.size(); i++) {
            reg += cards.get(i).getValue().getNumVal();
        }
       
        //calculate value for the hand (treat A as 1)
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getValue().getStrVal().equals("Ace")) {
                low += 1;
            } else {
                low += cards.get(i).getValue().getNumVal();
            }
        }
        
        //when A is calculated as 11 and total value is over 21, switch it's
        //value to 1
        return (reg > 21) ? low : reg;
    }
    
    //clear all the cards in the hand
    void clearHand() {
        cards.clear();
    }
    
}
