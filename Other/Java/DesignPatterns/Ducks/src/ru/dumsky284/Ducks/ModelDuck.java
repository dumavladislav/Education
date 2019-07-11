package ru.dumsky284.Ducks;

import ru.dumsky284.Ducks.Behaviors.FlyNoWay;
import ru.dumsky284.Ducks.Behaviors.Quack;

public class ModelDuck extends Duck {

    ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

}
