package com.FreshFit.components;

public class Meat extends PremiumTopping{
    public Meat(String name, double basePrice) {
        super(name, 1); //$1 for 4"
    }
    //do not override because the method in Topping is set as default
}
