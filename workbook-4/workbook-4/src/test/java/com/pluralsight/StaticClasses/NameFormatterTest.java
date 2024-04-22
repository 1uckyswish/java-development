package com.pluralsight.StaticClasses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameFormatterTest {

    @Test
    public void testFormatWithPrefix() {
        String formattedName = NameFormatter.format("Dr", "John", "", "Doe", "PhD");
        assertEquals("Dr. John Doe, PhD", formattedName);
    }

    @Test
    public void testFormatWithoutMiddleName() {
        String formattedName = NameFormatter.format("Mr", "James", "", "Bond", "Jr");
        assertEquals("Mr. James Bond, Jr", formattedName);
    }

    @Test
    public void testFormatWithFullName() {
        String formattedName = NameFormatter.format("John Smith");
        assertEquals("John Smith", formattedName);
    }

    @Test
    public void testFormatWithFirstNameAndLastName() {
        String formattedName = NameFormatter.format("Alice", "Wonderland");
        assertEquals("Alice Wonderland", formattedName);
    }

}
