package com.pluralsight;

public class PalindromeProduct {
    public static boolean isPalindrome(int num) {
        String numStr = Integer.toString(num);
        StringBuilder reversed = new StringBuilder(numStr).reverse();
        return numStr.equals(reversed.toString());
    }

    public static void main(String[] args) {
        int largestPalindrome = 0;
        //* Store your value in a variable

        //make one loop to always do once and increment after 100
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                // if the two values times by J then check it by reversing it to check if it equals itself.
                //check if if the reversed number that is Palindromic is greater then the prior largest
                int product = i * j;
                if (isPalindrome(product) && product > largestPalindrome) {
                    largestPalindrome = product;
                }
            }
        }

        System.out.println("The largest palindrome number that is the product of two numbers from 1 through 99 is: " + largestPalindrome);
    }
}
