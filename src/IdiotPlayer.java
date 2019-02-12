/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kakas
 */
import java.util.*;
public class IdiotPlayer {
	
        public String name;
	private ArrayList<IdiotCard> hand;
        private ArrayList<IdiotCard> facedown;
	private ArrayList<IdiotCard> faceup;
        
	public IdiotPlayer(String n) {
                name = n;
		hand = new ArrayList<IdiotCard>();
		facedown = new ArrayList<IdiotCard>(3);
		faceup = new ArrayList<IdiotCard>(3);
		
	}  
        
        public String name() {
            return name;
        }
        
        public void addCard(IdiotCard card) {
            hand.add(card);
        }
        
        public IdiotCard getCard(int card) {
            return hand.get(card);
        }
        
        public IdiotCard playCard(int card) {
            return hand.remove(card);
        }
        
        public int handSize() {
            return hand.size();
        }
        
        public boolean handIsEmpty() {
            return hand.isEmpty();
        }
        
        public void clearHand() {
            hand.clear();
        }
        
        public String hand() {
            return hand.toString();
        }
        
        public void addCardToFaceUp(IdiotCard card) {
            faceup.add(card);
	}
	
        public IdiotCard getCardFaceUp(int card) {
            return faceup.get(card);
	}
        
        public IdiotCard playCardFaceUp(int card) {
            return faceup.remove(card);
	}
        
        public int faceUpSize() {
            return faceup.size();
        }
        
        public boolean faceUpIsEmpty() {
            return faceup.isEmpty();
        }
        
        public void clearFaceUp() {
            faceup.clear();
        }
        
        public String faceUp() {
            return faceup.toString();
        }
             
	public void addCardToFaceDown(IdiotCard card) {
            facedown.add(card);
	}
        
	public IdiotCard getCardFaceDown(int card) {
            return facedown.get(card);
	}
        
	public IdiotCard playCardFaceDown(int card) {
            return facedown.remove(card);
	}
        
        public int faceDownSize() {
            return facedown.size();
        }
        
        public boolean faceDownIsEmpty() {
            return facedown.isEmpty();
        }
        
        public void clearFaceDown() {
            facedown.clear();
        }
        
        public String faceDown() {
            return facedown.toString();
        }
        public boolean done() {
            return handIsEmpty() && faceUpIsEmpty() && faceDownIsEmpty();
        }
}