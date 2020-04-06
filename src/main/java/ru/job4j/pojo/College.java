package ru.job4j.pojo;

import java.time.LocalDate;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Levina Anastasia Aleksandrovna");
        student.setGroup("intern-job4j");
        student.setArrival(LocalDate.of(2020, 3, 8));
        System.out.println(student.getFullName() + " studying in a group - " + student.getGroup() + " from " + student.getArrival());
    }
}