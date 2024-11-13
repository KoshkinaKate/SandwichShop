package com.FreshFit.components;

public class Meat extends PremiumTopping {
    public Meat(String name, double basePrice) {
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
                return getBasePrice(); // Default to 4"
        }
    }

}
