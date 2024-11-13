package com.FreshFit.orders;

import com.FreshFit.components.Topping;
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

        // List each sandwich with details
        int sandwichNumber = 1;
        for (Sandwich sandwich : sandwiches) {
            summary.append("Sandwich ").append(sandwichNumber++).append(":\n");
            summary.append("  Bread: ").append(sandwich.getBread().getType()).append("\n");
            summary.append("  Size: ").append(sandwich.getSize()).append("\n");
            summary.append("  Toasted: ").append(sandwich.isToasted() ? "Yes" : "No").append("\n");
            summary.append("  Toppings:\n");

            // Premium toppings (like cheese, meat)
            for (Topping topping : sandwich.getPremiumToppings()) {
                summary.append("    - ").append(topping.getName()).append("\n");
            }

            // Regular/free toppings (like sauces, veggies)
            for (Topping topping : sandwich.getRegularToppings()) {
                summary.append("    - ").append(topping.getName()).append("\n");
            }

            summary.append("  Price: $").append(sandwich.getPrice()).append("\n\n");
        }

        // List each drink with details
        int drinkNumber = 1;
        for (Drink drink : drinks) {
            summary.append("Drink ").append(drinkNumber++).append(":\n");
            summary.append("  Size: ").append(drink.getSize()).append("\n");
            summary.append("  Flavor: ").append(drink.getFlavor()).append("\n");
            summary.append("  Price: $").append(drink.getPrice()).append("\n\n");
        }

        // List each chips with details
        int chipsNumber = 1;
        for (Chips chip : chips) {
            summary.append("Chips ").append(chipsNumber++).append(":\n");
            summary.append("  Type: ").append(chip.getType()).append("\n");
            summary.append("  Price: $").append(chip.getPrice()).append("\n\n");
        }

        // Total price
        summary.append("Total Price: $").append(getTotalPrice()).append("\n");
        summary.append("Confirm Order? (yes/no): ");

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