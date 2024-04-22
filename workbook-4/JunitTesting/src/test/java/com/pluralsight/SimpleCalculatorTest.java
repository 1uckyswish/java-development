package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @Test
    public void twoPlusTwoShouldEqualFour(){
        //Create an instance of the class you want to test
        SimpleCalculator calculator = new SimpleCalculator();
        //Call the method within the class you want to check
        //Pass it the correct number of arguments needed
        int methodCallValue = calculator.add(2,2);

        //ASSERT STATEMENT
        //Checks if values do equal
        assertEquals(4, methodCallValue);
        //Checks if values do not equal
        assertNotEquals(6, methodCallValue);
        //Check if value is true or false
        //assertTrue();
        //assertFalse();
        //Check if the value is null or not null
        //assertNotNull();
        //assertNull();

        //*Another way
        assertTrue(methodCallValue == 4);
    }

    @Test
    public void threePlusSevenShouldEqualTen(){
        //Create an instance of the class you want to test
        SimpleCalculator calculator = new SimpleCalculator();
        //Call the method within the class you want to check
        //Pass it the correct number of arguments needed
        int methodCallValue = calculator.add(3,7);
        assertEquals(10, methodCallValue);
    }
}