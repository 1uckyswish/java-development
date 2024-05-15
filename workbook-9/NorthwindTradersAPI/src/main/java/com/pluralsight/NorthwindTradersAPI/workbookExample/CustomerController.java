package com.pluralsight.NorthwindTradersAPI.workbookExample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer( 1, "John Doe", "123 Main St."));
        customers.add(new Customer( 2, "Jane Doe", "456 Main St."));
        customers.add(new Customer( 3, "Joe Doe", "789 Main St."));
        return customers;
    }
}
