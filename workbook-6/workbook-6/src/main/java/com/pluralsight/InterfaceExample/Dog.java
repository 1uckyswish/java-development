package com.pluralsight.InterfaceExample;

public class Dog implements MakesNoise{
    private int age;
    private String name;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    //gets methods from Interface
    //Must have same return type
    //Same method name
    //Same @param
    @Override
    public void makeNoise() {
        System.out.println("WOOF WOOF");
    }
}
