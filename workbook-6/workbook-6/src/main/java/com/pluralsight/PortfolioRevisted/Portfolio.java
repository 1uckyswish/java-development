package com.pluralsight.PortfolioRevisted;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private String name;
    private String owner;
    private List<Valuable> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.assets = new ArrayList<>();
    }

    public double getValue() {
        double totalValue = 0;
        for (Valuable asset : assets) {
            totalValue += asset.getValue();
        }
        return totalValue;
    }

    public Valuable getMostValuable() {
        if (assets.isEmpty()) {
            return null;
        }

        Valuable mostValuable = assets.get(0);
        for (Valuable asset : assets) {
            if (asset.getValue() > mostValuable.getValue()) {
                mostValuable = asset;
            }
        }
        return mostValuable;
    }

    public Valuable getLeastValuable() {
        if (assets.isEmpty()) {
            return null;
        }

        Valuable leastValuable = assets.get(0);
        for (Valuable asset : assets) {
            if (asset.getValue() < leastValuable.getValue()) {
                leastValuable = asset;
            }
        }
        return leastValuable;
    }

    public void add(Valuable asset) {
        assets.add(asset);
    }
}
