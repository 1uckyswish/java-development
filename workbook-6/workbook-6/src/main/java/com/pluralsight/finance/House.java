package com.pluralsight.finance;

public class House extends FixedAsset {
    private int yearBuilt;
    private int squareFeet;
    private int bedrooms;

    public House(String name, double marketValue, int yearBuilt, int squareFeet, int bedrooms) {
        super(name, marketValue);
        this.yearBuilt = yearBuilt;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
    }

    @Override
    public double getValue() {
        // Calculate the value based on the provided attributes
        double value = calculateValue();
        return value;
    }

    private double calculateValue() {
        int currentYear = java.time.Year.now().getValue();
        int age = currentYear - yearBuilt;
        double ageDepreciation = 1.0 - (age * 0.02);

        double squareFootageValue = squareFeet * 100;
        double bedroomsValue = bedrooms * 5000;

        double estimatedValue = ageDepreciation * (squareFootageValue + bedroomsValue);

        return estimatedValue;
    }
}
