package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int size = 0;


    public Item add(Item item) {
        item.setId(generateId());
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int count = 0;
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (item != null) {
                itemsWithoutNull[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, count);
    }

    public Item[] findByName(String key) {
        Item[] itemsArray = new Item[items.length];
        int count = 0;
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (item != null && item.getName().equals(key)) {
                itemsArray[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(itemsArray, count);
    }


    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item findById(String id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId().equals(id)) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}