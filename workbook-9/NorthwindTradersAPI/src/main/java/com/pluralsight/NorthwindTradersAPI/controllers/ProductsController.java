package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.ProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product insertProduct(@RequestBody Product product) {
        Product newProduct = productDao.insert(product);
        return newProduct;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        productDao.udpate(id, product);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id) {
        productDao.delete(id);
    }

}
