package com.pluralsight.service;

import com.pluralsight.ProductUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ProductUI productUI = context.getBean(ProductUI.class);
        productUI.run();
    }
}
