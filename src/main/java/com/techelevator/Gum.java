package com.techelevator;

public class Gum extends Product {
    public Gum(String productName, double price, String slot) {
        super(productName, price, slot);
    }
    @Override
    public String getSound() {
        return "Chew Chew, Yum!";
    }
}