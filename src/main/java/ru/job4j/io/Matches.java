package ru.job4j.io;

import java.io.IOException;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int match = 11;
        System.out.println("Игра ''Спички''");
        System.out.println("На столе лежат спички. Всего их " + match + ". Из них возьмите от 1 до 3 штук.");
        int counter = 0;
        while (true) {
            int gamer = counter % 2 + 1;
            System.out.print("Введите количество спичек для " + gamer + "-го игрока: ");
            int number1 = userInput(input);
            if (number1 == match) {
                System.out.println("Игра завершена. Победил " + gamer + "-й игрок!");
                break;
            }
            match -= number1;
            if (!overLimit(match)) {
                break;
            }
            counter++;
        }
    }

    public static int userInput(Scanner input) {
        while (true) {
            try {
                int i = Integer.parseInt(input.nextLine());
                if (i >= 1 && i <= 3) return i;
                else throw new IOException();
            } catch (IOException | NumberFormatException ex) {
                System.out.println("Неправильный ввод. Введите, пожалуйста, число от 1 до 3: ");
            }
        }
    }

    public static boolean overLimit(int residual) {
        if (residual > 0) {
            System.out.println("Осталось " + (residual) + " спичек.");
        }
        if (residual < 0) {
            System.out.println("Вы превысили лимит оставшихся спичек! Не делайте так больше. Игра завершена, никто не победил. ");
            return false;
        }
        return true;
    }
}
