package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemSortTest {

    @Test
    public void compareAscending() {
        List<Item> items = Arrays.asList(
                new Item("January"),
                new Item("February"),
                new Item("March"),
                new Item("April")
        );
        items.sort(new ItemSortAscending());
        List<Item> expect = Arrays.asList(
                new Item("April"),
                new Item("February"),
                new Item("January"),
                new Item("March")
        );
        assertThat(items, is(expect));
    }

    @Test
    public void compareDescending() {
        List<Item> items = Arrays.asList(
                new Item("January"),
                new Item("February"),
                new Item("March"),
                new Item("April")
        );
        items.sort(new ItemSortDescending());
        List<Item> expect = Arrays.asList(
                new Item("March"),
                new Item("January"),
                new Item("February"),
                new Item("April")
        );
        assertThat(items, is(expect));
    }
}