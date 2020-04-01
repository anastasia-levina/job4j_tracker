package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String song;
        if (position == 1) {
            song = "Пусть бегут неуклюже";
        } else if (position == 2) {
            song = "Спокойной ночи";
        } else {
            song = "Песня не найдена";
        }
        System.out.println("Sign a song: " + song);
    }

    public static void main(String[] args) {
        Jukebox muse = new Jukebox();
        int position = 1;
        muse.music(position);
        position = 2;
        muse.music(position);
        position = 3;
        muse.music(position);
    }
}
