package com.pluralsight.Vehicles;

public class Main {
    public static void main(String[] args) {
        Car bmw = new Car("Green", 4, 4, 100);
        Moped slowRide = new Moped("Red", 1, 1, 10);
        HoverCraft martyMcfly = new HoverCraft("Yellow", 1, 0, 300);
        SemiTruck trailer = new SemiTruck("Blue", 2, 8, 1000);

        System.out.println(bmw);
        System.out.println(slowRide);
        System.out.println(martyMcfly);
        System.out.println(trailer);
    }
}
