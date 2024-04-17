package com.pluralsight;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class SearchInventory {
    public static ArrayList<Product> inventory = getInventory();
    public static void main(String[] args){
        startProgram();
    }

    public static void startProgram(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1- List all products");
        System.out.println("2- Lookup a product by its id");
        System.out.println("3- Find all products within a price range");
        System.out.println("4- Add a new product");
        System.out.println("5- Quit the application");
        System.out.print("Enter command: ");
        String userInput = scanner.nextLine().trim().toLowerCase();
        switch (userInput){
            case "1": listAllProducts(); break;
            case "2": findID(scanner); break;
            case "3": findPrice(scanner); break;
            case "4": addProduct(scanner); break;
            case "5":
                System.out.println("Exiting....");break;
            default:
                System.out.println("Sorry please choose one of the options from above");
                startProgram();
        }

    }

    public static void addProduct(Scanner scanner){
        System.out.print("Please Enter a product ID: ");
        int newId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Please Enter the product name: ");
        String newName = scanner.nextLine();
        System.out.print("Please Enter the product price: ");
        float newPrice = scanner.nextFloat();
        inventory.add(new Product(newId, newName, newPrice));
        addToFile(new Product(newId, newName, newPrice));
        System.out.println("New product added");
        System.out.println("******** SUMMARY OF NEW PRODUCT ADDED ********");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            if(p.getId() == newId){
                System.out.printf("id: %d Product: %s - Price: $%.2f\n",
                        p.getId(), p.getName(), p.getPrice());
            }
        }

        thankUser();
    }

    public static void addToFile(Product product){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv", true));
            writer.newLine();
            writer.write(product.getId()+"|"+ product.getName()+"|"+product.getPrice());
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void thankUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thank you for using our program!");
        System.out.print("Is there anything else we can assist you with? (yes/no): ");
        String response = scanner.nextLine().toLowerCase();

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

    public static void findPrice(Scanner scanner){
        System.out.print("Please Insert Min price: ");
        float min = scanner.nextFloat();
        System.out.print("Please Insert Max price: ");
        float max = scanner.nextFloat();
        scanner.nextLine();
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            if(p.getPrice() >= min && p.getPrice() <= max){
                System.out.printf("id: %d Product: %s - Price: $%.2f\n",
                        p.getId(), p.getName(), p.getPrice());
            }
        }
        thankUser();
    }

    public static void findID(Scanner scanner) {
        System.out.print("Please Insert ID to search: ");
        int idInput = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            if(p.getId() == idInput){
                System.out.printf("id: %d Product: %s - Price: $%.2f\n",
                        p.getId(), p.getName(), p.getPrice());
            }
        }
        thankUser();
    }

    public static void listAllProducts(){
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d Product: %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
        thankUser();
    }

    public static ArrayList<Product> getInventory(){
        ArrayList<Product> inventory = new ArrayList<Product>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
            String line;
            while ((line = reader.readLine()) != null){
                String[] splitProducts = line.split(Pattern.quote("|"));
                inventory.add(new Product(Integer.parseInt(splitProducts[0]), splitProducts[1], Float.parseFloat(splitProducts[2])));
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        // Sort the inventory based on product names
        inventory.sort(Comparator.comparing(Product::getPrice));
        return  inventory;
    }
}
