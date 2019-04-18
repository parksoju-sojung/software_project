
package BlackJack;

/**
 * A class that models Player in the game. Player has id, score and card hand.
 * Player can gain score and show their hand.
 * 
 * @author Sojung Park
 */
public class Player {
    String id; //the unique ID for this player
    int score = 0;
    Hand hand;
    
    /**
     * create a Player object with given name. New empty hand is created
     * automatically
     * 
     * @param s name of the player
     */
    public Player(String s) {
        hand = new Hand();
        id = s;
    }
    
    /**
     * add 1 point to the score
     */
    public void addScore() {
        score++;
    }
    
    /**
     * Show hand by printing all the cards in the hand and value of the hand
     */
    public void showHand() {
        String s = "";
        //get all the String version of the card in the hand and add to String s
        //for print later
        for(int i = 0; i < hand.getCards().size(); i++) {
            s += hand.getCards().get(i).toString() + " ";
        }
        
        System.out.println("\n" + id + "'s hand: " + s);
        System.out.println(id + "'s hand value: " + hand.calcHand());
    }
    
}
