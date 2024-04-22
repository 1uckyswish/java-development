package com.pluralsight.BlackJack;

import java.util.ArrayList;

public class Hand {
    //Array list of cars the user will have
    private ArrayList<Card> cards;
    //User name associated with the cards
    private String playerName;

    //construct a new hand aka player
    public Hand(String playerName) {
        this.playerName = playerName;
        cards = new ArrayList<>();
    }
    //Add a card to the hand list by passing the card Class to it as its value
    public void deal(Card card) {
        cards.add(card);
    }
    //returns the size of the arrayList
    public int getSize() {
        return cards.size();
    }
    //returns the player name
    public String getPlayerName() {
        return playerName;
    }

    //Loop through the Arraylist to append a values of the two cards
    @Override
    public String toString() {
        StringBuilder handString = new StringBuilder();
        for (Card card : cards) {
            handString.append(card.getValue()).append(" ").append(card.getSuit()).append(", ");
        }
        return handString.toString();
    }

    //Returns the whole cards ArrayList
    public ArrayList<Card> getCards() {
        return cards;
    }
}
