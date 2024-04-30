package com.pluralsight.PortfolioRevisted;

public class Gold extends FixedAsset{
    private double weight;
    public Gold(double weight) {
        super("Gold", weight);
        this.weight = weight;
    }

    @Override
    public double getValue() {
        return weight;
    }
}
