package ru.job4j.poly;

public interface Transport {

    void toGo();

    void passengers(int numberPass);

    double priceTankUp(int fuel);
}
