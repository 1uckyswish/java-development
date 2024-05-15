package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts();
    Product getById(int id);
    Product insert(Product product);
    void udpate(int id, Product product);
}
