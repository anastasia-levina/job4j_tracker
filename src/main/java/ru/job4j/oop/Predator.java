package ru.job4j.oop;

public class Predator extends Animal {

    public Predator(String name) {
        super(name);
    }

    public Predator() {
        super();
        System.out.println("Predator");
    }
}