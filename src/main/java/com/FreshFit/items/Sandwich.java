package com.FreshFit.items;

import com.FreshFit.components.Bread;
import com.FreshFit.components.PremiumTopping;
import com.FreshFit.components.RegularTopping;
import com.FreshFit.components.Topping;
import com.FreshFit.utilities.IPrice;

import java.util.ArrayList;
import java.util.List;
// this class calculates total Price for the Sandwich
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

    // Add a single topping to the sandwich
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Add multiple toppings to the sandwich
    public void addToppings(List<Topping> toppings) {
        this.toppings.addAll(toppings);
    }

    public List<Topping> getToppings() {
        return toppings;
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
                return 0;  // Default to 4"
        }
    }
    public List<Topping> getPremiumToppings() {
        List<Topping> premiumToppings = new ArrayList<>();
        for (Topping topping : toppings) {
            if (topping instanceof PremiumTopping) {
                premiumToppings.add(topping);
            }
        }
        return premiumToppings;
    }

    public List<Topping> getRegularToppings() {
        List<Topping> regularToppings = new ArrayList<>();
        for (Topping topping : toppings) {
            if (topping instanceof RegularTopping) {
                regularToppings.add(topping);
            }
        }
        return regularToppings;
    }

    @Override
    public double getPrice() {
        double totalPrice = getSandwichPriceBySize();

        // Add premium topping prices
        for (Topping topping : toppings) {
            if (topping instanceof PremiumTopping) {
                totalPrice += ((PremiumTopping) topping).getPrice(size);
            }
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder();
        details.append(size).append(" sandwich on ").append(bread);
        if (toasted) {
            details.append(" (toasted)");
        }
        details.append(", Toppings: ");
        toppings.forEach(topping -> details.append(topping).append(", "));
        if (!toppings.isEmpty()) {
            details.setLength(details.length() - 2); // Remove trailing comma
        }
        return details.toString();
    }
}