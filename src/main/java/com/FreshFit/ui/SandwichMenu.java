package com.FreshFit.ui;

import com.FreshFit.components.Bread;
import com.FreshFit.orders.Order;

import java.util.Scanner;

public class SandwichMenu {
    private Order order;
    Scanner scanner = new Scanner(System.in);

    public SandwichMenu(Order order) {
        this.order = order;
    }
    public void displaySandwichMenu() {

        //Bread options
        System.out.println("Select Your Bread:");
        System.out.println("1. White");
        System.out.println("2. Wheat");
        System.out.println("3. Rye");

        Bread bread;
        int breadChoice = scanner.nextInt();
        switch (breadChoice) {
            case 1:
                bread = new Bread("White");
                break;
            case 2:
                bread = new Bread("Wheat");
                break;
            case 3:
                bread = new Bread("Rye");
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }
        //Sandwich size
        

    }
}
// all screens need to operate on the same Order instance ->should accept the Order instance as a parameter, through the constructor
//bread a,b,c; size a,b,c; toasted yes/no; toppings meat, cheese, regular ones, sauces
//display()