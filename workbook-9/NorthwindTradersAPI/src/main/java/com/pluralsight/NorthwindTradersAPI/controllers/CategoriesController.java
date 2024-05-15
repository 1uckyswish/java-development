package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories") // Adding path at the class level
public class CategoriesController {

    private final CategoryDao categoryDao;

    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Category> categories() {
        return categoryDao.getAllCategories();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Category getCategory(@PathVariable int id){
       return categoryDao.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category insertCategory(@RequestBody Category category){
        Category newCategory = categoryDao.insert(category);
        return newCategory;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateCategory(@PathVariable int id, @RequestBody Category category){
        categoryDao.update(id, category);
    }
}
