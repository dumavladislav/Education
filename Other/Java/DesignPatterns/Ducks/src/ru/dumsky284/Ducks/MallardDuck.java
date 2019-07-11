package ru.dumsky284.Ducks;

import ru.dumsky284.Ducks.Behaviors.FlyWithWings;
import ru.dumsky284.Ducks.Behaviors.Quack;

public class MallardDuck extends Duck {

    MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

}
