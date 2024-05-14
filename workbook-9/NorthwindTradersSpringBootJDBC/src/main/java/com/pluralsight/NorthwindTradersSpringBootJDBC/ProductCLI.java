package com.pluralsight.NorthwindTradersSpringBootJDBC;

import com.pluralsight.NorthwindTradersSpringBootJDBC.models.Product;
import com.pluralsight.NorthwindTradersSpringBootJDBC.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Scanner;

@Component
public class ProductCLI implements CommandLineRunner {

    private final ProductDao productDao;
    private final Scanner scanner;

    @Autowired
    public ProductCLI(ProductDao productDao) {
        this.productDao = productDao;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add a product");
            System.out.println("2. Update a product");
            System.out.println("3. Delete a product");
            System.out.println("4. Search for a product");
            System.out.println("5. Display all products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    displayAllProducts();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addProduct() {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product categoryID: ");
        int category = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        Product product = new Product(id, name, category, price);
        productDao.add(product);
        System.out.println("Product added successfully.");
    }

    private void updateProduct() {
        System.out.print("Enter product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter new product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new product categoryID: ");
        int category = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        Product product = new Product(productId, name, category, price);
        productDao.update(product);
        System.out.println("Product updated successfully.");
    }

    private void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        productDao.delete(productId);
        System.out.println("Product deleted successfully.");
    }

    private void searchProduct() {
        System.out.print("Enter keyword to search for: ");
        String keyword = scanner.nextLine();

        List<Product> products = productDao.search(keyword);
        if (products.isEmpty()) {
            System.out.println("No products found matching the keyword.");
        } else {
            System.out.println("Products found:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private void displayAllProducts() {
        List<Product> products = productDao.getAll();
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("All Products:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
