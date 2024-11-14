package com.FreshFit.orders;

import com.FreshFit.components.Bread;
import com.FreshFit.components.Cheese;
import com.FreshFit.components.Meat;
import com.FreshFit.items.Chips;
import com.FreshFit.items.Drink;
import com.FreshFit.items.Sandwich;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    public void getTotalPrice_should_calculate_SandwichDrinkChipsAmount(){
        //arrange
        Sandwich sandwich = new Sandwich("4\"",true,new Bread("white"));
        sandwich.addToppings(List.of(new Meat("Turkey"), new Cheese("Swiss")));

        Drink drink = new Drink("Medium", "Water");

        Chips chip = new Chips("BBQ");

        Order currentOrder = new Order();

        currentOrder.addSandwich(sandwich);
        currentOrder.addDrink(drink);
        currentOrder.addChips(chip);

        double expectedTotalPrice = sandwich.getPrice() + drink.getPrice() + chip.getPrice();

        //act
        double actualTotalPrice = currentOrder.getTotalPrice();

        //assert
        assertEquals(expectedTotalPrice,actualTotalPrice);
    }

}