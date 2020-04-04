package ru.job4j.oop;

public class Doctor extends Profession {

    private Diagnose diagnose;

    public Diagnose heal(Pacient pacient) {
        if (pacient.getDisease()) {
            diagnose = new Diagnose();
        }
        return diagnose;
    }
}
