package com.FreshFit.items;

import com.FreshFit.components.Bread;
import com.FreshFit.components.Topping;
import com.FreshFit.utilities.IPrice;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements IPrice {
    private String size;
    private boolean toasted;
    private Bread bread;
    private List<Topping> toppings;

    public Sandwich(String size, boolean toasted, Bread bread) {
        this.size = size;
        this.toasted = toasted;
        this.bread = bread;
        this.toppings = new ArrayList<>();
    }

    public String getSize() {
        return size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public Bread getBread() {
        return bread;
    }

    //premium and regular toppings
    public void addTopping(Topping topping){
        toppings.add(topping);
    }


    @Override
    public double getPrice() {
        double totalPrice = 
    }
}