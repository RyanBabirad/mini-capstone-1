package com.techelevator;

public class Drink extends Product {

    private final Drink cola = new Drink("Cola", 1.25, 5);
    private final Drink drSalt = new Drink( "Dr. Salt", 1.50, 5);
    private final Drink mountainMelter = new Drink( "Mountain Melter", 1.50, 5);
    private final Drink heavy = new Drink("Heavy", 1.50, 5);


    public Drink(String productName, double price, int stock) {
        super(productName, price, stock);
    }

    public Drink getCola() {
        return cola;
    }

    public Drink getDrSalt() {
        return drSalt;
    }

    public Drink getMountainMelter() {
        return mountainMelter;
    }

    public Drink getHeavy() {
        return heavy;
    }
}
