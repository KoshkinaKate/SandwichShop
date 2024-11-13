//package com.FreshFit.ui;
//
//import com.FreshFit.items.Drink;
//
//public class DrinkMenu {
//    private UserInterface ui;
//
//    public DrinkMenu(UserInterface ui) {
//        this.ui = ui;
//    }
//
//    public void display() {
//        System.out.print("Select Drink Size (Small, Medium, Large): ");
//        String size = ui.getScanner().nextLine();
//
//        System.out.print("Select Drink Flavor: ");
//        String flavor = ui.getScanner().nextLine();
//
//        ui.getCurrentOrder().addDrink(new Drink(size, flavor));
//        System.out.println("Drink added to your order.");
//        new OrderScreen(ui).display();
//    }
//}
