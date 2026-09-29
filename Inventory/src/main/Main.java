package main;

import crop.Crop;
import farmsupply.FarmSupply;
import inventoryitem.InventoryItem;
import livestock.Livestock;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<InventoryItem> inventory = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Farmer Inventory ===");
            System.out.println("1. Add an item");
            System.out.println("2. View inventory");
            System.out.println("3. Update stock");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            switch (input.nextLine().trim()) {
                case "1" -> addItem();
                case "2" -> showInventory();
                case "3" -> updateStock();
                case "4" -> running = false;
                default -> System.out.println("Please choose 1, 2, 3, or 4.");
            }
        }

        System.out.println("Inventory closed.");
    }

    private static void addItem() {
        System.out.println("\nItem type: 1. Crop  2. Livestock  3. Farm supply");
        System.out.print("Choose a type: ");
        String type = input.nextLine().trim();
        if (!type.equals("1") && !type.equals("2") && !type.equals("3")) {
            System.out.println("Please choose a valid item type.");
            return;
        }

        String name = readText("Item name: ");
        int quantity = readPositiveInteger("Quantity: ");
        String unit = readText("Unit (kg, bags, head, etc.): ");

        InventoryItem item = switch (type) {
            case "1" -> new Crop(name, quantity, unit, readText("Growing season: "));
            case "2" -> new Livestock(name, quantity, unit, readText("Breed or animal type: "));
            default -> new FarmSupply(name, quantity, unit, readText("What is it used for? "));
        };

        inventory.add(item);
        System.out.println("Added: " + item);
    }

    private static void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }

        System.out.println("\n--- Current Inventory ---");
        for (int index = 0; index < inventory.size(); index++) {
            System.out.println((index + 1) + ". " + inventory.get(index));
        }
    }

    private static void updateStock() {
        if (inventory.isEmpty()) {
            System.out.println("Add an item before updating stock.");
            return;
        }

        showInventory();
        int itemNumber;
        while (true) {
            itemNumber = readPositiveInteger("Item number to update: ");
            if (itemNumber <= inventory.size()) {
                break;
            }
            System.out.println("Choose an item number from the list.");
        }

        InventoryItem item = inventory.get(itemNumber - 1);
        System.out.println("1. Add stock  2. Remove stock");
        System.out.print("Choose an action: ");
        String action = input.nextLine().trim();
        int amount = readPositiveInteger("Amount: ");

        if (action.equals("1")) {
            item.addStock(amount);
            System.out.println("Updated: " + item);
        } else if (action.equals("2")) {
            if (item.removeStock(amount)) {
                System.out.println("Updated: " + item);
            } else {
                System.out.println("There is not enough stock to remove that amount.");
            }
        } else {
            System.out.println("Please choose 1 or 2. No stock was changed.");
        }
    }

    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = input.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This value cannot be empty.");
        }
    }

    private static int readPositiveInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(input.nextLine().trim());
                if (value > 0) {
                    return value;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Enter a whole number greater than zero.");
                continue;
            }
            System.out.println("Enter a whole number greater than zero.");
        }
    }
}