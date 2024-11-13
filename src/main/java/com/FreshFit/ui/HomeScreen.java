//package com.FreshFit.ui;
//
//import java.util.Scanner;
//
//public class HomeScreen {
//    private Scanner scanner = new Scanner(System.in);
//    private UserInterface ui;
//
//    public HomeScreen(UserInterface ui) {
//        this.ui = ui;
//    }
//
//    public HomeScreen() {
//
//    }
//
//    public void displayMenu(){
//        while(true){
//            System.out.println("Welcome to Fresh & Fit! ");
//            System.out.println("1. New Order");
//            System.out.println("2. Exit");
//
//            System.out.println("Please choose an option: ");
//            int option = scanner.nextInt();
//
//            switch (option){
//                case 1:
//                    ui.startNewOrder();
//                    break;
//                case 0:
//                    System.out.println("Thank you for visiting Fresh & Fit!");
//                default:
//                    System.out.println("Invalid Option. ");
//            }
//        }
//    }
//}