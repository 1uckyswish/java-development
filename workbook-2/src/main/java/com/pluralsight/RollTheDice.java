package com.pluralsight;

public class RollTheDice {
    static int twoCounter = 0;
    static int fourCounter = 0;
    static int sixCounter = 0;
    static int sevenCounter = 0;
    public static void main(String[] args) {
        Dice dice = new Dice();
        playGame(dice);

    }


    public static void playGame(Dice dice) {
        int roll1 = 0;
        int roll2 = 0;
        for(int i = 1; i <= 20; i++){
            roll1 = dice.roll();
            roll2 = dice.roll();
            checkTimes(roll1, roll2);
            printDiceFormat(roll1, roll2, i);
        }

        displayCounters();

    }

    public static void displayCounters(){
        System.out.println("********** Total ********** ");
        System.out.println("Number of times 2 is rolled: " + twoCounter);
        System.out.println("Number of times 4 is rolled: " + fourCounter);
        System.out.println("Number of times 6 is rolled: " + sixCounter);
        System.out.println("Number of times 7 is rolled: " + sevenCounter);
    }

    public static void printDiceFormat(int roll1, int roll2, int index){
        int total = roll1 + roll2;
        System.out.printf("Roll %d: %d - %d  Sum: %d\n", index, roll1, roll2, total);
    }



    public static void checkTimes(int roll1, int roll2){
        switch (roll1 + roll2){
            case 2:
                twoCounter++;
                break;
            case 4:
                fourCounter++;
                break;
            case 6:
                sixCounter++;
                break;
            case 7:
                sevenCounter++;
                break;
        }
    }




    public static class Dice{
      int roll() {
        int randomNumber = (int)(Math.random() * 6) + 1;
        return randomNumber;
    }
}
}
