package com.pluralsight;

import java.util.Arrays;
import java.util.Scanner;

public class VehicleInventory {
    static final int MAX_CARS = 7;
    static final int STARTING_CAR_COUNT = 6;
    static Vehicle[] vehicles = new Vehicle[MAX_CARS];
    static int vehicleCount = STARTING_CAR_COUNT;

    public static void main(String[] args) {
        // Preload the array of vehicles at the start
        preloadVehicles();
        // Prompt the user questions
        promptUser();

    }

    public static void preloadVehicles() {
        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);
    }

    public static void promptUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Java Motor's");
        System.out.println("\nWhat would you like to do?");
        System.out.println("1 - List all current vehicles");
        System.out.println("2 - Search by Make/Model");
        System.out.println("3 - Search by price range");
        System.out.println("4 - Search by color");
        System.out.println("5 - Add a new vehicle to inventory");
        System.out.println("6 - Quit..");
        System.out.print("Enter your command: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline buffer

        // check the case from user to call function else rerun the program
        switch (choice) {
            case 1:
                listAllVehicles(scanner);
                break;
            case 2:
                searchByMakeModel(scanner);
                break;
            case 3:
                searchByPriceRange(scanner);
                break;
            case 4:
                searchByColor(scanner);
                break;
            case 5:
                addCar(scanner);
                break;
            case 6:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                promptUser();
        }
    }

    public static void listAllVehicles(Scanner scanner) {
        System.out.println("\nList of all vehicles in inventory:");
        // * loop through the array to show current vehicles. the condition checks the
        // current vehicle count.
        for (int i = 0; i < vehicleCount; i++) {
            // if (i < vehicleCount && vehicles[i] != null) {
            // System.out.println(vehicles[i]);
            //
            // }
            System.out.println(vehicles[i]);
        }
        // * prompt the user again for options after finishing up
        askUserForRedo(scanner);
    }

    public static void searchByPriceRange(Scanner scanner) {
        // * Grab price range
        System.out.print("Enter minimum car price: $");
        float minPrice = scanner.nextFloat();

        System.out.print("Enter maximum car price: $");
        float maxPrice = scanner.nextFloat();
        scanner.nextLine(); // ! eat buffer line
        System.out.println();
        // * a variable to store if car is found else it will print no car found
        boolean carFound = false;

        for (int i = 0; i < vehicleCount; i++) {
            // user getters to retrieve each objects value to test case
            // * IF test if passed it will update boolean to true
            if (vehicles[i].getPrice() >= minPrice && vehicles[i].getPrice() <= maxPrice) {
                System.out.println("Vehicle found:");
                System.out.println("Vehicle ID: " + vehicles[i].getVehicleId());
                System.out.println("Make/Model: " + vehicles[i].getMakeModel());
                System.out.println("Color: " + vehicles[i].getColor());
                System.out.println("Odometer Reading: " + vehicles[i].getOdometerReading());
                System.out.println("Price: $" + vehicles[i].getPrice());
                System.out.println();
                carFound = true;
            }

        }
        // ! if boolean is not updated and stays false it will print no vehicle found
        if (!carFound) {
            System.out.println("No vehicles found within the specified price range.");
        }
        // * prompt the user again for options after finishing up
        askUserForRedo(scanner);

    }

    public static void addCar(Scanner scanner) {
        // ! If vehicle count has reached its max the user can not continue so rerun
        // program
        if (vehicleCount >= MAX_CARS) {
            System.out.println("Cannot add more vehicles. Inventory is full.");
            askUserForRedo(scanner);
        }
        // * Ask user various car info to add to inventory
        System.out.print("Enter Vehicle ID: ");
        long vehicleId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter Make/Model: ");
        String makeModel = scanner.nextLine();

        System.out.print("Enter Color: ");
        String color = scanner.nextLine();

        System.out.print("Enter Odometer Reading: ");
        int odometerReading = scanner.nextInt();

        System.out.print("Enter Price: $");
        float price = scanner.nextFloat();
        scanner.nextLine();
        vehicles[vehicleCount++] = new Vehicle(vehicleId, makeModel, color, odometerReading, price);
        System.out.println("Vehicle Added Successfully.");
        System.out.println("Newly Added Vehicle Details:");
        System.out.println("*****************************");
        System.out.println(vehicles[vehicleCount - 1]);
        System.out.println();
        askUserForRedo(scanner);
    }

    public static void askUserForRedo(Scanner scanner) {
        System.out.println("Do you need help with anything else? (yes/no) ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            promptUser();
        } else {
            System.out.println("Thank you for visiting Java Motors EST 1995");
            System.out.println("Goodbye have a nice day");
        }
    }

    public static void searchByMakeModel(Scanner scanner) {
        // * Ask user for car model or make as string
        System.out.print("Enter Make/Model To Search: ");
        String makeModelInput = scanner.nextLine().toLowerCase(); // Convert input to lowercase for case-insensitive
        // comparison
        System.out.println();
        boolean carFound = false;

        for (int i = 0; i < vehicleCount; i++) {
            String makeModel = vehicles[i].getMakeModel().toLowerCase(); // Convert vehicle make/model to lowercase for
            // comparison
            // user getters to retrieve each objects value to test case
            // * IF test if passed it will update boolean to true
            // ** USE STRING METOD TO FIND IF MAKE CONTAINS A WORD FROM USER INPUT** //
            if (makeModel.contains(makeModelInput)) {
                System.out.println("Vehicle found:");
                System.out.println("Vehicle ID: " + vehicles[i].getVehicleId());
                System.out.println("Make/Model: " + vehicles[i].getMakeModel());
                System.out.println("Color: " + vehicles[i].getColor());
                System.out.println("Odometer Reading: " + vehicles[i].getOdometerReading());
                System.out.println("Price: $" + vehicles[i].getPrice());
                System.out.println();
                carFound = true;
            }

        }
        // ! if boolean is not updated and stays false it will print no vehicle found
        if (!carFound) {
            System.out.println("No vehicles found with the given make/model.");
        }
        // * prompt the user again for options after finishing up
        askUserForRedo(scanner);
    }

    public static void searchByColor(Scanner scanner) {
        // * Ask user for car COLOR as string
        System.out.print("Enter color to search: ");
        String colorInput = scanner.nextLine().toLowerCase(); // Convert input to lowercase for case-insensitive
        // comparison
        System.out.println();
        // * a variable to store if car is found else it will print no car found
        boolean carFound = false;

        for (int i = 0; i < vehicleCount; i++) {
            String color = vehicles[i].getColor().toLowerCase(); // Convert vehicle color to lowercase for comparison
            // user getters to retrieve each objects value to test case
            // * IF test if passed it will update boolean to true
            // ** USE STRING METOD TO FIND IF MAKE CONTAINS A WORD FROM USER INPUT** //
            if (color.contains(colorInput)) {
                System.out.println("Vehicle found:");
                System.out.println("Vehicle ID: " + vehicles[i].getVehicleId());
                System.out.println("Make/Model: " + vehicles[i].getMakeModel());
                System.out.println("Color: " + vehicles[i].getColor());
                System.out.println("Odometer Reading: " + vehicles[i].getOdometerReading());
                System.out.println("Price: $" + vehicles[i].getPrice());
                System.out.println();
                carFound = true;
            }
        }
        // ! if boolean is not updated and stays false it will print no vehicle found
        if (!carFound) {
            System.out.println("No vehicles found with the given color.");
        }
        // * prompt the user again for options after finishing up
        askUserForRedo(scanner);
    }
}