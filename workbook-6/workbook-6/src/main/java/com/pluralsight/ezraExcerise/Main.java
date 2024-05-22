package com.pluralsight.ezraExcerise;

import java.util.ArrayList;
import java.util.List;

public class Main<E> {

    public static <E> ArrayList<E> removeDuplicates(List<E> list) {
        ArrayList<E> newList = new ArrayList<>();
        for (E num : list) {
            if (!newList.contains(num)) {
                newList.add(num);
            }
        }
        return newList;
    }

    public static <E> ArrayList<E> mergeLists(List<E> list1, List<E> list2) {
        ArrayList<E> newList = new ArrayList<>();
        newList.addAll(list1);
        newList.addAll(list2);
        return newList;
    }

    public static <E> ArrayList<E> mergeLists2(List<E> list1, List<E> list2) {
        ArrayList<E> newList = new ArrayList<>();
        int loopSize = list1.size() > list2.size() ? list1.size() : list2.size();
        for(int i = 0; i < loopSize; i++) {
            newList.add(list1.get(i));
            newList.add(list2.get(i));
        }
        return newList;
    }

    public static <E> ArrayList<E> reverseList(List<E> list) {
        ArrayList<E> newList = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--){
            newList.add(list.get(i));
        }
        return newList;
    }





    public static void main(String[] args) {
        List<Integer> duplicates = List.of(1, 2, 1, 3, 4, 5, 2);
        System.out.println("Orginal List: " + duplicates);
        List<Integer> noDuplicates = removeDuplicates(duplicates);
        System.out.println("List without duplicates: " + noDuplicates);

        List<Integer> number1 = List.of(1, 2, 3, 4);
        List<Integer> number2 = List.of(10, 20, 30, 40);
        System.out.println("Merged ListV1: " + mergeLists(number1, number2));
        System.out.println("Merged ListV2: " + mergeLists2(number1, number2));

        List<String> names = List.of("Ezra", "Elon", "Lebron", "Santa");
        List<Double> gasPrices = List.of(1.00, 2.00, 3.00, 4.00);

        System.out.println(reverseList(names));
        System.out.println(reverseList(gasPrices));
    }
}
