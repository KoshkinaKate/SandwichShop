package com.FreshFit.ui;
// interactive menu for a customer
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
    private Order currentOrder; //stores a current order
    private Scanner scanner = new Scanner(System.in);

    //constructor
    public UserInterface() {
        this.currentOrder = new Order(); //assign to an Object
    }

    public void start() {
        displayHomeScreen();
    }

    // Display HomeScreen
    private void displayHomeScreen() {
        System.out.println("Welcome to Fresh & Fit Sandwich Shop!");
        System.out.println("Striving to help you stay healthy ");
        System.out.println("1. Start a new order");
        System.out.println("2. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            startNewOrder();
        } else if (choice == 2) {
            System.out.println("Thank you! Have a wonderful day!");
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
            System.out.println("1. Create a Nutritious Sandwich");
            System.out.println("2. Choose a Fresh, Hydrating Drink");
            System.out.println("3. Add a Wholesome Snack (Chips) ");
            System.out.println("4. Proceed to Checkout with Your Healthy Choices");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addSandwich();
                case 2 -> {
                    currentOrder.addDrink(selectDrink());
                    System.out.println("Drink added to your order.");
                }
                case 3 -> {
                    currentOrder.addChips(selectChips());
                    System.out.println("Snack added to your order.");
                }
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
        sandwich.addToppings(selectSauceOptions());
        sandwich.addToppings(selectVegetableOptions());

        currentOrder.addSandwich(sandwich);
        System.out.println("A nutritious sandwich has been added to your order.");
        displayOrderScreen();
    }

    private String selectSandwichSize() {
        System.out.println("Select size:");
        System.out.println("1. 4\"");
        System.out.println("2. 8\"");
        System.out.println("3. 12\"");

        int choice = scanner.nextInt();
        scanner.nextLine();

        return switch (choice) {
            case 1 -> "4\"";
            case 2 -> "8\"";
            case 3 -> "12\"";
            default -> {
                System.out.println("Invalid choice.");
                yield "4\"";
            }
        };
    }

    private String selectBreadType() {
        System.out.println("Pick your foundation for a balanced meal:");
        System.out.println("1. Soft White (Comfort Classic)");
        System.out.println("2. Whole Wheat (Heart-Healthy Choice)");
        System.out.println("3. Rye (Packed with Fiber and Flavor)");
        System.out.println("4. Multigrain (Loaded with Whole Grains)");
        System.out.println("5. Sourdough (Gut-Friendly Probiotics)");
        System.out.println("6. Wrap (Perfect for a Low-Calorie Option)");


        int choice = scanner.nextInt();
        scanner.nextLine();

        return switch (choice) {
            case 1 -> "white";
            case 2 -> "wheat";
            case 3 -> "rye";
            case 4 -> "multigrain";
            case 5 -> "sourdough";
            case 6 -> "wrap";
            default -> {
                System.out.println("Invalid choice.");
                yield "white"; //acts like a return statement
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
        System.out.println("Choose your protein: ");
        System.out.println("1. Turkey (Lean and High Protein)");
        System.out.println("2. Ham (Rich in Flavor)");
        System.out.println("3. Steak (Protein-Packed)");
        System.out.println("4. Chicken (Low Fat, High Protein)");
        System.out.println("5. Roast Beef (Iron-Rich)");
        System.out.println("Enter 0 to finish selection.");


        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> meats.add(new Meat("Turkey"));
                case 2 -> meats.add(new Meat("Ham"));
                case 3 -> meats.add(new Meat("Steak"));
                case 4 -> meats.add(new Meat("Chicken"));
                case 5 -> meats.add(new Meat("Roast Beef"));
                case 0 -> { return meats; }
                default -> System.out.println("Invalid choice.");
            }
            System.out.println("Add another meat or type '0' to finish:");
        }
    }

    private List<Topping> selectCheeseOptions() {
        List<Topping> cheeses = new ArrayList<>();
        System.out.println("Choose your cheese: ");
        System.out.println("1. Swiss (Low Sodium)");
        System.out.println("2. Cheddar (Rich in Calcium)");
        System.out.println("3. Mozzarella (Light and Creamy)");
        System.out.println("4. Provolone (Smooth Flavor)");
        System.out.println("5. Pepper Jack (Spicy Kick)");
        System.out.println("Enter 0 to finish selection.");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> cheeses.add(new Cheese("Swiss"));
                case 2 -> cheeses.add(new Cheese("Cheddar"));
                case 3 -> cheeses.add(new Cheese("Mozzarella"));
                case 4 -> cheeses.add(new Cheese("Provolone"));
                case 5 -> cheeses.add(new Cheese("Pepper Jack"));
                case 0 -> { return cheeses; } //saves a list of chosen cheeses
                default -> System.out.println("Invalid choice.");
            }
            System.out.println("Add another cheese or type '0' to finish:");
        }
    }

    private List<Topping> selectSauceOptions() {
        List<Topping> sauces = new ArrayList<>();
        System.out.println("Select your sauce:");
        System.out.println("1. Ketchup (Classic Flavor)");
        System.out.println("2. Mustard (Low Calorie, Zesty)");
        System.out.println("3. Mayo (Smooth and Creamy)");
        System.out.println("4. BBQ Sauce (Smoky and Bold)");
        System.out.println("5. Hot Sauce (Spicy Kick)");
        System.out.println("Enter 0 to finish selection.");


        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> sauces.add(new Sauce("Ketchup"));
                case 2 -> sauces.add(new Sauce("Mustard"));
                case 3 -> sauces.add(new Sauce("Mayo"));
                case 4 -> sauces.add(new Sauce("BBQ Sauce"));
                case 5 -> sauces.add(new Sauce("Hot Sauce"));
                case 0 -> { return sauces; }
                default -> System.out.println("Invalid choice.");
            }
            System.out.println("Add another sauce or type '0' to finish:");
        }
    }

    private List<Topping> selectVegetableOptions() {
        List<Topping> vegetables = new ArrayList<>();
        System.out.println("Choose your veggies:");
        System.out.println("1. Lettuce (Crisp and Fresh)");
        System.out.println("2. Tomato (Juicy and Rich in Antioxidants)");
        System.out.println("3. Onion (Adds a Zesty Crunch)");
        System.out.println("4. Pickles (Tangy and Low Calorie)");
        System.out.println("5. Cucumber (Refreshing and Hydrating)");
        System.out.println("6. Spinach (Packed with Nutrients)");
        System.out.println("Enter 0 to finish selection.");


        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> vegetables.add(new Vegetable("Lettuce"));
                case 2 -> vegetables.add(new Vegetable("Tomato"));
                case 3 -> vegetables.add(new Vegetable("Onion"));
                case 4 -> vegetables.add(new Vegetable("Pickles"));
                case 5 -> vegetables.add(new Vegetable("Cucumber"));
                case 6 -> vegetables.add(new Vegetable("Spinach"));
                case 0 -> { return vegetables; }
                default -> System.out.println("Invalid choice.");
            }
            System.out.println("Add another vegetable or type '0' to finish:");
        }
    }

    private Drink selectDrink() {
        System.out.println("Select Drink Size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        System.out.println("4. Extra Large");


        String size;
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        switch (sizeChoice) {
            case 1 -> size = "Small";
            case 2 -> size = "Medium";
            case 3 -> size = "Large";
            case 4 -> size = "Extra Large";
            default -> {
                System.out.println("Invalid choice.");
                size = "Small";
            }
        }

        System.out.println("Select your drink: ");
        System.out.println("1. Cola (Classic but Sugary)");
        System.out.println("2. Juice (Refreshing and Natural)");
        System.out.println("3. Water (Pure and Hydrating)");
        System.out.println("4. Sparkling Water (Zero Calories, Bubbly)");
        System.out.println("5. Iced Tea (Light and Refreshing)");
        System.out.println("6. Gatorade (Electrolyte Boost)");
        System.out.println("Enter 0 to finish selection.");


        String type;
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        switch (typeChoice) {
            case 1 -> type = "Cola";
            case 2 -> type = "Juice";
            case 3 -> type = "Water";
            case 4 -> type = "Sparkling Water";
            case 5 -> type = "Iced Tea";
            case 6 -> type = "Gatorade";
            default -> {
                System.out.println("Invalid choice.");
                type = "Water"; //type is ready for use whenever we need it when yield is right now giving a choice
            }
        }
        return new Drink(size, type); // Create the drink with the selected size and type
    }


    private Chips selectChips() {
        System.out.println("Select your chips:");
        System.out.println("1. BBQ (Smoky and Bold)");
        System.out.println("2. Spicy (Hot and Zesty)");
        System.out.println("3. Regular (Classic Crunch)");
        System.out.println("4. Sour Cream & Onion (Tangy Twist)");
        System.out.println("5. Salt & Vinegar (Sharp and Savory)");
        System.out.println("Enter 0 to finish selection.");


        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        return switch (choice) {
            case 1 -> new Chips("BBQ");
            case 2 -> new Chips("Spicy");
            case 3 -> new Chips("Regular");
            case 4 -> new Chips("Sour Cream & Onion");
            case 5 -> new Chips("Salt & Vinegar");
            default -> {
                System.out.println("Invalid choice.");
                yield new Chips("Regular");
            }
        };
    }

    private void displayCheckOutMenu() {
        // Display the order summary on the console
        System.out.println("Checkout Summary:");
        String orderDetails = currentOrder.generateOrderSummary();
        System.out.println(orderDetails);

        System.out.println("Confirm Order? (yes/no):");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("yes")) {
            // Save the receipt to a file upon confirmation
            FileManager.generateReceipt(orderDetails);
            // Go back to the home screen after confirming
            displayHomeScreen();
        } else if (confirmation.equals("no")) {
            System.out.println("Order canceled. Returning to the order menu.");
            // Return to the order screen if the user cancels
            displayOrderScreen();
        } else {
            System.out.println("Invalid choice.");
            // Retry if the input is invalid
            displayCheckOutMenu();
        }
    }
}

