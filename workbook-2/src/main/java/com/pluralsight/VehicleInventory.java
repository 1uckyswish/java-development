package com.pluralsight;


import java.util.Arrays;
import java.util.Scanner;

class Vehicle{
    private long vehicleId;
    private String makeModel;
    private String color;
    private int odometerReading;
    private float price;

    public Vehicle(long vehicleId, String makeModel, String color, int odometerReading, float price) {
        this.vehicleId = vehicleId;
        this.makeModel = makeModel;
        this.color = color;
        this.odometerReading = odometerReading;
        this.price = price;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d, %,.2f",
                makeModel, color, makeModel, odometerReading, price);
    }
}

public class VehicleInventory {
    static final int MAX_CARS = 20;
    static final int STARTING_CAR_COUNT = 6;
    static Vehicle[] vehicles = new Vehicle[MAX_CARS];
    static int vehicleCount = STARTING_CAR_COUNT;

    public static void main(String[] args) {
        preloadVehicles();
        promptUser();
//        preloadVehicles();
//        listAllVehicles();

    }

    public static void preloadVehicles(){
        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);
    }

    public static void promptUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat do you want to do?");
        System.out.println("1 - List all vehicles");
        System.out.println("2 - Search by make/model");
        System.out.println("3 - Search by price range");
        System.out.println("4 - Search by color");
        System.out.println("5 - Add a vehicle");
        System.out.println("6 - Quit");
        System.out.print("Enter your command: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

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
        System.out.println("\nList of all vehicles:");
        for (int i = 0; i < vehicleCount; i++) {
//            if (i < vehicleCount && vehicles[i] != null) {
//                System.out.println(vehicles[i]);
//
//            }
            System.out.println(vehicles[i]);
        }
        askUserForRedo(scanner);
    }

    public static void searchByPriceRange(Scanner scanner) {
        System.out.print("Enter minimum car price: $");
        float minPrice = scanner.nextFloat();

        System.out.print("Enter maximum car price: $");
        float maxPrice = scanner.nextFloat();
        scanner.nextLine();
        System.out.println();
        boolean carFound = false;

        for (int i = 0; i < vehicleCount; i++) {
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

        if (!carFound) {
            System.out.println("No vehicles found within the specified price range.");
        }
        askUserForRedo(scanner);

    }


    public static void addCar(Scanner scanner){
        if (vehicleCount >= MAX_CARS) {
            System.out.println("Cannot add more vehicles. Inventory is full.");
            return;
        }
        System.out.print("Enter vehicle ID: ");
        long vehicleId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter make/model: ");
        String makeModel = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter odometer reading: ");
        int odometerReading = scanner.nextInt();

        System.out.print("Enter price: ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        vehicles[vehicleCount++] = new Vehicle(vehicleId, makeModel, color, odometerReading, price);
        System.out.println("Vehicle added successfully.");
        System.out.println("Newly added vehicle details:");
        System.out.println(vehicles[vehicleCount - 1]);
        System.out.println();
        askUserForRedo(scanner);
    }

    public static void askUserForRedo(Scanner scanner){
        System.out.println("Do you need help with anything else? (yes/no) ");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("yes")){
            promptUser();
        }else{
            System.out.println("Goodbye have a nice day");
        }
    }

    public static void searchByMakeModel(Scanner scanner) {
        System.out.print("Enter make/model to search: ");
        String makeModelInput = scanner.nextLine().toLowerCase(); // Convert input to lowercase for case-insensitive comparison
        System.out.println();
        boolean carFound = false;

        for (int i = 0; i < vehicleCount; i++) {
            String makeModel = vehicles[i].getMakeModel().toLowerCase(); // Convert vehicle make/model to lowercase for comparison
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

        if (!carFound) {
            System.out.println("No vehicles found with the given make/model.");
        }
        askUserForRedo(scanner);
    }


    public static void searchByColor(Scanner scanner) {
        System.out.print("Enter color to search: ");
        String colorInput = scanner.nextLine().toLowerCase(); // Convert input to lowercase for case-insensitive comparison
        System.out.println();
        boolean carFound = false;

        for (int i = 0; i < vehicleCount; i++) {
            String color = vehicles[i].getColor().toLowerCase(); // Convert vehicle color to lowercase for comparison
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

        if (!carFound) {
            System.out.println("No vehicles found with the given color.");
        }
        askUserForRedo(scanner);
    }


}


