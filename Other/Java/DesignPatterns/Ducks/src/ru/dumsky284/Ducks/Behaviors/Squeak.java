package ru.dumsky284.Ducks.Behaviors;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeack!!!");
    }
}
