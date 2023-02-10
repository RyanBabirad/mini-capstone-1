package com.techelevator;

public class Chip extends Product {

    private final Chip potatoCrisps = new Chip("Potato Crisps", 3.05, 5);
    private final Chip stackers = new Chip("Stackers", 1.45, 5);
    private final Chip grainWaves = new Chip("Grain Waves", 2.75, 5);
    private final Chip cloudPopcorn = new Chip( "Cloud Popcorn", 3.65, 5);

    public Chip(String productName, double price, int stock) {
        super(productName, price, stock);
    }

    public Chip getPotatoCrisps() {
        return potatoCrisps;
    }

    public Chip getStackers() {
        return stackers;
    }

    public Chip getGrainWaves() {
        return grainWaves;
    }

    public Chip getCloudPopcorn() {
        return cloudPopcorn;
    }
}
