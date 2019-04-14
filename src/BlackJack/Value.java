package BlackJack;

public enum Value {
    ACE (11, "Ace"),
    TWO (2, "2"), 
    THREE (3, "3"), 
    FOUR (4, "4"), 
    FIVE (5, "5"), 
    SIX (6, "6"), 
    SEVEN (7, "7"), 
    EIGHT (8, "8"),        
    NINE (9, "9"), 
    TEN (10, "10"), 
    JACK (10, "Jack"), 
    QUEEN (10, "Queen"), 
    KING (10, "King");
    
    private String strVal;
    private int numVal;
    
    public String getStrVal() {
        return strVal;
    }
    public int getNumVal() {
        return numVal;
    }
    
    private Value(int n, String s) {
        strVal = s;
        numVal = n;
    }
}