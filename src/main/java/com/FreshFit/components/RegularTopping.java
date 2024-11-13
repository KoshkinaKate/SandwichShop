package com.FreshFit.components;

public class RegularTopping extends Topping {

    public RegularTopping(String name) {
        super(name, 0.0);
    }

    @Override
    public double getPrice(String size) {
        return 0.0;
    }
}
