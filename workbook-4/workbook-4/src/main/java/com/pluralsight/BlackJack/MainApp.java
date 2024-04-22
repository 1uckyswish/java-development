package com.pluralsight.BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ask the user for how many players
        //Keep the program running until more then one player is active
        int numOfPlayers = 0;
        while(true){
            System.out.print("Enter the number of players: ");
            numOfPlayers = scanner.nextInt();
            if(numOfPlayers >= 2){
                break;
            }
            System.out.println("Sorry to play this game it needs to be at-least 2 players");
        }

        scanner.nextLine();
        //Make a new Array of Hand objects (Players playing) by its length
        Hand[] hands = new Hand[numOfPlayers];
        //Loop through the array to fill
        //Ask for name and make a new set of ArrayList of zero
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.print("\nEnter player " + (i + 1) + "'s name: ");
            String playerName = scanner.nextLine();
            hands[i] = new Hand(playerName);
        }
        //Running this code makes a deck of cards worth 52 cards
        Deck deck = new Deck();
        //Shuffle mixes the cards random
        deck.shuffle();

        //We want to give each Hand(person) two cards each
        //We loop two times
        //We make a Card object that takes its constructor value
        //the deal method takes one card from the front and adds it to the current hand
        for (int i = 0; i < 2; i++) {
            for (Hand hand : hands) {
                Card card = deck.deal();
                hand.deal(card);
            }
        }


        String winner = "";
        int highestValue = 0;
        //For each player display the name its two total cards
        for (Hand hand : hands) {
            System.out.println(hand.getPlayerName() + "'s hand: " + hand);
            //Pass all the whole ArrayList of cards each user has
            int handValue = calculateHandValue(hand.getCards());
            //For each player display the name its two total cards
            System.out.println(hand.getPlayerName() + "'s hand value: " + handValue);
            if (handValue <= 21 && handValue > highestValue) {
                highestValue = handValue;
                winner = hand.getPlayerName();
            }
        }
        System.out.println("The winner is: " + winner);
    }

    private static int calculateHandValue(ArrayList<Card> cards) {
        int value = 0;
        for (Card card : cards) {
            //Get the value of each card
            String cardValue = card.getValue();
            //Check what the card value is
            //if it fits a face card it defaults t0 10
            if (cardValue.equals("J") || cardValue.equals("Q") || cardValue.equals("K")) {
                value += 10; // Face cards are worth 10
                //Set it to 11 by default
            } else if (cardValue.equals("A")) {
                // Ace can be 1 or 11, we'll handle it separately
                value += 11;
                //for non face cards and are regular numbers just add
            } else {
                value += Integer.parseInt(cardValue); // Numeric cards
            }
        }
        // Adjust for Ace if needed
        //If the value of the sum causes the player to break and he has a ACE then how about we convert his number to a 1
        for (Card card : cards) {
            //Check each card
            if (value > 21 && card.getValue().equals("A")) {
                value -= 10; // If Ace causes bust, count it as 1 instead of 11
            }
        }
        return value;
    }
}
