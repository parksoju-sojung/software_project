package BlackJack;

public enum Suit {
	HEART ("HEART"),
	CLUB ("CLUB"),
	SPADE ("SPADE"),
        DIAMOND ("DIAMOND");
        
        private String strVal;
        
        public String getStrVal() {
            return(strVal);
        }
        
        private Suit(String s) {
            strVal = s;
        }
}

