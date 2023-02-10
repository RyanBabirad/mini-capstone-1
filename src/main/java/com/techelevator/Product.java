package com.techelevator;

public abstract class Product {

    private String slot;
    private String productName;
    private double price;
    private int stock = 5;


    public Product(String productName, double price, String slot) {
        this.productName = productName;
        this.price = price;
        this.slot = slot;
    }

    public String getSlot() {
        return slot;
    }

    public void setStock(int stock) {
        this.stock -= 1;
    }

    public int getStock() {
        return stock;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }



    public abstract String getSound();


}

