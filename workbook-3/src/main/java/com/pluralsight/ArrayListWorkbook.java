package com.pluralsight;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListWorkbook {
    public static void main(String[] args) {
        ArrayList<String> kids = new ArrayList<>();
        kids.add("Noel");
        kids.add("Jojo");
        kids.add("Lordi");
        kids.set(2, "Jesus");
        for (int i = 0; i < kids.size(); i++) {
            System.out.println((i + 1) + " : " + kids.get(i));
        }

        kids.add("Maria");
        System.out.println("After Maria was added");
        for (int i = 0; i < kids.size(); i++) {
            System.out.println((i + 1) + " : " + kids.get(i));
        }

        Collections.sort(kids); //sort array
        System.out.println("After being sorted");
        for (int i = 0; i < kids.size(); i++) {
            System.out.println((i + 1) + " : " + kids.get(i));
        }
    }
}
