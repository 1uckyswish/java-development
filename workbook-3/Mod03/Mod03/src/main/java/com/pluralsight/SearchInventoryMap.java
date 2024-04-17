package com.pluralsight;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SearchInventoryMap {
    //Make HashMap global within the class
    static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void getUserInput(){
        Scanner scanner = new Scanner(System.in);
        //Gran user input to find ID
        System.out.print("Insert product ID to find product: ");
        int productId = scanner.nextInt();
        //Check if user input for the ID exist in the inventory
        if(inventory.get(productId) != null){
            System.out.println("******** PRODUCT  ********");
            System.out.println(inventory.get(productId));
            System.out.println("**************************");
        }else{
            //Inform user the ID does not exist in the inventory
            System.out.println("Sorry that ID could not be found");
            //Rerun program till ID is found
            getUserInput();
        }
        scanner.nextLine();
        //Prompt user for redo if they want to check for another ID
        promptUserRedo(scanner);
    }

    public static void promptUserRedo( Scanner scanner) {
        //Ask user if they want to continue or exit out
        System.out.print("\nDo you want to search again? ");
        String userOption = scanner.nextLine().trim().toLowerCase();
        if(userOption.equals("yes")){
            //Prompt user again for input if they want to continue
            getUserInput();
        }else if(userOption.equals("no")){
            //Prompt user a goodbye
            System.out.println("Exiting.....");
            System.out.println("Thank you come again");
            return;
        }else{
            //If input is not within the range prompt user again
            System.out.print("Sorry wrong option. Please respond with (yes/no)");
            promptUserRedo(scanner);
        }
    }

    //Try something new. instead of try catch do an EXPECTED EXCEPTION
    public static void loadInventory() throws IOException {
        //Instantiate a new reader for file Inventory.csv
        BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
        //Variable will represent our line reader
        String line;
        //Make line be our line reader but check if does not equal null
        while((line = reader.readLine()) != null){
            //Split the entries by the (|)
            String[] splitProducts = line.split(Pattern.quote("|"));
            //Pass the products to the inventory HashMap
            //Call method to make the object and pass it
            inventory.put(Integer.parseInt(splitProducts[0]), makeObject(splitProducts));
        }
        reader.close();
    }
    //Method to create an object by the array values
    public static Product makeObject(String[] splitProducts) {
        //Each value is assigned a variable
        int productId = Integer.parseInt(splitProducts[0]);
        String productName = splitProducts[1];
        float productPrice = Float.parseFloat(splitProducts[2]);
        // return a new object by its values
        return new Product(productId, productName, productPrice);
    }

    //Trying something new with the exception throwing within main
    public static void main(String[] args) throws IOException {
        //Load HashMap inventory
        loadInventory();
        //Grab user input to continue running program
        getUserInput();
    }
}
