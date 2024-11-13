package com.FreshFit.components;

public class Cheese extends PremiumTopping {

    //constructor
    public Cheese(String name) {
        super(name);
    }

    @Override
    public double getPrice(String size) {
        switch (size) {
            case "4\"":
                return 0.75;
            case "8\"":
                return 1.5;
            case "12\"":
                return 2.25;
            default:
                return 0.75;
        }
    }
}

