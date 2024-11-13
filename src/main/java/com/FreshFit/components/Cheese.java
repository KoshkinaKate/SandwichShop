package com.FreshFit.components;

public class Cheese extends PremiumTopping {

    public Cheese(String name, double basePrice) {
        super(name, basePrice);
    }

    @Override
    public double getPrice(String size) {
        switch (size) {
            case "4\"":
                return 0.75;
            case "8\"":
                return 1.50;
            case "12\"":
                return 2.25;
            default:
                return 0.75;
        }
    }
}

