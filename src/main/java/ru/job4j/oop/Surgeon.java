package ru.job4j.oop;

public class Surgeon extends Doctor {

    private Diagnose cut;

    public Diagnose doSurgery(Pacient pacient) {
        if (pacient.getAppendicitis()) {
            cut = new Diagnose();
        }
        return cut;
    }
}