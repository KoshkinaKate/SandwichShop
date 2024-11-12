package com.FreshFit.components;

public class Meat extends PremiumTopping{
    public Meat(String name, double basePrice) {
        super(name, basePrice);
    }

    @Override
    public double getPrice() { //from IPrice
        return 0;
    }
}
