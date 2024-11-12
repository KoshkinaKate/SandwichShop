package com.FreshFit.components;

public class RegularTopping extends Topping{
    public RegularTopping(String name, double basePrice) {
        super(name, 0.0);
    }

//    @Override
//    public double getPrice(String size) { // abstract method from Topping, must be implemented
//        return 0.0; //free toppings
//    }
}