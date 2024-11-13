package com.FreshFit.components;
//Only name created because some sauce/veggies are free and premium has set price

public abstract class Topping {
    private String name;

    public Topping(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract double getPrice(String size);

}
