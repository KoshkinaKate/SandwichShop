package com.FreshFit.ui;

import java.util.Scanner;

public class HomeScreen {
   private Scanner scanner = new Scanner(System.in);
   private UserInterface ui;

    public HomeScreen(UserInterface ui) {
        this.ui = ui;
    }

    public void displayMenu(){
        while(true){
            System.out.println("Welcome to Fresh and Fit! ");
            System.out.println("1. New Order");
            System.out.println("2. Exit");

            System.out.println("Please choose an option: ");
            int option = scanner.nextInt();
        }
    }
}
