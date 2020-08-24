package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        String[] firstSplit = first.split("/");
        String[] secondSplit = second.split("/");
        int rsl = firstSplit[0].compareTo(secondSplit[0]);
        return rsl == 0 ? first.compareTo(second) : second.compareTo(first);
    }
}