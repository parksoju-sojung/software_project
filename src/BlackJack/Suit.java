package BlackJack;

/**
 * enum that represents Suit of card
 * 
 * @author Sojung Park
 */
public enum Suit {
	HEART ("HEART"),
	CLUB ("CLUB"),
	SPADE ("SPADE"),
        DIAMOND ("DIAMOND");
        
        private String strVal;
        
        /**
         * String value of the suit of card
         * 
         * @return 
         */
        public String getStrVal() {
            return(strVal);
        }
        
        /**
         * create suit enum
         * 
         * @param s String value of Suit
         */
        private Suit(String s) {
            strVal = s;
        }
}

