package com.pluralsight.NorthwindTradersAPI.models;

public class Product {
    private int productId;
    private String productName;
    private int categoyrId;
    private double unitPrice;

    public Product(int productId, String productName, int categoyrId, double unitPrice){
        this.productId = productId;
        this.productName = productName;
        this.categoyrId = categoyrId;
        this.unitPrice = unitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoyrId() {
        return categoyrId;
    }

    public void setCategoyrId(int categoyrId) {
        this.categoyrId = categoyrId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString(){
        return productId + " " + productName + " " + categoyrId + " " + unitPrice;
    }
}
