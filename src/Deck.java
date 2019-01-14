import java.util.*;
public class Deck {

    private static final int NUM_FACES = 13;
    private static final int NUM_SUITS = 4;
    private static final int NUM_CARDS = NUM_FACES * NUM_SUITS;

    private static final String[] SUITS = { "Clubs", "Spades", "Diamonds", "Hearts" };

    private ArrayList<IdiotCard> deck;

    

    public Deck() {
        // Instantiate deck and fill it with cards. Loops are your friend.
        //deck = new ArrayList<IdiotCard>(NUM_CARDS);
    	this.fillDeck();
    }
    
 // Shuffle deck
    public void shuffle() {
    	Collections.shuffle(deck);	 
    }

    public void fillDeck() {
    	deck = new ArrayList<IdiotCard>(NUM_CARDS);
    	for(int y = 0; y  < NUM_SUITS; y++) {
            for(int x = 1; x <= NUM_FACES; x++) {
                IdiotCard card = new IdiotCard(x, SUITS[y]);
                    deck.add(card);  		
            }	
    	}
        IdiotCard card = new IdiotCard(0, "Joker");
    	deck.add(card);
    	deck.add(card);
    }
    
    public IdiotCard deal() {
    	return deck.remove(deck.size() - 1);
    }
    
    public IdiotCard draw() {
        return deck.remove(deck.size() - 1);
    }

    public boolean hasCards() {
    	return !deck.isEmpty();
    }
    public int getSize() {
    	return deck.size();
    }
    public String toString() {
        return deck.toString();
    } 

}