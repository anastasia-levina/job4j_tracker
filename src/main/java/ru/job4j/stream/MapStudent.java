package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStudent {
    public static Map<String, Integer> studentMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        Student::getScore,
                        (st, st1) -> st)
                );
    }
}