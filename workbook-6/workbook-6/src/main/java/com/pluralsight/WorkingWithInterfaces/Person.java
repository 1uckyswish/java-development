package com.pluralsight.WorkingWithInterfaces;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        // Compare last names
        int lastNameComparison = this.lastName.compareTo(otherPerson.getLastName());
        if (lastNameComparison != 0) {
            // If last names are not equal, return the comparison result
            return lastNameComparison;
        }

        // Last names are equal, so compare first names
        int firstNameComparison = this.firstName.compareTo(otherPerson.getFirstName());
        if (firstNameComparison != 0) {
            // If first names are not equal, return the comparison result
            return firstNameComparison;
        }

        // First and last names are equal, so compare ages
        return Integer.compare(this.age, otherPerson.getAge());
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
