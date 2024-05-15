package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories") // Adding path at the class level
public class CategoriesController {
    public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Food"));
        categories.add(new Category(2, "Clothing"));
        categories.add(new Category(3, "Software"));
        return categories;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Category> categories() {
        return getAllCategories();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public List<Category> getCategory(@PathVariable int id){
        List<Category> categories = new ArrayList<>();
        for (Category category : getAllCategories()){
            if(category.getCategoryID() == id){
                categories.add(category);
            }
        }
        return categories;
    }

    @RequestMapping(path = "/category/{category}", method = RequestMethod.GET)
    public List<Category> getCategoriesByName(@PathVariable String category) {
        List<Category> filteredCategories = new ArrayList<>();
        for (Category cat : getAllCategories()) {
            if (cat.getCategoryName().equalsIgnoreCase(category)) {
                filteredCategories.add(cat);
            }
        }
        return filteredCategories;
    }
}
