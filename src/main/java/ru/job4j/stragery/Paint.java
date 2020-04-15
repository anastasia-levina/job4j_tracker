package ru.job4j.stragery;


public class Paint {

    public void draw(Shape shape) {
        System.out.print(shape.draw());
    }

    public static void main(String[] args) {
        Shape square = new Square();
        Shape triangle = new Triangle();
        new Paint().draw(square);
        new Paint().draw(triangle);
        System.out.println();
    }
}