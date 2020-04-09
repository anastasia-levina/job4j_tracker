package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int match = 11;
        System.out.println("Игра ''Спички''");
        System.out.println("На столе лежат спички. Всего их " + match + ". Из них возьмите от 1 до 3 штук.");
        while (true) {
            System.out.print("Введите количество спичек для первого игрока: ");
            int number1 = input.nextInt();
            if (number1 > 3 || number1 <= 0) {
                System.out.print("Введено неверное количество спичек, введите количество от 1 до 3: ");
                number1 = input.nextInt();
            }
            int residual = match - number1;
            if (residual >= 0) {
                System.out.println("Осталось " + (residual) + " спичек.");
            }
            if (residual < 0) {
                System.out.println("Вы превысили лимит оставшихся спичек! Не делайте так больше. Игра завершена, никто не победил. ");
                break;
            } else if (number1 == match) {
                System.out.println("Игра завершена. Победил первый игрок!");
                break;
            }
            System.out.print("Введите количество спичек для второго игрока: ");
            int number2 = input.nextInt();
            if (number2 > 3 || number2 <= 0) {
                System.out.print("Введено неверное количество спичек, введите количество от 1 до 3: ");
                number2 = input.nextInt();
            }
            int residual2 = match - number1 - number2;
            if (residual2 >= 0) {
                System.out.println("Осталось " + (residual2) + " спичек.");
            }
            if (residual2 < 0) {
                System.out.println("Вы превысили лимит оставшихся спичек! Не делайте так больше. Игра завершена, никто не победил. ");
                break;
            } else if (number2 == residual) {
                System.out.println("Игра завершена. Победил второй игрок!");
                break;
            }
            match = match - (number1 + number2);
        }
        System.out.println();
    }
}
