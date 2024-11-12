package com.FreshFit.components;

import com.FreshFit.utilities.IPrice;

public abstract class Topping implements IPrice {
    private String name;
    private double basePrice; //will be set by subclasses

    public Topping(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public abstract double getPrice(String size); //subclasses will get this class

}
