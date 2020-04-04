package ru.job4j.oop;

public class Builder extends Engineer {

    private Tasks build;

    public Tasks equipment(Working working) {
        return build;
    }
}
