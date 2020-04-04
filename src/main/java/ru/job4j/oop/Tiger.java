package ru.job4j.oop;

public class Tiger extends Predator {

    public Tiger(String name) {
        super(name);
    }

    public Tiger() {
        super();
        System.out.println("Tiger");
    }
}