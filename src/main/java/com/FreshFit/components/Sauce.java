package com.FreshFit.components;

public class Sauce extends Topping{
    public Sauce(String name, double basePrice) {
        super(name, basePrice);
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
//inherits name
//override getPrice return 0.0
//inherits getName