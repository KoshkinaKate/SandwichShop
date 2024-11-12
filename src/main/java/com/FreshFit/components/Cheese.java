package com.FreshFit.components;

public class Cheese extends PremiumTopping{
    public Cheese(String name, double basePrice) {
        super(name, 0.75); // 0.75 for 4"
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
                return getBasePrice(); // Default to 4"
        }
    }
}
