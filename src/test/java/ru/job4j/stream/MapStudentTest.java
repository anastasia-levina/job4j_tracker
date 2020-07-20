package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MapStudentTest {
    @Test
    public void whenMapStudent() {
        Student alekseev = new Student("Alekseev", 80);
        Student medlin = new Student("Medlin", 93);
        Student belov = new Student("Belov", 69);
        List<Student> students = Arrays.asList(alekseev, medlin, belov);
        Map<String, Integer> result = MapStudent.studentMap(students);
        Map<String, Integer> expected = Map.of("Alekseev", 80, "Medlin", 93, "Belov", 69);
        assertThat(result, is(expected));
    }
}