package com.FreshFit.components;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MeatTest {

    @Test
    public void getPrice_should_calculatePriceForMeat(){
        //arrange
        Meat meat = new Meat("Ham");

        //act
        double price = meat.getPrice("8\"");

        //assert
        assertEquals(2,price);
    }
  
}