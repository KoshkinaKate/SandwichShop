package com.FreshFit.components;

public class RegularTopping extends Topping{
    public RegularTopping(String name, double basePrice) {
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