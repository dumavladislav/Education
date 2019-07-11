package ru.dumsky284.Ducks;

import ru.dumsky284.Ducks.Behaviors.FlyNoWay;
import ru.dumsky284.Ducks.Behaviors.MuteQuack;

public class WoodenDuck extends Duck {

    WoodenDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

}
