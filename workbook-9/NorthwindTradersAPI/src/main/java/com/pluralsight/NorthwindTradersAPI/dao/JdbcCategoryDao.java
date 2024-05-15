package com.pluralsight.NorthwindTradersAPI.dao;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCategoryDao implements CategoryDao{

    private final DataSource dataSource;

    @Autowired
    public JdbcCategoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
        ){
            String sql = "SELECT CategoryID, CategoryName FROM Categories;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
            ){
                while(resultSet.next()){
                    int id = resultSet.getInt("CategoryID");
                    String name =resultSet.getString("CategoryName");
                    Category category = new Category(id, name);
                    categories.add(category);
                }

            }catch (Exception e) {
                e.printStackTrace();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getById(int id) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT CategoryID, CategoryName FROM Categories WHERE CategoryID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int categoryID = resultSet.getInt("CategoryID");
                        String categoryName = resultSet.getString("CategoryName");
                        return new Category(categoryID, categoryName);
                    } else {
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception (e.g., log it, throw a custom exception)
            return null;
        }
    }
}
