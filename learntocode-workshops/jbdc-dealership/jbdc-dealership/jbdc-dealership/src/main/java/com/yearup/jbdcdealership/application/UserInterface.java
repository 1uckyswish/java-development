package com.yearup.jbdcdealership.application;

import com.yearup.jbdcdealership.data.DealerDao;
import com.yearup.jbdcdealership.models.Vehicle;
import com.yearup.jbdcdealership.utilityMethods.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.yearup.jbdcdealership.utilityMethods.UtilityMethods.*;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private DealerDao dealerDao;
    private List<Vehicle> vehicles;

    public UserInterface(DealerDao dealerDao) {
        this.dealerDao = dealerDao;
    }

    /**
     * Method hold the User Display screen for them to navigate the Dealership and
     * its inventory
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        // Create a boolean flag to check if user clicked the correct choice given
        boolean exit = false;
        // If not true, continue
        while (!exit) {
            // Display menu
            // Read user command
            String choice = displayHomeScreen();

            // Process user command
            // This will keep the program running unless the user types 0
            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "10":
                    processUpdateVehicleRequest();
                    break;
                case "11":
                    processRecordOfSaleOrLease();
                    break;
                case "12":
                    adminDisplay();
                    break;
                case "0":
                    System.out.println("Thanks for Visiting...");
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.print("\nInvalid choice. Please try again.\n");
                    break;
            }
        }

        // Close the scanner properly
        scanner.close();
    }

    private void processUpdateVehicleRequest() {
        // Pass the question and scanner into the method to validate the correct input
        // data Type
        String vinChoice = validateStringInput(scanner, "Please enter the VIN of the vehicle to update: ");
        int year = validateIntInput(scanner, "Please enter the year of the vehicle: ");
        scanner.nextLine(); // Consume newline character
        String make = validateStringInput(scanner, "Please enter the make of the vehicle: ");
        String model = validateStringInput(scanner, "Please enter the model of the vehicle: ");
        String vehicleType = validateStringInput(scanner, "Please enter the type of the vehicle (e.g., sedan, SUV): ");
        String color = validateStringInput(scanner, "Please enter the color of the vehicle: ");
        int odometer = validateIntInput(scanner, "Please enter the current mileage of the vehicle: ");
        double price = validateDoubleInput(scanner, "Please enter the price of the vehicle for sale: ");
        scanner.nextLine(); // Consume newline character
        // Pass all the variable to make a new Vehicle using its constructor
        Vehicle newVehicleMade = new Vehicle(vinChoice, year, make, model, vehicleType, color, odometer, price, "No");
        dealerDao.update(vinChoice, newVehicleMade);
        // Show the new Vehicle they added
        System.out.println("==== Vehicle Updated ====");
        System.out.println(newVehicleMade);
    }

    private void processRemoveVehicleRequest() {
        // Pass the question and scanner into the method to validate the correct input
        // data Type
        String vinChoice = validateStringInput(scanner, "Please enter the VIN of the vehicle to remove: ");
        boolean deleted = dealerDao.delete(vinChoice);

        if (deleted) {
            // Deletion was successful
            System.out.println("Vehicle with VIN " + vinChoice + " was successfully removed from database.");
        } else {
            // Deletion failed (vehicle not found or other error)
            System.out.println("Failed to remove vehicle with VIN " + vinChoice + ".");
        }
    }

    private void processAddVehicleRequest() {
        String vin = validateStringInput(scanner, "Please enter the VIN # of the vehicle: ");
        int year = validateIntInput(scanner, "Please enter the year of the vehicle: ");
        scanner.nextLine(); // Consume newline character
        String make = validateStringInput(scanner, "Please enter the make of the vehicle: ");
        String model = validateStringInput(scanner, "Please enter the model of the vehicle: ");
        String vehicleType = validateStringInput(scanner, "Please enter the type of the vehicle (e.g., sedan, SUV): ");
        String color = validateStringInput(scanner, "Please enter the color of the vehicle: ");
        int odometer = validateIntInput(scanner, "Please enter the current mileage of the vehicle: ");
        double price = validateDoubleInput(scanner, "Please enter the price of the vehicle for sale: ");
        scanner.nextLine(); // Consume newline character

        // Pass all the variable to make a new Vehicle using its constructor
        Vehicle newVehicleMade = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, "No");
        dealerDao.create(newVehicleMade);
        // Show the new Vehicle they added
        System.out.println("==== New Vehicle Added ====");
        System.out.println(newVehicleMade);
    }

    private void processGetAllVehiclesRequest() {
        System.out.println("\n==== All Vehicle's In Inventory ====");
        vehicles = dealerDao.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.print("Please specify the type of vehicle you are looking for\n");
        // When it returns make it lowerCase for the easier checking below
        String typeChoice = validateStringInput(scanner, "Please enter the type of vehicle: ").toLowerCase();
        vehicles = dealerDao.getByType(typeChoice);
        // If the Arraylist values returned are true within the range, display them all
        if (!vehicles.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Type ====");
            // Passing the ArrayLost that hold the values pass it to a method that iterates
            // through it and displays it
            displayVehicles(vehicles);
        } else {
            // if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available for the specified type ===\n");
        }
    }

    private void processGetByMileageRequest() {
        System.out.print("Please specify the desired mileage for a vehicle\n");
        int minMileageChoice = validateIntInput(scanner, "Please enter the MIN desired mileage: ");
        int maxmileageChoice = validateIntInput(scanner, "Please enter the MAX desired mileage: ");
        scanner.nextLine(); // Consume newline buffer
        // Pass the value the user submitted to the method of the dealership to do the
        // checking
        vehicles = dealerDao.getByMileage(minMileageChoice, maxmileageChoice);
        // If the Arraylist values returned are true within the range, display them all
        if (!vehicles.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Mileage ====");
            // Passing the ArrayLost that hold the values pass it to a method that iterates
            // through it and displays it
            displayVehicles(vehicles);
        } else {
            // if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available with the specified mileage range ===\n");
        }
    }

    private void processGetByColorRequest() {
        System.out.print("Please specify the color of the car you are looking for\n");
        // When it returns make it lowerCase for the easier checking below
        String colorChoice = validateStringInput(scanner, "Please enter the car color: ").toLowerCase();
        // Pass the value the user submitted to the method of the dealership to do the
        // checking
        vehicles = dealerDao.getByColor(colorChoice);
        // If the Arraylist values returned are true within the range, display them all
        if (!vehicles.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Color ====");
            // Passing the ArrayLost that hold the values pass it to a method that iterates
            // through it and displays it
            displayVehicles(vehicles);
        } else {
            // if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available in the specified color ====\n");
        }
    }

    private void processGetByYearRequest() {
        System.out.print("Please specify the year you are looking for\n");
        int yearChoice = validateIntInput(scanner, "Please enter the year: ");
        scanner.nextLine(); // Consume newline buffer
        vehicles = dealerDao.getByYear(yearChoice);
        if (!vehicles.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Year ====");
            // Passing the ArrayList that hold the values pass it to a method that iterates
            // through it and displays it
            displayVehicles(vehicles);
        } else {
            // if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available for the specified year ====\n");
        }

    }

    private void processGetByMakeModelRequest() {
        System.out.print("Please specify the make: ");
        String makeName = validateStringInput(scanner, "Please enter the make name: ").toLowerCase();

        System.out.print("Please specify the model: ");
        String modelName = validateStringInput(scanner, "Please enter the model name: ").toLowerCase();

        vehicles = dealerDao.getByMakeModel(makeName, modelName);
        // If the Arraylist values returned are true within the range, display them all
        if (!vehicles.isEmpty()) {
            // Passing the ArrayLost that hold the values pass it to a method that iterates
            // through it and displays it
            System.out.println("\n==== Vehicle Results By Make And Model ====");
            displayVehicles(vehicles);
        } else {
            // if no values are found inform user
            System.out.println(
                    "\n=== Sorry, there are no vehicles available matching the specified make and model name ===\n");
        }
    }

    private void processGetByPriceRequest() {
        System.out.println("\nPlease enter the price range you're interested in");
        double minPrice = validateDoubleInput(scanner, "Please enter the minimum price: ");
        double maxPrice = validateDoubleInput(scanner, "Please enter the maximum price: ");
        scanner.nextLine();
        vehicles = dealerDao.getByPrice(minPrice, maxPrice);
        // If the Arraylist values returned are true within the range, display them all
        if (!vehicles.isEmpty()) {
            System.out.println("\n==== Vehicle Results By Price ====");
            // Passing the ArrayLost that hold the values pass it to a method that iterates
            // through it and displays it
            displayVehicles(vehicles);
        } else {
            // if no values are found inform user
            System.out.println("\n==== Sorry, there are no vehicles available within the specified price range ===\n");
        }
    }


    private void adminDisplay() {
        //Greet user and collect login info
        System.out.println("\nWelcome to the Contract Administration System!\nPlease log in to proceed.");
        System.out.print("Enter your admin username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter your admin password: ");
        String password = scanner.nextLine().trim();
        if (!password.equalsIgnoreCase("ABC123")) {
            System.out.println("\nIncorrect password. Access denied.");
            System.out.println("Returning back home...\n");
        }else {
            System.out.println("\nWelcome back, " + username + "!");
            System.out.println("Loading the Contract Administration System...\n");

            //Instantiate an admin Object to access the method to display the options to choose from
            AdminUserInterface admin = new AdminUserInterface(dealerDao);
            admin.display();
            String choice = scanner.nextLine().trim();
            // Display the chosen contracts
            switch (choice) {
                case "1":
                    admin.viewAllContracts();
                    break;
                case "2":
                    admin.viewSaleContracts();
                    break;
                case "3":
                    admin.viewLeaseContracts();
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    System.out.println("Returning to the main menu...\n");
            }
        }
    }

    private void processRecordOfSaleOrLease() {
        System.out.println();
        String saleOrLease = validateStringInput(scanner, "Would you like to Sell or Lease Vehicle: ");
        if(saleOrLease.equalsIgnoreCase("Sell")){
            String vin = validateStringInput(scanner, "Please enter the VIN # of the vehicle: ");
            dealerDao.sellCar(vin);
        } else if (saleOrLease.equalsIgnoreCase("Lease")) {
            String vin = validateStringInput(scanner, "Please enter the VIN # of the vehicle: ");
            dealerDao.leaseCar(vin);
        }else{
            System.out.println("\n~~~ Sorry wrong choice. " + saleOrLease + " is an Invalid entry ~~~\n");
        }

    }

    public String displayHomeScreen(){
        System.out.println("==== Dealership Menu ====");
        System.out.println("1. Get vehicles by price");
        System.out.println("2. Get vehicles by make and model");
        System.out.println("3. Get vehicles by year");
        System.out.println("4. Get vehicles by color");
        System.out.println("5. Get vehicles by mileage");
        System.out.println("6. Get vehicles by vehicle type");
        System.out.println("7. Get all vehicles");
        System.out.println("8. Add vehicle");
        System.out.println("9. Remove vehicle");
        System.out.println("10. Update vehicle");
        System.out.println("11. Sell or Lease a vehicle");
        System.out.println("12. Admin Portal");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextLine().trim();
    }

    /**
     * Displays the details of all vehicles in the inventory.
     * Iterates through the list of vehicles passed as a parameter.
     * Print the details of each vehicle to the console.
     *
     * @param vehicles ArrayList of vehicles to be displayed
     */
    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}
