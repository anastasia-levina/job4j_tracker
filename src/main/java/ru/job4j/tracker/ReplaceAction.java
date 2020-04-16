package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        String newName = input.askStr("Enter new name: ");
        Item item = new Item(newName);
        if (tracker.replace(id, item)) {
            System.out.println("replacement was successful");
        } else {
            System.out.println("no replacement, item not found");
        }
        return true;
    }
}
