package ru.dumsky284.Ducks.Behaviors;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Hey, I'm not flying, mate!!!");
    }
}
