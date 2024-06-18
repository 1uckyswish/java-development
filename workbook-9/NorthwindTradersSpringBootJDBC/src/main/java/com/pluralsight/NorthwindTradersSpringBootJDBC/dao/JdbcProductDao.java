package com.pluralsight.NorthwindTradersSpringBootJDBC.dao;

import com.pluralsight.NorthwindTradersSpringBootJDBC.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcProductDao implements ProductDao{

    @Autowired
    private DataSource dataSource;

    @Override
    public void add(Product product) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO Products (ProductName, CategoryID, UnitPrice) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, product.getName());
                statement.setInt(2, product.getCategory());
                statement.setDouble(3, product.getPrice());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new product was inserted successfully.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception properly
        }
    }


    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT p.*, c.CategoryName\n" +
                    "FROM Products p\n" +
                    "JOIN Categories c ON p.CategoryId = c.CategoryId;\n";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int catId = resultSet.getInt(4);
                    double price = resultSet.getDouble("UnitPrice");
                    String catName = resultSet.getString("CategoryName");

                    Product product = new Product(catId, name, catId, price, catName);
                    // Set other properties similarly
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception properly
        }
        return products;
    }


    @Override
    public void delete(int productId) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "DELETE FROM Products WHERE ProductID = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, productId);

                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Product with ID " + productId + " was deleted successfully.");
                } else {
                    System.out.println("No product found with ID " + productId + ".");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception properly
        }
    }


    @Override
    public void update(Product product) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE Products SET ProductName = ?, CategoryID = ?, UnitPrice = ? WHERE ProductID = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, product.getName());
                statement.setInt(2, product.getCategory());
                statement.setDouble(3, product.getPrice());
                statement.setInt(4, product.getProductId());

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Product with ID " + product.getProductId() + " was updated successfully.");
                } else {
                    System.out.println("No product found with ID " + product.getProductId() + ".");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception properly
        }
    }


    @Override
    public List<Product> search(String keyword) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT p.*, c.CategoryName\n" +
                    "FROM Products p\n" +
                    "JOIN Categories c ON p.CategoryId = c.CategoryId WHERE ProductName LIKE ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "%" + keyword + "%");

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("ProductID");
                        String name = resultSet.getString("ProductName");
                        int category = resultSet.getInt("CategoryID");
                        double price = resultSet.getDouble("UnitPrice");
                        String catName = resultSet.getString("CategoryName");

                        Product product = new Product(category, name, category, price, catName);
                        products.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception properly
        }
        return products;
    }

}
