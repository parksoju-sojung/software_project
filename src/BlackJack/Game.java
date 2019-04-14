/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye, 2018
 */
public class Game {
    private final String gameName = "BlackJack";//the title of the game
    private Player user;// the players of the game
    private Player dealer;
    private Deck deck;
    final String cantContMsg = "Deck has runout! Thanks for playing.";
    
    public Game() {
        deck = new Deck();
        dealer = new Player("Dealer");
    }
    
    public void setUser(Player p) {
        user = p;
    }

    /**
     * @return the gameName
     */
    public String getGameName() {
        return gameName;
    }
    
    public Deck getDeck() {
        return deck;
    }
    
    public Player getDealer() {
        return dealer;
    }
   
    
    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
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
                System.out.println("Would you like to draw another card?(Y/N)");
                char c = in.next().toUpperCase().charAt(0);
                if (c == 'Y') {
                    user.hand.addCard(deck.draw());
                    user.showHand();
                } else {
                    break;
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
