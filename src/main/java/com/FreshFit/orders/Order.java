package com.FreshFit.orders;
//manages customer's order calc.price for sandwiches, drinks, chips
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

    //adding objects to the list
    public void addSandwich (Sandwich sandwich){
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public void addChips(Chips chip){
        chips.add(chip);
    }

    //total price for the order
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

        int sandwichCount = 1;
        for (Sandwich sandwich : sandwiches) {
            summary.append("Sandwich ").append(sandwichCount++).append(":\n")
                    .append("  Bread: ").append(sandwich.getBread().getType()).append("\n")
                    .append("  Size: ").append(sandwich.getSize()).append("\n")
                    .append("  Toasted: ").append(sandwich.isToasted() ? "Yes" : "No").append("\n")
                    .append("  Toppings:\n");

            for (Topping topping : sandwich.getToppings()) {
                summary.append("    - ").append(topping.getName()).append("\n"); // Add each topping, including sauces
            }

            summary.append("  Price: $").append(sandwich.getPrice()).append("\n\n");
        }

        int drinkCount = 1;
        for (Drink drink : drinks) {
            summary.append("Drink ").append(drinkCount++).append(":\n")
                    .append("  Size: ").append(drink.getSize()).append("\n")
                    .append("  Flavor: ").append(drink.getFlavor()).append("\n")
                    .append("  Price: $").append(drink.getPrice()).append("\n\n");
        }

        int chipsCount = 1;
        for (Chips chip : chips) {
            summary.append("Chips ").append(chipsCount++).append(":\n")
                    .append("  Type: ").append(chip.getType()).append("\n")
                    .append("  Price: $").append(chip.getPrice()).append("\n\n");
        }

        summary.append("Total Price: $").append(getTotalPrice()).append("\n");
        return summary.toString();
    }
    // finalizes the order by generating a receipt file through the FileManager
    public void checkOut(){
        String orderDetails = generateOrderSummary();
        FileManager.generateReceipt(orderDetails);
    };
}
