package com.pluralsight.BlackJack;

public class Card {
    private String suit;
    private String value;

    //Our main class for a card
    //Suit is the sign of the card
    //Value is the worth of the card
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }
    //Retruns the sign
    public String getSuit() {
        return suit;
    }
    //Returns the value
    public String getValue() {
        return value;
    }
}
