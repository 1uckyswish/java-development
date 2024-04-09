package com.pluralsight;

public class PracticeOperations {
    public static void main(String[] args) {
        String firstName = "Noel";
        String lastName = "Guillen";
        String middleName = "Blas";
        String fullName = firstName + " " + lastName + " " + middleName;
        //Name result
        System.out.println(fullName);
        //add,sub,multi result
        double houseCost = 6.00d;
        double taxPerYear = 1.00d;
        double insurance = 3.00d;
        double result = 0;
        result = houseCost + taxPerYear + insurance;
        System.out.println("result of adding " + result);
        result = houseCost - taxPerYear - insurance;
        System.out.println("result of minus " + result);
        result = houseCost * taxPerYear * insurance;
        System.out.println("result of multi " + result);
        //result of divide
        double result2 = houseCost / taxPerYear;
        double valueOfResult2 = result2 / insurance;
        double accumulationResult = valueOfResult2;
        System.out.println("divison result before to base 10 ");
        System.out.println(accumulationResult);
        accumulationResult += 10;
        System.out.println("First add result to base 10 ");
        System.out.println(accumulationResult);
        accumulationResult += 100;
        System.out.println("Second add result to base 100 ");
        System.out.println(accumulationResult);
        accumulationResult += 1000;
        System.out.println("Third add result to base 1000 ");
        System.out.println(accumulationResult);
    }
}
