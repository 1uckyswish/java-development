package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products") // Adding path at the class level
public class ProductsController {

    private List<Product> allProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Chai", 1, 18.00));
        products.add(new Product(2, "Chang", 1, 19.00));
        products.add(new Product(3, "Aniseed Syrup", 2, 10.00));
        return products;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return allProducts();
    }

    @RequestMapping(path = "/name/{name}", method = RequestMethod.GET)
    public List<Product> getProductsByName(@PathVariable String name) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : getAllProducts()) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    @RequestMapping(path = "price/{price}", method = RequestMethod.GET)
    public List<Product> getProductsByPrice(@PathVariable Double price) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : getAllProducts()) {
            if (product.getUnitPrice() == price) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public List<Product> getProduct(@PathVariable int id) {
        List<Product> products = new ArrayList<>();
        for (Product product : getAllProducts()) {
            if (product.getProductId() == id) {
                products.add(product);
            }
        }
        return products;
    }
}
