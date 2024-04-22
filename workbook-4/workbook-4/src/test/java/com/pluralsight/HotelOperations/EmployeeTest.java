package com.pluralsight.HotelOperations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testPunchInAndPunchOut() {
        // Create an Employee object
        Employee employee = new Employee(1, "John Doe", "IT", 20.0, 0.0);

        // Punch in at a specific time
        employee.punchIn(8.0); // Assuming 8:00 AM

        // Punch out at a later time
        employee.punchOut(16.5); // Assuming 4:30 PM

        // Calculate expected hours worked
        double expectedHoursWorked = 16.5 - 8.0; // 8.5 hours

        // Verify that hours worked is calculated correctly
        assertEquals(expectedHoursWorked, employee.getHoursWorked());
    }
}
