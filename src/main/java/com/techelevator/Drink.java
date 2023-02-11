package com.techelevator;

public class Drink extends Product {
    public Drink(String productName, double price, String slot) {
        super(productName, price, slot);
    }
    @Override
    public String getSound(){
        return "Chug Chug, Yum!";
    }
}
