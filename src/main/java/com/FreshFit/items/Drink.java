package com.FreshFit.items;

import com.FreshFit.utilities.IPrice;

public class Drink implements IPrice {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;

    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice() {
        switch (size) {
            case"Small":
                return 2.00;
            case "Medium":
                return 2.50;
            case "Large":
                return 3.00;
            default:
                return 2.00; // Default to small size
        }
    }
    @Override
    public String toString() {
        return size + " " + flavor + " drink";
    }

}
