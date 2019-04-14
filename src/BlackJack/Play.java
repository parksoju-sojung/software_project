/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.Scanner;

/**
 *
 * @author spark
 */
public class Play {
    
    public static void main(String[] args) {
        Game g = new Game();
        Scanner in = new Scanner(System.in);
        System.out.print("Welcome to " + g.getGameName() + 
                "!\nPlease enter your name: ");
        String name = in.next().trim();
        g.setUser(new Player(name));
        System.out.println("Hello, " + name);
        
        System.out.print("Would you like to play? (Y/N)");
        char start = in.next().toUpperCase().charAt(0);
        
        int round = 0;
        
        while (start == 'Y') {
            round++;
            System.out.println("\nRound" + round);
            g.play();
            if (g.possibleToContinue()) {
                System.out.print("Play another round? (Y/N)");
                start = in.next().toUpperCase().charAt(0);
                
            } else {
                System.out.println(g.cantContMsg);
                start = 'N';
            }
        }
        
        System.out.println("See you next time!");
    }
    
}
