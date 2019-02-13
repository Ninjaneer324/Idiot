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
import java.io.*;

public class Idiot2p {
    private static IdiotPlayer p1;
    private static IdiotPlayer p2;
    private static Deck deck;
    private static Pile pile;
    private static ArrayList<IdiotCard> trash;
    public static void main(String[] args) throws Exception {
         Scanner scan = new Scanner(System.in);
         boolean play = false;
         int win = -1;
         //Game itself
         do {
             //Instructions
             System.out.println("Every time it's your turn, you'll have a list printed out in front of you to represent the cards \nyou can play. "
                     + "To play a card, enter the index or position in the list the card is in.\n"
                     + "For ex: [King of Hearts, Ace of Clubs, Two of Spades]. To play Ace of Clubs, type in 2.\n"
                     + "Type 0 if you can't play any cards. Have fun! :)");
             System.out.println("");
             System.out.print("Player 1 Name: ");
             String p1_n = scan.next();
             System.out.print("\nPlayer 2 Name: ");
             String p2_n = scan.next();
             System.out.println("");
             System.out.println(p1_n+  " v. " + p2_n);
             System.out.println("");
             //Insert game
             p1 = new IdiotPlayer(p1_n);
             p2 = new IdiotPlayer(p2_n);
             deck = new Deck();
             //Shuffle deck
             deck.shuffle();
             //Play pile
             pile = new Pile();
             //Trash pile
             trash = new ArrayList<IdiotCard>();
             //Deal cards
             p1.addCard(deck.deal());
             p1.addCard(deck.deal());
             p1.addCard(deck.deal());
             
             p1.addCardToFaceDown(deck.deal());
             p1.addCardToFaceDown(deck.deal());
             p1.addCardToFaceDown(deck.deal());
             
             p1.addCardToFaceUp(deck.deal());
             p1.addCardToFaceUp(deck.deal());
             p1.addCardToFaceUp(deck.deal());
             
             p2.addCard(deck.deal());
             p2.addCard(deck.deal());
             p2.addCard(deck.deal());
             
             p2.addCardToFaceDown(deck.deal());
             p2.addCardToFaceDown(deck.deal());
             p2.addCardToFaceDown(deck.deal());
             
             p2.addCardToFaceUp(deck.deal());
             p2.addCardToFaceUp(deck.deal());
             p2.addCardToFaceUp(deck.deal());
             
            int turn = (int) (Math.random() * 2);
            do {
                if(!pile.isEmpty()) {
                    System.out.println("This is the play pile top card.");
                    System.out.println(pile.top());
                    if(pile.top3()) {
                        System.out.println("This is the cards underneath the 3(s).");
                        pile.printUnder3();
                    }
                    System.out.println("");
                }
                if(turn == 0) {
                    System.out.println("Give Device to " + p1.name() + ".");
                    System.out.println(p1.name() + ", enter the list index of the card you wanna play.");
                    if (!p1.handIsEmpty()) {
                        System.out.println(p1.name()+"'s Hand: "+p1.hand());
                        int card = scan.nextInt() - 1;
                        while(card < -1 || card >= p1.handSize()) {
                            System.out.println("I'm sorry. That index won't work. Try again.");
                            card = scan.nextInt() - 1;
                        }
                        System.out.println("");
                        if(card == -1) {
                            System.out.println(p1.name() + " can't play any cards.");
                            for(int i = pile.size() - 1; i > -1; i--) {
                                p1.addCard(pile.remove(i));
                            }
                        }
                        else {
                            IdiotCard temp = p1.getCard(card);
                            pile.add(p1.playCard(card));
                            System.out.println(p1.name() + " played " + temp+".\n\n\n");
                            if(p1.handSize() < 3 && !deck.isEmpty())
                                p1.addCard(deck.draw());
                        }
                    }
                    else if (!p1.faceUpIsEmpty()) {
                        System.out.println(p1.name() + "'s Face Up: "+p1.faceUp());
                        int card = scan.nextInt() - 1;
                        while(card < -1 || card >= p1.faceUpSize()) {
                            System.out.println("I'm sorry. That won't work. Try again.");
                            card = scan.nextInt() - 1;
                        }
                        System.out.println("");
                        if(card == -1) {
                            System.out.println(p1.name() + " can't play any cards.");
                            for(int i = pile.size() - 1; i > -1; i--) {
                                p1.addCard(pile.remove(i));
                            }
                        }
                        else {
                            IdiotCard temp = p1.getCardFaceUp(card);
                            pile.add(p1.playCardFaceUp(card));
                            System.out.println(p1.name() + " played " + temp+".\n\n\n");
                        }
                    }
                    else if(!p1.faceDownIsEmpty()) {
                        System.out.println(p1.name() + "'s Face Down: "+p1.faceDown());
                        int card = scan.nextInt() - 1;
                        while(card < -1 || card >= p1.faceDownSize()) {
                            System.out.println("I'm sorry. That index won't work. Try again.");
                            card = scan.nextInt() - 1;
                        }
                        System.out.println("");
                        if(card == -1) {
                            System.out.println(p1.name() + " can't play any cards.");
                            for(int i = pile.size() - 1; i > -1; i--) {
                                p1.addCard(pile.remove(i));
                            }
                        }
                        else {
                            IdiotCard temp = p1.getCardFaceDown(card);
                            pile.add(p1.playCardFaceDown(card));
                            System.out.println("");
                            System.out.println(p1.name() + " played " + temp+".\n\n\n");
                        }
                    }
                    turn++;
                    if(p1.done())
                        win = 1;
                }
                else {
                    System.out.println("Give Device to " + p2.name() + ".");
                    System.out.println(p2.name() + ", enter the list index of the card you wanna play.");
                    if (!p2.handIsEmpty()) {
                        System.out.println(p2.name() + "'s Hand: "+p2.hand());
                        int card = scan.nextInt() - 1;
                        while(card < - 1 || card >= p2.handSize()) {
                            System.out.println("I'm sorry. That index won't work. Try again.");
                            card = scan.nextInt() - 1;
                        }
                        System.out.println("");
                        if(card == -1) {
                            System.out.println(p2.name() + " can't play any cards.");
                            for(int i = pile.size() - 1; i > -1; i--) {
                                p2.addCard(pile.remove(i));
                            }
                        }
                        else {
                            IdiotCard temp = p2.getCard(card);
                            pile.add(p2.playCard(card));
                            System.out.println(p2.name() + " played " + temp + ".\n\n\n");
                            if(p1.handSize() < 3 && !deck.isEmpty())
                                p1.addCard(deck.draw());
                        }
                    }
                    else if (!p2.faceUpIsEmpty()) {
                        System.out.println(p2.name() + "'s Face Up: "+p2.faceUp());
                        int card = scan.nextInt() - 1;
                        while(card < -1 || card >= p2.faceUpSize()) {
                            System.out.println("I'm sorry. That index won't work. Try again.");
                            card = scan.nextInt() - 1;
                        }
                        System.out.println("");
                        if(card == -1) {
                            System.out.println(p2.name() + " can't play any cards.");
                            for(int i = pile.size() - 1; i > -1; i--) {
                                p2.addCard(pile.remove(i));
                            }
                        }
                        else {
                            IdiotCard temp = p2.getCardFaceUp(card);
                            pile.add(p2.playCardFaceUp(card));
                            System.out.println(p2.name() + " played " + temp + ".\n\n\n");
                        }
                    }
                    else if(!p2.faceDownIsEmpty()) {
                        System.out.println(p2.name() + "'s Face Down: "+p2.faceDown());
                        int card = scan.nextInt() - 1;
                        while(card < -1 || card >= p2.faceDownSize()) {
                            System.out.println("I'm sorry. That index won't work. Try again.");
                            card = scan.nextInt() - 1;
                        }
                        System.out.println("");
                        if(card == -1) {
                            System.out.println(p2.name() + " can't play any cards.");
                            for(int i = pile.size() - 1; i > -1; i--) {
                                p2.addCard(pile.remove(i));
                            }
                        }
                        else {
                            IdiotCard temp = p2.getCardFaceDown(card);
                            pile.add(p2.playCardFaceDown(card));
                            System.out.println(p2.name() + " played " + temp + ".\n\n\n");
                            p2.addCard(deck.draw());
                        }
                    }
                    turn--;   
                    if(p2.done())
                        win = 2;
                }
            }while(!(win == 2 || win == 1));
                 //End of game print outs
                 if(win == 1) {
                     System.out.println("Congratulations " + p1.name() + "!!!\nYou did your best " + p2.name()+"\n");
                 }
                 else {
                     System.out.println("Congratulations " + p2.name() + "!!!\nYou did your best " + p1.name()+"\n");
                 }
                 play = false;
                 System.out.print("Play again? Type \"Y\" for yes or \"N\" for no: ");
                 String ans = scan.next().toUpperCase();
                 if(ans.equals("Y")) {
                     play = true;
                 }
                 System.out.print("\n\n\n\n");
         }while(play);
         
    }

    public static boolean isSpecial(IdiotCard c) {
        return c.getFace() == 2 || c.getFace() == 3 || c.getFace() == 7 || c.getFace() == 10;
    }
    
    public static boolean valid(IdiotCard top, IdiotCard play) {
        if(play.getFace() == 10) {
            for(int i = pile.size() - 1; i > -1; i--)
                trash.add(pile.remove(i));
            trash.add(play);
            return true;
        }
        if(top.getFace() == 2 || isSpecial(play))
            return true;
        if(pile.top3()) {
            int temp = 2;
            while(pile.size() - temp > -1 && pile.get(pile.size() - temp).getFace() == 3) {
                temp++;
            }
            if (pile.size() - temp <= -1)
                temp = pile.size();
            IdiotCard t = pile.get(pile.size() - temp);
            if(!isSpecial(t) && t.getFace() <= play.getFace())
                    return true;
            else if(isSpecial(t)) {
                switch(t.getFace()) {
                    case 2:
                    case 3:
                        return true;
                    case 7:
                        return play.getFace() <= 7;
                }
            }
        }
        return top.getFace() <= play.getFace();
    }
    
}