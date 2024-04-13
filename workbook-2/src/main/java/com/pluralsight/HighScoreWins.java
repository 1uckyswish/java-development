package com.pluralsight;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HighScoreWins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a game score (ex. Home:Visitor|21:9):  ");
        String userScore = scanner.nextLine().trim();
        String[] pipeSplit = splitWordByQuote(userScore, "|");
        String[] teamSection = splitWordByQuote(pipeSplit[0], ":");
        String[] scoreSection = splitWordByQuote(pipeSplit[1], ":");
        returnWinner(scoreSection[0], scoreSection[1], teamSection);
    }

    public static String[] splitWordByQuote(String value, String quote){
        return value.split(Pattern.quote(quote));
    }

    public static int convertStringToInt(String wordedNumber){
        return Integer.parseInt(wordedNumber);
    }
    
    public static void returnWinner(String numberOne, String numberTwo, String[] teamSection){
        if(convertStringToInt(numberOne) > convertStringToInt(numberTwo)){
            System.out.println("Winner: " + teamSection[0]);
        } else if (convertStringToInt(numberOne) < convertStringToInt(numberTwo)) {
            System.out.println("Winner: " + teamSection[1]);
        }else{
            System.out.println("Its a Tie!");
        }
    }
}
