package com.pluralsight.BlackJack;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;


    //When we make a new Class of deck we make 52 cards
    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String suit : suits) {
            for (String value : values) {
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }
    }
    //Shuffle the cards
    public void shuffle() {
        Collections.shuffle(cards);
    }

    //Everytime we call deal we get the shuffled Arraylist and get the first card every time
    //If not card is able to be deal (Pull) return null
    public Card deal() {
        if (cards.size() > 0) {
            return cards.remove(0);
        } else {
            return null;
        }
    }

    //Returns the size of the amount of cards left in the deck
    public int getSize() {
        return cards.size();
    }
}
