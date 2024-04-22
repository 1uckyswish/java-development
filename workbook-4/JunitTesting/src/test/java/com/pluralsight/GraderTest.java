package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraderTest {
    @Test
    public void fiftyNineShouldReturnF(){
        Grader grader = new Grader();
        assertEquals('F', grader.determineLetterGrade(59));
    }

    @Test
    public void sixtyNineShouldReturnF(){
        Grader grader = new Grader();
        assertEquals('D', grader.determineLetterGrade(69));
    }

    @Test
    public void seventyNineShouldReturnC(){
        Grader grader = new Grader();
        assertEquals('C', grader.determineLetterGrade(79));
    }

    @Test
    public void eightyNineShouldReturnB(){
        Grader grader = new Grader();
        assertEquals('B', grader.determineLetterGrade(89));
    }

    @Test
    public void ninetyNineShouldReturnB(){
        Grader grader = new Grader();
        assertEquals('A', grader.determineLetterGrade(99));
    }

    @Test
    public void zeroShouldReturnF(){
        Grader grader = new Grader();
        assertEquals('F', grader.determineLetterGrade(0));
    }

    @Test
    public void sixtyShouldReturnD(){
        Grader grader = new Grader();
        assertEquals('D', grader.determineLetterGrade(60));
    }

    @Test
    public void seventyShouldReturnC(){
        Grader grader = new Grader();
        assertEquals('C', grader.determineLetterGrade(70));
    }

    @Test
    public void eightyShouldReturnB(){
        Grader grader = new Grader();
        assertEquals('B', grader.determineLetterGrade(80));
    }

    @Test
    public void ninetyShouldReturnB(){
        Grader grader = new Grader();
        assertEquals('A', grader.determineLetterGrade(90));
    }

    @Test
    public void negativeShouldReturnIllegalArgument(){
        Grader grader = new Grader();
        assertThrows(IllegalArgumentException.class, () -> {
            grader.determineLetterGrade(-1);
        });
    }

}