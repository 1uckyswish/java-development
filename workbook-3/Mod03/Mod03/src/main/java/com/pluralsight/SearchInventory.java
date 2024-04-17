package com.pluralsight;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class SearchInventory {
    public static ArrayList<Product> inventory = getInventory();

    public static void main(String[] args) {
        // Run Program
        startProgram();
    }

    public static void startProgram() {
        // Grab input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1- List all products");
        System.out.println("2- Lookup a product by its id");
        System.out.println("3- Find all products within a price range");
        System.out.println("4- Add a new product");
        System.out.println("5- Quit the application");
        System.out.print("Enter command: ");
        String userInput = scanner.nextLine().trim().toLowerCase();
        // Check user input else return program
        switch (userInput) {
            case "1":
                listAllProducts();
                break;
            case "2":
                findID(scanner);
                break;
            case "3":
                findPrice(scanner);
                break;
            case "4":
                addProduct(scanner);
                break;
            case "5":
                System.out.println("Exiting....");
                break;
            default:
                System.out.println("Sorry please choose one of the options from above");
                startProgram();
        }

    }

    // Method for adding product
    public static void addProduct(Scanner scanner) {
        // Grab user info for new product
        System.out.print("Please Enter a product ID: ");
        int newId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Please Enter the product name: ");
        String newName = scanner.nextLine();
        System.out.print("Please Enter the product price: ");
        float newPrice = scanner.nextFloat();
        // Add data to ArrayList by appending it
        inventory.add(new Product(newId, newName, newPrice));
        // Pass new object to get applied to CSV
        addToFile(new Product(newId, newName, newPrice));
        System.out.println("New product added");
        System.out.println("******** SUMMARY OF NEW PRODUCT ADDED ********");
        // Print each product
        for (int i = 0; i < inventory.size(); i++) {
            // Grab the inventory by the index
            Product p = inventory.get(i);
            if (p.getId() == newId) {
                System.out.printf("id: %d Product: %s - Price: $%.2f\n",
                        p.getId(), p.getName(), p.getPrice());
            }
        }
        // Return the user to exit options
        thankUser();
    }

    // Method to add file to CSV and pass a Class
    public static void addToFile(Product product) {
        try {
            // Make a writer passing the CSV. Apply true for it not override current
            // inventory
            BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv", true));
            // Make a new line
            writer.newLine();
            // Write to file in certain formatt
            writer.write(product.getId() + "|" + product.getName() + "|" + product.getPrice());
            // Close program
            writer.close();
            // Catch expected errors
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to return user prompt to exit
    public static void thankUser() {
        Scanner scanner = new Scanner(System.in);
        // Great user
        System.out.println("Thank you for using our program!");
        System.out.print("Is there anything else we can assist you with? (yes/no): ");
        // Take user input
        String response = scanner.nextLine().toLowerCase();
        // Check user choice
        if (response.equals("yes")) {
            startProgram();
        } else if (response.equals("no")) {
            System.out.println("Thank you, come back again.");
            return;
        } else {
            System.out.println("Invalid response. Please enter 'yes' or 'no'.");
            startProgram();
        }
    }

    // Find product price. Pass in Product object
    public static void findPrice(Scanner scanner) {
        // Grab user input. MAX AND MIN
        System.out.print("Please Insert Min price: ");
        float min = scanner.nextFloat();
        System.out.print("Please Insert Max price: ");
        float max = scanner.nextFloat();
        scanner.nextLine();
        // Loop through the array list
        for (int i = 0; i < inventory.size(); i++) {
            // Get Object by index from the arrayList
            Product p = inventory.get(i);
            if (p.getPrice() >= min && p.getPrice() <= max) {
                // Grab product objects values with its getters
                System.out.printf("id: %d Product: %s - Price: $%.2f\n",
                        p.getId(), p.getName(), p.getPrice());
            }
        }
        // Return the user to exit options
        thankUser();
    }

    // Find product ID. Pass in Product object
    public static void findID(Scanner scanner) {
        // Grab user input. ID
        System.out.print("Please Insert ID to search: ");
        int idInput = scanner.nextInt();
        scanner.nextLine();
        // Loop through the array list
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            if (p.getId() == idInput) {
                // Grab product objects values with its getters
                System.out.printf("id: %d Product: %s - Price: $%.2f\n",
                        p.getId(), p.getName(), p.getPrice());
            }
        }
        // Return the user to exit options
        thankUser();
    }

    // List all the products in the arrayList based on its index
    public static void listAllProducts() {
        // Loop through the array list
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d Product: %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
        // Return the user to exit options
        thankUser();
    }

    public static ArrayList<Product> getInventory() {
        // Make an ArrayList of the data type object Product
        ArrayList<Product> inventory = new ArrayList<Product>();
        try {
            // Make a reader to parse the CSV and read it line by line
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
            // Line is the current line it reads. Default its set to null
            String line;
            // If the line does not equal null then read
            while ((line = reader.readLine()) != null) {
                // Grab array of info split by the (|)
                String[] splitProducts = line.split(Pattern.quote("|"));
                // Add to ArrayList by making a new object of Product passing splitProducts
                // array values by index
                // Convert string values to data type specific based on the constructor
                inventory.add(new Product(Integer.parseInt(splitProducts[0]), splitProducts[1],
                        Float.parseFloat(splitProducts[2])));
            }
            reader.close();
            // Catch expected errors
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Sort the inventory based on product names
        inventory.sort(Comparator.comparing(Product::getPrice));
        // When method is called it will return ArrayList
        return inventory;
    }
}
