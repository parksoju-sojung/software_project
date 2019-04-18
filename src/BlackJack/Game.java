
package BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models BlackJack game. It has game name, user, dealer, deck of
 * cards and error message used when there is not enough card in the deck. It
 * shows current score for user and dealer and declare winner or draw
 * 
 * @author Sojung Park
 */
public class Game {
    private final String gameName = "BlackJack";//the title of the game
    private Player user;// the players of the game
    private Player dealer;
    private Deck deck;
    final String cantContMsg = "Deck has runout! Thanks for playing.";
    
    /**
     * Create game with new Deck of Cards and register computer as dealer with
     * name "Dealer"
     */
    public Game() {
        deck = new Deck();
        dealer = new Player("Dealer");
    }
    
    /**
     * Register given player as user
     * 
     * @param p given player
     */
    public void setUser(Player p) {
        user = p;
    }

    /**
     * Retrieve game name
     * 
     * @return the gameName
     */
    public String getGameName() {
        return gameName;
    }
    
    /**
     * Retrieve deck of cards
     * 
     * @return deck
     */
    public Deck getDeck() {
        return deck;
    }
    
    /**
     * retrieve dealer of the game
     * 
     * @return dealer
     */
    public Player getDealer() {
        return dealer;
    }
   
    
    /**
     * Play the game. 
     */
    public void play() {
        Scanner in = new Scanner(System.in);
        
        user.hand.clearHand();
        dealer.hand.clearHand();
        
        user.hand.addCard(deck.draw());
        dealer.hand.addCard(deck.draw());
        user.hand.addCard(deck.draw());
        dealer.hand.addCard(deck.draw());
        
        System.out.println("Card dealt!");
        
        if(dealer.hand.calcHand() != 21 && user.hand.calcHand() != 21) {
            
            System.out.println(dealer.id + " has " + dealer.hand.getNthCard(1)
                + " and a face-down card");
            user.showHand();
            do {
                System.out.print("Would you like to draw another card?(Y/N)");
                char c = in.next().toUpperCase().charAt(0);
                if (c == 'Y') {
                    user.hand.addCard(deck.draw());
                    user.showHand();
                } else if (c == 'N') {
                    break;
                } else { 
                    System.out.println("Please enter Y or N only");
                    continue;
                }
            } while (user.hand.calcHand() < 21);
            
            if(user.hand.calcHand() >21) {
                busted(user);
                declareWinner(dealer);
                
            } else{
            
                System.out.println("Your turn is over");
                dealer.showHand();
            
                while(dealer.hand.calcHand() < 17) {
                    System.out.println("Dealer Hand is less than or equal to 16."
                            + "\nDealer draw another card.");
                    dealer.hand.addCard(deck.draw());      
                    dealer.showHand();
                }
                
                if(dealer.hand.calcHand() > 21) {
                    busted(dealer);
                    declareWinner(user);
                } else {
                    if (dealer.hand.calcHand() == user.hand.calcHand()) {
                        declareDraw();
                    } else {
                        declareWinner(
                            dealer.hand.calcHand() > user.hand.calcHand() ?
                                dealer : user
                        );
                    }
                }
            }
            
        } else {
            dealer.showHand();
            user.showHand();
            
            if(dealer.hand.calcHand() == 21) {
                blackJack(dealer);
                
                if(user.hand.calcHand() != 21) {
                    declareWinner(dealer);
                } else {
                    declareDraw();
                }
                
            } else {
                blackJack(user);
                declareWinner(user);
            }
        }
        
        showScore();
    }
    
    public void showScore() {
        System.out.println("\nScore\n" + dealer.id + ": " + dealer.score + " "
                + user.id + ": " + user.score);
    }
    
    public void declareWinner(Player p) {
        System.out.println(p.id + " Win!");
        p.addScore();
    }
    
    public void declareDraw() {
        System.out.println("It's a draw!");
    }
    
    public void blackJack(Player p) {
        System.out.println(p.id + " has a BlackJack!");
    }
    
    public void busted(Player p) {
        System.out.println(p.id + " has busted!");
    }
    
    public Boolean possibleToContinue() {
        return (deck.getCards().size() > 20);
    }
    
}//end class
