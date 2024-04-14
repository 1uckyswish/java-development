package com.pluralsight;

import java.util.Arrays;

public class TestStatistics {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 65, 87, 70, 95, 81, 88, 73};
        System.out.println("High Score: " + getHighScore(scores));
        System.out.println("Low Score: " + getLowScore(scores));
        System.out.println("Average Score: " + getAverage(scores));
        System.out.println("Median Score: " + getMedian(scores));
        System.out.println("Phew! I was bracing myself for the worst, thinking I'd have to curve the test.");
        System.out.print("But hey, you all surprised me! Did better than I anticipated. No curves needed!");

    }

    public static int getHighScore(int[] scores){
        int highScore = scores[0];
        for (int score : scores) {
            if (score > highScore) highScore = score;
        }
        return highScore;
    }

    public static int getLowScore(int[] scores){
        int lowScore = scores[0];
        for (int score : scores) {
            if (score < lowScore) lowScore = score;
        }
        return lowScore;
    }

    public static int getAverage(int[] scores){
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total / scores.length;
    }

    public static int getMedian(int[] scores) {
        Arrays.sort(scores);
        if (scores.length % 2 == 0) {
            int middle1 = scores[scores.length / 2 - 1];
            int middle2 = scores[scores.length / 2];

            return (middle1 + middle2) / 2;
        }else{
            return scores[scores.length / 2];
        }

    }
}
