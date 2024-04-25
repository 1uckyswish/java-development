package com.pluralsight.Vehicles;

public class Main {
    public static void main(String[] args) {
        Car bmw = new Car();
        bmw.setColor("Green");
        bmw.setFuel(5);

        Moped slowRide = new Moped();
        slowRide.setColor("Yellow");
        slowRide.setNumberOfPassengers(1);

        HoverCraft martyMcfly = new HoverCraft();
        martyMcfly.setColor("Silver");
        martyMcfly.setFuel(100000000);

        SemiTruck trailer = new SemiTruck();
        trailer.setCargoCapacity(230);
        trailer.setColor("Gun Metal");
    }
}
