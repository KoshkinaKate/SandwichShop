package com.FreshFit.components;

public class Meat extends PremiumTopping{
    public Meat(String name, double basePrice) {
        super(name, 1); //$1 for 4"
    }
    //do not override because it inherits getPrice(String size) from Premium Toppings, override getPrice()-default or getPrice(string) if methods need to be changed.
}
