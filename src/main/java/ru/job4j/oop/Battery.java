package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int charge) {
        this.load = charge;
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery = new Battery(90);
        Battery phone = new Battery(10);
        System.out.println("battery : " + battery.load + ". phone : " + phone.load);
        battery.exchange(phone);
        System.out.println("battery : " + battery.load + ". phone : " + phone.load);
    }
}
