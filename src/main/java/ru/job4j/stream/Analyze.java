package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .mapToDouble(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> {
            double score = pupil.getSubjects().stream()
                    .mapToInt(Subject::getScore)
                    .average()
                    .orElse(0);
            return new Tuple(pupil.getName(), score);
        })
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        () -> new TreeMap<>(Collections.reverseOrder()), Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> {
            double score = pupil.getSubjects().stream()
                    .mapToInt(Subject::getScore)
                    .sum();
            return new Tuple(pupil.getName(), score);
        })
                .max((t1, t2) -> (int) (t1.getScore() - t2.getScore())).orElseGet(Tuple::new);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.summingInt(Subject::getScore)))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max((t1, t2) -> (int) (t1.getScore() - t2.getScore()))
                .orElseGet(Tuple::new);
    }
}