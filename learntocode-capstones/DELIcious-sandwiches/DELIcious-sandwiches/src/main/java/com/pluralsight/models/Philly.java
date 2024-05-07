/**
 * Represents a signature Philly sandwich order, extending the Sandwich class and implementing the ToppingsManipulate interface.
 * This class provides specific configurations and operations for creating a Philly sandwich order.
 */
package com.pluralsight.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Philly extends Sandwich implements ToppingsManipulate {

    /**
     * Constructs a Philly sandwich object with default values for size, bread type,
     * and toasting preference,
     * and sets specific prices for meat, cheese, and overall sandwich.
     * Initializes regular and premium toppings for the Philly sandwich.
     */
    public Philly() {
        super("8", "White", true); // Call the constructor of the parent class with default values
        setSizePrice(7.00);
        setToasted(true);
        setMeatPrice(2.00);
        setCheesePrice(1.50);
        setExtraMeat(false);
        setExtraMeatPrice(0.00);
        setExtraCheese(false);
        setExtraCheesePrice(0.00);
        setHasMeat(true);
        setHasCheese(true);
        setPrice(10.50);
        // Create new ArrayList instances for regular and premium toppings
        List<String> regularToppings = new ArrayList<>(Arrays.asList("Peppers", "Mayo"));
        List<String> premiumToppings = new ArrayList<>(Arrays.asList("Steak", "American"));

        // Set the regular and premium toppings
        this.setRegularToppings(regularToppings);
        this.setPremiumToppings(premiumToppings);
    }

    /**
     * Removes a specified regular topping from the Philly sandwich.
     *
     * @param topping The regular topping to be removed.
     */
    public void removeRegularTopping(String topping) {
        List<String> regularToppings = new ArrayList<>(getRegularToppings());
        if (regularToppings.contains(topping)) {
            regularToppings.remove(topping);
            setRegularToppings(regularToppings);
        }
    }

    /**
     * Removes a specified premium topping from the Philly sandwich.
     *
     * @param topping The premium topping to be removed.
     */
    public void removePremiumTopping(String topping) {
        List<String> premiumToppings = new ArrayList<>(getPremiumToppings());
        if (premiumToppings.contains(topping)) {
            premiumToppings.remove(topping);
            setPremiumToppings(premiumToppings);
        }
    }

    /**
     * Overrides the toString method to provide a formatted string representation of
     * the Philly sandwich object.
     *
     * @return A string representation of the Philly sandwich object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|+--------------------------------------+\n");
        sb.append("| Signature Philly Special\n"); // Add the header here
        sb.append("|+--------------------------------------+\n");
        sb.append("|Bread Choice: ").append(getType()).append("\n");
        sb.append("|Bread Size: ").append(getSize()).append(" inch\n");
        sb.append("|Base Price: $").append(String.format("%.2f", getSizePrice())).append("\n");
        sb.append("|Toasted: ").append(isToasted() ? "Yes" : "No").append("\n");

        if (!getRegularToppings().isEmpty()) {
            sb.append("|Regular Toppings:\n");
            for (String topping : getRegularToppings()) {
                if (!topping.equals("4oz Au Jus sauce")) {
                    sb.append("|- ").append(capitalizeFirstLetter(topping)).append("\n");
                }
            }
        }

        if (!getPremiumToppings().isEmpty()) {
            sb.append("|Premium Toppings:\n");
            for (String topping : getPremiumToppings()) {
                sb.append("|- ").append(capitalizeFirstLetter(topping)).append("\n");
            }
        }

        sb.append("|Toppings cost:\n");
        if (isHasMeat()) {
            sb.append("|- Meat price: $").append(String.format("%.2f", getMeatPrice())).append("\n");
            if (isExtraMeat()) {
                sb.append("|  - Extra Meat Cost: $").append(String.format("%.2f", getExtraMeatPrice())).append("\n");
            }
        }
        if (isHasCheese()) {
            sb.append("|- Cheese price: $").append(String.format("%.2f", getCheesePrice())).append("\n");
            if (isExtraCheese()) {
                sb.append("|  - Extra Cheese Cost: $").append(String.format("%.2f", getExtraCheesePrice()))
                        .append("\n");
            }
        }

        if (getRegularToppings().contains("4oz Au Jus sauce")) {
            sb.append("|Sides: 4oz Au Jus sauce\n");
        }

        sb.append("|Sandwich Price: $").append(String.format("%.2f", getPrice())).append("\n");
        sb.append("|+--------------------------------------+\n");

        return sb.toString();
    }

    // Private helper method to capitalize the first letter of a string
    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}