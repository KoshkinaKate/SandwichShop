package com.FreshFit.components;

public abstract class PremiumTopping extends Topping{
    public PremiumTopping(String name, double basePrice) {
        super(name, basePrice);
    }
    @Override
    public double getPrice(String size) {
        switch (size) {
            case "4\"":
                return getBasePrice();
            case "8\"":
                return getBasePrice() * 2;
            case "12\"":
                return getBasePrice() * 3;
            default:
                return getBasePrice();
        }
    }
}
//meat and cheese
//inherits both name and price
//getName and getPrice;