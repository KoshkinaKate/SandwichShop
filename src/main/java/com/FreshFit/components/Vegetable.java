package com.FreshFit.components;
// free toppings
public class Vegetable extends Topping {

    public Vegetable(String name) {
        super(name);
    }

    @Override
    public double getPrice(String size) {
        return 0.0;
    }
}
