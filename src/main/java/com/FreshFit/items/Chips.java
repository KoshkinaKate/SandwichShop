package com.FreshFit.items;

import com.FreshFit.utilities.IPrice;

public class Chips implements IPrice {
    private String type; //BBQ, Spicy etc

    public Chips(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }

    @Override
    public double getPrice() {
        return 1.5; //always the same price
    }
    @Override
    public String toString() {
        return type + " chips";
    }

}