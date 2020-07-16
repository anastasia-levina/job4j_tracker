package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static void main(String[] args) {

        ArrayList<Integer> intArrayList = new ArrayList<>();
        intArrayList.add(1);
        intArrayList.add(23);
        intArrayList.add(-9);
        intArrayList.add(55);
        intArrayList.add(-15);

        List<Integer> list = intArrayList.stream()
                .filter(i -> i > 0)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}