package com.FreshFit.components;

public class Sauce extends Topping{
    public Sauce(String name, double basePrice) {
        super(name, 0.0);
    }

    @Override
    public double getPrice(String size) {
        return 0.0; //free
    }
}
//inherits name
//override getPrice return 0.0
//inherits getName