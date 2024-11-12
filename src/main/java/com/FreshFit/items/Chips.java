package com.FreshFit.items;

import com.FreshFit.utilities.IPrice;

public class Chips implements IPrice {
    private String type; //BBQ, Spicy etc
    private final double price = 1.50;

    public Chips(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }

    @Override
    public double getPrice() {
        return price;
    }
}