package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {

        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();

        ball.runAway();
        hare.tryEat(ball);
        ball.runAway(hare);
        wolf.tryEat(ball);
        ball.runAway(wolf);
        fox.tryEat(ball);
        ball.restInPeace();
    }
}
