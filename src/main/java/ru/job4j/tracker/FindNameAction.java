package ru.job4j.tracker;

public class FindNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String key = input.askStr("Enter name: ");
        System.out.print("information this item(s): ");
        StartUI.allItems(tracker.findByName(key));
        return true;
    }
}
