package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = 0;
        int size = Math.min(left.length(), right.length());
        for (int index = 0; index < size; index++) {
            result = Character.compare(left.charAt(index), right.charAt(index));
            if (result != 0) break;
        }
        return result == 0 ? Integer.compare(left.length(), right.length()) : result;
    }
}
