package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.SimpleProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DaoConfig {

    @Bean
    public SimpleProductDao simpleProductDao() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics", 999.99));
        products.add(new Product(2, "T-shirt", "Apparel", 19.99));
        products.add(new Product(3, "Headphones", "Electronics", 49.99));
        products.add(new Product(4, "Book", "Books", 12.99));
        products.add(new Product(5, "Smartphone", "Electronics", 699.99));

        return new SimpleProductDao(products);
    }
}
