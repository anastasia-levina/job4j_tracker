package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 562);
        Book javaFirst = new Book("Java first", 707);
        Book сlockworkOrange = new Book("Clockwork Orange", 420);
        Book road = new Book("Road", 343);

        Book[] bookArray = new Book[4];

        bookArray[0] = cleanCode;
        bookArray[1] = javaFirst;
        bookArray[2] = сlockworkOrange;
        bookArray[3] = road;

        for (int index = 0; index < bookArray.length; index++) {
            Book bk = bookArray[index];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }

        System.out.println("Exchange Clean Code with Road.");
        Book tmp = bookArray[0];
        bookArray[0] = bookArray[3];
        bookArray[3] = tmp;

        for (int index = 0; index < bookArray.length; index++) {
            Book bk = bookArray[index];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }

        System.out.println("Shown only book.name == Clean code.");
        for (int index = 0; index < bookArray.length; index++) {
            Book bk = bookArray[index];
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getCount());
            }
        }
    }
}