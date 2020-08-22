package ru.job4j.stream;

import java.util.*;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        List<Integer> listInt = new ArrayList<>();
        it.forEachRemaining(iterator -> iterator.forEachRemaining(listInt::add));
        return listInt;
    }
}