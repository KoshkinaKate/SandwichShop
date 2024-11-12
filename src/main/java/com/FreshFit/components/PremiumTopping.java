package com.FreshFit.components;

public abstract class PremiumTopping extends Topping{
    public PremiumTopping(String name, double basePrice) {
        super(name, basePrice);
    }

    public abstract double getPrice(String size);
}
