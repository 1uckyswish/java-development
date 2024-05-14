package com.pluralsight.dao;

import com.pluralsight.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao{
    private List<Product> products;

    public SimpleProductDao(List<Product> employees) {
        this.products = new ArrayList<>();
        this.products.add(new Product(1, "Laptop", "Electronics", 999.99));
        this.products.add(new Product(2, "T-shirt", "Apparel", 19.99));
        this.products.add(new Product(3, "Headphones", "Electronics", 49.99));
        this.products.add(new Product(4, "Book", "Books", 12.99));
        this.products.add(new Product(5, "Smartphone", "Electronics", 699.99));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void delete(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId) {
                products.remove(i);
                break; // Exit loop after deleting the first matching product
            }
        }
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == product.getProductId()) {
                products.set(i, product);
                break;
            }
        }
    }

    @Override
    public List<Product> search(String keyword) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(keyword) || product.getCategory().contains(keyword)) {
                result.add(product);
            }
        }
        return result;
    }



}
