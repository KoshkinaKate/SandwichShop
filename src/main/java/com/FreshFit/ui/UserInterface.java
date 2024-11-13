package com.FreshFit.ui;

import com.FreshFit.orders.Order;

public class UserInterface {
    private Order currentOrder;
    private HomeScreen homeScreen;

    public UserInterface(){
        homeScreen = new HomeScreen();
    }
    public void displayHomeScreen(){
        homeScreen.displayMenu();
    }
    public void startNewOrder(){
    }
    public void displayAllMenus(){

    }
    public void viewOrderSummary(){

    }
    public void confirmOrder(){

    }
}
//controller
//It may instantiate and call the display methods of screens like HomeScreen, DrinkMenu, SandwichMenu, and CheckOutMenu
// manages the screens and coordinates between them.
//displayHomeScreen();
//startNewOrder();
//display all the menus;
//viewOrderSummary()
//confirmOrder();