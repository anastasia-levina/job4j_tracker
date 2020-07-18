package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {

    @Test
    public void whenStudentMovesInClassA() {
        Student alekseev = new Student("Alekseev", 80);
        Student medlin = new Student("Medlin", 93);
        Student belov = new Student("Belov", 69);
        List<Student> students = Arrays.asList(alekseev, medlin, belov);
        List<Student> result = School.collect(students, student -> student.getScore() <= 100 && student.getScore() >= 70);
        List<Student> expected = Arrays.asList(alekseev, medlin);
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentMovesInClassB() {
        Student botin = new Student("Botin", 56);
        Student zolin = new Student("Zolin", 62);
        Student belov = new Student("Belov", 69);
        Student borodin = new Student("Borodin", 45);
        List<Student> students = Arrays.asList(botin, zolin, belov, borodin);
        List<Student> result = School.collect(students, student -> student.getScore() < 70 && student.getScore() >= 50);
        List<Student> expected = Arrays.asList(botin, zolin, belov);
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentMovesInClassC() {
        Student borodin = new Student("Borodin", 45);
        Student zolin = new Student("Zolin", 62);
        Student gribin = new Student("Gribin", 24);
        List<Student> students = Arrays.asList(borodin, zolin, gribin);
        List<Student> result = School.collect(students, student -> student.getScore() < 50 && student.getScore() >= 0);
        List<Student> expected = Arrays.asList(borodin, gribin);
        assertThat(result, is(expected));
    }
}