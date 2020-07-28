package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when11ElementsThen12() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31),
                3
        );
        int[][] expect = {
                {21, 22, 23},
                {24, 25, 26},
                {27, 28, 29},
                {30, 31, 0}
        };
        assertThat(result, is(expect));
    }

}