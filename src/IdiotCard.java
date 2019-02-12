
public class IdiotCard {
	

    public static final String FACES[] = { "Joker", "Ace", "Two", 
    					"Three", "Four", "Five", 
                                          "Six", "Seven", "Eight", 
    		                                "Nine", "Ten", "Jack", 
    		                                   "Queen", "King"};

    private String suit = "";
    private int face = 0;
    
    public IdiotCard() {
        face = 1;
        suit = "Spades";
    }
    
    public IdiotCard(int f, String s ) {
    	//set variables
        face = f;
        suit = s;
    }
    
    public int getFace() {
        return face;
    }
    
    public String getSuit() {
        return suit;
    }
    
    public int getValue() {
	int val = face;
	if(val == 1) {
            val = 14;
        }
	return val;
    }
   
    public boolean isSpecial() {
        return face == 2 || face == 3 || face == 7 || face == 0 || face == 10;
    }

    public String toString() {
    	if(face == 0)
            return FACES[face];
        return FACES[ face ] + " of " + suit;
    }
}