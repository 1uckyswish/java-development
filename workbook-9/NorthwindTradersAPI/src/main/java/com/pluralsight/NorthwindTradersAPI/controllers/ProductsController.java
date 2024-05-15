package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.ProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products") // Adding path at the class level
public class ProductsController {

    private final ProductDao productDao;

    @Autowired
    public ProductsController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable int id) {
        return productDao.getById(id);
    }
}
