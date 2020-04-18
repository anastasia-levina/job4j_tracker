package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        System.out.println("factorial of a given number is: " + calc(4));
    }

    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The input parameter must be at least zero.");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
