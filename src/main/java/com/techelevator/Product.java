package com.techelevator;

import java.util.Stack;

public class Product {


    private String productName;
    private double price;
    private int stock = 5;
    private Stack<String> productStack = new Stack<>();

    public Product () {}

    public Product(String productName, double price, int stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
