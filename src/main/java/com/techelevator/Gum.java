package com.techelevator;

public class Gum extends Product{

    Gum uChews = new Gum("U-Chews", 0.85, 5);
    Gum littleLeagueChew = new Gum( "Little League Chew", 0.95, 5);
    Gum chiclets = new Gum( "Chiclets", .75, 5);
    Gum tripleMint = new Gum( "Triplemint", .75, 5);


    public Gum(String productName, double price, int stock) {
        super(productName, price, stock);
    }

    public Gum getuChews() {
        return uChews;
    }

    public Gum getLittleLeagueChew() {
        return littleLeagueChew;
    }

    public Gum getChiclets() {
        return chiclets;
    }

    public Gum getTripleMint() {
        return tripleMint;
    }
}
