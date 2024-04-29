package com.pluralsight.GenericsExample;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //When you use the class, specific the data type
        Printer<Integer> printer = new Printer<>(23);
        printer.print();

        Printer<String> printer2 = new Printer<>("Hello");
        printer2.print();

        Printer<Boolean> printer3 = new Printer<>(true);
        printer3.print();

        Printer<Double> printer4 = new Printer<>(33.00);
        printer4.print();

        shout("Lebron james");
        shout(23.00);
        shout2(21, "Cats");
        shout2("I am hunrgy", true);


        List<Integer> catAges = new ArrayList<>();
        catAges.add(1);
        catAges.add(2);
        List<String> catNames = new ArrayList<>();
        catNames.add("Jimmy");
        catNames.add("Vivian");

        getListData(catAges);
        getListData(catNames);

    }

    public static void getListData(List<?>data){
        System.out.println(data);
    }

    public static <T> void shout(T thingToShout) {
        System.out.println(thingToShout);
    }

    public static <T, V> void shout2(T thingToShout, V thingToSee) {
        System.out.println(thingToShout);
        System.out.println(thingToSee);
    }

    public static <T, V, X> X shout2(T thingToShout, V thingToSee, X thingToThorw) {
        System.out.println(thingToShout);
        System.out.println(thingToSee);
        return thingToThorw;
    }
}
