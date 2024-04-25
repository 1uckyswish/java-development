package com.pluralsight.Vehicles;

public class Main {
    public static void main(String[] args) {
        Car bmw = new Car("Green", 4, 4, 100);
        System.out.println(bmw);
        Moped slowRide = new Moped("Red", 1, 1, 10);
        System.out.println(slowRide);
        HoverCraft martyMcfly = new HoverCraft("Yellow", 1, 0, 300);
        System.out.println(martyMcfly);
        SemiTruck trailer = new SemiTruck("Blue", 2, 8, 1000);
        System.out.println(trailer);

        System.out.println(bmw instanceof Vehicle);
        System.out.println(slowRide.getClass());

        String name = "noel";
        System.out.println(name.hashCode());
    }
}
