package com.FreshFit.items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChipsTest {
    @Test

    public void getPrice_should_calculateTotalAmountForChips(){
        //arrange
        Chips chips = new Chips("BBQ");
        Chips chips1 = new Chips("Spicy");
        //act
        double price = chips.getPrice() + chips1.getPrice();
        //assert
        assertEquals(3, price);
    }

}