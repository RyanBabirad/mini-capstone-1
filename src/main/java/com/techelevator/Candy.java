package com.techelevator;

import java.io.CharArrayReader;
import java.util.Stack;

public class Candy extends Product {

    private final Candy moonpie = new Candy("Moonpie", 1.80, 5);
    private final Candy cowtales = new Candy("Cowtales",1.50, 5);
    private final Candy wonkaBar = new Candy("Wonka Bar", 1.50, 5);
    private final Candy crunchie = new Candy( "Crunchie", 1.75, 5);

    public Candy(String productName, double price, int stock) {
        super(productName, price, stock);
    }






    public Candy getMoonpie() {
        return moonpie;
    }

    public Candy getCowtales() {
        return cowtales;
    }

    public Candy getWonkaBar() {
        return wonkaBar;
    }

    public Candy getCrunchie() {
        return crunchie;
    }
}
