package com.pluralsight;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");

        RegistrationService registrationService = ctx.getBean(RegistrationService.class);

        Long studentID = registrationService.registerStudent(
                new Student("Alan", "Turing", "Computer Science"));
        System.out.println("Student Registered with ID: " + studentID);
        Long studentID2 = registrationService.registerStudent(
                new Student("Johannes", "Kepler", "Astronomy"));
        System.out.println("Student Registered with ID: "+ studentID2);
    }
}
