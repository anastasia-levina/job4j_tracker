package ru.job4j.oop;

public class Dentist extends Doctor {

    private Diagnose toothFilling;

    public Diagnose treatTooth(Pacient pacient) {
        if (pacient.getCaries()) {
            toothFilling = new Diagnose();
        }
        return toothFilling;
    }
}