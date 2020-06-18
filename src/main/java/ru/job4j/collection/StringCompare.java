package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = 0;
        int size = Math.max(left.length(), right.length());
        char[] leftCharArr = left.toCharArray();
        char[] rightCharArr = right.toCharArray();
        for (int index = 0; index < size; index++) {
            if (index >= leftCharArr.length || index >= rightCharArr.length) {
                result = -1;
                break;
            }
            result = Character.compare(leftCharArr[index], rightCharArr[index]);
            if (result != 0) break;
        }
        return result;
    }
}
