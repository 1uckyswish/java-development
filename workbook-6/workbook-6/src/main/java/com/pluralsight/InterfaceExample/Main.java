package com.pluralsight.InterfaceExample;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog(1, "Rex");
        dog.makeNoise();
        Cat cat = new Cat(2, "Minnie");
        cat.makeNoise();
        Car car = new Car();
        car.makeNoise();

        makeTheNoise(car);

    }
    //genric methods
    private static void makeTheNoise(MakesNoise makesNoise){
        makesNoise.makeNoise();
    }
}
