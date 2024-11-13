package com.FreshFit.components;

public class Meat extends PremiumTopping {

    //constructor
    public Meat(String name) {
        super(name);
    }

    @Override
    public double getPrice(String size) {
        switch (size) {
            case "4\"":
                return 1;
            case "8\"":
                return 2;
            case "12\"":
                return 3;
            default:
                return 1;
        }
    }

}
