package ru.job4j.lambda;

import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return (attachment.getSize() > 100);
            }
        };
        return filter(rsl, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return (attachment.getName().contains("bug"));
            }
        };
        return filter(rsl, predicate);
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (predicate.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Attachment> rsl = List.of(
                new Attachment("first", 100),
                new Attachment("second", 130),
                new Attachment("third", 190));
        System.out.println(filter(rsl, a -> a.getSize() > 90 && a.getName().equals("first")).size());
        System.out.println(filter(rsl, a -> a.getSize() > 100 && a.getName().equals("second")).size());
        System.out.println(filter(rsl, a -> a.getSize() > 90 && a.getName().equals("third")).size());
    }
}