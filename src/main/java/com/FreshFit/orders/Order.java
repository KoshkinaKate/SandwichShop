package com.FreshFit.orders;

import com.FreshFit.items.Chips;
import com.FreshFit.items.Drink;
import com.FreshFit.items.Sandwich;
import com.FreshFit.utilities.FileManager;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich (Sandwich sandwich){
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public void addChips(Chips chip){
        chips.add(chip);
    }
    public double getTotalPrice (){
        double total =0;
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getPrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (Chips chip : chips) {
            total += chip.getPrice();
        }
        return total;
    }
    // Generates a summary of the entire order
    public String generateOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order Summary:\n");

        summary.append("Sandwiches:\n");
        for (Sandwich sandwich : sandwiches) {
            summary.append("- ").append(sandwich).append(" | Price: $").append(sandwich.getPrice()).append("\n");
        }

        summary.append("Drinks:\n");
        for (Drink drink : drinks) {
            summary.append("- ").append(drink).append(" | Price: $").append(drink.getPrice()).append("\n");
        }

        summary.append("Chips:\n");
        for (Chips chip : chips) {
            summary.append("- ").append(chip).append(" | Price: $").append(chip.getPrice()).append("\n");
        }

        summary.append("Total Price: $").append(getTotalPrice()).append("\n");
        return summary.toString();
    }

    public void checkOut(){
        String orderDetails = generateOrderSummary();
        FileManager.generateReceipt(orderDetails);
    };


    
}
// Keeps track of items in the order and calculates the total
//List<Sandwich> same with drink, chips.
//getTotalPrice(): double
//CheckOut->calls fileManager
//addSandwich, addDrink, addChips void.