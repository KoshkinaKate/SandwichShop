package com.FreshFit.ui;

import com.FreshFit.orders.Order;
import com.FreshFit.items.Sandwich;
import com.FreshFit.items.Drink;
import com.FreshFit.items.Chips;
import com.FreshFit.components.Bread;
import com.FreshFit.components.Meat;
import com.FreshFit.components.Cheese;
import com.FreshFit.components.Sauce;
import com.FreshFit.components.Vegetable;
import com.FreshFit.components.Topping;
import com.FreshFit.utilities.FileManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Order currentOrder;
    private Scanner scanner;

    public UserInterface() {
        this.currentOrder = new Order();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        displayHomeScreen();
    }

    // Display Home Screen
    private void displayHomeScreen() {
        System.out.println("Welcome to DELI-cious Sandwich Shop!");
        System.out.println("1. Start a new order");
        System.out.println("2. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            startNewOrder();
        } else if (choice == 2) {
            System.out.println("Thank you! Have a great day!");
        } else {
            System.out.println("Invalid choice. Try again.");
            displayHomeScreen();
        }
    }

    // Start a New Order
    private void startNewOrder() {
        this.currentOrder = new Order();
        displayOrderScreen();
    }

    // Display Order Screen
    private void displayOrderScreen() {
        boolean continueOrdering = true;

        while (continueOrdering) {
            System.out.println("Order Menu:");
            System.out.println("1. Add a Sandwich");
            System.out.println("2. Add a Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addSandwich();
                case 2 -> currentOrder.addDrink(selectDrink());
                case 3 -> currentOrder.addChips(selectChips());
                case 4 -> {
                    displayCheckOutMenu();
                    continueOrdering = false; // Exit loop after checkout
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Sandwich Menu
    private void addSandwich() {
        String size = selectSandwichSize();
        String breadType = selectBreadType();
        boolean toasted = selectToastedOption();
        Sandwich sandwich = new Sandwich(size, toasted, new Bread(breadType));

        // Add meats, cheeses, sauces, and vegetables
        sandwich.addToppings(selectMeatOptions());
        sandwich.addToppings(selectCheeseOptions());
        sandwich.addToppings(selectSauceOptions());       // Add sauces
        sandwich.addToppings(selectVegetableOptions());   // Add vegetables

        currentOrder.addSandwich(sandwich);
        System.out.println("Sandwich added to your order.");
        displayOrderScreen();
    }

    private String selectSandwichSize() {
        System.out.println("Select size:");
        System.out.println("1. 4\"");
        System.out.println("2. 8\"");
        System.out.println("3. 12\"");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        return switch (choice) {
            case 1 -> "4\"";
            case 2 -> "8\"";
            case 3 -> "12\"";
            default -> {
                System.out.println("Invalid choice. Defaulting to 4\".");
                yield "4\"";
            }
        };
    }

    private String selectBreadType() {
        System.out.println("Choose bread type:");
        System.out.println("1. White");
        System.out.println("2. Wheat");
        System.out.println("3. Rye");
        System.out.println("4. Wrap");

        int choice = scanner.nextInt();
        scanner.nextLine();

        return switch (choice) {
            case 1 -> "white";
            case 2 -> "wheat";
            case 3 -> "rye";
            case 4 -> "wrap";
            default -> {
                System.out.println("Invalid choice. Defaulting to white.");
                yield "white";
            }
        };
    }

    private boolean selectToastedOption() {
        System.out.println("Would you like it toasted?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice == 1; // Return true if yes, false if no
    }

    private List<Topping> selectMeatOptions() {
        List<Topping> meats = new ArrayList<>();
        System.out.println("Select meat (choose options by number, type '0' to finish):");
        System.out.println("1. Turkey");
        System.out.println("2. Ham");
        System.out.println("3. Steak");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> meats.add(new Meat("Turkey"));
                case 2 -> meats.add(new Meat("Ham"));
                case 3 -> meats.add(new Meat("Steak"));
                case 0 -> { return meats; }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("Add another meat or type '0' to finish:");
        }
    }

    private List<Topping> selectCheeseOptions() {
        List<Topping> cheeses = new ArrayList<>();
        System.out.println("Select cheese (choose options by number, type '0' to finish):");
        System.out.println("1. Swiss");
        System.out.println("2. Cheddar");
        System.out.println("3. Mozzarella");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> cheeses.add(new Cheese("Swiss"));
                case 2 -> cheeses.add(new Cheese("Cheddar"));
                case 3 -> cheeses.add(new Cheese("Mozzarella"));
                case 0 -> { return cheeses; }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("Add another cheese or type '0' to finish:");
        }
    }

    private List<Topping> selectSauceOptions() {
        List<Topping> sauces = new ArrayList<>();
        System.out.println("Select sauces (choose options by number, type '0' to finish):");
        System.out.println("1. Ketchup");
        System.out.println("2. Mustard");
        System.out.println("3. Mayo");
        System.out.println("4. BBQ Sauce");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> sauces.add(new Sauce("Ketchup"));
                case 2 -> sauces.add(new Sauce("Mustard"));
                case 3 -> sauces.add(new Sauce("Mayo"));
                case 4 -> sauces.add(new Sauce("BBQ Sauce"));
                case 0 -> { return sauces; }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("Add another sauce or type '0' to finish:");
        }
    }

    private List<Topping> selectVegetableOptions() {
        List<Topping> vegetables = new ArrayList<>();
        System.out.println("Select vegetables (choose options by number, type '0' to finish):");
        System.out.println("1. Lettuce");
        System.out.println("2. Tomato");
        System.out.println("3. Onion");
        System.out.println("4. Pickles");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> vegetables.add(new Vegetable("Lettuce"));
                case 2 -> vegetables.add(new Vegetable("Tomato"));
                case 3 -> vegetables.add(new Vegetable("Onion"));
                case 4 -> vegetables.add(new Vegetable("Pickles"));
                case 0 -> { return vegetables; }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("Add another vegetable or type '0' to finish:");
        }
    }

    private Drink selectDrink() {
        System.out.println("Select Drink Size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        String size;
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        switch (sizeChoice) {
            case 1 -> size = "Small";
            case 2 -> size = "Medium";
            case 3 -> size = "Large";
            default -> {
                System.out.println("Invalid choice. Defaulting to Small.");
                size = "Small";
            }
        }

        System.out.println("Select Drink Type:");
        System.out.println("1. Cola");
        System.out.println("2. Juice");
        System.out.println("3. Water");

        String type;
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        switch (typeChoice) {
            case 1 -> type = "Cola";
            case 2 -> type = "Juice";
            case 3 -> type = "Water";
            default -> {
                System.out.println("Invalid choice. Defaulting to Cola.");
                type = "Cola";
            }
        }

        return new Drink(size, type); // Create the drink with the selected size and type
    }


    private Chips selectChips() {
        System.out.println("Select Chips Type:");
        System.out.println("1. BBQ");
        System.out.println("2. Spicy");
        System.out.println("3. Regular");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        return switch (choice) {
            case 1 -> new Chips("BBQ");
            case 2 -> new Chips("Spicy");
            case 3 -> new Chips("Regular");
            default -> {
                System.out.println("Invalid choice. Defaulting to Regular.");
                yield new Chips("Regular");
            }
        };
    }

    private void displayCheckOutMenu() {
        System.out.println("Checkout Summary:");
        String orderDetails = currentOrder.generateOrderSummary();
        System.out.println(orderDetails); // Display the order summary on the console

        System.out.println("Confirm Order? (yes/no):");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("yes")) {
            // Save the receipt to a file upon confirmation
            FileManager.generateReceipt(orderDetails);
            System.out.println("Order confirmed! Your receipt has been generated.");
            displayHomeScreen(); // Go back to the home screen after confirming
        } else if (confirmation.equals("no")) {
            System.out.println("Order canceled. Returning to the order menu.");
            displayOrderScreen(); // Return to the order screen if the user cancels
        } else {
            System.out.println("Invalid choice. Try again.");
            displayCheckOutMenu(); // Retry if the input is invalid
        }
    }
}

