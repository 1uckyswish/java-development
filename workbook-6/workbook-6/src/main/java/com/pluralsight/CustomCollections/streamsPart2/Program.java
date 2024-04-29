package com.pluralsight.CustomCollections.streamsPart2;

import com.pluralsight.CustomCollections.streams.Person;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<com.pluralsight.CustomCollections.streams.Person> people = new ArrayList<>();

        // Adding 10 people to the ArrayList
        people.add(new com.pluralsight.CustomCollections.streams.Person("John", "Doe", 30));
        people.add(new com.pluralsight.CustomCollections.streams.Person("Alice", "Smith", 25));
        people.add(new com.pluralsight.CustomCollections.streams.Person("Michael", "Johnson", 40));
        people.add(new com.pluralsight.CustomCollections.streams.Person("Emily", "Brown", 35));
        people.add(new com.pluralsight.CustomCollections.streams.Person("David", "Wilson", 28));
        people.add(new com.pluralsight.CustomCollections.streams.Person("Sarah", "Martinez", 32));
        people.add(new com.pluralsight.CustomCollections.streams.Person("Robert", "Anderson", 45));
        people.add(new com.pluralsight.CustomCollections.streams.Person("Jessica", "Taylor", 22));
        people.add(new com.pluralsight.CustomCollections.streams.Person("William", "Thomas", 38));
        people.add(new Person("Jennifer", "Hernandez", 27));

    }
}
