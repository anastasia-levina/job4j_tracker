package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println(name + " successfully added");
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                System.out.println("loading all items...");
                allItems(tracker.findAll());
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter id: ");
                String id = scanner.nextLine();
                System.out.println("Enter new name: ");
                String newName = scanner.nextLine();
                Item item = new Item(newName);
                if (tracker.replace(id, item)) {
                    System.out.println("replacement was successful");
                } else {
                    System.out.println("no replacement, item not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter id: ");
                String id = scanner.nextLine();
                if (tracker.delete(id)) {
                    System.out.println("item successfully deleted");
                } else {
                    System.out.println("deletion failed, item not found");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.println("Enter id: ");
                String id = scanner.nextLine();
                System.out.println("item name to this id: ");
                System.out.println(tracker.findById(id).getName());
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.println("Enter name: ");
                String key = scanner.nextLine();
                System.out.println("information this item(s): ");
                allItems(tracker.findByName(key));
            } else if (select == 6) {
                System.out.println("=== Exit Program ====");
                System.out.print("Goodbye!");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select: ");
    }

    private void allItems(Item[] items) {
        for (int index = 0; index < items.length; index++) {
            System.out.println("name: " + items[index].getName() + ", id: " + items[index].getId());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}