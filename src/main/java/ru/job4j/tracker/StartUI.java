package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                showItems(tracker);
            } else if (select == 2) {
                replaceItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findIdItem(input, tracker);
            } else if (select == 5) {
                findNameItem(input, tracker);
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

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println(name + " successfully added");
    }

    public static void showItems(Tracker tracker) {
        System.out.println("=== Show all items ====");
        System.out.println("loading all items...");
        allItems(tracker.findAll());
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String id = input.askStr("Enter id: ");
        String newName = input.askStr("Enter new name: ");
        Item item = new Item(newName);
        if (tracker.replace(id, item)) {
            System.out.println("replacement was successful");
        } else {
            System.out.println("no replacement, item not found");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String id = input.askStr("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("item successfully deleted");
        } else {
            System.out.println("deletion failed, item not found");
        }
    }

    public static void findIdItem(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        String id = input.askStr("Enter id: ");
        System.out.println("item name to this id: ");
        System.out.println(tracker.findById(id).getName());
    }

    public static void findNameItem(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String key = input.askStr("Enter name: ");
        System.out.println("information this item(s): ");
        allItems(tracker.findByName(key));
    }


    private static void allItems(Item[] items) {
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