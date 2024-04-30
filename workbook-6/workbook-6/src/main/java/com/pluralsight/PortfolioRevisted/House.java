package com.pluralsight.PortfolioRevisted;

public class House extends FixedAsset{
    private int yearBuilt;
    private int sqaureFeet;
    private int bedrooms;

    public House(String name, int yearBuilt, int sqaureFeet, int bedrooms) {
        super("House", 0);
        this.yearBuilt = yearBuilt;
        this.sqaureFeet = sqaureFeet;
        this.bedrooms = bedrooms;
    }

    // Create the override getValue method.
    @Override
    public double getValue() {
        // Calculate the total value.
        return super.getValue() + (yearBuilt * sqaureFeet * bedrooms);
    }
}
