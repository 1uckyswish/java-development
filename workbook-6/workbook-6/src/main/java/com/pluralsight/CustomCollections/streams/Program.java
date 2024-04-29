package com.pluralsight.CustomCollections.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        // Adding 10 people to the ArrayList
        people.add(new Person("John", "Doe", 30));
        people.add(new Person("Alice", "Smith", 25));
        people.add(new Person("Michael", "Johnson", 40));
        people.add(new Person("Emily", "Brown", 35));
        people.add(new Person("David", "Wilson", 28));
        people.add(new Person("Sarah", "Martinez", 32));
        people.add(new Person("Robert", "Anderson", 45));
        people.add(new Person("Jessica", "Taylor", 22));
        people.add(new Person("William", "Thomas", 38));
        people.add(new Person("Jennifer", "Hernandez", 27));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name to search (First or Last): ");
        String findName = scanner.nextLine().trim();
        List<Person> searchHistory = new ArrayList<>();
        for (Person person : people) {
            if (person.getFirstName().toLowerCase().equalsIgnoreCase(findName) || person.getLastName().toLowerCase().equalsIgnoreCase(findName)) {
                searchHistory.add(person);
            }
        }

        System.out.println("Search History: ");
        for (Person person : searchHistory) {
            System.out.println(person);
        }

        // Calculating the average age
        double totalAge = 0;
        for (Person person : people) {
            totalAge += person.getAge();
        }
        double averageAge = totalAge / people.size();
        System.out.println("Average Age: " + averageAge);

        // Finding the oldest person
        int maxAge = 0;
        for (Person person : people) {
            if (person.getAge() > maxAge) {
                maxAge = person.getAge();
            }
        }
        System.out.println("Age of the Oldest Person: " + maxAge);

        // Finding the youngest person
        int minAge = maxAge;
        for (Person person : people) {
            if (person.getAge() < minAge) {
                minAge = person.getAge();
            }
        }
        System.out.println("Age of the Youngest Person: " + minAge);
    }
}
