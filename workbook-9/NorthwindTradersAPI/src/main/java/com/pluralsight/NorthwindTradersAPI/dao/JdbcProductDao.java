package com.pluralsight.NorthwindTradersAPI.dao;

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
public class JdbcProductDao implements ProductDao {

    private final DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
        ){
            String sql = "SELECT ProductID, ProductName, CategoryID, UnitPrice FROM Products;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
            ){
                while(resultSet.next()){
                    int id = resultSet.getInt("ProductID");
                    String name =resultSet.getString("ProductName");
                    int categoryID = resultSet.getInt("CategoryID");
                    double unitPrice = resultSet.getDouble("UnitPrice");
                    Product product = new Product(id, name, categoryID, unitPrice);
                    products.add(product);
                }

            }catch (Exception e) {
                e.printStackTrace();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }


    @Override
    public Product getById(int id) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT ProductID, ProductName, CategoryID, UnitPrice FROM Products WHERE ProductID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int productId = resultSet.getInt("ProductID");
                        String productName = resultSet.getString("ProductName");
                        int categoryId = resultSet.getInt("CategoryID");
                        double unitPrice = resultSet.getDouble("UnitPrice");
                        return new Product(productId, productName, categoryId, unitPrice);
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

    @Override
    public Product insert(Product product) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO Products (ProductName, CategoryID, UnitPrice) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, product.getProductName());
                preparedStatement.setInt(2, product.getCategoyrId());
                preparedStatement.setDouble(3, product.getUnitPrice());
                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows == 0) {
                    throw new RuntimeException("Inserting product failed, no rows affected.");
                }
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int productId = generatedKeys.getInt(1);
                        product.setProductId(productId);
                        return product;
                    } else {
                        throw new RuntimeException("Inserting product failed, no ID obtained.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception (e.g., log it, throw a custom exception)
            return null;
        }
    }

    @Override
    public void udpate(int id, Product product) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE Products SET ProductName = ?, CategoryID = ?, UnitPrice = ? WHERE ProductID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, product.getProductName());
                preparedStatement.setInt(2, product.getCategoyrId());
                preparedStatement.setDouble(3, product.getUnitPrice());
                preparedStatement.setInt(4, id);
                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows == 0) {
                    throw new RuntimeException("Updating product failed, no rows affected.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception (e.g., log it, throw a custom exception)
        }
    }


}
