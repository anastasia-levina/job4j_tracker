package ru.job4j.tracker;

public class FindIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item expected = tracker.findById(id);
        if (expected == null) {
            System.out.println("item does not exist");
        } else {
            System.out.println("information this item: ");
            System.out.println(expected);
        }
        return true;
    }
}
