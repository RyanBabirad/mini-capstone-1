package com.techelevator;

public class Chip extends Product {
    public Chip(String productName, double price, String slot) {
        super(productName, price, slot);
    }
    @Override
    public String getSound(){
        return "Crunch Crunch, Yum!";
    }
}
