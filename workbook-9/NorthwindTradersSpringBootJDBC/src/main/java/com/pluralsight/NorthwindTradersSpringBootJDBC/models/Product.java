package com.pluralsight.NorthwindTradersSpringBootJDBC.models;

public class Product {
    private int productId;
    private String name;
    private int category;
    private double price;
    private String categoryName;

    public Product(int productId, String name, int category, double price,String categoryName) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.categoryName = categoryName;
    }

    public Product(int productId, String name, int category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}