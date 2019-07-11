package ru.dumsky284.Ducks;

import ru.dumsky284.Ducks.Behaviors.FlyBehavior;
import ru.dumsky284.Ducks.Behaviors.QuackBehavior;

public class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }

}
