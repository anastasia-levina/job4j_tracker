package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixIntegerTest {

    @Test
    public void whenMatrixIntegerConvertToList() {
        Integer[][] matrixInt = new Integer[2][3];
        matrixInt[0][0] = 1;
        matrixInt[0][1] = 2;
        matrixInt[0][2] = 23;
        matrixInt[1][0] = -4;
        matrixInt[1][1] = 5;
        matrixInt[1][2] = 9;
        List<Integer> rsl = MatrixInteger.convert(matrixInt);
        List<Integer> exp = Arrays.asList(1, 2, 23, -4, 5, 9);
        assertThat(rsl, is(exp));
    }
}