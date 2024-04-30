package com.pluralsight.PortfolioRevisted;

public abstract class FixedAsset implements Valuable{
    private String name;
    private double marketValue;

    public FixedAsset(String name, double marketValue) {
        this.name = name;
        this.marketValue = marketValue;
    }

    @Override
    public double getValue() {
        return marketValue;
    }
}
