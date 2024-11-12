package com.FreshFit.components;

public class Meat extends PremiumTopping {
    public Meat(String name, double basePrice) {
        super(name, 1); //$1 for 4"
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }
}
