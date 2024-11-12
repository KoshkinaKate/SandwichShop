package com.FreshFit.orders;

import com.FreshFit.items.Chips;
import com.FreshFit.items.Drink;
import com.FreshFit.items.Sandwich;

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

    
}
// Keeps track of items in the order and calculates the total
//List<Sandwich> same with drink, chips.
//getTotalPrice(): double
//CheckOut->calls fileManager
//addSandwich, addDrink, addChips void.