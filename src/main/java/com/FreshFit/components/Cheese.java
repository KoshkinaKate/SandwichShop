package com.FreshFit.components;

public class Cheese extends PremiumTopping{
    public Cheese(String name, double basePrice) {
        super(name, 0.75); // 0.75 for 4"
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }
}
