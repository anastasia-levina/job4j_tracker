package ru.job4j.poly;

public class Bus implements Transport {

    private static final double FUEL_COST = 45.00;
    private int numberPass = 0;
    private static final int CAPACITY = 60;

    @Override
    public void toGo() {
        System.out.println("Bus is going");
    }

    @Override
    public void passengers(int numberNewPass) {
        while (numberPass <= CAPACITY && numberNewPass != 0) {
            numberPass++;
            numberNewPass--;
        }
    }

    @Override
    public double priceTankUp(int fuel) {
        return FUEL_COST * fuel;
    }
}
