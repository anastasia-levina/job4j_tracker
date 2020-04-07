package ru.job4j.pojo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first, is(second));
    }

    @Test
    public void eqEqName() {
        License first = new License();
        first.setCode("bmw");
        License second = new License();
        second.setCode("audio");
        assertNotEquals(first, second);
    }
}