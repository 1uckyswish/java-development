package com.pluralsight.NorthwindTradersSpringBoot.dao;


import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class SimpleProductDao implements ProductDao{
    private List<Product> products;

    public SimpleProductDao(List<Product> products) {
        this.products = products;
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
