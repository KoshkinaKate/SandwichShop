package com.FreshFit.items;
// this class managing sandwich properties and calculates total Price for the Sandwich
import com.FreshFit.components.Bread;
import com.FreshFit.components.PremiumTopping;
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

    public List<Topping> getToppings() {
        return toppings;
    }

    // Add multiple toppings to the sandwich
    //addAll to append all items from the provided toppings list to the existing list in the sandwich
    public void addToppings(List<Topping> toppings) {
        this.toppings.addAll(toppings);
    }

    private double getSandwichPriceBySize() {
        switch (size) {
            case "4\"":
                return 5.50;
            case "8\"":
                return 7.00;
            case "12\"":
                return 8.50;
            default:
                return 5.5;  // Default to 4"
        }
    }

    //total price for sandwich
    @Override
    public double getPrice() {
        double totalPrice = getSandwichPriceBySize();

        // Add premium topping prices
        for (Topping topping : toppings) {
            if (topping instanceof PremiumTopping) { //check to see the topping is premium
                totalPrice += ((PremiumTopping) topping).getPrice(size);
            }
        }
        return totalPrice;
    }
}