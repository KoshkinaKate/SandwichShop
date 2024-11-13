package com.FreshFit.components;

public class Cheese extends PremiumTopping {

    public Cheese(String name) {
        super(name, 0.75);
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

