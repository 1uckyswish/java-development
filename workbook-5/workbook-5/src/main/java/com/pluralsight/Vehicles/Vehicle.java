package com.pluralsight.Vehicles;

public class Vehicle {
    private String color;
    private int numberOfPassengers;
    private int cargoCapacity;
    private int fuel;

    public Vehicle(String color, int numberOfPassengers, int cargoCapacity, int fuel) {
        System.out.println("New Vehicle Made :)");
        this.color = color;
        this.numberOfPassengers = numberOfPassengers;
        this.cargoCapacity = cargoCapacity;
        this.fuel = fuel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }


    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "color='" + color + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                ", cargoCapacity=" + cargoCapacity +
                ", fuel=" + fuel +
                '}';
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
