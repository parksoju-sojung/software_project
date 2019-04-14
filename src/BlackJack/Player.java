/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package BlackJack;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 */
public class Player {
    String id; //the unique ID for this player
    int score = 0;
    Hand hand;
    
    public Player(String s) {
        hand = new Hand();
        id = s;
    }
    
    public void addScore() {
        score++;
    }
    
    /**
     * The method to be instantiated when you subclass the Player class
     * with your specific type of Player and filled in with logic to play your game.
     * 
     * @return 
     */
    public void showHand() {
        String s = "";
        for(int i = 0; i < hand.getCards().size(); i++) {
            s += hand.getCards().get(i).toString() + " ";
        }
        
        System.out.println("\n" + id + "'s hand: " + s);
        System.out.println(id + "'s hand value: " + hand.calcHand());
    }
    
}
