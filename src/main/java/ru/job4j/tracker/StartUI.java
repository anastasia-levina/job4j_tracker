package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println(name + " successfully added");
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                System.out.println("loading all items...");
                allItems(tracker.findAll());
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                String id = input.askStr("Enter id: ");
                String newName = input.askStr("Enter new name: ");
                Item item = new Item(newName);
                if (tracker.replace(id, item)) {
                    System.out.println("replacement was successful");
                } else {
                    System.out.println("no replacement, item not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                String id = input.askStr("Enter id: ");
                if (tracker.delete(id)) {
                    System.out.println("item successfully deleted");
                } else {
                    System.out.println("deletion failed, item not found");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                String id = input.askStr("Enter id: ");
                System.out.println("item name to this id: ");
                System.out.println(tracker.findById(id).getName());
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                String key = input.askStr("Enter name: ");
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
    }

    private void allItems(Item[] items) {
        for (int index = 0; index < items.length; index++) {
            System.out.println("name: " + items[index].getName() + ", id: " + items[index].getId());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}