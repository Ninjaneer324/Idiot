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

public class Pile {
    private ArrayList<IdiotCard> pile;
    public Pile() {
        pile = new ArrayList<IdiotCard>();
    }
    public IdiotCard top() {
        return pile.get(pile.size() - 1);
    }
    public int size() {
        return pile.size();
    }
    public IdiotCard get(int card) {
        return pile.get(card);
    }
    
    public void add(IdiotCard card) {
        pile.add(card);
    }
    
    public IdiotCard remove(int card) {
        return pile.remove(card);
    }
    
    public boolean top3() {
        return pile.size() >= 2 && this.top().getFace() == 3;
    }
    
    public boolean isEmpty() {
        return pile.isEmpty();
    }
    public void printUnder3() {
        int temp = 2;
        while(pile.size() - temp > -1 && pile.get(pile.size() - temp).getFace() == 3) {
            temp++;
        }
        System.out.println(pile.get(pile.size() - temp));
    }
}

