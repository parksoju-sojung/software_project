
package BlackJack;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Test for Game class
 * 
 * @author Sojung Park
 */
public class GameTest {
    
    public GameTest() {
    }
    
    /**
     * Test of possibleToContinue method, of class Game. Method returns true if
     * the size of card array of deck for Game object is greater than 20.
     */
    @Test
    public void testPossibleToContinue() {
        System.out.println("possibleToContinue");
        
        //good test with new deck(104 cards) 
        Game instanceGood = new Game();
        Boolean resultGood = instanceGood.possibleToContinue();
        assertEquals(true, resultGood);
        
        //bad test with deck with only 1 card;
        Game instanceBad = new Game();
        ArrayList<Card> shortArr = new ArrayList<>();
        shortArr.add(new Card(Suit.HEART, Value.ACE));
        instanceBad.getDeck().setCards(shortArr);
        Boolean resultBad = instanceBad.possibleToContinue();
        assertEquals(false, resultBad);
        
        //boundary test with deck with 20 cards
        Game instanceBoundary = new Game();
        ArrayList<Card> boundaryArr = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            shortArr.add(new Card(Suit.HEART, Value.ACE));
        }
        instanceBoundary.getDeck().setCards(boundaryArr);
        Boolean resultBoundary = instanceBoundary.possibleToContinue();
        assertEquals(false, resultBoundary);
        
    }
    
}
