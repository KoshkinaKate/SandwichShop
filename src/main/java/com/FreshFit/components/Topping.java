package com.FreshFit.components;

import com.FreshFit.utilities.IPrice;
//implementing IPrice so each subclass (PremiumTopping, Meat etc will have getPrice method)
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

    @Override
    public double getPrice() {
        return getPrice("4\"");  // Defaults to smallest size (subclasses does not need to implement getPrice())
    }

    public abstract double getPrice(String size); //subclasses will get this class helpful with sizes to determine price

}
