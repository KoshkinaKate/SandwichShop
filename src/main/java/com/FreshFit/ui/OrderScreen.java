package com.FreshFit.ui;

import com.FreshFit.orders.Order;

import java.util.Scanner;

public class OrderScreen {
    private Order order;
    Scanner scanner = new Scanner(System.in);

    public OrderScreen(Order order) {
        this.order = order;
    }

    public void displayOrderMenu(){
        while(true) {
            System.out.println("Order Menu:");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel Order");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

//            switch (option) {
//                case 1:
//                    new SandwichMenu(order).displaySanswichMenu();
//                    break;
//                case 2:
//                    new DrinkMenu(order).displayDrinkMenu();
//                    break;
//                case 3:
//                    new ChipsMenu(order).displayChipsMenu();
//                    break;
//                case 4:
//                    new CheckOutMenu(order).displayCheckoutMenu();
//                    return;
//                case 0:
//                    System.out.println("Order canceled. Returning to main menu.");
//                    return;
//                default:
//                    System.out.println("Invalid Option");
//            }
        }
    }
}