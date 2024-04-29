package com.pluralsight.finance;

public class Jewelry extends FixedAsset {
    private double karat;

    public Jewelry(String name, double karat) {
        super(name, karat); // Using karat as the market value
        this.karat = karat;
    }

    @Override
    public double getValue() {
        return karat;
    }
}
