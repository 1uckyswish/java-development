package com.pluralsight.CustomCollections.streamsPart2;

import com.pluralsight.CustomCollections.streams.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

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

        Scanner scanner = new Scanner(System.in);
        System.out.print("Find name: ");
        String nameChoice = scanner.nextLine();
        List<Person> searchNames = people.stream().filter(person -> person.getFirstName().equals(nameChoice)).collect(Collectors.toList());
        System.out.println("******");
        System.out.println(searchNames);


        List<Integer> averageAge = people.stream().map(person -> person.getAge()).collect(Collectors.toList());
        int sum = averageAge.stream().reduce(0, (a , b) -> a + b);
        double averageFinal = sum / (double) averageAge.size();
        System.out.println("Average age: " + averageFinal);

        //Using sorted
        Optional<Integer> youngestAgeSorted = people.stream().map(person -> person.getAge()).sorted().findFirst();
        Optional<Integer> youngestAgeSorted2 = people.stream()
                .map(Person::getAge)
                .sorted()
                .findFirst();
        Optional<Integer> oldestAgeSorted1 = people.stream().map(person -> person.getAge()).sorted(Comparator.reverseOrder()).findFirst();
        Optional<Integer> oldestAgeSorted2 = people.stream()
                .map(Person::getAge)
                .sorted(Comparator.reverseOrder())
                .findFirst();

        youngestAgeSorted.ifPresent(age -> System.out.println("Youngest is " + age));
        oldestAgeSorted1.ifPresent(age -> System.out.println("Oldest age (sorted): " + age));

        Optional<Integer> youngestAgeMap1 = people.stream().map(person -> person.getAge()).min(Comparator.naturalOrder());
        Optional<Integer> youngestAgeMap2 = people.stream().map(Person::getAge).min(Integer::compareTo);

        Optional<Integer> oldestAgeMap1 = people.stream().map(Person::getAge).max(Integer::compareTo);
        Optional<Integer> oldestAgeMap2= people.stream()
                .map(Person::getAge)
                .max(Integer::compareTo);
        youngestAgeMap1.ifPresent(age -> System.out.println("Youngest age (map): " + age));
        oldestAgeMap1.ifPresent(age -> System.out.println("Oldest age (map): " + age));


        Optional<Integer> youngestAgeReduce = people.stream()
                .map(Person::getAge)
                .reduce(Integer::min);

        Optional<Integer> oldestAgeReduce = people.stream()
                .map(Person::getAge)
                .reduce(Integer::max);

        youngestAgeReduce.ifPresent(age -> System.out.println("Youngest age (reduce): " + age));
        oldestAgeReduce.ifPresent(age -> System.out.println("Oldest age (reduce): " + age));

    }
}
