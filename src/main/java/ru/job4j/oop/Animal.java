package ru.job4j.oop;

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
        System.out.println("Animal");
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
    }
}