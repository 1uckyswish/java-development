package com.pluralsight;

public class ShoppingList {
    public static void main(String[] args) {
        String[] items = {
                "Hat",
                "Shoes",
                "Pants",
                "Phone",
                "Milk",
                "Cheese",
                "Bananas",
                "Apples",
                "Water",
                "Books"
        };

        for(String item : items){
            System.out.println(item);
        }
    }
}
