package com.techelevator;

public class Candy extends Product {
    public Candy(String productName, double price, String slot) {
        super(productName, price, slot);
    }
    @Override
    public String getSound(){
        return "Munch Munch, Yum!";
    }
}
