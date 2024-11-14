package com.FreshFit.items;

import com.FreshFit.components.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    public void getPrice_should_calculatePrice4Sandwich(){
        //arrange
        Sandwich sandwich = new Sandwich("12\"", true, new Bread("rye"));
        sandwich.addToppings(List.of(
                new Meat("Chicken"),
                new Cheese("Provolone"),
                new Vegetable("Pickles"),
                new Sauce("Mayo")));
        //act
        double price = sandwich.getPrice();
        //assert
        assertEquals(13.75,price);
    }


}