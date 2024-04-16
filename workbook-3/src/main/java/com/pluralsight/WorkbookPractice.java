package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class WorkbookPractice {
    public static void main(String[] args) {
//        String myStr = "I love cats. Cats are very easy to love. Cats are very popular.";
//        String regex = "(?i)cats";
//        System.out.println(myStr.replaceAll(regex, "dogs"));
//       try{
//           FileInputStream fis = new FileInputStream("poem.txt");
//           Scanner scanner = new Scanner(fis);
//           String input;
//            while(scanner.hasNextLine()){
//                input = scanner.nextLine();
//                System.out.println(input);
//            }
//           scanner.close();
//       }catch (Exception e){
//        // display stack trace if there was an error
//           e.printStackTrace();
//       }

//        try
//        {
//// create a FileReader object connected to the File
//            FileReader fileReader = new FileReader("poem.txt");
//// create a BufferedReader to manage input stream
//            BufferedReader bufReader = new BufferedReader(fileReader);
//            String input;
//// read until there is no more data
//            while((input = bufReader.readLine()) != null) {
//                System.out.println(input);
//            }
//// close the stream and release the resources
//            bufReader.close();
//        }
//        catch(IOException e) {
//// display stack trace if there was an error
//            e.printStackTrace();
//        }

//        try{
//        FileWriter writer = new FileWriter("skills.txt");
//        writer.write("Skills: \n");
//        writer.write("Git, HTML, CSS, Boostrap\n");
//        writer.write("JAVA");
//        writer.close();
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }

        try{
            FileWriter fileWriter = new FileWriter("skills.txt");
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            String text;
            for (int i = 1; i <= 10; i++) {
                text = String.format("Counting %d\n", i);
                bufWriter.write(text);
            }
            bufWriter.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
