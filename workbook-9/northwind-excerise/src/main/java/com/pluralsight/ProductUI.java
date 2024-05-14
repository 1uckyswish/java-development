package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pluralsight.dao.SimpleProductDao;
import com.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUI {

    private final SimpleProductDao productDao;
    private final Scanner scanner;

    @Autowired
    public ProductUI(SimpleProductDao productDao) {
        this.productDao = productDao;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Options:");
            System.out.println("1. List Products");
            System.out.println("2. Add Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Update Product");
            System.out.println("5. Search Product");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    listProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    searchProduct();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void listProducts() {
        System.out.println("Listing Products:");
        for (Product product : productDao.getAll()) {
            System.out.println(product);
        }
    }

    private void addProduct() {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product category: ");
        String category = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        productDao.add(new Product(id, name, category, price));
        System.out.println("Product added successfully!");
    }

    private void deleteProduct() {
        System.out.print("Enter the ID of the product to delete: ");
        int productId = scanner.nextInt();
        productDao.delete(productId);
        System.out.println("Product deleted successfully!");
    }

    private void updateProduct() {
        System.out.print("Enter the ID of the product to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new category: ");
        String newCategory = scanner.nextLine();
        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();
        Product updatedProduct = new Product(productId, newName, newCategory, newPrice);
        productDao.update(updatedProduct);
        System.out.println("Product updated successfully!");
    }

    private void searchProduct() {
        System.out.print("Enter search keyword: ");
        String keyword = scanner.next();
        List<Product> searchResult = productDao.search(keyword);
        if (searchResult.isEmpty()) {
            System.out.println("No matching products found.");
        } else {
            System.out.println("Search results:");
            for (Product product : searchResult) {
                System.out.println(product);
            }
        }
    }
}
