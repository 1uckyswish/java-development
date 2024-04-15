package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class WorkbookPractice {
    public static void main(String[] args) {
//        String myStr = "I love cats. Cats are very easy to love. Cats are very popular.";
//        String regex = "(?i)cats";
//        System.out.println(myStr.replaceAll(regex, "dogs"));
       try{
           FileInputStream fis = new FileInputStream("poem.txt");
           Scanner scanner = new Scanner(fis);
           String input;
            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                System.out.println(input);
            }
           scanner.close();
       }catch (Exception e){
        // display stack trace if there was an error
           e.printStackTrace();
       }
    }
}
