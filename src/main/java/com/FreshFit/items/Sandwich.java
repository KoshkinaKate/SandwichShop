package com.FreshFit.items;

import com.FreshFit.utilities.IPrice;

public class Sandwich implements IPrice {
    @Override
    public double getPrice() {
        return 0;
    }
}
//Represents a sandwich, implements iPrice
// String size, List<Toppings>, boolean toasted, Bread bread
//addTopping() void