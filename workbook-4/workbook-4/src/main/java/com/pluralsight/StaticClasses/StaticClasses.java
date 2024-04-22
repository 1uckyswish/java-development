package com.pluralsight.StaticClasses;

public class StaticClasses {
    public static void main(String[] args) {
        System.out.println(NameFormatter.format("Dr", "Mel", "B", "Johnson", "PhD"));
        System.out.println(NameFormatter.format("Mel B Johnson, PhD"));
        System.out.println(NameFormatter.format("Mel", "Johnson,"));
    }
}
