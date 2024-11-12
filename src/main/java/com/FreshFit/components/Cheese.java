package com.FreshFit.components;

public class Cheese extends PremiumTopping{
    public Cheese(String name, double basePrice) {
        super(name, basePrice);
    }

    @Override
    public double getPrice() { //from IPrice
        return 0;
    }
}
