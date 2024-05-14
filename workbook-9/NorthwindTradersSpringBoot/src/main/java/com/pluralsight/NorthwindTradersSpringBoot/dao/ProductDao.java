package com.pluralsight.NorthwindTradersSpringBoot.dao;



import com.pluralsight.NorthwindTradersSpringBoot.models.Product;

import java.util.List;

public interface ProductDao {
    void add (Product product);
    List<Product> getAll();
    void delete(int productId); // New method for deleting a product
    void update(Product product); // New method for updating a product
    List<Product> search(String keyword); // New method for searching products
}
