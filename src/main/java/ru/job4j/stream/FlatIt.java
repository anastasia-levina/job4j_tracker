package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        List<Integer> listInt = new ArrayList<>();
        while (it.hasNext()) {
            Iterator<Integer> next = it.next();
            while (next.hasNext()) {
                listInt.add(next.next());
            }
        }
        return listInt;
    }
}