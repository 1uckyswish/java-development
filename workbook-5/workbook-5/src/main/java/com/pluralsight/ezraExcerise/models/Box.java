package com.pluralsight.ezraExcerise.models;

public class Box extends Rectangle{
    private double height;
    public Box(double length, double width, double height) {
        super(length, width);
        this.height = height;
    }

    @Override
    public double getArea() {
        // Surface area of a box
        return 2 * (length * width + length * height + width * height);
    }
}
