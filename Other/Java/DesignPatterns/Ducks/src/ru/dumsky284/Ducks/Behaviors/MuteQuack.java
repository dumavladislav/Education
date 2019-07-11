package ru.dumsky284.Ducks.Behaviors;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("--- SILENCE ----");
    }
}
