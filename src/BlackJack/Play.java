
package BlackJack;

import java.util.Scanner;

/**
 * This class is main method for playing game. It asks user name and greets user
 * and ask if user wants to play. User can play again if want, but impossible to
 * play if it does not meet any condition given by game. Also shows what round
 * the player is playing. This main method can play any game that takes user 
 * name and have condition to continue.
 * 
 * @author Sojung Park
 */
public class Play {
    
    public static void main(String[] args) {
        //create game
        Game g = new Game();
        
        //take user input for name
        Scanner in = new Scanner(System.in);
        System.out.print("Welcome to " + g.getGameName() + 
                "!\nPlease enter your name: ");
        
        //trim string input and register the name as a player 
        String name = in.next().trim();
        g.setUser(new Player(name));
        
        //greet user
        System.out.println("Hello, " + name);
        
        char start = '\0';
        int round = 0;
        
        //ask if user wants to play
        System.out.print("Would you like to play? (Y/N)");
        start = in.next().toUpperCase().charAt(0);
        
        while (start != 'N') {
            
            //if user wants to play,
            if (start == 'Y') {
                
                //increase number of round and let user know what round of game
                //it is
                round++;
                System.out.println("\nRound" + round);
                
                //play game
                g.play();
                
                //if meets condition, pask user if want to play another round
                if (g.possibleToContinue()) {
                    System.out.print("Play another round? (Y/N)");
                    start = in.next().toUpperCase().charAt(0);
                //if game is impossible to continue, show error message and end 
                //game  
                } else {
                    System.out.println(g.cantContMsg);
                    start = 'N';
                }
            // if user gives input that is not Y or N, ask for correct input
            } else if (start != 'N') {
                System.out.println("Please enter Y or N only");
                System.out.print("Would you like to play? (Y/N)");
                start = in.next().toUpperCase().charAt(0);
            }
            
        }
        
        //say goodbye to the user at exit
        System.out.println("See you next time!");
    }
    
}
